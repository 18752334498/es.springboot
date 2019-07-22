package com.yucong.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.yucong.entity.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String> {

}
