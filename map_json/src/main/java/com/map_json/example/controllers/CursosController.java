package com.map_json.example.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import com.map_json.example.model.Curso;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursosController {

    private List<Curso> list_cursos;

    @PostConstruct
    public void init() {
        this.list_cursos = new ArrayList<Curso>();
        this.list_cursos.add(new Curso("Spring", "25", "tarde"));
        this.list_cursos.add(new Curso("Spring boot", "20", "tarde"));
        this.list_cursos.add(new Curso("Python", "30", "tarde"));
        this.list_cursos.add(new Curso("Java EE", "50", "fin de semana"));
        this.list_cursos.add(new Curso("java básico", "30", "mañana"));
    }

    /* Lista de cursos disponibles */
    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getList_cursos() {
        return this.list_cursos;
    }

    /* Informacion del curso */
    @GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso() {
        return new Curso("Java", "100", "Mañana");
    }

    /* Informacion del curso por nombre en Json */
    @GetMapping(value = "cursos/JSON/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> buscarCursoJSON(@PathVariable("name") String c_name) {
        ArrayList<Curso> auxList = new ArrayList<Curso>();
        for (Curso curso : list_cursos) {
            if (curso.getNombre().contains(c_name)) {
                auxList.add(curso);
            }
        }
        return auxList;
    }

    /* Informacion del curso por nombre en XML */
    /* Se agrega dependencia jackson-dataformat-xml */
    @GetMapping(value = "cursos/XML/{name}", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Curso> buscarCursoXML(@PathVariable("name") String c_name) {
        ArrayList<Curso> auxList = new ArrayList<Curso>();
        for (Curso curso : list_cursos) {
            if (curso.getNombre().contains(c_name)) {
                auxList.add(curso);
            }
        }
        return auxList;
    }

    @DeleteMapping(value = "curso/{name}")
    public void eliminarCurso(@PathVariable("name") String s_name) {
        list_cursos.removeIf(c -> c.getNombre().equals(s_name));
    }

    @PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> altaCurso(@RequestBody Curso curso) {
        this.list_cursos.add(curso);
        return this.list_cursos;
    }

    @PutMapping (value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> UpdateCurso(@RequestBody Curso curso) {
        for (int i = 0; i < this.list_cursos.size(); i++) {
            if (this.list_cursos.get(i).getNombre().equals(curso.getNombre())
                list_cursos.set(i, curso);   
        }
        return this.list_cursos;
    }
}
