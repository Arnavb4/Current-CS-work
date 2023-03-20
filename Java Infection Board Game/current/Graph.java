public class Graph
{
   private boolean connectionMatrix[][];
   private int numVertices;
   
   public Graph(int constructorVertices)
   {
      numVertices = constructorVertices;
      connectionMatrix = new boolean[numVertices][numVertices];
   }
   
   public void addEdge(int i, int j)
   {
      connectionMatrix[i][j] = true;
      connectionMatrix[j][i] = true;
   }
   
   public void removeEdge(int i, int j)
   {
      connectionMatrix[i][j] = false;
      connectionMatrix[j][i] = false;
   }
   
   public static void main(String args[])
   {
      // San Francisco = 0, Chicago = 1, Montreal = 2, New York = 3, DC = 4, Atlanta = 5
      // LA = 6, Mexico City = 7, Miami = 8, Bogota = 9, Lima = 10, Santiago = 11, Buenos Aires = 12, Sao Paolo = 13
      // London = 14, Madrid = 15

      Graph g = new Graph(16);
      g.addEdge(3, 4);
      g.addEdge(3, 2);
      g.addEdge(2, 4);
      g.addEdge(4, 5);
      g.addEdge(1, 2);
      g.addEdge(1, 5);
      g.addEdge(1, 0);
      
      g.addEdge(0, 6);
      g.addEdge(6, 1);
      g.addEdge(7, 1);
      g.addEdge(8, 5);
      g.addEdge(8, 4);
      
      g.addEdge(6, 7);
      g.addEdge(7, 8);
      g.addEdge(8, 9);
      g.addEdge(7, 9);
      g.addEdge(7, 10);
      g.addEdge(10, 11);
      g.addEdge(9, 10);
      g.addEdge(9, 12);
      g.addEdge(9, 13);
      
      g.addEdge(3, 14);
      g.addEdge(3, 15);
      g.addEdge(13, 15);
      g.addEdge(14, 15);
   }
}