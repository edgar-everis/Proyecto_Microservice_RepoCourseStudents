package com.main.expose;

import com.main.model.RepoCourseStudents;
import com.main.service.RepoCourseStudentsService;

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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/API/Report1")
public class ControllerRepoCourseStudents {

	private static Logger log = LoggerFactory.getLogger(ControllerRepoCourseStudents.class);
	
	
    @Autowired
    private RepoCourseStudentsService reposervice;

    @Value("${Configuracion.texto}")
    private String texto;
    
    @GetMapping
    public Flux<RepoCourseStudents> Getall() {
        return reposervice.GetAll();
    }

    @GetMapping("/coursestatus/{idstudent}")
    public Flux<RepoCourseStudents> FindbyIdstudent(@PathVariable String idstudent) {
        return reposervice.findByIdstudent(idstudent);
    }

    @GetMapping("/coursestatus/{idstudent}/{status}")
    public Flux<RepoCourseStudents> FindbyIdstudentAndStatus(@PathVariable String idstudent,
            @PathVariable String status) {
        return reposervice.findByIdstudentAndStatus(idstudent, status);
    }

    @GetMapping("/coursecondition/{idstudent}/{condition}")
    public Flux<RepoCourseStudents> FindbyIdstudentAndCondition(@PathVariable String idstudent,
            @PathVariable String condition) {
        return reposervice.findByIdstudentAndCondition(idstudent, condition);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RepoCourseStudents> createCourseStudents(@RequestBody RepoCourseStudents repocourse) {
        return reposervice.CreateRepocourseStudents(repocourse);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RepoCourseStudents> updateCourseStudents(@PathVariable String id,
            @RequestBody RepoCourseStudents repocourse) {
        return reposervice.ModifyStudent(id, repocourse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCourseStudents(@PathVariable String id) {
        return reposervice.DeleteById(id);
    }
    
    @GetMapping("/Obtener-config")
    public ResponseEntity<?> Obtnerconfig(@Value("${server.port}") String puerto)
    {
    	log.info(texto);
    	Map< String,String> json = new HashMap<>();
    	json.put("texto", texto);
		return new ResponseEntity<Map< String,String>>(json, HttpStatus.OK);
    	
    }
    
    
}
