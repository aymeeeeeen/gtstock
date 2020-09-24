package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
