package com.us.pryacademia;

import java.util.Collection;
import java.util.HashSet;

public class Profesor extends ClasePadreAcademia {
    static int idLast = 0;
    
    String dir;
    
    HashSet<Asignatura> hsAsg = new HashSet<Asignatura>();
    
    public Profesor(String nombre, String dir) {
        super(++Profesor.idLast, nombre);
        this.dir = dir;
    }

    public Integer getId() {
        return id;
    }

    public void add (Asignatura asg){
        if (!hsAsg.contains(asg))
        {
            hsAsg.add(asg);
            asg.setIdProfe(id);
        }
            
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
