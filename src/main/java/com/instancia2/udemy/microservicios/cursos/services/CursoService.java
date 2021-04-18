package com.instancia2.udemy.microservicios.cursos.services;

import com.instancia2.udemy.microservicios.cursos.models.entity.Curso;
import java.util.Optional;

public interface CursoService {

    public Iterable<Curso> findAll();

    public Optional<Curso> findById(Long id);

    public Curso save(Curso alumno);

    public void deleteById(Long id);
}
