package com.main.ServiceImplements;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.main.model.RepoCourseStudents;

import com.main.repository.RepoCourseStundetsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class RepoCourseStudentsImplTest {

  @Mock private RepoCourseStundetsRepository Repository;
  @InjectMocks private RepoCourseStudentsImpl Service;

  @Test
  public void testCreateRepocourseStudents() {
    RepoCourseStudents repo = new RepoCourseStudents();
    repo.setId("1");
    repo.setIdcourse("C01");
    repo.setIdstudent("STU01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");

    when(Repository.save(repo)).thenReturn(Mono.just(repo));
    Mono<RepoCourseStudents> actual = Service.CreateRepocourseStudents(repo);
    assertResults(actual, repo);
  }

  @Test
  public void testDeleteById() {
    RepoCourseStudents repo = new RepoCourseStudents();
    repo.setId("1");
    repo.setIdcourse("C01");
    repo.setIdstudent("P01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");
    when(Repository.delete(repo)).thenReturn(Mono.empty());
  }

  @Test
  public void testFindById() {
    RepoCourseStudents stu = new RepoCourseStudents();
    stu.setId("4");
    stu.setIdcourse("C01");
    stu.setIdstudent("P01");
    stu.setStatus("iniciado");
    stu.setCondition("Activo");

    when(Repository.findById("4")).thenReturn(Mono.just(stu));
    Mono<RepoCourseStudents> actual = Service.findById("4");
    assertResults(actual, stu);
    System.out.println(actual);
    System.out.println(stu.getIdcourse());
  }

  @Test
  public void testFindByIdstudent() {
    RepoCourseStudents repo = new RepoCourseStudents();
    repo.setId("4");
    repo.setIdcourse("C01");
    repo.setIdstudent("STU01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");

    when(Repository.findByIdstudent("STU01")).thenReturn(Flux.just(repo));
    Flux<RepoCourseStudents> actual = Service.findByIdstudent("STU01");
    assertResults(actual, repo);
    System.out.println(actual);
    System.out.println(repo.getIdstudent());
  }

  @Test
  public void testFindByIdstudentAndCondition() {
    RepoCourseStudents repo = new RepoCourseStudents();
    repo.setId("4");
    repo.setIdcourse("C01");
    repo.setIdstudent("STU01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");

    when(Repository.findByIdstudentAndCondition("STU01", "Activo")).thenReturn(Flux.just(repo));
    Flux<RepoCourseStudents> actual = Service.findByIdstudentAndCondition("STU01", "Activo");
    assertResults(actual, repo);
    System.out.println(actual);
    System.out.println(repo.getIdstudent());
  }

  @Test
  public void testFindByIdstudentAndStatus() {
    RepoCourseStudents repo = new RepoCourseStudents();
    repo.setId("5");
    repo.setIdcourse("C01");
    repo.setIdstudent("STU01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");

    when(Repository.findByIdstudentAndStatus("STU01", "iniciado")).thenReturn(Flux.just(repo));
    Flux<RepoCourseStudents> actual = Service.findByIdstudentAndStatus("STU01", "iniciado");
    assertResults(actual, repo);
    System.out.println(actual);
    System.out.println(repo.getIdstudent());
  }

  @Test
  public void testGetAll() {
    RepoCourseStudents repo = new RepoCourseStudents();
    repo.setId("1");
    repo.setIdcourse("C01");
    repo.setIdstudent("STU01");
    repo.setCondition("Activo");
    repo.setStatus("Activo");
    when(Service.GetAll()).thenReturn(Flux.just(repo));
    Flux<RepoCourseStudents> actual = Service.GetAll();
    assertResults(actual, repo);
  }

  private void assertResults(
      Publisher<RepoCourseStudents> publisher, RepoCourseStudents... expectedProducts) {
    StepVerifier.create(publisher).expectNext(expectedProducts).verifyComplete();
  }
}
