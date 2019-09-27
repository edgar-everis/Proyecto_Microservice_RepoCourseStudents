package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.main.model.RepoCourseStudents;

import reactor.core.publisher.Flux;

@Repository
public interface RepoCourseStundetsRepository
    extends ReactiveMongoRepository<RepoCourseStudents, String> {

  Flux<RepoCourseStudents> findByIdstudent(String idstudent);

  Flux<RepoCourseStudents> findByIdstudentAndCondition(String idstudent, String condition);

  Flux<RepoCourseStudents> findByIdstudentAndStatus(String idstudent, String status);
}
