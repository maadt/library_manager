package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Log;
import com.example.repository.LogRepository;

@Service
public class LogService {
	private final LogRepository logRepository;
	// このサービスクラスはリポジトリインターフェースをフィールドとして持つ
	
	@Autowired // libraryRepositoryにリポジトリインターフェースの機能を提供する（依存性注入）
	public LogService(LogRepository logRepository) {
		this.logRepository = logRepository;
	}
	
	public List<Log> findAll() {
	// エンティティクラスに全てのデータがList型で格納される
		return this.logRepository.findAll();
		// 依存性注入によって提供されたリポジトリインターフェースの機能「findAll()」を実行
	}

}
