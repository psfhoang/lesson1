package com.repository;

import com.entity.Book;

import java.sql.SQLException;

public interface BookDao extends BaseDao<Book> {
    public Book findBookByName(String name) throws SQLException;
}
