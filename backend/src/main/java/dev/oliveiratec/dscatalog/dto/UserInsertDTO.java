package dev.oliveiratec.dscatalog.dto;

import net.bytebuddy.implementation.bind.annotation.Super;

public class UserInsertDTO extends UserDTO{
    private String password;

    public UserInsertDTO(){
    }

    public String getPassword() {
        return password;
    }

    public UserInsertDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
