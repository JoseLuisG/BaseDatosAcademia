package com.us.pryacademia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Asignatura extends ClasePadreAcademia {
    
    private static int idLast;
    
    private int   horas;
    private Date  horaIni;
    private Date  horaFin;
    
    private HashSet<Alumno> hsAlu = new HashSet<Alumno>();

    public Asignatura(String nombre, int horas) {
        super(++Asignatura.idLast, nombre);
        this.horas = horas;
        
    }
    //Obtiene el alumno
    public Asignatura(Integer id) {
        Asignatura asg = Academia.db.getTbAsignaturas().get(id);
        this.id = asg.id;
        this.nombre = asg.nombre;
        this.horas = asg.horas;
        this.horaFin = asg.horaFin;
        this.horaIni = asg.horaIni;
    }
    
    
    public Integer getId() {
        return this.id;
    }
    public void add (Alumno alu){
        if (!hsAlu.contains(alu))
        {
            hsAlu.add(alu);
            alu.add(this);
        }

    }
    
    public void remove (Alumno alu){
        if (hsAlu.contains(alu))
        {
            hsAlu.remove(alu);
            alu.remove(this);
        }
            
    }


    public Collection<Alumno> getAlumnos() {
        return Collections.unmodifiableSet(hsAlu);
    }

    @Override
    public String toString() {
        return "Asignatura{" + "id=" + id 
                + ", nombre=" + nombre 
                + ", horas=" + horas 
                + ", num.Alu=" + hsAlu.size() + '}';
    }
}
