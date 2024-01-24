package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer>{
	Log findFirstByLibraryIdAndUserIdOrderByRentDateDesc(Integer id, Integer userId);
	List<Log> findByUserId(Integer userId);
}


