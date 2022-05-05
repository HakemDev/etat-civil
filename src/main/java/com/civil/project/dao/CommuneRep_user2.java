package com.civil.project.dao;

import com.civil.project.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRep_user2 extends JpaRepository<Commune,Integer> {
}
