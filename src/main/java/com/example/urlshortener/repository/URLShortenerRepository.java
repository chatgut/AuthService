package com.example.urlshortener.repository;

import com.example.urlshortener.entity.URLShortenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLShortenerRepository extends JpaRepository<URLShortenerEntity, Long> {
}