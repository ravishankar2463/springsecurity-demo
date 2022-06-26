package com.example.security.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {
    @Id
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_permissions",
            joinColumns = {@JoinColumn(name = "role", referencedColumnName = "role")},
            inverseJoinColumns = {@JoinColumn(name = "permission", referencedColumnName = "permission")})
    private Set<Permission> permissions;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getName() {
        return getRole();
    }
}
