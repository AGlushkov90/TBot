package com.glushkov.service;

import com.glushkov.entity.AppDocument;
import com.glushkov.entity.AppPhoto;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;


public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegramMessage);
//    String generateLink(Long docId, LinkType linkType);
}
