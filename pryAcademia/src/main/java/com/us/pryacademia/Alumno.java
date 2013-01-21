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
        this.hsAsg = alu.hsAsg;
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
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (this.id != other.id || this.id == 0) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "id=" + id 
                + ", nombre=" + nombre 
                + ", dir=" + dir 
                + ", num.Asg=" + hsAsg.size() + '}';
    }
    
    
    
    

    

    
    
    
    
    
}
