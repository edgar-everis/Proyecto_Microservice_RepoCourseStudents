package com.main.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "Reporte1")
public class RepoCourseStudents {

  @NotEmpty // condition = activo o finalizado
  private String condition;

  @Id private String id;

  @NotEmpty private String idcourse;

  @NotEmpty private String idstudent;

  @NotEmpty // Status = Iniciado o no iniciado
  private String status;
}
