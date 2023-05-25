/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolbinariobusqueda2;

/**
 *
 * @author matia
 */
public class NodoArbol {
    int dato;
    NodoArbol derecho;
    NodoArbol izquierdo;
    
    public NodoArbol(int dato)
    {
        this.dato = dato;
        derecho = izquierdo = null;
    }
    
    public NodoArbol getDerecho()
    {
        return derecho;
    }
    
    public NodoArbol getIzquierdo()
    {
        return izquierdo;
    }
    
     public void setDerecho(NodoArbol derecho)
    {
        this.derecho = derecho;
    }
    
    public void setIzquierdo(NodoArbol izquierdo)
    {
        this.izquierdo = izquierdo;
    }
    
    
    public int getDato()
    {
        return dato;
    }
    
    public void insertar(int valor)
    {
        if(this.dato>valor)
        {
            if(izquierdo == null)
            {
                izquierdo = new NodoArbol(valor);
            }
            else
            {
                izquierdo.insertar(valor);
            }
        }   
        else
        {
            if(derecho == null)
            {
                derecho = new NodoArbol(valor);
            }
            else
            {
                derecho.insertar(valor);
            }
        }
    }
}
