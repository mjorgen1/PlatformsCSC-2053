import ch09.graphs.*;

public class Eulerian {
	public static void main(String[] args) {
		WeightedGraph<Vert> graph1 = new WeightedGraph<Vert>(4); //Create graph1
		WeightedGraph<Vert> graph2 = new WeightedGraph<Vert>(4); //Create graph2
		Vert A = new Vert("A");  // Create 4 verticies, A, B, C, D
		Vert B = new Vert("B");
		Vert C = new Vert("C");
		Vert D = new Vert("D");
        
        System.out.println("Graph 1 is empty? (should be true) " + graph1.isEmpty()); //Should print out true
        System.out.println("Graph 1 full? (should be false) " + graph1.isFull()); //Should print out false

        System.out.println("Adding verticies, A, B, C, D");
		graph1.addVertex(A);
		graph1.addVertex(B);
		graph1.addVertex(C);
		graph1.addVertex(D);
        System.out.println("Graph 1 is empty? (should be false) " + graph1.isEmpty()); //Should print out false
        System.out.println("Graph 1 full? (should be true) " + graph1.isFull()); //Should print out true
        
        System.out.println("Does Graph 1 have Vertex A? (should be true) " + graph1.hasVertex(A)); //Should print out true
        Vert E = new Vert("E");
        System.out.println("Does Graph 1 have Vertex E? (should be false) " + graph1.hasVertex(E)); //Should print out false
		
        graph2.addVertex(A); // Creating graph 2
		graph2.addVertex(B);
		graph2.addVertex(C);
		graph2.addVertex(D);

		
		graph1.addEdge(A,B,2); //Adding edges for the 7 Bridges of Konigsberg
		graph1.addEdge(B,A,2);
		graph1.addEdge(B,C,2);
		graph1.addEdge(C,B,2);
		graph1.addEdge(A,D,1);
		graph1.addEdge(D,A,1);
		graph1.addEdge(B,D,1);
		graph1.addEdge(D,B,1);
		graph1.addEdge(C,D,1);
		graph1.addEdge(D,C,1);

		graph2.addEdge(A,B,2); // Adding edges for graph 2
		graph2.addEdge(B,A,2);
		graph2.addEdge(B,C,2);
		graph2.addEdge(C,B,2);
		graph2.addEdge(C,D,2);
		graph2.addEdge(D,C,2);

        System.out.println("Degree of Vertex A in graph1 (should be 3) " + graph1.vertexDegree(A));
        
        System.out.println("Is graph1 Eulerian? (should be false) " + graph1.isEulerian());
        System.out.println("Is graph2 Eulerian? (should be true) " + graph2.isEulerian());
        
			
	}
	
}
