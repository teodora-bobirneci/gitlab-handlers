package org.versioning.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

class Changes {
    @Setter @Getter private String[] updated_at;
    @Setter @Getter private String[] updated_by_id;
    @Setter @Getter private Collection<Labels> labels;

}