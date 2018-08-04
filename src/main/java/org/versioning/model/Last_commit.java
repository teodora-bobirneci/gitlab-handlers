package org.versioning.model;

import lombok.Getter;
import lombok.Setter;

public class Last_commit {
    @Setter @Getter private String timestamp;
    @Setter @Getter private String message;
    @Setter @Getter private String id;
    @Setter @Getter private Author author;
    @Setter @Getter private String url;

}
