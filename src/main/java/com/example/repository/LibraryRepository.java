package com.example.repository;

// JpaRepositoryを拡張してデータベースのCRUD操作を行うインターフェース
// サービスクラスに機能を提供する
// エンティティクラスとデータベースを正しくマッピングする

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
// <エンティティクラス, 主キー>とすることでエンティティクラスとデータベースが正しくマッピングされる
}
