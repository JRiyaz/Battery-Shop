package com.batteryshop.service.impl;

import com.batteryshop.entity.UserEntity;
import com.batteryshop.repository.UserRepository;
import com.batteryshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Optional<UserEntity> findByEmailOrMobile(String email_mobile) {
        if (email_mobile.contains("@") && email_mobile.contains(".")) {
            System.err.println("Email " + email_mobile);
            return repository.findByEmail(email_mobile);
        }

//        try {
//            Long num = Long.valueOf(email_mobile);
//            System.err.println("Mobile " + email_mobile);
//            return repository.findByMobile(email_mobile);
//
//        } catch (Exception e) {
//            return Optional.of(new UserEntity());
//        }
        return Optional.empty();
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public List<UserEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<UserEntity> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public <S extends UserEntity> List<S> saveAll(Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

    @Override
    public void deleteInBatch(Iterable<UserEntity> iterable) {

    }

    @Override
    public UserEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends UserEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<UserEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserEntity> S save(S s) {
        return null;
    }

    @Override
    public Optional<UserEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(UserEntity userEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends UserEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserEntity> boolean exists(Example<S> example) {
        return false;
    }
}
