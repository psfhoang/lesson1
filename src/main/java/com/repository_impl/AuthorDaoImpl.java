package com.repository_impl;

import com.entity.Author;
import com.repository.AuthorDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorDaoImpl  implements AuthorDao {
    @Override
    public Author getObject(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public List<Author> getList(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public List<Author> findAll() throws SQLException {
        return null;
    }

    @Override
    public Author findById(int id) throws SQLException {
        return null;
    }

    @Override
    public Author insert(Author author) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Author author) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}
