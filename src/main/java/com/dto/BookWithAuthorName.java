package com.dto;

import com.entity.Book;

public class BookWithAuthorName extends Book {
    private String nameAuthor;

    public BookWithAuthorName(String name, String nameAuthor) {
        super(name);
        this.nameAuthor = nameAuthor;
    }

    public BookWithAuthorName(int id, String name, int author_Id, String nameAuthor) {
        super(id, name, author_Id);
        this.nameAuthor = nameAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    @Override
    public String toString() {
        return "BookWithAuthorName{" +
                "nameAuthor='" + nameAuthor + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
