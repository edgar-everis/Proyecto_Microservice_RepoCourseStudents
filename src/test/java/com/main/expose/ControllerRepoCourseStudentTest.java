package com.main.expose;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.main.model.RepoCourseStudents;

import com.main.repository.RepoCourseStundetsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class ControllerRepoCourseStudentTest {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private RepoCourseStundetsRepository Repository;
    private WebTestClient client;
    private List<RepoCourseStudents> expectedProducts;
  @BeforeEach
  void setUp() throws Exception {
      client = WebTestClient
	      .bindToApplicationContext(applicationContext)
	      .configureClient()
	      .baseUrl("/API/RepoCourseTeachers")
	      .build();

	    Flux<RepoCourseStudents> initData = Repository.deleteAll()
	      .thenMany(Flux.just(
	RepoCourseStudents.builder().id("1").idcourse("C01").idstudent("STU01").status("Activo").condition("Iniciado").build(),
	RepoCourseStudents.builder().id("2").idcourse("C02").idstudent("STU02").status("Activo").condition("Iniciado").build())
	        .flatMap(Repository::save))
	      .thenMany(Repository.findAll());

	    expectedProducts = initData.collectList().block();
  }

  @Test
  void testCreateCourseStudents() {
      RepoCourseStudents expectedProduct = expectedProducts.get(0);
      client.post().uri("/create").body(Mono.just(expectedProduct), RepoCourseStudents.class).exchange()
        .expectStatus().isCreated();
  }

  @Test
  void testDeleteCourseStudents() {
      RepoCourseStudents productToDelete = expectedProducts.get(0);
      client.delete().uri("/delete/{id}", productToDelete.getId()).exchange()
        .expectStatus().isNoContent();
  }

  @Test
  void testFindbyIdstudent() {
      String idstudent = "STU01";
      client.get().uri("/coursestatus/{idstudent}", idstudent).exchange()
        .expectStatus().isOk();
  }

  @Test
  void testFindbyIdstudentAndCondition() {
      String idstudent = "STU01";
      String condition = "Iniciado";


        client.get().uri("/coursecondition/{idteacher}/{condition}", idstudent,condition).exchange()
          .expectStatus().isOk().
      expectBodyList(RepoCourseStudents.class);
  }

  @Test
  void testFindbyIdstudentAndStatus() {
      String idstudent = "STU01";
      String status = "Activo";


        client.get().uri("/coursestatus/{idstudent}/{status}", idstudent,status).exchange()
          .expectStatus().isOk().
      expectBodyList(RepoCourseStudents.class);
  }

  @Test
  void testGetall() {
      client.get().uri("/").exchange()
      .expectStatus().isOk();
  }

  @Test
  void testUpdateCourseStudents() {
      RepoCourseStudents expectedProduct = expectedProducts.get(0);

      client.put().uri("/update/{id}", expectedProduct.getId()).body(Mono.just(expectedProduct), RepoCourseStudents.class).exchange()
        .expectStatus().isOk();
  }
}
