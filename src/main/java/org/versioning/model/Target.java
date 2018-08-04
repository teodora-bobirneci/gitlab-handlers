package org.versioning.model;


import lombok.Getter;
import lombok.Setter;

class Target {
    @Setter @Getter private String avatar_url;
    @Setter @Getter private String web_url;
    @Setter @Getter private String http_url;
    @Setter @Getter private String homepage;
    @Setter @Getter private String url;
    @Setter @Getter private String ssh_url;
    @Setter @Getter private String namespace;
    @Setter @Getter private String default_branch;
    @Setter @Getter private String path_with_namespace;
    @Setter @Getter private String git_ssh_url;
    @Setter @Getter private String description;
    @Setter @Getter private String visibility_level;
    @Setter @Getter private String name;
    @Setter @Getter private String git_http_url;
}
