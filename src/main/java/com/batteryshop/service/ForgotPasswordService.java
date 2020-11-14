package com.batteryshop.service;

import com.batteryshop.entity.ForgotPasswordEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ForgotPasswordService {

    List<ForgotPasswordEntity> findAll();

    List<ForgotPasswordEntity> findAll(Sort sort);

    List<ForgotPasswordEntity> findAllById(Iterable<Integer> iterable);

    <S extends ForgotPasswordEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends ForgotPasswordEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<ForgotPasswordEntity> iterable);

    void deleteAllInBatch();

    ForgotPasswordEntity getOne(Integer integer);

    <S extends ForgotPasswordEntity> List<S> findAll(Example<S> example);

    <S extends ForgotPasswordEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<ForgotPasswordEntity> findAll(Pageable pageable);

    <S extends ForgotPasswordEntity> S save(S s);

    Optional<ForgotPasswordEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(ForgotPasswordEntity forgotPasswordEntity);

    void deleteAll(Iterable<? extends ForgotPasswordEntity> iterable);

    void deleteAll();

    <S extends ForgotPasswordEntity> Optional<S> findOne(Example<S> example);

    <S extends ForgotPasswordEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends ForgotPasswordEntity> long count(Example<S> example);

    <S extends ForgotPasswordEntity> boolean exists(Example<S> example);
}
