package com.movenow.movenow.application;


import com.movenow.movenow.LoadDatabase;
import com.movenow.movenow.domain.Media;
import com.movenow.movenow.domain.MediaRepository;
import com.movenow.movenow.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    private final MediaRepository mediaRepository;
    @Autowired
    private FileStorageService storageService;

    public MediaController(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }   

    @GetMapping("/{id}")
    public Media getMedia(@PathVariable Long id) {
        return storageService.getMedia(id);
    }

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    
    @GetMapping(
            value = "/{id}/download",
            produces = MediaType.IMAGE_GIF_VALUE
    )
    public byte[] getFile(@PathVariable Long id) {        
        var file = storageService.getFile(id);
        
        return file;
    }

    @PostMapping
    public ResponseEntity createMedia(@RequestParam("file") MultipartFile file) throws URISyntaxException, IOException {
        var savedMedia = storageService.store(file);
        
        return ResponseEntity.created(new URI("/media/" + savedMedia.getId())).body(savedMedia);        
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMedia(@PathVariable Long id, @RequestBody Media media) {
        var currentMedia = storageService.updateMedia(media);

        return ResponseEntity.ok(currentMedia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMedia(@PathVariable Long id) {
        storageService.deleteFileById(id);
        
        return ResponseEntity.ok().build();
    }
}
