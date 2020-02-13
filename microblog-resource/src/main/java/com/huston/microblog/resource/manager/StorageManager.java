package com.huston.microblog.resource.manager;

import com.huston.microblog.resource.model.exception.StorageException;
import com.huston.microblog.resource.model.exception.StorageFileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface StorageManager {

    void init() throws StorageException;

    void store(MultipartFile file, String filename) throws StorageException;

    void store(MultipartFile file) throws StorageException;

    Stream<Path> loadAll() throws StorageException;

    Path load(String filename);

    Resource loadAsResource(String filename) throws StorageFileNotFoundException;

    void deleteAll();

}

