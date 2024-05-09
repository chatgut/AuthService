package com.example.urlshortener.service;

import com.example.urlshortener.repository.URLShortenerRepository;
import org.springframework.stereotype.Service;

@Service
public class URLShortenerService {

    private final URLShortenerRepository urlShortenerRepository;

    public URLShortenerService(URLShortenerRepository urlShortenerRepository) {
        this.urlShortenerRepository = urlShortenerRepository;
    }


}
