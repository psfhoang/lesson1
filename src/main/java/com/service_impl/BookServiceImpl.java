package com.service_impl;

import com.dto.BookWithAuthorName;
import com.entity.Book;
import com.exception.ErrorDetails;
import com.exception.ResourceAlreadyExistException;
import com.exception.ResourceNotFoundException;
import com.repository_impl.BookDaoImpl;
import com.service.BookService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();
    @Override
    public List<Book> findAll() throws SQLException {
        return bookDao.findAll();
    }
    public List<BookWithAuthorName> bookWithAuthorNames() throws SQLException {
        return bookDao.getBookWithAuthorName();
    }
    @Override
    public Book findById(int id) throws SQLException {
        Book book = bookDao.findById(id);
        if(book == null){
            throw new ResourceNotFoundException((long) id);
        }
        return book;
    }

    @Override
    public Book insert(Book book) throws SQLException {
        Book book1=null;
        if(bookDao.findBookByName(book.getName())!=null){
            throw new ResourceAlreadyExistException(book.getName());
        }
        try{
             book1 =  bookDao.insert(book);
        }catch (SQLIntegrityConstraintViolationException e){
            //Đoạn này phải dùng Author service để check xem author có tồn tại không
            System.out.println("Id của Author k tồn tại"); ;
        }

        return book1;
    }

    @Override
    public boolean Update(Book book) throws SQLException {
        Boolean temp = false;
        try {
            temp = bookDao.update(book);
        }catch (SQLIntegrityConstraintViolationException e){
            //Đoạn này phải dùng Author service để check xem author có tồn tại không
            temp=false;
        }
        return temp;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Book book = bookDao.findById(id);
        if(book==null){
            throw new ResourceNotFoundException((long)id);
        }
        return bookDao.delete(id);
    }


}
