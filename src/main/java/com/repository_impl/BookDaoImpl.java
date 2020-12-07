package com.repository_impl;

import com.dto.BookWithAuthorName;
import com.entity.MyConnection;
import com.repository.BookDao;
import com.entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    MyConnection myConnection = new MyConnection();
    @Override
    public Book getObject(ResultSet resultSet) throws SQLException {
        Book book = null;
        book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
        return book;
    }
    public List<BookWithAuthorName> getBookWithAuthorName() throws SQLException{
        String sql = "SELECT book.name,author.name FROM book inner join author on book.author_id=author.id";
        try {
            List<BookWithAuthorName> bookWithAuthorNames= new ArrayList<>();
            PreparedStatement preparedStatement = myConnection.connection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                BookWithAuthorName bookWithAuthorName = new BookWithAuthorName(resultSet.getString(1),resultSet.getString(2));
                if(bookWithAuthorName!=null){
                    bookWithAuthorNames.add(bookWithAuthorName);
                }
            }
            return bookWithAuthorNames;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    @Override
    public List<Book> getList(ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = this.getObject(resultSet);
            if(book!=null){
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findAll() throws SQLException {
        String sql = "select * from book";
        try {
            PreparedStatement preparedStatement = myConnection.connection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE);
            return this.getList(preparedStatement.executeQuery());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Book findById(int id) throws SQLException {
        String sql="select * from book where id = ? ";
        try {
            Book book = null;
            PreparedStatement preparedStatement = myConnection.connection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                book = this.getObject(resultSet);
            }
            return book;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book insert(Book book) throws SQLException {
        Book book1 = null;
        String sql = "insert into book(name,author_id) values(?,?)";
        try {
            PreparedStatement preparedStatement = myConnection.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setInt(2,book.getAuthor_Id());
            int rs = preparedStatement.executeUpdate();
            if(rs>0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()){
                    int id=(int) resultSet.getLong(1);
                    book1 = this.findById(id);
                }
            }
            System.out.println(book1);
            return book1;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        String sql ="update book set name = ?,author_id = ? where id = ?";
        try {
            PreparedStatement preparedStatement = myConnection.connection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setInt(2,book.getAuthor_Id());
            preparedStatement.setInt(3,book.getId());
            return preparedStatement.executeUpdate()>0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "delete from book where id = ?";
        try {
            PreparedStatement preparedStatement = myConnection.connection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Book findBookByName(String name) throws SQLException {
        String sql="select * from book where name = ? ";
        try {
            Book book = null;
            PreparedStatement preparedStatement = myConnection.connection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                book = this.getObject(resultSet);
            }
            return book;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
