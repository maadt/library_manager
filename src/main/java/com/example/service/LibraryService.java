package com.example.service;

// コントローラーによって実行される
// リポジトリインターフェースを持つ

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Library;
import com.example.repository.LibraryRepository;


@Service
public class LibraryService {
	
	private final LibraryRepository libraryRepository;
	// このサービスクラスはリポジトリインターフェースをフィールドとして持つ
	
	@Autowired // libraryRepositoryにリポジトリインターフェースの機能を提供する（依存性注入）
	public LibraryService(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}
	
	public List<Library> findAll() {
	// エンティティクラスに全てのデータがList型で格納される
		return this.libraryRepository.findAll();
		// 依存性注入によって提供されたリポジトリインターフェースの機能「findAll()」を実行
	}
}
