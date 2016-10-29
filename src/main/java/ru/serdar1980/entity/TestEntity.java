package ru.serdar1980.entity;


import ru.serdar1980.constraint.MaxLength;

public class TestEntity {
    @MaxLength(maxLength = 5, fieldName = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
