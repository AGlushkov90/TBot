package com.glushkov.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import com.glushkov.controller.UpdateController;
import com.glushkov.service.AnswerConsumer;

import static com.glushkov.model.RabbitQueue.ANSWER_MESSAGE;
@Service
public class AnswerConsumerImpl implements AnswerConsumer {
    private final UpdateController updateProcessor;

    public AnswerConsumerImpl(UpdateController updateProcessor) {
        this.updateProcessor = updateProcessor;
    }

    @Override
    @RabbitListener(queues = ANSWER_MESSAGE)
    public void consume(SendMessage sendMessage) {
        updateProcessor.setView(sendMessage);
    }
}