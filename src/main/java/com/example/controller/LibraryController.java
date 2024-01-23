package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Library;
import com.example.service.LibraryService;
import com.example.service.LogService;
import com.example.service.LoginUser;

@Controller
@RequestMapping("library")
public class LibraryController {
	
	private final LibraryService libraryService;
	private final LogService logService;
	
	@Autowired
	public LibraryController(LibraryService libraryService, LogService logService) {
		this.libraryService = libraryService;
		this.logService = logService;
		
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
	// @RequestParamによって、ここで{id}は必要無い
	public String borrowingForm(@RequestParam("id") Integer id, Model model) {
		//@RequestParam()：Webリクエストから特定のリクエストパラメータをメソッドのパラメータにバインドする
		Library library = this.libraryService.findById(id);
		// Library library：書籍情報（library）を定義
		// this.libraryService.findById(id)：リクエストパラメータで渡された書籍IDに該当する書籍情報を1件取得し代入
		model.addAttribute("library", library);
		return "library/borrowingForm";
		// library/borrowingForm.htmlを返す
	}
	
	@PostMapping("/borrow")
	public String borrow(@RequestParam("id") Integer id, @RequestParam("return_due_date") String returnDueDate
			             , @AuthenticationPrincipal LoginUser loginUser) {
		// @AuthenticationPrincipal：認証済みユーザーのUserDetailsのインスタンスを直接取得する
		Library library = this.libraryService.findById(id);
		// 変数 library を定義し、リクエストパラメータで渡された書籍IDに該当する書籍情報を1件取得し代入する
		Integer userId = loginUser.getUserId();
		// 取得した書籍情報の USER_ID を ↓
		this.libraryService.update(id, userId);
		// 現在ログインしているユーザーのIDで上書きし LIBRARIES テーブルの情報を更新
		this.logService.save(id, userId, returnDueDate);
		return "redirect:/library";
		// リダイレクト
	}
	
	@PostMapping("/return")
	public String returnBook(@RequestParam("id") Integer id, @AuthenticationPrincipal LoginUser loginUser) {
		Library library = this.libraryService.findById(id); //1
		Integer userId = loginUser.getUserId();
		this.libraryService.update(id); //2
		this.logService.save(id, userId); //3
		return "redirect:/library"; //4
	}
}