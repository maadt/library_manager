package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Library;
import com.example.service.LibraryService;

@Controller
@RequestMapping("library")
public class LibraryController {
	
	private final LibraryService libraryService;
	
	@Autowired
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
	
	@GetMapping("/borrow")
	// @RequestParamによって{id}は必要無い
	public String borrowingForm(@RequestParam("id") Integer id, Model model) {
		//@RequestParam()：Webリクエストから特定のリクエストパラメータをメソッドのパラメータにバインドする
		Library library = this.libraryService.findById(id);
		// Library library：書籍情報（library）を定義
		// this.libraryService.findById(id)：リクエストパラメータで渡された書籍IDに該当する書籍情報を1件取得し代入
		model.addAttribute("library", library);
		return "library/borrowingForm";
		// library/borrowingForm.htmlを返す
	}
}