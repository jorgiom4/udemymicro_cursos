package com.instancia2.udemy.microservicios.cursos.models.repository;

import com.instancia2.udemy.microservicios.cursos.models.entity.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CursoRepository extends CrudRepository<Curso, Long> {

    @Query("select c from Curso c join fetch c.alumnos a where a.id=?1")
    public List<Curso> findCursosByAlumnoId(Long id);

}
