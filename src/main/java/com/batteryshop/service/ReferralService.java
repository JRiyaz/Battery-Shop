package com.batteryshop.service;

import com.batteryshop.entity.ReferralEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ReferralService {

    List<ReferralEntity> findAll();

    List<ReferralEntity> findAll(Sort sort);

    List<ReferralEntity> findAllById(Iterable<Integer> iterable);

    <S extends ReferralEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends ReferralEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<ReferralEntity> iterable);

    void deleteAllInBatch();

    ReferralEntity getOne(Integer integer);

    <S extends ReferralEntity> List<S> findAll(Example<S> example);

    <S extends ReferralEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<ReferralEntity> findAll(Pageable pageable);

    <S extends ReferralEntity> S save(S s);

    Optional<ReferralEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(ReferralEntity referralEntity);

    void deleteAll(Iterable<? extends ReferralEntity> iterable);

    void deleteAll();

    <S extends ReferralEntity> Optional<S> findOne(Example<S> example);

    <S extends ReferralEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends ReferralEntity> long count(Example<S> example);

    <S extends ReferralEntity> boolean exists(Example<S> example);
}
