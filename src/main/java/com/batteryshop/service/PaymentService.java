package com.batteryshop.service;

import com.batteryshop.entity.PaymentEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PaymentService {
    List<PaymentEntity> findAll();

    List<PaymentEntity> findAll(Sort sort);

    List<PaymentEntity> findAllById(Iterable<Integer> iterable);

    <S extends PaymentEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends PaymentEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<PaymentEntity> iterable);

    void deleteAllInBatch();

    PaymentEntity getOne(Integer integer);

    <S extends PaymentEntity> List<S> findAll(Example<S> example);

    <S extends PaymentEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<PaymentEntity> findAll(Pageable pageable);

    <S extends PaymentEntity> S save(S s);

    Optional<PaymentEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(PaymentEntity paymentEntity);

    void deleteAll(Iterable<? extends PaymentEntity> iterable);

    void deleteAll();

    <S extends PaymentEntity> Optional<S> findOne(Example<S> example);

    <S extends PaymentEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends PaymentEntity> long count(Example<S> example);

    <S extends PaymentEntity> boolean exists(Example<S> example);
}
