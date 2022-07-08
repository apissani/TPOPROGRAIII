package tpomriPackage;

/**
Bedecarats, Esteban  	LU 1107524
Pissani, Alejandra    LU 1088304
**/

import java.util.ArrayList;

public class DFS {

	public static ArrayList<Integer> dfsGrafo(GrafoDinamico grafo, NodoGrafo origen) {
		ArrayList<Integer> nodos = new ArrayList<Integer>();

		visitarNodo(origen, nodos);
		return nodos;
	}

	public static void visitarNodo(NodoGrafo nodo, ArrayList<Integer> lista) {
		nodo.Visitado = true;
		NodoArista aux = nodo.lista;

		while (aux != null) {
			if (!aux.apunta.Visitado) {
				visitarNodo(aux.apunta, lista);
			} else {
				aux = aux.sig;
			}
		}

		lista.add(nodo.valor);
	}

	public static void main(String[] args) {
		GrafoDinamico grafo = new GrafoDinamico();

		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);

		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(1, 4, 0);
		grafo.agregarArista(2, 5, 0);
		grafo.agregarArista(5, 4, 0);
		grafo.agregarArista(4, 2, 0);
		grafo.agregarArista(3, 5, 0);
		grafo.agregarArista(3, 6, 0);
		grafo.agregarArista(6, 6, 0);

		NodoGrafo origen = grafo.encontrarNodo(1);
		
		System.out.println("DFS");
		System.out.println("Origen: " + origen.valor);
		ArrayList<Integer> resultado = dfsGrafo(grafo, origen);

		for (int i = resultado.size() - 1; i >= 0; i--) {
			if (i != 0) {
				System.out.print(resultado.get(i) + " -> ");
			} else {
				System.out.print(resultado.get(i));
			}
		}

	}
}