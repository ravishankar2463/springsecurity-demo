package com.example.security.models;

import javax.persistence.*;

@Entity
@Table(name="permissions")
public class Permission {

    @Id
    private String permission;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getName() {
        return getPermission();
    }
}
