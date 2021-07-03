package com.movenow.movenow.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "media")
public class Media {
    @Id
    @GeneratedValue
    private Long id;

    @Transient
    private String fileUrl;
    
    @Lob
    private byte[] file;

    public Media() {
    }

    public Media(byte[] file) {
        this.file = file;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileUrl() {
        return "/api/media/" + id + "/download";
    }
}
