package com.movenow.movenow.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "media")
public class Media
{
    @Id
    @GeneratedValue
    private Long id;

    private String pictureUrl;
    
    private String videoUrl;

    @Lob
    private byte[] file;

    public Media() {}

    public Media(byte[] file)
    {
        this.file = file;        
    }

    public Media(String videoUrl)
    {
        this.videoUrl = videoUrl;
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @JsonIgnore
    public byte[] getFile()
    {
        return file;
    }

    public void setFile(byte[] file)
    {
        this.file = file;
    }

    public void setPictureUrl(String pictureUrl)
    {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl()
    {
        return pictureUrl;
    }

    public String getVideoUrl()
    {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl)
    {
        this.videoUrl = videoUrl;
    }
}
