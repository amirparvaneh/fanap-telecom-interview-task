package com.fanap.telecom.service;

public interface BaseService<T> {
    void save(T t);

    void delete(Long id);

    T find(Long id);
}
