package com.kirillsoklakov.spring.boot.application.repository;

import com.kirillsoklakov.spring.boot.application.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends JpaRepository<Visitor, Long> {
}

