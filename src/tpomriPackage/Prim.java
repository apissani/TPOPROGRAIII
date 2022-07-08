package tpomriPackage;

/**
Bedecarats, Esteban  	LU 1107524
Pissani, Alejandra    LU 1088304
**/

import java.util.ArrayList;

public class Prim {
	
	public static int menorArista(ArrayList<NodoArista> array ) {
		int menor = 500;
		int posicion = -1;
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).peso < menor && !array.get(i).apunta.Visitado) {
				menor = array.get(i).peso ; 
				posicion = i;
			}
		}
		return posicion;	
	}
	
	public static GrafoDinamico prim(NodoGrafo nodo) {
		ArrayList<NodoArista> aristas = new ArrayList<NodoArista>(); 
		ArrayList<NodoGrafo> nodos = new ArrayList<NodoGrafo>();
			
		NodoGrafo auxNodo = nodo;
		NodoArista aux; 
		auxNodo.Visitado = true;
		GrafoDinamico arbol = new GrafoDinamico();
		int indice = 0;
		arbol.agregarVertice(nodo.valor);	
		nodos.add(nodo);
	while(!nodos.isEmpty()){
			aux = auxNodo.lista;
			while(aux != null) {
				if(!aux.Visitado) {
					aristas.add(aux);
					aux.Visitado = true;
				}
				aux = aux.sig;
			}
			
			indice = menorArista(aristas);
			if(indice != -1) {
				aux = aristas.get(indice);
				arbol.agregarVertice(aux.apunta.valor);
				aux.apunta.Visitado = true;
				arbol.agregarArista(aux.origen, aux.apunta.valor, aux.peso);			
				aristas.remove(indice);
				nodos.add(aux.apunta);
				auxNodo = aux.apunta;
			}else {
				return arbol;
			}
			
		}
		return arbol;
	}
	
	public static void main(String[] args) {
		GrafoDinamico grafo = new GrafoDinamico();

		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		
		grafo.agregarArista(1, 3, 1);
		grafo.agregarArista(3, 1, 1);
		
		grafo.agregarArista(1, 4, 5);
		grafo.agregarArista(4, 1, 5);
		
		grafo.agregarArista(1, 2, 6);
		grafo.agregarArista(2, 1, 6);
		
		grafo.agregarArista(2, 3, 5);
		grafo.agregarArista(3, 2, 5);
		
		grafo.agregarArista(3, 4, 5);
		grafo.agregarArista(4, 3, 5);
		
		grafo.agregarArista(3, 5, 6);
		grafo.agregarArista(5, 3, 6);
		
		grafo.agregarArista(3, 6, 4);
		grafo.agregarArista(6, 3, 4);
		
		grafo.agregarArista(2, 5, 3);
		grafo.agregarArista(5, 2, 3);
		
		grafo.agregarArista(4, 6, 2);
		grafo.agregarArista(6, 4, 2);
		
		grafo.agregarArista(5, 6, 6);
		grafo.agregarArista(6, 5, 6);
		
		System.out.println("Prim" );
		NodoGrafo origen = grafo.encontrarNodo(1);
		System.out.println("Origen: " + origen.valor);
		prim(origen).mostrarGrafo();
		
	}

}