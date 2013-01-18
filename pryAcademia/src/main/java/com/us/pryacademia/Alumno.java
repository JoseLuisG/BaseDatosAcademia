package com.us.pryacademia;

import java.util.Collection;
import java.util.HashSet;

public class Alumno {
    static int idLast = 0;
    
    static int idAsg=0;
    int id;
    String nombre;
    String dir;
    
    HashSet<Asignatura> hsAsg = new HashSet<Asignatura>();;
    
    public Alumno(String nombre, String dir) {
        this.nombre = nombre;
        this.dir = dir;
        this.id = ++Alumno.idLast;
    }

    public Integer getId() {
        return id;
    }

    public boolean existe (){
        return Academia.db.getAlumnos().contains(this.id);
    }
    
    public void add (Asignatura asg){
        if (idAsg != asg.getId())
        {
            idAsg = asg.getId();
            hsAsg.add(asg);
            asg.add(this);
        }
        else
        {
            idAsg = -1;
        }
        
    }
    
    public void remove (Asignatura asg){
        Academia.db.bajaAlumno(this);
    }

    public Collection<Asignatura> getAsignaturas() {
        return hsAsg;
    }
    
    

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id 
                + ", nombre=" + nombre 
                + ", dir=" + dir 
                + ", num.Asg=" + hsAsg.size() + '}';
    }
    
    
    
    

    

    
    
    
    
    
}
