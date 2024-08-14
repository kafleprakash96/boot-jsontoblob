package com.example.jsontoblob.controller;

import com.example.jsontoblob.dto.ArticleDto;
import com.example.jsontoblob.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/save")
    public ResponseEntity<ArticleDto> saveArticle(@RequestBody ArticleDto articleDto) throws SQLException {
        return ResponseEntity.ok().body(articleService.saveArticle(articleDto));
    }
}
