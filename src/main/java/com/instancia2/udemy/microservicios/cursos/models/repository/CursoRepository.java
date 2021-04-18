package com.instancia2.udemy.microservicios.cursos.models.repository;

import com.instancia2.udemy.microservicios.cursos.models.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
