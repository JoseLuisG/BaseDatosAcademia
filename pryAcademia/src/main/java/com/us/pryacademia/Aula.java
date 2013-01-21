package com.us.pryacademia;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Aula extends ClasePadreAcademia {
    static int idLast = 0;
    
    String idAula;
    int capacidad;
    boolean hayProyector;
    
    HashSet<Asignatura> hsAsg = new HashSet<Asignatura>();
    
    public Aula(String nombre, String dir, boolean hayProyector) {
        super(++Aula.idLast, nombre);
        this.idAula = "Aula-" + String.valueOf(super.id);
        this.hayProyector = hayProyector;
    }

    public Aula(String idAula) {
        Aula au = Academia.db.getTbAulas().get(idAula);
        this.idAula = au.idAula;
        this.nombre = au.nombre;
        this.hsAsg = au.hsAsg;
    }
 
    public String getId() {
        return idAula;
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
        return "Alumno{" + "id=" + idAula 
                + ", nombre=" + nombre 
                + ", capacidad=" + capacidad
                + ", num.Asg=" + hsAsg.size() + '}';
    }
    
    
    
    

    

    
    
    
    
    
}
