package com.us.pryacademia;

import com.us.pryacademia.basedatos.BaseDatos;
import java.util.HashSet;

public class Academia {
    private String nombre;
    private String dir;
    public static BaseDatos db;
    
    public Academia(String nombre, String dir) {
        this.nombre = nombre;
        this.dir = dir;
        db = new BaseDatos("Academia");
            }
    public static BaseDatos getDb(){
        return db;
    }
    
    public static void main(String[] args) {
        
        Academia academia = new Academia ("La Crea", "Nicolas Guillen");
        
        System.out.println("");
        System.out.println("========Datos academia ===========");
        System.out.println(academia);
        System.out.println("");
        
        mostrarProfes();
        mostrarAlumnos();
        mostrarAsignaturas();
        
        // Borrar una matricula (NO FUNCIONA, EL OBJETO ES DIFERENTE)
        Alumno alu = new Alumno(1); // jose
        alu.remove(new Asignatura(1)); // Dibujo
        mostrarAlumnos();
        mostrarAsignaturas();
    
    }

    private static void mostrarAlumnos(){
        System.out.println("========Datos Alumnos  ===========");
        for (Alumno alu : Academia.db.getAlumnos())
        {
            System.out.println(alu);
            System.out.println("Matriculado en:");
            for (Asignatura asg : alu.getAsignaturas())
            {
                System.out.println("    " + asg);
            }

        }
        
    }
    private static void mostrarAsignaturas(){
        System.out.println("");
        System.out.println("========Datos Asignaturas  ===========");
        for (Asignatura asg : Academia.db.getAsignaturas())
        {
            System.out.println(asg);
            System.out.println("Relacion de alumnos:");
            for (Alumno alu : asg.getAlumnos())
            {
                System.out.println("    " + alu);
            }
            
        }
        
    }

    private static void mostrarProfes(){
        System.out.println("");
        System.out.println("========Datos PROFESORES   ===========");
        for (Profesor profe : Academia.db.getProfesores())
        {
            System.out.println(profe);
        }
    }

    @Override
    public String toString() {
        return "Academia{" + "nombre=" + nombre + ", dir=" + dir + '}';
    }
    
    
    
    
    
    
}
