package org.versioning.handlers.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.versioning.email.EmailSenderService;
import org.versioning.handlers.MergeRequestEventHandler;
import org.versioning.model.EmailMessage;

@Service
public class DefaultMergeRequestEventHandler implements MergeRequestEventHandler {

    private static Logger logger = LoggerFactory.getLogger(DefaultMergeRequestEventHandler.class);

    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    @Async("gitlabHandlers-executor")
    public void doHandle(String event) {
        logger.info(Thread.currentThread().getName() + ": Execute method asynchronously. ");
        sendMail(event);
    }

    private void sendMail(String event) {
        EmailMessage emailMessage = buildEmail(event);
        emailSenderService.sendMail(emailMessage);
    }

    private EmailMessage buildEmail(String event) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setSubject("New Merge Request");
        emailMessage.setBody(event);
        emailMessage.setRecipients(new String[]{"recipient@mail.com"});
        return emailMessage;
    }

}
