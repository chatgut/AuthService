package com.example.urlshortener.controller;

import com.example.urlshortener.dto.UrlRequest;
import com.example.urlshortener.dto.UrlResponse;
import com.example.urlshortener.service.URLShortenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import java.util.logging.Logger;

@RestController
public class URLShortenerController {

    private final URLShortenerService urlShortenerService;
    private static final Logger LOG = Logger.getLogger(URLShortenerController.class.getName());

    public URLShortenerController(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponse> shortenURL(@RequestBody UrlRequest urlRequest) {
        String shortURL = urlShortenerService.shortenURL(urlRequest.getUrl());
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        UrlResponse urlResponse = new UrlResponse(baseUrl + "/" + shortURL);
        return new ResponseEntity<>(urlResponse, HttpStatus.OK);
    }

    @GetMapping("/{shortUrl}")
    public RedirectView getLongUrl(@PathVariable("shortUrl") String shortUrl) {
        LOG.info(String.format("Getting long URL for short URL: %s", shortUrl));
        String longUrl = urlShortenerService.getLongURL(shortUrl);
        LOG.info(String.format("Long URL: %s", longUrl));
        return new RedirectView(longUrl);
    }
}
