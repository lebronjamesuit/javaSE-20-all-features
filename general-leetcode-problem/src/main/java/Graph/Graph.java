package Graph;


import java.util.ArrayList;
import java.util.HashMap;

// Facebook connect relationship Friends to Friends
// adjList:  the way to describe the connections
public class Graph {

    private static HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    private static boolean addVertex (String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }

        return false;
    }

    private static boolean addEdges(String vertex1, String vertex2){
        if( adjList.get(vertex1) != null &&  adjList.get(vertex2) != null){
            adjList.get(vertex1).add(vertex2);     // A =  [B]
            adjList.get(vertex2).add(vertex1);     // B =  [A]
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        System.out.println("before add edges");
        Graph.addVertex("A");
        Graph.addVertex("B");
        Graph.addVertex("E");
        Graph.addVertex("D");
        Graph.addVertex("C");
        System.out.println(adjList);


        String vertexA = "A";
        String vertexB = "B";
        String vertexC = "C";
        String vertexE = "E";
        String vertexD = "D";

        Graph.addEdges(vertexA, vertexB);
        Graph.addEdges(vertexA, vertexC);
        Graph.addEdges(vertexE, vertexB);
        Graph.addEdges(vertexE, vertexD);
        Graph.addEdges(vertexC, vertexD);


        // Is the code break?
        Graph.addEdges(vertexA, "James");
        adjList.entrySet().stream().forEach(System.out::println);

        // remove an Edge "X"
        // remove edge between A and B

        System.out.println("After remove Edge between Vertex A and Vertex B");
        Graph.removeEdges(vertexA, vertexB);
        adjList.entrySet().stream().forEach(System.out::println);


        // remove Vertex A from the AdjList  A B C D E
        removeVertex(vertexA);
        System.out.println("After remove Vertex A");
        adjList.entrySet().stream().forEach(System.out::println);
        
    }

    // O(m) with m is number of edge of the vertex A.
    private static void removeVertex(String vertex) {
        final  String  needToMove  = vertex;
        ArrayList edgeOfVertex = adjList.get(vertex);
        edgeOfVertex.stream().forEach(item  -> {
            adjList.get(item).remove(needToMove);
        });
        adjList.remove(needToMove);

    }

    //  O(n) + O(m)
    private static boolean removeEdges(String vertexA, String vertexB) {
        if(adjList.get(vertexA) != null && adjList.get(vertexB) != null){
            adjList.get(vertexA).remove(vertexB); //  O(n) + O(m)
            adjList.get(vertexB).remove(vertexA);
            return true;
        }
        return false;
    }

}
