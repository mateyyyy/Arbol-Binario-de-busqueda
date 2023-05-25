/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbolbinariobusqueda2;

/**
 *
 * @author matia
 */
public class ArbolBinarioBusqueda2 {
    public static void main(String[] args) {
        ArbolBin arbol = new ArbolBin();
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(12);
        arbol.insertar(11);
        arbol.insertar(7);
        arbol.insertar(15);
        
        
        System.out.println("Recorrido pre : ");
        arbol.dispararPre();
        System.out.println("Recorrido In: ");
        arbol.dispararIn();
        System.out.println("Recorrido post : ");
        arbol.dispararPost();
        System.out.println("Menor de mayores : " + arbol.menorDeMayores((arbol.getRaiz().getDerecho())).getDato());
        NodoArbol busca = arbol.localizar(5,arbol.getRaiz());
        System.out.println("Dato encontrado! : " + busca.getDato());
        System.out.println("Nodo a eliminar : 5");
        arbol.eliminar(5);
        
        System.out.println("Recorrido pre : ");
        arbol.dispararPre();
        System.out.println("Recorrido In: ");
        arbol.dispararIn();
        System.out.println("Recorrido post : ");
        arbol.dispararPost();
    }
}
