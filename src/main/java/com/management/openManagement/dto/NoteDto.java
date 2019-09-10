package com.management.openManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.management.openManagement.models.ParentNote;

public class NoteDto extends ParentNote {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("owner")
    private String owner;

    @Override
    public String sayHello(){
        System.out.println("HELLOOOOO");
        return "helloooo";
    }

    @Override
    public void dene(){
        System.out.println("deneme override");
    }



    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
