package com.batteryshop.service;

import com.batteryshop.entity.ImageEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ImageService {
    List<ImageEntity> findAll();

    List<ImageEntity> findAll(Sort sort);

    List<ImageEntity> findAllById(Iterable<Integer> iterable);

    <S extends ImageEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends ImageEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<ImageEntity> iterable);

    void deleteAllInBatch();

    ImageEntity getOne(Integer integer);

    <S extends ImageEntity> List<S> findAll(Example<S> example);

    <S extends ImageEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<ImageEntity> findAll(Pageable pageable);

    <S extends ImageEntity> S save(S s);

    Optional<ImageEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(ImageEntity imageEntity);

    void deleteAll(Iterable<? extends ImageEntity> iterable);

    void deleteAll();

    <S extends ImageEntity> Optional<S> findOne(Example<S> example);

    <S extends ImageEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends ImageEntity> long count(Example<S> example);

    <S extends ImageEntity> boolean exists(Example<S> example);
}
