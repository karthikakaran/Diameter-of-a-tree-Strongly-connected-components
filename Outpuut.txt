CS 5V81.012 : Implementation of Data Structures and Algorithms
Optional Project 8 - Group 3

******************************************************************************************************************************************************************
Note: Timer.java needs to be compiled because most of the programs use it
so compile :  javac Timer.java
   run :      java Timer.java

******************************************************************************************************************************************************************
2. Diameter of a tree

compile :  javac -Xlint Driver.java
run :  Driver [l1.txt] 2

input : filename mentioned in the run statement
sample input: 	9 8
		1 2 1
		2 3 1
		3 4 1
		3 5 1
		2 7 1
		7 8 1
		6 9 1
		5 6 1
		1 2

output : Diameter of the Tree :: 6
	 Time: 1 msec.
	 Memory: 1 MB / 119 MB.

sample for NOT A TREE:  4 6
			1 2 1
			1 3 1
			2 3 1
			3 1 1
			3 4 1
			4 4 1
			1 2 

output : It is not a tree!
	 Time: 0 msec.
	 Memory: 1 MB / 119 MB.
 
******************************************************************************************************************************************************************
3. Strongly connected components of a directed graph

compile :  javac -Xlint Driver.java
run :  java Driver [p1.txt] 5

input : filename mentioned in the run statement
sample input :  8 14
		1 2 1
		3 1 1
		2 3 1
		3 4 1
		2 4 1
		2 5 1
		4 6 1
		6 4 1
		5 6 1
		5 7 1
		7 5 1
		6 8 1
		8 8 1
		7 8 1
		1 2
 
output: # of strongly connected components ::4
	Time: 1 msec.
	Memory: 1 MB / 119 MB

sample input 2 :4 6
		1 2 1
		1 3 1
		2 3 1
		3 1 1
		3 4 1
		4 4 1
		1 2 

output: # of strongly connected components ::2
	Time: 1 msec.
	Memory: 1 MB / 119 MB.

******************************************************************************************************************************************************************
4. Shortest path in a DAG

compile : javac -Xlint Driver.java
run	: java Driver [h1.txt] 3

Input format:
	<# of vertices> <# of edges>
	<from vertex> <to vertex> <weight of the edge>
	.
	.
	.
	<source vertex>	 <destination vertex>

Sample Input :  10 12
		1 3 1
		1 8 1
		8 6 1
		3 2 1
		8 2 1
		8 5 1
		6 10 1
		5 10 1
		5 4 1
		2 4 1
		4 7 1
		10 9 1
		1 2

Output:		Distance: 2

******************************************************************************************************************************************************************
5. Odd length cycle in a non-bipartite graph

compile : javac OddCycle.java
run	: java OddCycle
Input format:
	<# of vertices> <# of edges>
	<from vertex> <to vertex> <weight of the edge>
	.
	.
	.

Sample Input :  4 4 
		1 2 1
		2 3 1
		3 4 1
		4 2 1

Output:		3
		4
		2
		3

Sample Input :  2 2	
		1 2 1
		2 1 1

Output:		No odd cycles- The graph is bipartite

