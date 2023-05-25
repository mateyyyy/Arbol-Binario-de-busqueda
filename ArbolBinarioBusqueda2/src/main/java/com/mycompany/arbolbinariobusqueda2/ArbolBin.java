/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolbinariobusqueda2;

/**
 *
 * @author matia
 */
public class ArbolBin {
    NodoArbol raiz;
    
    public ArbolBin()
    {
        this.raiz = null;
    }
    
    public NodoArbol getRaiz()
    {
        return raiz;
    }
    
    public void insertar(int valor)
    {
        if(raiz == null)
        { 
            raiz = new NodoArbol(valor);
        }
        else
        {
            this.raiz.insertar(valor);
        }
    }
    
    public void dispararPre()
    {
        preOrden(raiz);
    }
    
    public void preOrden(NodoArbol nodo)
    {
        if(nodo==null){
            return;
        }
        else{
            System.out.println(nodo.getDato());
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
        }
    }
    
    
    public void dispararPost()
    {
        postOrden(raiz);
    }
    
    public void postOrden(NodoArbol nodo)
    {
        if(nodo==null){
            return;
        }
        else{
            postOrden(nodo.getIzquierdo());
            postOrden(nodo.getDerecho());
            System.out.println(nodo.getDato());
        }
    }
    
    public void dispararIn()
    {
        inOrden(raiz);
    }
    
    public void inOrden(NodoArbol nodo)
    {
        if(nodo==null){
            return;
        }
        else{
            inOrden(nodo.getIzquierdo());
            System.out.println(nodo.getDato());
            inOrden(nodo.getDerecho());
        }
    }
    
    public NodoArbol localizar(int dato,NodoArbol r)
    {
        if(r!=null)
        {
            if(dato>r.getDato())
            {
                r = localizar(dato,r.getDerecho());
            }
            if(dato<r.getDato())
            {
                r = localizar(dato,r.getIzquierdo());
            }
        }
        else
        {
            return null;
        }
        return r;
    }
    
    public boolean eliminar(int d)
    {
        NodoArbol aux = raiz;
        NodoArbol padre = raiz;
        boolean esHijoizq = true;
        while(aux.getDato()!=d)
        {
            padre = aux;
            if(d<aux.getDato())
            {
                esHijoizq = true;
                aux = aux.getIzquierdo();
            }
            else
            {
                esHijoizq = false;
                aux = aux.getDerecho();
            }
            if(aux == null)
            {
                return false;
            }
        }
        if(aux.getIzquierdo()==null && aux.getDerecho()==null)
        {
            if(esHijoizq)
            {
                padre.setIzquierdo(null);
            }
            else
            {
                padre.setDerecho(null);
            }
        }
        else if(aux.getDerecho()==null)
        {
            if(aux == raiz)
            {
                raiz = aux.getIzquierdo();
            }
            else if(esHijoizq)
            {
                padre.setIzquierdo(aux.getIzquierdo());
            }
            else
            {
                padre.setDerecho(aux.getIzquierdo());
            }
        }
        else if(aux.getIzquierdo()==null)
        {
            if(aux == raiz)
            {
                raiz = aux.getDerecho();
            }
            else if(esHijoizq)
            {
                padre.setIzquierdo(aux.getDerecho());
            }
            else
            {
                padre.setDerecho(aux.getDerecho());
            }   
        }
        else
        {
            NodoArbol menorMayores = menorDeMayores(aux.getDerecho());
            if(aux == raiz)
            {
                raiz = menorMayores;
                menorMayores.setDerecho(aux.getDerecho());
                menorMayores.setIzquierdo(aux.getIzquierdo());
                eliminar(menorMayores.getDato());
            }
            else if(esHijoizq)
            {
                padre.setIzquierdo(menorMayores);
                menorMayores.setDerecho(aux.getDerecho());
                menorMayores.setIzquierdo(aux.getIzquierdo());
                eliminar(menorMayores.getDato());
            }
            else
            {
                padre.setDerecho(menorMayores);
                menorMayores.setDerecho(aux.getDerecho());
                menorMayores.setIzquierdo(aux.getIzquierdo());
                eliminar(menorMayores.getDato());
            }
        }
        return true;
    }
    
    public NodoArbol menorDeMayores(NodoArbol r)
    {
        while(r.getIzquierdo()!=null)
        {
            r = r.getIzquierdo();
        }
        return r;
    }
    
    public NodoArbol mayorDeMenores(NodoArbol r)
    {
        while(r.getDerecho()!=null)
        {
            r = r.getDerecho();
        }
        return r;
    }
    
}
