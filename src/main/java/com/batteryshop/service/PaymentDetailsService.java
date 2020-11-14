package com.batteryshop.service;

import com.batteryshop.entity.PaymentDetailsEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PaymentDetailsService {
    List<PaymentDetailsEntity> findAll();

    List<PaymentDetailsEntity> findAll(Sort sort);

    List<PaymentDetailsEntity> findAllById(Iterable<Integer> iterable);

    <S extends PaymentDetailsEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends PaymentDetailsEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<PaymentDetailsEntity> iterable);

    void deleteAllInBatch();

    PaymentDetailsEntity getOne(Integer integer);

    <S extends PaymentDetailsEntity> List<S> findAll(Example<S> example);

    <S extends PaymentDetailsEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<PaymentDetailsEntity> findAll(Pageable pageable);

    <S extends PaymentDetailsEntity> S save(S s);

    Optional<PaymentDetailsEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(PaymentDetailsEntity paymentDetailsEntity);

    void deleteAll(Iterable<? extends PaymentDetailsEntity> iterable);

    void deleteAll();

    <S extends PaymentDetailsEntity> Optional<S> findOne(Example<S> example);

    <S extends PaymentDetailsEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends PaymentDetailsEntity> long count(Example<S> example);

    <S extends PaymentDetailsEntity> boolean exists(Example<S> example);
}
