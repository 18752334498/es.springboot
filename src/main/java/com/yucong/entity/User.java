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
@Document(indexName = "user", type = "doc", shards = 1, replicas = 0) // 分片为，副本为0
public class User {

    /**
     * @Description: @Id注解必须是springframework包下的 org.springframework.data.annotation.Id
     * @Author: https://blog.csdn.net/chen_2890
     */
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Keyword)
    private String sex;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String hobby;

    @Field(type = FieldType.Keyword)
    private String province;

    @Field(type = FieldType.Keyword)
    private String city;

    @Field(type = FieldType.Date)
    private Date birth;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String intro;

}
