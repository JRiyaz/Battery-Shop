package com.batteryshop.service;

import com.batteryshop.entity.OrderEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderService {

    List<OrderEntity> findAll();

    List<OrderEntity> findAll(Sort sort);

    List<OrderEntity> findAllById(Iterable<Integer> iterable);

    <S extends OrderEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends OrderEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<OrderEntity> iterable);

    void deleteAllInBatch();

    OrderEntity getOne(Integer integer);

    <S extends OrderEntity> List<S> findAll(Example<S> example);

    <S extends OrderEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<OrderEntity> findAll(Pageable pageable);

    <S extends OrderEntity> S save(S s);

    Optional<OrderEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(OrderEntity orderEntity);

    void deleteAll(Iterable<? extends OrderEntity> iterable);

    void deleteAll();

    <S extends OrderEntity> Optional<S> findOne(Example<S> example);

    <S extends OrderEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends OrderEntity> long count(Example<S> example);

    <S extends OrderEntity> boolean exists(Example<S> example);
}
