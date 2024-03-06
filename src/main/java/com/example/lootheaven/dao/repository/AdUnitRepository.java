package com.example.lootheaven.dao.repository;

import com.example.lootheaven.dao.models.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdUnitRepository extends JpaRepository<AdUnit, Long>{
    List<AdUnit> findAllByGame(String game);
}
