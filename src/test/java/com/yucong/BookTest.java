package com.yucong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.yucong.dao.BookRepository;
import com.yucong.entity.Book;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApp.class)
public class BookTest {

    @Autowired
    private ElasticsearchTemplate esTemplete;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createIndex() {
        boolean createIndex = esTemplete.createIndex(Book.class);
        System.out.println(createIndex);
    }

    @Test
    public void deleteIndex() {
        boolean deleteIndex = esTemplete.deleteIndex(Book.class);
        System.out.println(deleteIndex);
    }

    @Test
    public void save() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("笑傲江湖", "令狐冲任盈盈辟邪剑谱葵花宝典吸星大法", new Date(), 24.34, 100));
        bookRepository.saveAll(list);
    }

}
