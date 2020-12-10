package com.controller;

import com.dto.BookWithAuthorName;
import com.dto.DataResponse;
import com.entity.Book;

import com.service_impl.BookServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;


import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;


public class BookController {
    private final BookServiceImpl bookService = new BookServiceImpl();
    public DataResponse<List<Book>> getAllBooks() throws SQLException {
        return new DataResponse<>(200,"ok",bookService.findAll());
    }
    public DataResponse<Book> findBookById(int id) throws SQLException{
        return new DataResponse<>(200,"ok",bookService.findById(id));
    }
    public DataResponse<List<BookWithAuthorName>> bookWithAuthorNameDataResponse() throws SQLException {
        return new DataResponse<>(200,"ok",bookService.bookWithAuthorNames());
    }
    public DataResponse<Book> insertBook(Book book) throws SQLException {
        return new DataResponse<>(200,"ok",bookService.insert(book));
    }
    public DataResponse<Boolean> updateBook(Book book) throws SQLException{
        return new DataResponse<>(200,"ok",bookService.Update(book));
    }
    public DataResponse<Boolean> deleteBook(int id) throws SQLException{
        return new DataResponse<>(200,"ok",bookService.delete(id));
    }
}
