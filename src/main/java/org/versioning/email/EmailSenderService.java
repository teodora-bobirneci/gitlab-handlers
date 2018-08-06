package org.versioning.email;

import org.versioning.model.EmailMessage;

public interface EmailSenderService {

    void sendMail(EmailMessage emailMessage);

}
