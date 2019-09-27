package com.main.expose;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.RepoCourseStudents;
import com.main.service.RepoCourseStudentsService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/API/RepoCourseStu")
public class ControllerRepoCourseStudents {

  private static Logger log = LoggerFactory.getLogger(ControllerRepoCourseStudents.class);

  @Autowired private RepoCourseStudentsService reposervice;

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<RepoCourseStudents> createCourseStudents(@RequestBody RepoCourseStudents repocourse) {
    return reposervice.CreateRepocourseStudents(repocourse);
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteCourseStudents(@PathVariable String id) {
    return reposervice.DeleteById(id);
  }

  @GetMapping("/coursestatus/{idstudent}")
  public Flux<RepoCourseStudents> FindbyIdstudent(@PathVariable String idstudent) {
    return reposervice.findByIdstudent(idstudent);
  }

  @GetMapping("/coursecondition/{idstudent}/{condition}")
  public Flux<RepoCourseStudents> FindbyIdstudentAndCondition(
      @PathVariable String idstudent, @PathVariable String condition) {
    return reposervice.findByIdstudentAndCondition(idstudent, condition);
  }

  @GetMapping("/coursestatus/{idstudent}/{status}")
  public Flux<RepoCourseStudents> FindbyIdstudentAndStatus(
      @PathVariable String idstudent, @PathVariable String status) {
    return reposervice.findByIdstudentAndStatus(idstudent, status);
  }

  @GetMapping
  public Flux<RepoCourseStudents> Getall() {
    return reposervice.GetAll();
  }

  @PutMapping("/update/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<RepoCourseStudents> updateCourseStudents(
      @PathVariable String id, @RequestBody RepoCourseStudents repocourse) {
    return reposervice.ModifyStudent(id, repocourse);
  }
}
