package com.main.service;

import com.main.model.RepoCourseStudents;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RepoCourseStudentsService {

    Flux<RepoCourseStudents> findByIdstudentAndCondition(String idstudent, String condition);

    Flux<RepoCourseStudents> findByIdstudentAndStatus(String idstudent, String status);

    Flux<RepoCourseStudents> findByIdstudent(String idstudent);

    Flux<RepoCourseStudents> GetAll();

    Mono<RepoCourseStudents> findById(String id);

    Mono<RepoCourseStudents> CreateRepocourseStudents(RepoCourseStudents repocourse);

    Mono<RepoCourseStudents> ModifyStudent(String id, RepoCourseStudents repocourse);

    Mono<Void> DeleteById(String id);

}
