package com.batteryshop.service;

import com.batteryshop.entity.ProductEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductService {
    List<ProductEntity> findAll();

    List<ProductEntity> findAll(Sort sort);

    List<ProductEntity> findAllById(Iterable<String> iterable);

    <S extends ProductEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends ProductEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<ProductEntity> iterable);

    void deleteAllInBatch();

    ProductEntity getOne(String s);

    <S extends ProductEntity> List<S> findAll(Example<S> example);

    <S extends ProductEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<ProductEntity> findAll(Pageable pageable);

    <S extends ProductEntity> S save(S s);

    Optional<ProductEntity> findById(String s);

    boolean existsById(String s);

    long count();

    void deleteById(String s);

    void delete(ProductEntity productEntity);

    void deleteAll(Iterable<? extends ProductEntity> iterable);

    void deleteAll();

    <S extends ProductEntity> Optional<S> findOne(Example<S> example);

    <S extends ProductEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends ProductEntity> long count(Example<S> example);

    <S extends ProductEntity> boolean exists(Example<S> example);
}
