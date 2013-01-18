package com.us.pryacademia;

import java.util.Collection;
import java.util.HashSet;

public class Asignatura {
    
    private static int auxId;
    private int id;

    static int idAlu;    
    private String nombre;
    private int    horas;
    
    
    private HashSet<Alumno> hsAlu = new HashSet<Alumno>();

    public Asignatura(String nombre, int horas) {
        this.nombre = nombre;
        this.horas = horas;
        this.id = ++Asignatura.auxId;
    }
    
    public Integer getId() {
        return this.id;
    }
    public void add (Alumno alu){
        if (idAlu != alu.getId())
        {
            idAlu = alu.getId();
            hsAlu.add(alu);
            alu.add(this);
        }
        else
        {
            idAlu = -1;
        }
    }

    public Collection<Alumno> getAlumnos() {
        return hsAlu;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "id=" + id 
                + ", nombre=" + nombre 
                + ", horas=" + horas 
                + ", num.Alu=" + hsAlu.size() + '}';
    }
    
    
    
    


    
    
    
    
    
    
    
}
