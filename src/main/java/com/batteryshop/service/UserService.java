package com.batteryshop.service;

import com.batteryshop.entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

    Optional<UserEntity> findByEmailOrMobile(String email);

    List<UserEntity> findAll();

    List<UserEntity> findAll(Sort sort);

    List<UserEntity> findAllById(Iterable<Integer> iterable);

    <S extends UserEntity> List<S> saveAll(Iterable<S> iterable);

    void deleteInBatch(Iterable<UserEntity> iterable);

    UserEntity getOne(Integer integer);

    <S extends UserEntity> List<S> findAll(Example<S> example);

    <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<UserEntity> findAll(Pageable pageable);

    <S extends UserEntity> S save(S s);

    Optional<UserEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(UserEntity userEntity);

    void deleteAll(Iterable<? extends UserEntity> iterable);

    void deleteAll();

    <S extends UserEntity> Optional<S> findOne(Example<S> example);

    <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends UserEntity> long count(Example<S> example);

    <S extends UserEntity> boolean exists(Example<S> example);
}
