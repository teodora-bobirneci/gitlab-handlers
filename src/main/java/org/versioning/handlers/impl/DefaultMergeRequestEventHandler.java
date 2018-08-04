package org.versioning.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.versioning.email.EmailMessage;
import org.versioning.email.EmailSenderService;
import org.versioning.handlers.MergeRequestEventHandler;

@Service
public class DefaultMergeRequestEventHandler implements MergeRequestEventHandler {


    @Autowired private EmailSenderService emailSenderService;

    @Override
    @Async
    public void doHandle(String event) {
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
