package com.picoulet.springdelamort.repositories;

import com.picoulet.springdelamort.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
