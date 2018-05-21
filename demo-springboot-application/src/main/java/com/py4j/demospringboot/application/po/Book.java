package com.py4j.demospringboot.application.po;

import com.py4j.demospringboot.application.annotaion.KeyWordValidator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author Warren
 * @CreateTime 19.May.2018
 * @Version V1.0
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @KeyWordValidator(values = {"毛泽东"} , message = "{KeyWordValidator.book.writer}")
    private String writer;

    @NotNull
    @Size(min=5)
    private String introduction;

    public long getId() {
        return id;
    }

    public void setId(long pId) {
        id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String pWriter) {
        writer = pWriter;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String pIntroduction) {
        introduction = pIntroduction;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
