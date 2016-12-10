//===========================================================================================================================
//	Program : Class to represent a vertex of a graph, provided by Dr. Balaji
//===========================================================================================================================
//	@author: Karthika Karunakaran
// 	Date created: 2016/11/13
//===========================================================================================================================
/**
 * Class to represent a vertex of a graph
 * @author rbk
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Vertex implements Comparator<Vertex>, Iterable<Edge> {
	int name; // name of the vertex
	boolean seen; // flag to check if the vertex has already been visited
	int d;
	Vertex p; // fields used in algorithms of Prim and Dijkstra
	List<Edge> adj, revAdj; // adjacency list; use LinkedList or ArrayList
	boolean inTree;
	int level;
	boolean color; /*false-red true-blue*/
	int count=0;
	int cno;
	
	/** Procedure to compare the vertex based on distance, to check 
	 * if current distance of vertex is greater then new distance from new parent
	 * @parameter u : vertex : from vertex
	 * @parameter v : vertex : to vertex
	 * @return int : comparison result
	 */
	public int compare(Vertex u, Vertex v) {
		return u.d - v.d;
	}

	/**Constructor for the vertex
	 * @param n
	 * : int - name of the vertex
	 */
	Vertex(int n) {
		name = n;
		seen = false;
		d = Integer.MAX_VALUE;
		p = null;
		adj = new ArrayList<Edge>();
		revAdj = new ArrayList<Edge>(); /* only for directed graphs */
		inTree = false;
		cno = 0;
	}

	public Iterator<Edge> iterator() {
		return adj.iterator();
	}

	/**
	 * Method to represent a vertex by its name
	 */
	public String toString() {
		return Integer.toString(name);
	}
}
