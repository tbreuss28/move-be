package com.movenow.movenow.application;


import com.movenow.movenow.domain.Media;
import com.movenow.movenow.service.FileStorageService;
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
public class MediaController
{
    @Autowired
    private FileStorageService storageService;

    @GetMapping("/{id}")
    public Media getMedia(@PathVariable Long id)
    {
        return storageService.getMedia(id);
    }

    @GetMapping(value = "/{id}/download", produces = MediaType.IMAGE_GIF_VALUE)
    public byte[] getFile(@PathVariable Long id)
    {
        return storageService.getFile(id);
    }

    @PostMapping
    public ResponseEntity createMedia(@RequestParam("file") MultipartFile file) throws URISyntaxException, IOException
    {
        var savedMedia = storageService.store(file);

        return ResponseEntity.created(new URI("/media/" + savedMedia.getId())).body(savedMedia);
    }

    @PostMapping("/createLink")
    public ResponseEntity createMedia(@RequestParam("Url") String url) throws URISyntaxException
    {
        var savedMedia = storageService.store(url);

        return ResponseEntity.created(new URI("/media/" + savedMedia.getId())).body(savedMedia);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMedia(@PathVariable Long id, @RequestBody Media media)
    {
        var currentMedia = storageService.updateMedia(id, media);

        return ResponseEntity.ok(currentMedia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMedia(@PathVariable Long id)
    {
        storageService.deleteFileById(id);

        return ResponseEntity.ok().build();
    }
}
