package com.service;

import java.sql.SQLException;
import java.util.List;


public interface BaseService<T> {
    List<T> findAll() throws SQLException;

    T findById(int id) throws SQLException;

    T insert(T t) throws SQLException;

    boolean Update(T t) throws SQLException;

    boolean delete(int id) throws SQLException;

}


