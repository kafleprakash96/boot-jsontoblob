package com.example.jsontoblob.repo;

import com.example.jsontoblob.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
