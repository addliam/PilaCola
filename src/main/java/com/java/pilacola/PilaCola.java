/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.java.pilacola;

import java.util.List;

/**
 *
 * @author liamy
 */
public class PilaCola {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Cola<Estudiante> cola = new Cola<>();
        cola.add(new Estudiante(0,"liam"));
        cola.add(new Estudiante(1,"alex"));
        cola.add(new Estudiante(2,"august"));
        cola.reverse();
        Estudiante found = cola.getElement("1");
        System.out.println("Found -> "+found.nombre );
        List<Estudiante> estudiantes = cola.elements();
        for (Estudiante est:estudiantes){
            System.out.println("Cod: "+String.valueOf(est.codigo)+" Nombre: "+String.valueOf(est.nombre));
        }
//        Pila<Estudiante> pilaEst = new Pila<>();
//        pilaEst.push(new Estudiante(0, "liam"));
//        pilaEst.push(new Estudiante(1, "diego"));
//        pilaEst.push(new Estudiante(2, "goku"));
//        List<Estudiante> estudiantes = pilaEst.elements();
//        for (Estudiante est:estudiantes){
//            System.out.println("Cod: "+String.valueOf(est.codigo)+" Nombre: "+String.valueOf(est.nombre));
//        }
//        pilaEst.reverse();
//        boolean existe = pilaEst.contains("4");
//        Estudiante encontrado = pilaEst.getElement("1");
//        if (encontrado != null){
//            System.out.println(" --------- Encontrado ------------ ");        
//            System.out.println(encontrado.codigo + " "+ encontrado.nombre);
//            System.out.println("-------------------------------------");
//        }
//        System.out.println("Tamano: "+pilaEst.size());
//        System.out.println("Aplicando metodo clear ...");
//        pilaEst.clear();
//        System.out.println("Esta vacio: "+pilaEst.isEmpty());
        
        
        
    }
}
