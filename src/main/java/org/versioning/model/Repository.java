package org.versioning.model;

import lombok.Getter;
import lombok.Setter;

class Repository
{
    @Setter @Getter private String description;
    @Setter @Getter private String name;
    @Setter @Getter private String homepage;
    @Setter @Getter private String url;
}
