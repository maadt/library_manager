package com.example.service;

import java.time.LocalDateTime;
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
	
	// 挿入処理
	public Log save(Integer id, Integer userId, String returnDueDate) {
				
		Log log = new Log(); 
		log.setLibraryId(id); // LIBRARY_ID は対象の書籍のIDとする
		log.setUserId(userId); // USER_ID は現在ログインしているユーザーのIDとする
		LocalDateTime rentDate = LocalDateTime.now(); // RENT_DATE は現在の日付とする
		log.setRentDate(rentDate);
		LocalDateTime parsedDate = LocalDateTime.parse(returnDueDate + "T00:00:00");
		// 引数には、返却予定日と T00:00:00を文字連結する
		// 指定した日付を LocalDateTimeとして保存するには parse()メソッドを利用する
		log.setReturnDueDate(parsedDate); // RETURN_DUE_DATE はフォームから送られてきた返却予定日とする
		log.setReturnDate(null);// return_dateにはNULLを設定
		return this.logRepository.save(log); // itemRepositoryを介してDBにデータが保存される
	}
}
