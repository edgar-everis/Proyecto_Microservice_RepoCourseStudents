package com.main.repository;

import com.main.model.RepoCourseStudents;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface RepoCourseStundetsRepository extends ReactiveMongoRepository<RepoCourseStudents, String> {
    Flux<RepoCourseStudents> findByIdstudentAndCondition(String idstudent, String condition);

    Flux<RepoCourseStudents> findByIdstudentAndStatus(String idstudent, String status);

    Flux<RepoCourseStudents> findByIdstudent(String idstudent);
}
