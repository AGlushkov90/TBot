package com.glushkov.service.impl;
import com.glushkov.service.MainService;
import com.glushkov.service.ProducerService;
import com.glushkov.utils.MessageUtils;
import lombok.extern.log4j.Log4j;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.glushkov.service.ConsumerService;
//import com.glushkov.service.MainService;

import static com.glushkov.model.RabbitQueue.*;

@Service
@Log4j
public class ConsumerServiceImpl implements ConsumerService {
//    private final MainService mainService;
//
//    public ConsumerServiceImpl(MainService mainService) {
//        this.mainService = mainService;
//    }

    private final MessageUtils messageUtils;
    private final MainService mainService;
//    private final TelegramBot telegramBot;
   private final ProducerService producerService;

    public ConsumerServiceImpl(MessageUtils messageUtils, MainService mainService, ProducerService producerService) {
       this.messageUtils = messageUtils;
        this.mainService = mainService;
//        this.telegramBot = telegramBot;
        this.producerService = producerService;
    }

    @Override
    @RabbitListener(queues = TEXT_MESSAGE_UPDATE)
    public void consumeTextMessageUpdates(Update update) {
        log.debug("NODE: Text message is received");
//        telegramBot.sendAnswerMessage(messageUtils.generateSendMessageWithText(update, "Answer for message"));
            mainService.processTextMessage(update);
//        mainService.processTextMessage(update);
    }

    @Override
    @RabbitListener(queues = DOC_MESSAGE_UPDATE)
    public void consumeDocMessageUpdates(Update update) {
        log.debug("NODE: Doc message is received");
        mainService.processDocMessage(update);
    }

    @Override
    @RabbitListener(queues = PHOTO_MESSAGE_UPDATE)
    public void consumePhotoMessageUpdates(Update update) {
        log.debug("NODE: Photo message is received");
     mainService.processPhotoMessage(update);
    }
}
