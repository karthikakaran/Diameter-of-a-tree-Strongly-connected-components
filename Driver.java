//===========================================================================================================================
//	Program : Read graph, calls to break into graphs, stitch the graphs and verify, sample provided by Dr. Balaji
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritika
// 	Date created: 2016/11/20
//===========================================================================================================================
/* Ver 1.0: Driver code for MST and Shortest paths */

import java.util.Comparator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in;
		int VERBOSE = 0;

		if (args.length > 0) {
			File inputFile = new File(args[0]);
			in = new Scanner(inputFile);
		} else {
			in = new Scanner(System.in);
		}
		if (args.length > 1) {
			VERBOSE = Integer.parseInt(args[1]);
		}
		
		Graph g;
		if (VERBOSE % 2 == 0)
			g = Graph.readGraph(in);
		else
			g = Graph.readDirectedGraph(in);
		int src = in.nextInt();
		int target = in.nextInt();
		Vertex s = g.getVertex(src);
		Vertex t = g.getVertex(target);

		Timer timer = new Timer();

		if (VERBOSE % 3 == 0) { // Run DAG if VERBOSE is a multiple of 3
			DAGShortestPath.DAGShortestPaths(g, s);
			/*if (result == -1) {
				System.out.println("Graph has a cycle!");
			} else*/
			System.out.println("Distance: " + t.d);
			if (VERBOSE > 0) {
				System.out.println();
				for (Vertex u : g) {
					System.out.println(u + " " + u.d + " " + u.p);
				}
				System.out.println();
			}
		}

		if (VERBOSE % 5 == 0) { // Run Shortest path if VERBOSE is a multiple of 5
			int noOfComp = StronglyConnectedComponents.stronglyConnectedComponents(g, s);
			System.out.println("# of strongly connected components ::" + noOfComp);
		}
		
		if (VERBOSE % 2 == 0) {
			int diameter = Diameter.diameter(g);
			if (diameter != -1)
				System.out.println("Diameter of the Tree :: " + diameter);
			else
				System.out.println("It is not a tree!");
		}
		
		System.out.println(timer.end());
	}
}
