package com.civil.project.dao;

import com.civil.project.entity.ActeNaissance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaissanceActeRep_user2 extends JpaRepository<ActeNaissance, Integer> {
}
