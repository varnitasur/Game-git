package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Prize;

@Repository
public interface PrizeRepository extends JpaRepository<Prize, Integer>{
	
	Optional<Prize> findBywin(String prizeName);

}
