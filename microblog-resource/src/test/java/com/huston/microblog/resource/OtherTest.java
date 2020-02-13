package com.huston.microblog.resource;

import com.huston.microblog.resource.model.enums.FileTypeEnum;
import com.huston.microblog.resource.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class OtherTest {

    @Test
    public void  testMP4FileType() throws IOException {
        File file=new File("D:\\视频\\外教.mp4");
        try(FileInputStream inputStream = new FileInputStream(file)){
            FileTypeEnum fileType = FileUtils.getFileType(inputStream);
            System.out.println(fileType);
        }
        File file2=new File("D:\\视频\\外教.mp4");
        try(FileInputStream inputStream = new FileInputStream(file2)){
            byte[] bytes = new byte[32];
            inputStream.read(bytes, 0, 32);
            System.out.println(FileUtils.bytesToHexString(bytes));
            System.out.println(new String(bytes));
        }
    }

    @Test
    public void testFileType(){
        int max=0;
        FileTypeEnum maxType = null;
        FileTypeEnum[] fileTypeEnums = FileTypeEnum.values();
        for (FileTypeEnum fileTypeEnum : fileTypeEnums) {
            if(fileTypeEnum.getValue().length()>max){
                max=fileTypeEnum.getValue().length();
                maxType=fileTypeEnum;
            }
        }
        System.out.println(max);
        System.out.println(maxType+" "+maxType.getValue());
    }
}
