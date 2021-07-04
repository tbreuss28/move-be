package com.movenow.movenow.service;

import com.movenow.movenow.domain.Media;
import com.movenow.movenow.domain.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageService {
    @Autowired
    private MediaRepository mediaRepository;

    public Media store(MultipartFile file) throws IOException {
        Media media = new Media(file.getBytes());

        mediaRepository.save(media);
        media.setPictureUrl("/api/media/" + media.getId() + "/download");
        mediaRepository.save(media);
        
        return media;
    }

    public Media store(String videoUrl)
    {
        Media media = new Media(videoUrl);
        mediaRepository.save(media);

        return media;
    }

    public Media getMedia(Long id) {        
        return mediaRepository.findById(id).get();
    }
    
    public Media updateMedia(Long id, Media media){
        var updatedMedia = mediaRepository.findById(id).orElseThrow(RuntimeException::new);
        updatedMedia.setFile(media.getFile());
        updatedMedia = mediaRepository.save(media);
        
        return updatedMedia;
    }

    public void deleteFileById(Long id) {
        mediaRepository.deleteById(id);
    }

    public byte[] getFile(Long id) {
        return getMedia(id).getFile();
    }
}
