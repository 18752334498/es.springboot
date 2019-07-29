package com.yucong.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "bk", type = "doc", shards = 1, replicas = 0) // 分片为1，副本为0
public class Book {

    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String intro;

    @Field(type = FieldType.Date)
    private Date publish;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Integer)
    private Integer page;

    public Book(String name, String intro, Date publish, Double price, Integer page) {
        super();
        this.name = name;
        this.intro = intro;
        this.publish = publish;
        this.price = price;
        this.page = page;
    }

}
