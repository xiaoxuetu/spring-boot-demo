package org.xiaoxuetu.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private long id;

    private String username;

    private String password;
}
