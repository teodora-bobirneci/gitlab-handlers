package org.versioning.model;

import lombok.Getter;
import lombok.Setter;

public class EmailMessage {
    @Getter @Setter private String[] recipients;
    @Getter @Setter private String subject;
    @Getter @Setter private String body;
}
