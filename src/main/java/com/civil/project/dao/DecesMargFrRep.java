package com.civil.project.dao;

import com.civil.project.entity.MarginaleDecesAr;
import com.civil.project.entity.MarginaleDecesFr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecesMargFrRep extends JpaRepository<MarginaleDecesFr,Integer> {
}
