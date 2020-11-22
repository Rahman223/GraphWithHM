class TestGraphWithHM {
    public static void main (String[] args){
        Graph graph = new Graph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
       // graph.showNodes();
        graph.connect(a, b);
        graph.connect(a, d);
        graph.connect(b, c);
        graph.connect(c, d);
        

        //graph.connectionOf(a);
        //graph.connectionOf(d);
       // graph.breadthFirst(a);
       // System.out.println();
       // graph.breadthFirst(b);
       graph.depthFirstSearch(d);
       System.out.println();
       graph.depthFirstSearch(b);
    }
}