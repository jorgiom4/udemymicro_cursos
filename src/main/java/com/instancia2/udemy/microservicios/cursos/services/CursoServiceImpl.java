package com.instancia2.udemy.microservicios.cursos.services;

import com.instancia2.udemy.microservicios.cursos.models.entity.Curso;
import com.instancia2.udemy.microservicios.cursos.models.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Curso> findAll() {
        return this.cursoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id) {
        return this.cursoRepository.findById(id);
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return this.cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.cursoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findCursosByAlumnoId(Long id) {
        return this.cursoRepository.findCursosByAlumnoId(id) ;
    }
}
