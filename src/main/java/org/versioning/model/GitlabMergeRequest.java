package org.versioning.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

public class GitlabMergeRequest
{
    @Setter @Getter private Project project;
    @Setter @Getter private Object_attributes object_attributes;
    @Setter @Getter private Repository repository;
    @Setter @Getter private Collection<Labels> labels;
    @Setter @Getter private String object_kind;
    @Setter @Getter private User user;
    @Setter @Getter private Changes changes;

}