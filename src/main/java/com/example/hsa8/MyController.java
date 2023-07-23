package com.example.hsa8;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;


@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Resource get() throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getResource("/static/Zugpsitze_mountain.jpg").toURI());
        System.out.println("image requested ; " + Date.from(Instant.now()));
        return new ByteArrayResource(Files.readAllBytes(path));
    }
}
