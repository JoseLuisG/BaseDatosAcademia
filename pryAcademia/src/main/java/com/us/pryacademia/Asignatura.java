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
    private int   idProfe;
    private String idAula;
    private Date  horaIni;
    private Date  horaFin;

    private HashSet<Alumno> hsAlu = new HashSet<Alumno>();

    public Asignatura(String nombre, int horas) {
        super(++Asignatura.idLast, nombre);
        this.horas = horas;
        this.id = ++Asignatura.idLast;
    }
    //Obtiene el alumno
    
    public Asignatura(Integer id) {
        Asignatura asg = Academia.db.getTbAsignaturas().get(id);
        this.id = asg.id;
        this.nombre = asg.nombre;
        this.horas = asg.horas;
        this.horaFin = asg.horaFin;
        this.horaIni = asg.horaIni;
        this.hsAlu = asg.hsAlu;
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

    public int getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(int idProfe) {
        this.idProfe = idProfe;
    }

    public String getIdAula() {
        return idAula;
    }

    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
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
        final Asignatura other = (Asignatura) obj;
        if (this.horas != other.horas) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Asignatura{" + "id=" + id 
                + ", nombre=" + nombre 
                + ", horas=" + horas 
                + ", num.Alu=" + hsAlu.size() + '}';
    }
}
