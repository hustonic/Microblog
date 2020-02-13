package com.huston.microblog.resource.util;

import com.huston.microblog.resource.model.enums.FileTypeEnum;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class FileUtils {

    /**
     * 把字节流转换成十六进制字符串表示
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        for (byte b : bytes) {
            int v = b & 0xFF;   //byte是有符号的，把它转成无符号的值
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 获取文件头
     */
    public static String getFileHeader(InputStream inputStream) throws IOException {
        byte[] b = new byte[16];
        inputStream.read(b, 0, 16);
        return bytesToHexString(b);
    }

    /**
     * 获取文件类型
     */
    public static FileTypeEnum getFileType(InputStream inputStream) throws IOException{
        String fileHeader = getFileHeader(inputStream);
        if (fileHeader == null || fileHeader.length() == 0) {
            return null;
        }
        fileHeader = fileHeader.toUpperCase();
        FileTypeEnum[] fileTypes = FileTypeEnum.values();
        for (FileTypeEnum type : fileTypes) {
            if (fileHeader.contains(type.getValue())) {
                return type;
            }
        }
        return null;
    }
}
