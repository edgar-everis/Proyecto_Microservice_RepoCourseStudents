package com.main.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.RepoCourseStudents;
import com.main.repository.RepoCourseStundetsRepository;
import com.main.service.RepoCourseStudentsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RepoCourseStudentsImpl implements RepoCourseStudentsService {

    @Autowired
    private RepoCourseStundetsRepository repository;

    @Override
    public Flux<RepoCourseStudents> GetAll() {

        return repository.findAll();
    }

    @Override
    public Mono<RepoCourseStudents> findById(String id) {

        return repository.findById(id);
    }

    @Override
    public Mono<RepoCourseStudents> CreateRepocourseStudents(RepoCourseStudents repocourse) {

        return repository.save(repocourse);
    }

    @Override

    public Mono<RepoCourseStudents> ModifyStudent(String id, RepoCourseStudents repocourse) {

        repocourse.setId(id);
        return repository.save(repocourse);
    }

    @Override
    public Mono<Void> DeleteById(String id) {

        return repository.deleteById(id);
    }

    @Override
    public Flux<RepoCourseStudents> findByIdstudent(String idstudent) {

        return repository.findByIdstudent(idstudent);
    }

    @Override
    public Flux<RepoCourseStudents> findByIdstudentAndStatus(String idstudent, String status) {

        return repository.findByIdstudentAndStatus(idstudent, status);
    }

    @Override
    public Flux<RepoCourseStudents> findByIdstudentAndCondition(String idstudent, String condition) {

        return repository.findByIdstudentAndCondition(idstudent, condition);
    }

}
