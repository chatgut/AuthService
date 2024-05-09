package com.example.urlshortener.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class URLShortenerController {

    private final Map<String, String> urlMap = new HashMap<>();

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String longUrl) {
        String shortUrl = generateShortUrl();
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    private static String generateShortUrl() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    @GetMapping("/{shortUrl}")
    public String redirect(@PathVariable String shortUrl) {
        String longUrl = urlMap.get(shortUrl);
        if (longUrl != null) {
            return "redirect:" + longUrl;
        } else {
            return "Shortened URL not found";
        }
    }
}
