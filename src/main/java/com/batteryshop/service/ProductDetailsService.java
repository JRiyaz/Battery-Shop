package com.batteryshop.service;

import com.batteryshop.entity.ProductDetailsEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductDetailsService {

    List<ProductDetailsEntity> findAll();

    List<ProductDetailsEntity> findAll(Sort sort);

    List<ProductDetailsEntity> findAllById(Iterable<String> iterable);

    <S extends ProductDetailsEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends ProductDetailsEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<ProductDetailsEntity> iterable);

    void deleteAllInBatch();

    ProductDetailsEntity getOne(String s);

    <S extends ProductDetailsEntity> List<S> findAll(Example<S> example);

    <S extends ProductDetailsEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<ProductDetailsEntity> findAll(Pageable pageable);

    <S extends ProductDetailsEntity> S save(S s);

    Optional<ProductDetailsEntity> findById(String s);

    boolean existsById(String s);

    long count();

    void deleteById(String s);

    void delete(ProductDetailsEntity productDetailsEntity);

    void deleteAll(Iterable<? extends ProductDetailsEntity> iterable);

    void deleteAll();

    <S extends ProductDetailsEntity> Optional<S> findOne(Example<S> example);

    <S extends ProductDetailsEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends ProductDetailsEntity> long count(Example<S> example);

    <S extends ProductDetailsEntity> boolean exists(Example<S> example);
}
