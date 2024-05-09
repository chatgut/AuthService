package com.example.urlshortener.controller;

import com.example.urlshortener.service.URLShortenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class URLShortenerController {

    private final URLShortenerService urlShortenerService;

    public URLShortenerController(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenURL(@RequestBody String longURL) {
        String shortURL = urlShortenerService.shortenURL(longURL);
        return new ResponseEntity<>(shortURL, HttpStatus.OK);
    }
}
