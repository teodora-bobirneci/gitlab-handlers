package org.versioning.model;

import lombok.Getter;
import lombok.Setter;

public class Previous {

    @Setter @Getter private String template;
    @Setter @Getter private String id;
    @Setter @Getter private String title;
    @Setter @Getter private String updated_at;
    @Setter @Getter private String color;
    @Setter @Getter private String description;
    @Setter @Getter private String project_id;
    @Setter @Getter private String group_id;
    @Setter @Getter private String created_at;
    @Setter @Getter private String type;
}
