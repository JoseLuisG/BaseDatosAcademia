package com.us.pryacademia;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Profesor extends ClasePadreAcademia {
    static int idLast = 0;
    
    String dir;
    
    HashSet<Asignatura> hsAsg = new HashSet<Asignatura>();
    
    public Profesor(String nombre, String dir) {
        super(++Profesor.idLast, nombre);
        this.dir = dir;
    }
    public Profesor(Integer id) {
        Profesor pro = Academia.db.getTbProfesores().get(id);
        this.id = pro.id;
        this.dir = pro.dir;
        this.nombre = pro.nombre;
        this.hsAsg = pro.hsAsg;
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
