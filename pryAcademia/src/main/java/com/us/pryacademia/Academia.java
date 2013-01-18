package com.us.pryacademia;

import com.us.pryacademia.basedatos.BaseDatos;
import java.util.HashSet;

public class Academia {
    private String nombre;
    private String dir;
    public static BaseDatos db = new BaseDatos("Academia");
    
    public Academia(String nombre, String dir) {
        this.nombre = nombre;
        this.dir = dir;
        Academia.db.crearBaseDatos();
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

    @Override
    public String toString() {
        return "Academia{" + "nombre=" + nombre + ", dir=" + dir + '}';
    }
    
    
    
    
    
    
}
