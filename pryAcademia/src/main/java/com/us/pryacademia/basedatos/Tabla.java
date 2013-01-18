/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.us.pryacademia.basedatos;

import java.util.HashMap;

/**
 *
 * @author UsuAll
 */
public class Tabla {

String nombre;
    HashMap<Object, Object> tabla;
    
    
    static int auxKey = 0;

    public Tabla(String nombre) {
        this.nombre = nombre;
        tabla = new HashMap<Object, Object>();
    }
    public void add (Object obj){
        //obj.auxKey++;
        
        tabla.put(auxKey, obj);
    }

    public void add() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
