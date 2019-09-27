package com.main.service;

import com.main.model.RepoCourseStudents;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RepoCourseStudentsService {

  Mono<RepoCourseStudents> CreateRepocourseStudents(RepoCourseStudents repocourse);

  Mono<Void> DeleteById(String id);

  Mono<RepoCourseStudents> findById(String id);

  Flux<RepoCourseStudents> findByIdstudent(String idstudent);

  Flux<RepoCourseStudents> findByIdstudentAndCondition(String idstudent, String condition);

  Flux<RepoCourseStudents> findByIdstudentAndStatus(String idstudent, String status);

  Flux<RepoCourseStudents> GetAll();

  Mono<RepoCourseStudents> ModifyStudent(String id, RepoCourseStudents repocourse);
}
