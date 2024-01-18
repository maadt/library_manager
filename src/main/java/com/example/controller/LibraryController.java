package com.example.controller;

// リクエストされたURLに応じて処理を振り分ける
// サービスクラスを実行 > データをモデルに格納 > ビューに渡す

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Library;
import com.example.service.LibraryService;

@Controller
@RequestMapping("library")
public class LibraryController {
	
	private final LibraryService libraryService;
	
	@Autowired // このクラスでサービスクラスを使えるようにする
	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
	}
	
	@GetMapping // 接続名:ポート番号/libraryで実行される
	public String index(Model model) {
		List<Library> libraries = this.libraryService.findAll();
		// サービスクラスを実行して取得したデータを「libraries」とする
		model.addAttribute("libraries", libraries);
		// librariesをモデルに追加
		return "library/index";
		// index.htmlの表示
	}
}
