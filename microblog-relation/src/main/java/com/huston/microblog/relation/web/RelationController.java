package com.huston.microblog.relation.web;

import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.common.service.FeignRelationService;
import com.huston.microblog.relation.model.dto.InsertGroupDTO;
import com.huston.microblog.relation.model.dto.RelationDTO;
import com.huston.microblog.relation.model.vo.InsertGroupVO;
import com.huston.microblog.relation.service.GroupService;
import com.huston.microblog.relation.service.RelationService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

import static com.huston.microblog.common.model.constant.CommonConstant.*;

/**
 * @author huxiantao-cn@foxmail.com
 */
@RestController
@Validated
public class RelationController implements FeignRelationService {

    private RelationService relationService;
    private GroupService groupService;

    public RelationController(RelationService relationService, GroupService groupService) {
        this.relationService = relationService;
        this.groupService = groupService;
    }

    @PostMapping("/relations")
    public Result insertRelation(@AuthenticationPrincipal Jwt jwt,
                                 @RequestBody Long userIdPub){
        Long userId=Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        relationService.insertRelation(userId, userIdPub);
        return Result.success();
    }

    @GetMapping("/relations")
    public Result<List<RelationDTO>> listRelation(@AuthenticationPrincipal Jwt jwt,
                                                  @RequestParam(value = "userIdSubscriber", required = false) Long userIdSub,
                                                  @RequestParam(value = "userIdPublisher", required = false) Long userIdPub,
                                                  @RequestParam("offset") @Min(0) Long offset,
                                                  @RequestParam("limit") @Min(1) Long limit) {
        Long myUserId=Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        if(userIdSub!=null) {
            List<RelationDTO> relationDTOS = relationService.listFollowRelation(userIdSub, offset, limit);
            //如果不是用户自己，则屏蔽掉某些字段
            if (!myUserId.equals(userIdSub)) {
                for (RelationDTO relationDTO : relationDTOS) {
                    relationDTO.setRelaRemark(null);
                }
            }
            return Result.success(relationDTOS);
        } else if (userIdPub!=null) {
            List<RelationDTO> relationDTOS = relationService.listFansRelation(userIdPub, offset, limit);
            return Result.success(relationDTOS);
        } else{
            throw new BadRequestException("userIdSubscriber和userIdPublisher必须至少提供一个参数");
        }
    }

    @DeleteMapping("/relations/{relaId}")
    public Result deleteRelation(@AuthenticationPrincipal Jwt jwt,
                                 @PathVariable("relaId") Long relaId){
        Long userId=Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        relationService.deleteRelation(userId, relaId);
        return Result.success();
    }

    @PatchMapping("/relations/{relaId}")
    public Result updateRelation(@AuthenticationPrincipal Jwt jwt,
                                 @PathVariable("relaId") Long relaId,
                                 @RequestParam("relaRemark") @Size(min = 1, max = 30, message = "备注名为1-30个字符") String relaRemark){
        Long userId=Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        relationService.updateRelation(userId, relaId, relaRemark);
        return Result.success();
    }

    @PostMapping("/groups")
    public Result addGroup(@AuthenticationPrincipal Jwt jwt,
                           @RequestBody @Validated InsertGroupVO insertGroupVO){
        Long userId=Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        InsertGroupDTO insertGroupDTO = new InsertGroupDTO();
        BeanUtils.copyProperties(insertGroupVO, insertGroupDTO);
        insertGroupDTO.setUserId(userId);
        groupService.insertGroup(insertGroupDTO);
        return Result.success();
    }

    @GetMapping("/relation-counts")
    public Result<Long> countRelation(@RequestParam(value = "userIdSubscriber", required = false) Long userIdSub,
                                      @RequestParam(value = "userIdPublisher", required = false) Long userIdPub){
        if(userIdSub==null && userIdPub==null){
            throw new BadRequestException("缺少参数userIdSubscriber或userIdPublisher");
        }
        return Result.success(relationService.countRelation(userIdSub, userIdPub));
    }

    @Override
    public Result<List<Long>> listFansId(Long userId) {
        return Result.success(relationService.listFansId(userId));
    }

}
