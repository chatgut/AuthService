package com.example.urlshortener.controller;

import com.example.urlshortener.service.URLShortenerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class URLShortenerController {
    private final URLShortenerService urlShortenerService;

    public URLShortenerController(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }
}
