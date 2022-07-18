package com.codegym.service;

import java.util.List;

public interface CRUD<E> {
    void create(E e);
    void edit(E e, int index);
    void delete(int index);
    List<E> getAll();
}
