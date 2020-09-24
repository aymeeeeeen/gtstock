package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
