/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.us.pryacademia.basedatos;

import com.us.pryacademia.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author UsuAll
 */
public class BaseDatos {
    String nombre;
    static HashMap<Integer, Alumno> hmAlumnos = new HashMap<Integer, Alumno>(); 
    static HashMap<Integer, Asignatura> hmAsignaturas = new HashMap<Integer, Asignatura>(); 
    static HashMap<Integer, Profesor> hmProfesores = new HashMap<Integer, Profesor>(); 
    static HashMap<String, Aula> hmAulas = new HashMap<String, Aula>(); 

    public BaseDatos(String nombre) {
        this.nombre = nombre;
        crearBaseDatos();
    }
    private void crearBaseDatos(){
                
        
        // Crear Alumnos
        int idJose = altaAlumno(new Alumno("Jose","C/El Pez"));
        int idJuan = altaAlumno(new Alumno("Juan","C/La Perdiz"));
        int idPepa = altaAlumno(new Alumno("Pepa","C/La Manteca"));
        
        // Crear Asignaturas
        int idMate = altaAsignatura (new Asignatura("Mate",10));
        int idDibujo = altaAsignatura (new Asignatura("Dibujo",20));
        int idCocina = altaAsignatura (new Asignatura("Cocina",10));
        
        // Crear relaciones Alumnos<->Asignaturas
        //hmAlumnos.get(idJose).add(hmAsignaturas.get(idMate));
        Alumno aluJose = hmAlumnos.get(idJose);
        Asignatura asgMate = hmAsignaturas.get(idMate);
        aluJose.add(asgMate);
        
        hmAlumnos.get(idJose).add(hmAsignaturas.get(idDibujo));
        
        hmAlumnos.get(idJuan).add(hmAsignaturas.get(idCocina));
    
        hmAlumnos.get(idPepa).add(hmAsignaturas.get(idMate));
        hmAlumnos.get(idPepa).add(hmAsignaturas.get(idDibujo));
        hmAlumnos.get(idPepa).add(hmAsignaturas.get(idCocina));
        
        // Crear Profesores
        int idProfeSabio = altaProfesor (new Profesor("Profe Sabio","C/Sabio Landia"));
        int idProfeLoco = altaProfesor (new Profesor("Profe Loco","C/El Parlamento"));
        int idProfeSordo = altaProfesor (new Profesor("Profe Sordo","C/Auditorio"));   
        
        // El profe da asignaturas
        Profesor pro = new Profesor(idProfeSabio);
        pro.add(new Asignatura(idMate));
        pro.add(new Asignatura(idDibujo));
        
        // Crear Aulas
        String idAula01 = altaAula (new Aula("Planta 01", "AULA 01", true));
        String idAula02 = altaAula (new Aula("Planta 02", "AULA 02", true));
        
        

    }
    public int altaAlumno (Alumno alu){
        hmAlumnos.put(alu.getId(),alu);
        return alu.getId();
    }

    public int altaAsignatura (Asignatura asg){
        hmAsignaturas.put(asg.getId(),asg);
        return asg.getId();
    }

    public int altaProfesor (Profesor profe){
        hmProfesores.put(profe.getId(),profe);
        return profe.getId();
    }
    public String altaAula (Aula au){
        hmAulas.put(au.getId(),au);
        return au.getId();
    }


    public  Collection<Alumno> getAlumnos() {
        return Collections.unmodifiableCollection(hmAlumnos.values());
    }
    public  Map<Integer,Alumno> getTbAlumnos() {
        return Collections.unmodifiableMap(hmAlumnos);
    }


    public Collection<Asignatura> getAsignaturas() {
        return Collections.unmodifiableCollection(hmAsignaturas.values());
    }
    public  Map<Integer,Asignatura> getTbAsignaturas() {
        return Collections.unmodifiableMap(hmAsignaturas);
    }

    
    public Collection<Profesor> getProfesores() {
        return Collections.unmodifiableCollection(hmProfesores.values());
    }
    public  Map<Integer,Profesor> getTbProfesores() {
        return Collections.unmodifiableMap(hmProfesores);
    }

    
    public Collection<Aula> getAulas() {
        return Collections.unmodifiableCollection(hmAulas.values());
    }
    public  Map<String,Aula> getTbAulas() {
        return Collections.unmodifiableMap(hmAulas);
    }


    
}
