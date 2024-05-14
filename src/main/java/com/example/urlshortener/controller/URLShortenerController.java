package com.example.urlshortener.controller;

import com.example.urlshortener.service.URLShortenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/url")
public class URLShortenerController {

    private final URLShortenerService urlShortenerService;
    private static final Logger LOG = Logger.getLogger(URLShortenerController.class.getName());

    public URLShortenerController(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenURL(@RequestBody String longURL) {
        String shortURL = urlShortenerService.shortenURL(longURL);
        return new ResponseEntity<>(shortURL, HttpStatus.OK);
    }

    @GetMapping("/{shortUrl}")
    public RedirectView getLongUrl(@PathVariable("shortUrl") String shortUrl) {
        LOG.info(String.format("Getting long URL for short URL: %s", shortUrl));
        String longUrl = urlShortenerService.getLongURL(shortUrl);
        LOG.info(String.format("Long URL: %s", longUrl));
        return new RedirectView(longUrl);
    }
}
