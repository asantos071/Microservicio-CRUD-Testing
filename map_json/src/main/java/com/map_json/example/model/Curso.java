package com.map_json.example.model;

public class Curso {
    private String nombre;
    private String duracion;
    private String horario;

    public Curso() {
    }

    public Curso(String nombre, String duracion, String horario) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.horario = horario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return this.duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}
