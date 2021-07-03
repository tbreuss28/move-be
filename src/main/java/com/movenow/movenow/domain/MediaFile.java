package com.movenow.movenow.domain;

import org.yaml.snakeyaml.events.Event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Base64;

@Entity
@Table(name = "mediaFile")
public class MediaFile {
    @Id
    @GeneratedValue
    private Long id;
    
    private Base64 file;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Base64 getFile() {
        return file;
    }

    public void setFile(Base64 file) {
        this.file = file;
    }
}
