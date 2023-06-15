/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.pilacola;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liamy
 */
class Nodo<T extends Identificable> {
    T elemento;
    Nodo<T> siguiente;
    public Nodo(T elemento){
        this.elemento = elemento;
        this.siguiente = null;
    }
}
public class Pila<T extends Identificable> {
    Nodo<T> tope;
    public void Pila(){tope = null;}
    public Nodo<T> getTope(){return tope;}
    public void push(T elemento){
        Nodo<T> newNodo = new Nodo<>(elemento);
        if (tope != null){
            newNodo.siguiente = tope;
        }
        tope = newNodo;
    }
    public void clear(){
        this.tope = null;
    }
    public int size(){
        int counter = 0;
        Nodo<T> aux = tope;
        while (aux != null){
            aux = aux.siguiente;
            counter++;
        }
        return counter;
    }
    public boolean isEmpty(){
        return tope == null;
    }
    
    public void sort(){}
    public void isSorted(){}
    public T getElement(String id){
        T pFound = null;
        Nodo<T> actual = tope;
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
        Nodo<T> actual = tope;
        while (actual != null){
            if (actual.elemento.getId().equals(id)){
                resp = true ;
                break;
            }
            actual = actual.siguiente;
        }
        return resp;
    }
    public T pop(){
        if (tope == null){
            return null;
        }else{
            Nodo<T> aux = tope;
            T elementoEliminar = tope.elemento;
            tope = tope.siguiente;
            return elementoEliminar;
        }
    }
    public List<T> elements(){
        List<T> elementos = new ArrayList<>();        
        if (tope != null){
            Nodo<T> aux = tope;
            while (aux != null){
                elementos.add(aux.elemento);
                aux = aux.siguiente;
            }
        }
        return elementos;
    }
    public void reverse(){
        // por si esta vacio o solo un elemento
        if (tope == null || tope.siguiente == null) {
            return;
        }
        Nodo<T> anterior = null;
        Nodo<T> actual = tope;
        Nodo<T> siguiente = null;
        while (actual != null){
            siguiente = actual.siguiente;
            // reverse
            actual.siguiente = anterior;
            // move pointers forward
            anterior = actual;
            actual = siguiente;
        }
        tope = anterior;
    }    
}