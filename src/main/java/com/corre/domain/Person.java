package com.corre.domain;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
