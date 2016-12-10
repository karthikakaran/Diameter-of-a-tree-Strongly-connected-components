//===========================================================================================================================
//	Program : To find Strongly Connected Components
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritika
// 	Date created: 2016/11/20
//===========================================================================================================================
import java.util.LinkedList;
import java.util.List;

public class StronglyConnectedComponents {
	/**
	 * Method to find the strongly connected components of a graph
	 * @param g : Graph : input 
	 * @param v : Vertex : source vertex
	 * @return : cno : int : number of components
	 */
	public static int stronglyConnectedComponents (Graph g, Vertex v) {
		//List to store topological order of vertices
		List<Vertex> topSortOrder = new LinkedList<Vertex>();
		//Topological sort with decreasing finishing time
		topSortOrder = dfsTopSort(g, v, topSortOrder);
		//DFS with the topological order of vertices for transpose of the graph G^T
		int cno = dfs(g, v, topSortOrder);
		return cno;
	}

	private static Graph constructGT(Graph g) {
		Graph gt = new Graph(g.size);
		gt.directed = true;
		for (Vertex from : g) {
			for (Edge e : from.revAdj) {
				Vertex to = e.otherEnd(from);
				gt.addEdge(from, to, e.weight);
			}
		}
		return gt;
	}
	
	/**
	 * Method to find the topological sort with decreasing finishing time
	 * @param g : Graph : input 
	 * @param v : Vertex : source vertex
	 * @param topSortOrder : List<Vertex> : list object to store the topologically sorted vertices
	 * @return : topSortOrder : List<Vertex> : topological sorted order of vertices
	 */
	public static List<Vertex> dfsTopSort(Graph g, Vertex s, List<Vertex> topSortOrder) {
		//setting all vertices as unseen and parent as null
		for (Vertex v : g) {
			v.seen = false;
			v.p = null;
		}
		//DFS visit 
		for (Vertex v : g) {
			if (!v.seen) {
				topSortOrder = dfsVisit(v, topSortOrder);
				topSortOrder.add(0, v);
			}
		}
		return topSortOrder;
	}

	/**
	 * Method to find the topological sort with decreasing finishing time, helper function
	 * @param v : Vertex : source vertex
	 * @param topSortOrder : List<Vertex> : list object to store the topologically sorted vertices
	 * @return : topSortOrder : List<Vertex> : topological sorted order of vertices
	 */
	public static List<Vertex> dfsVisit(Vertex v, List<Vertex> topSortOrder) {
		//set true for visited vertices
		v.seen = true;
		//DFS for edge
		for (Edge e : v.adj) {
			Vertex vert = e.otherEnd(v);
			//Do DFS and add if not visited
			if (!vert.seen) {
				vert.p = v;
				topSortOrder = dfsVisit(vert, topSortOrder);
				topSortOrder.add(0, vert);
			}
		}
		return topSortOrder;
	}
		
	/**
	 * Method to do DFS with topologically sorted vertex for G^T
	 * @param g : Graph : input graph
	 * @param v : Vertex : source vertex
	 * @param topSortOrder : List<Vertex> : topological sorted order of vertices
	 * @return : cno : int : number of components
	 */
	public static int dfs(Graph g, Vertex s, List<Vertex> topSortOrder) {
		int cno = 0;
		//set all vertices to unvisited and parent to null
    	for(Vertex v : g) {
    		v.seen = false;
    		v.p = null;
    	}
    	//do DFS in the topologically sorted order of graph G 
    	for(Vertex v : topSortOrder) {
    		if(!v.seen) {
    			v.cno = cno;
    			cno = dfsVisit(v, ++cno);
    		}
    	}
    	return cno;
    }

	/**
	 * Method to do DFS with topologically sorted vertex for G^T, helper function
	 * @param v : Vertex : source vertex
	 * @param cno : int : component no to be incremented
	 * @return : cno : int : number of components
	 */
	public static int dfsVisit(Vertex v, int cno) {
		//setting visited vertices to seen
		v.seen = true;
		//For every edge in the transposed graph or reversed adj list, do DFS
		for (Edge e : v.revAdj) {
			Vertex vert = e.otherEnd(v);
			if (!vert.seen){
				vert.p = v;
				v.cno = cno;
				cno = dfsVisit(vert, cno);
			}
		}
		return cno;
	}
}

