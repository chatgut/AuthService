package com.example.urlshortener.service;

import com.example.urlshortener.entity.URLShortenerEntity;
import com.example.urlshortener.repository.URLShortenerRepository;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class URLShortenerService {

    private final URLShortenerRepository urlShortenerRepository;
    private static final Logger logger = Logger.getLogger(URLShortenerService.class.getName());

    public URLShortenerService(URLShortenerRepository urlShortenerRepository) {
        this.urlShortenerRepository = urlShortenerRepository;
    }

    public String shortenURL(String longURL) {
        String shortURL = generateShortURL(longURL);
        URLShortenerEntity entity = new URLShortenerEntity(longURL, shortURL);
        urlShortenerRepository.save(entity);
        return shortURL;
    }

    public String getLongURL(String shortURL) {
        URLShortenerEntity entity = urlShortenerRepository.findByShortURL(shortURL);
        if (entity != null) {
            return entity.getLongURL();
        } else {
            logger.log(Level.WARNING, "Short URL not found: " + shortURL);
            throw new RuntimeException("Short URL not found");
        }
    }

    private String generateShortURL(String longURL) {
        String hash = generateHash(longURL);
        return "http://localhost:8080/" + hash.substring(0, 7);
    }

    private String generateHash(String longURL) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(longURL.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "SHA-256 algorithm not found", e);
            return longURL;
        }
    }
}
