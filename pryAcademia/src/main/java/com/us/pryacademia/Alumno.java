package com.us.pryacademia;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Alumno extends ClasePadreAcademia {
    static int idLast = 0;
    
    String dir;
    
    HashSet<Asignatura> hsAsg = new HashSet<Asignatura>();;
    
    //Crea el alumno
    public Alumno(String nombre, String dir) {
        super(++Alumno.idLast, nombre);
        this.dir = dir;
    }
    //Obtiene el alumno
    public Alumno(Integer id) {
        Alumno alu = Academia.db.getTbAlumnos().get(id);
        this.id = alu.id;
        this.dir = alu.dir;
        this.nombre = alu.nombre;
    }


    public Integer getId() {
        return id;
    }

    
    public void add (Asignatura asg){
        if (!hsAsg.contains(asg))
        {
            hsAsg.add(asg);
            asg.add(this);
        }
            
    }
    
    public void remove (Asignatura asg){
        if (hsAsg.contains(asg))
        {
            hsAsg.remove(asg);
            asg.remove(this);
        }
            
    }

    public Collection<Asignatura> getAsignaturas() {
        return Collections.unmodifiableSet(hsAsg);
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "id=" + id 
                + ", nombre=" + nombre 
                + ", dir=" + dir 
                + ", num.Asg=" + hsAsg.size() + '}';
    }
    
    
    
    

    

    
    
    
    
    
}