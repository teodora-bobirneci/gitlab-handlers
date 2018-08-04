package org.versioning.model;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Setter @Getter private String avatar_url;
    @Setter @Getter private String username;
    @Setter @Getter private String name;
}
