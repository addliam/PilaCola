package com.java.pilacola;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author liamy
 */
class NodoC<T extends Identificable>{
    T elemento;
    NodoC<T> siguiente;
    public NodoC(T elemento){
        this.elemento = elemento;
        this.siguiente = null;
    }
}
public class Cola<T extends Identificable> {
    NodoC<T> frente;
    NodoC<T> fin;
    public NodoC<T> getFrente(){return frente;}
    public NodoC<T>  getfin(){return fin;}
    public void add(T elemento){
        // encolar
        NodoC<T> nuevoNodo = new NodoC(elemento);
        if (frente == null){
            frente = nuevoNodo;
            fin = nuevoNodo;
        }else{
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }
    public T remove(){
        // desencola
        // Retorna null si no hay elementos
        T elementoRemover = null;
        if (frente != null){
            elementoRemover = frente.elemento;
            frente = frente.siguiente;
        }
        return elementoRemover;
    }
    public List<T> elements(){
        List<T> elementos = new ArrayList<>();        
        if (frente != null){
            NodoC<T> aux = frente;
            while (aux != null){
                elementos.add(aux.elemento);
                aux = aux.siguiente;
            }
        }
        return elementos;
    }
    public T getElement(String id){
        T pFound = null;
        NodoC<T> actual = frente;
        while (actual != null){
            if (actual.elemento.getId().equals(id)){
                pFound = actual.elemento;
                break;
            }
            actual = actual.siguiente;
        }
        return pFound;        
    }
    public boolean contains(String id){
        boolean resp = false;
        NodoC<T> actual = frente;
        while (actual != null){
            if (actual.elemento.getId().equals(id)){
                resp = true ;
                break;
            }
            actual = actual.siguiente;
        }
        return resp;
    }    
    public int reverse(){
        // invierte la cola in-place. retorna codigo de error 0 si fue exito
        int exitCode = 0;
        if (frente == null || frente.siguiente == null) {
            exitCode = 1;
        }        
        NodoC<T> anterior = null;
        NodoC<T> actual = frente;
        NodoC<T> siguiente = null;
        while (actual != null ){
            siguiente = actual.siguiente;
            // reverse
            actual.siguiente = anterior;
            // move pointers anterior y actual
            anterior = actual;
            actual = siguiente;
        }
        frente = anterior;
        return exitCode;
    }
}
