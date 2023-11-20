/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thai
 */
public interface DAOInterface <E, K> {

    abstract public int insert(E entity) throws SQLException ;

    abstract public int update(E entity) throws SQLException ;

    abstract public int delete(K key) throws SQLException ;

    abstract public List<E> selectAll() throws SQLException ;

    abstract public E selectByID(K key) throws SQLException ;

    abstract public List<E> selectBySQL(String sql, Object... args) throws SQLException ;

}
