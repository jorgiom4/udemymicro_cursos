package com.instancia2.udemy.microservicios.cursos.controllers;

import com.instancia2.udemy.microservicios.cursos.models.entity.Curso;
import com.instancia2.udemy.microservicios.cursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Listamos todos los cursos
    @GetMapping
    public ResponseEntity<?> listar(){

        return ResponseEntity.ok().body(cursoService.findAll());
    }

    // Buscamos un curso por su id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso.get());
    }

    // Creamos un curso nuevo
    @PostMapping("/new")
    public ResponseEntity<?> crearAlumno(@RequestBody Curso curso){
        Curso cursoDb = cursoService.save(curso);

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoDb);
    }

    // Actualizamos los datos de un curso
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCurso(@RequestBody Curso curso, @PathVariable Long id){
        Optional<Curso> c = cursoService.findById(id);
        if (c.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Curso cursoDb = c.get();
        cursoDb.setNombre(curso.getNombre());

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(cursoDb));
    }

    // Eliminamos un alumno de la BD
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCurso(@PathVariable Long id){
        cursoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
