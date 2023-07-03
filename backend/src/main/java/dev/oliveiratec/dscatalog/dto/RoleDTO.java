package dev.oliveiratec.dscatalog.dto;

import dev.oliveiratec.dscatalog.entities.Role;

import java.io.Serializable;

public class RoleDTO   implements Serializable {
    private Long id;
    private String authority;

    public RoleDTO(){

    }

    public RoleDTO(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.authority = role.getAuthority();
    }

    public Long getId() {
        return id;
    }

    public RoleDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAuthority() {
        return authority;
    }

    public RoleDTO setAuthority(String authority) {
        this.authority = authority;
        return this;
    }
}
