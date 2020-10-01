package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin("*")
public interface ArticleRepository extends JpaRepository<Article, Long> {
    public Page<Article> findByCodeArticleContains(String mc, Pageable pageable);

}


