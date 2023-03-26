package com.gl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
