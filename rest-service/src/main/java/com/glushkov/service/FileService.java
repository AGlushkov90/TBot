package com.glushkov.service;

import com.glushkov.entity.AppDocument;
import com.glushkov.entity.AppPhoto;
import com.glushkov.entity.BinaryContent;
import org.springframework.core.io.FileSystemResource;

import java.nio.file.FileSystem;

public interface FileService {
    AppDocument getDocument(String id);
    AppPhoto getPhoto(String id);
    FileSystemResource getFileSystemResource(BinaryContent binaryContent);
}
