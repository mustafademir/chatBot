package com.management.openManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.management.openManagement.models.note;

import java.util.Set;

public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("notes")
    private Set<note> notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  public Set<note> getNotes() {
    return notes;
  }

  public void setNotes(Set<note> notes) {
    this.notes = notes;
  }
}
