package com.huston.microblog.resource.manager.impl;

import com.huston.microblog.resource.config.FTPStorageProperties;
import com.huston.microblog.resource.config.StorageProperties;
import com.huston.microblog.resource.manager.StorageManager;
import com.huston.microblog.resource.model.exception.StorageException;
import com.huston.microblog.resource.model.exception.StorageFileNotFoundException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
public class FTPStorageManager implements StorageManager {

    private FTPStorageProperties ftpStorageProperties;

    public FTPStorageManager(FTPStorageProperties ftpStorageProperties) {
        this.ftpStorageProperties = ftpStorageProperties;
    }

    @Override
    public void init() throws StorageException {
        throw new StorageException("不支持此操作");
    }

    @Override
    public void store(MultipartFile file, String filename) throws StorageException {
        try (InputStream inputStream=file.getInputStream()){
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }

            //分割文件夹和文件名
            int index=filename.lastIndexOf("/");
            String path="";
            if(index>=0){
                path="/"+filename.substring(0,index);
            }
            String name = filename.substring(index+1);

            FTPClient ftpClient=new FTPClient();
            ftpClient.connect(ftpStorageProperties.getHost());  //连接ftp服务器，参数：服务器的ip
            ftpClient.login(ftpStorageProperties.getUsername(), ftpStorageProperties.getPassword());  //登录，参数：账号，密码
            ftpClient.enterLocalPassiveMode();  //开启被动模式（按自己如何配置的ftp服务器来决定是否开启）
            ftpClient.changeWorkingDirectory(path);  //改变工作目录（按自己需要是否改变），只能选择ftp用户根下已存在的目录
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);  //设置文件类型为二进制文件
            boolean success=ftpClient.storeFile(name, inputStream);  //上传文件,参数：上传后的文件名，输入流
            ftpClient.disconnect();  //关闭连接
            if(!success){
                throw new StorageException("上传文件失败");
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public void store(MultipartFile file) throws StorageException {
        throw new StorageException("不支持此操作");
    }

    @Override
    public Stream<Path> loadAll() throws StorageException {
        throw new StorageException("不支持此操作");
    }

    @Override
    public Path load(String filename) {
        throw new StorageException("不支持此操作");
    }

    @Override
    public Resource loadAsResource(String filename) throws StorageFileNotFoundException {
        throw new StorageException("不支持此操作");
    }

    @Override
    public void deleteAll() {
        throw new StorageException("不支持此操作");
    }
}
