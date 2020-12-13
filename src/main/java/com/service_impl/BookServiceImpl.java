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
    public List<Book> findAll()  {
        try {
            return bookDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<BookWithAuthorName> bookWithAuthorNames(){
        try {
            return bookDao.getBookWithAuthorName();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        try {
            book = bookDao.findById(id);
            if (book == null) {
                throw new ResourceNotFoundException((long) id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;
    }

    @Override
    public Book insert(Book book) {
        Book book1 = null;
        try {
            if (bookDao.findBookByName(book.getName()) != null) {
                throw new ResourceAlreadyExistException(book.getName());
            }
            book1 = bookDao.insert(book);
        } catch (SQLIntegrityConstraintViolationException e) {
            //Đoạn này phải dùng Author service để check xem author có tồn tại không
            System.out.println("Id của Author k tồn tại");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book1;
    }

    @Override
    public boolean Update(Book book) {
        Boolean temp = false;
        try {
            temp = bookDao.update(book);
        } catch (SQLIntegrityConstraintViolationException e) {
            //Đoạn này phải dùng Author service để check xem author có tồn tại không
            temp = false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return temp;
    }

    @Override
    public boolean delete(int id) {
        Book book = null;
        boolean temp = false;
        try {
            book = bookDao.findById(id);
            if (book == null) {
                throw new ResourceNotFoundException((long) id);
            }
            temp = bookDao.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return temp;
    }


}
