package com.entity;

public class Book {
    private int id;
    protected String name;
    private int author_Id;

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }

    public Book(String name, int author_Id) {
        this.name = name;
        this.author_Id = author_Id;
    }

    public Book(int id, String name, int author_Id) {
        this.id = id;
        this.name = name;
        this.author_Id = author_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthor_Id() {
        return author_Id;
    }

    public void setAuthor_Id(int author_Id) {
        this.author_Id = author_Id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author_Id=" + author_Id +
                '}';
    }
}
