package com.hiran.dubbo.entity;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class User implements Serializable {
    private static final long serialVersionUID = -9043697960658371189L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
