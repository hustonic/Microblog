package com.huston.microblog.mblog.web;

import com.huston.microblog.common.model.constant.CommonConstant;
import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.common.service.FeignMicroblogService;
import com.huston.microblog.mblog.manager.MicroblogTimelineManager;
import com.huston.microblog.mblog.model.dto.InsertMicroblogDTO;
import com.huston.microblog.common.model.dto.MicroblogDTO;
import com.huston.microblog.mblog.model.dto.UpdateMicroblogDTO;
import com.huston.microblog.mblog.model.enums.MicroblogTypeEnum;
import com.huston.microblog.mblog.model.enums.TimelineTypeEnum;
import com.huston.microblog.mblog.model.vo.InsertMicroblogVO;
import com.huston.microblog.mblog.model.vo.UpdateMicroblogVO;
import com.huston.microblog.mblog.service.MicroblogService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@RestController
@Validated
public class MicroblogController implements FeignMicroblogService {

    private MicroblogService microblogService;
    private MicroblogTimelineManager microblogTimelineManager;

    public MicroblogController(MicroblogService microblogService, MicroblogTimelineManager microblogTimelineManager) {
        this.microblogService = microblogService;
        this.microblogTimelineManager = microblogTimelineManager;
    }

    @PostMapping("/microblogs")
    public Result addMicroblog(@RequestBody @Validated InsertMicroblogVO insertMicroblogVO,
                                  @AuthenticationPrincipal Jwt jwt){
        if(MicroblogTypeEnum.valueOf(insertMicroblogVO.getMblogType())==null){
            throw new BadRequestException("微博类型不合法");
        }
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        InsertMicroblogDTO insertMicroblogDTO = new InsertMicroblogDTO();
        BeanUtils.copyProperties(insertMicroblogVO, insertMicroblogDTO);
        insertMicroblogDTO.setUserId(userId);
        microblogService.insertMicroblog(insertMicroblogDTO);
        return Result.success();
    }

    @GetMapping("/microblogs")
    public Result<List<MicroblogDTO>> listMicroblog(@RequestParam("timelineType") Integer timelineType,
                                                    @RequestParam("userId") Long userId,
                                                    @RequestParam(value = "offset") @Min(value = 0, message = "offset>=0") Long offset,
                                                    @RequestParam(value = "limit") @Min(value = 1, message = "limit>=1") Long limit,
                                                    @AuthenticationPrincipal Jwt jwt){
        Long myUserId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        List<MicroblogDTO> microblogDTOS;
        TimelineTypeEnum timelineTypeEnum = TimelineTypeEnum.valueOf(timelineType);
        if(timelineTypeEnum==null){
            throw new BadRequestException("timelineType不合法");
        }
        switch(timelineTypeEnum){
            case MICROBLOG_ME:
                microblogDTOS = microblogService.listUserMicroblog(userId, offset, limit);
                break;
            case MICROBLOG_FOLLOW:
                if(!myUserId.equals(userId)){
                    throw new BadRequestException("无权访问");
                }
                microblogDTOS = microblogService.listFollowMicroblog(userId, offset, limit);
                break;
            default:
                throw new BadRequestException("timelineType不合法");
        }

        return Result.success(microblogDTOS);
    }

    @Override
    public Result<MicroblogDTO> getMicroblog(Long mblogId){
        MicroblogDTO microblog = microblogService.getMicroblog(mblogId);
        return Result.success(microblog);
    }

    @PatchMapping("/microblogs/{mblogId}")
    public Result updateMicroblog(@PathVariable("mblogId") Long mblogId,
                                  @RequestBody UpdateMicroblogVO updateMicroblogVO,
                                  @AuthenticationPrincipal Jwt jwt){
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        UpdateMicroblogDTO updateMicroblogDTO = new UpdateMicroblogDTO();
        BeanUtils.copyProperties(updateMicroblogVO, updateMicroblogDTO);
        updateMicroblogDTO.setUserId(userId);
        updateMicroblogDTO.setMblogId(mblogId);
        microblogService.updateMicroblog(updateMicroblogDTO);
        return Result.success();
    }

    @DeleteMapping("/microblogs/{mblogId}")
    public Result deleteMicroblog(@PathVariable("mblogId") Long mblogId,
                                  @AuthenticationPrincipal Jwt jwt){
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        microblogService.deleteMicroblog(userId, mblogId);
        return Result.success();
    }

    @GetMapping("/microblog-counts/{userId}")
    public Result<Long> countMicroblog(@PathVariable("userId") Long userId){
        return Result.success(microblogTimelineManager.getSize(TimelineTypeEnum.MICROBLOG_ME.getCode(), userId));
    }

    @GetMapping("/forward-counts/{mblogId}")
    public Result<Long> countForward(@PathVariable("mblogId") Long mblogId){
        Long count = microblogService.countForward(mblogId);
        return Result.success(count);
    }
}
