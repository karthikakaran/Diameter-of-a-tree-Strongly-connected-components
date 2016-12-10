//===========================================================================================================================
//	Program : To find Diameter of a tree
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritika
// 	Date created: 2016/11/20
//===========================================================================================================================
public class Diameter {
	/**
	 * Method to find the diameter of the tree
	 * @param g : Graph : input 
	 * @return : max : int : diameter of given tree, return -1 if not a tree
	 */
	public static int diameter(Graph g) {
		int treeOrNot = 1;
		//Make all vertices unseen for BFS
		for(Vertex v : g) {
    		v.seen = false;
    	}
		//BFS with an arbitrary root
		treeOrNot = g.bfs(g.getVertex(1));
		
		//If not a tree return -1
		if (treeOrNot == -1) return -1;
		//Find a max distance vertex z from the BFS root
		Vertex z = g.getVertex(1);
		int max = 0;
		for(Vertex v : g) {
			//If graph is connected - which means if all are reachable after BFS,
			//so check all are seen, then it is a tree, else not a tree - Condition 1
			//Condition 2 - to chekc cycle is in bfs, modified to return -1 if not a tree
			if (!v.seen)
				treeOrNot = -1;
    		if (max < v.d) {
    			max = v.d;
    			z = v;
    		}
    	}
		//Again do BFS with z, so make all vertices unseen again for BFS
		for(Vertex v : g) {
    		v.seen = false;
    	}
		treeOrNot = g.bfs(z);
		//If not a tree return -1
		//if (treeOrNot == -1) return -1;
		//Find the vertex with maximum distance from the BFS root z, that is the diameter
		max = 0;
		for(Vertex v : g) {
    		if (max < v.d) {
    			max = v.d;
    		}
    	}
		return max;
	}
}
