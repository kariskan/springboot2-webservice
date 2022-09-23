package com.kariskan.practice.webservice.config.auth.dto;

import com.kariskan.practice.webservice.domain.user.Users;
import java.io.Serializable;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(Users user) {
        this.name = user.getName();
        this.email = user.getEmail();
        picture = user.getPicture();
    }

}
