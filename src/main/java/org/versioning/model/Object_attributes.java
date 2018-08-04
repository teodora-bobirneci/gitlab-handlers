package org.versioning.model;

import lombok.Getter;
import lombok.Setter;


class Object_attributes {
    @Setter @Getter private String target_branch;
    @Setter @Getter private String milestone_id;
    @Setter @Getter private String work_in_progress;
    @Setter @Getter private String iid;
    @Setter @Getter private String state;
    @Setter @Getter private User assignee;
    @Setter @Getter private String url;
    @Setter @Getter private String target_project_id;
    @Setter @Getter private String id;
    @Setter @Getter private Last_commit last_commit;
    @Setter @Getter private String title;
    @Setter @Getter private String updated_at;
    @Setter @Getter private Source source;
    @Setter @Getter private String assignee_id;
    @Setter @Getter private String description;
    @Setter @Getter private String source_branch;
    @Setter @Getter private String action;
    @Setter @Getter private Target target;
    @Setter @Getter private String source_project_id;
    @Setter @Getter private String created_at;
    @Setter @Getter private String author_id;
    @Setter @Getter private String merge_status;
}
