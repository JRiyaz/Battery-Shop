package com.batteryshop.service;

import com.batteryshop.entity.UserDetailsEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserDetailsService {

    List<UserDetailsEntity> findAll();

    List<UserDetailsEntity> findAll(Sort sort);

    List<UserDetailsEntity> findAllById(Iterable<Integer> iterable);

    <S extends UserDetailsEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends UserDetailsEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<UserDetailsEntity> iterable);

    void deleteAllInBatch();

    UserDetailsEntity getOne(Integer integer);

    <S extends UserDetailsEntity> List<S> findAll(Example<S> example);

    <S extends UserDetailsEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<UserDetailsEntity> findAll(Pageable pageable);

    <S extends UserDetailsEntity> S save(S s);

    Optional<UserDetailsEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(UserDetailsEntity userDetailsEntity);

    void deleteAll(Iterable<? extends UserDetailsEntity> iterable);

    void deleteAll();

    <S extends UserDetailsEntity> Optional<S> findOne(Example<S> example);

    <S extends UserDetailsEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends UserDetailsEntity> long count(Example<S> example);

    <S extends UserDetailsEntity> boolean exists(Example<S> example);
}
