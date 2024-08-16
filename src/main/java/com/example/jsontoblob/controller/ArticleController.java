package com.example.jsontoblob.controller;

import com.example.jsontoblob.dto.ArticleDto;
import com.example.jsontoblob.model.Article;
import com.example.jsontoblob.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable Long id) throws SQLException, IOException {
        return ResponseEntity.ok().body(articleService.getArticleById(id));
    }
}
