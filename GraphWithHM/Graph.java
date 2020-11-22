import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    HashMap <Node , LinkedList<Node>> hm = new HashMap<>();

public void addNode (Node a){
    LinkedList <Node> ll = new LinkedList<>();
    hm.put(a, ll);
}

public void showNodes (){
    for (Node n : hm.keySet()){
    System.out.println(n.name);
}
}

public void connect (Node a, Node b){
    if(hm.containsKey(a) && hm.containsKey(b)){
        if (!hm.get(a).contains(b)){
        hm.get(a).add(b);
        }
        if (!hm.get(b).contains(a)){
        hm.get(b).add(a);
        }
    }
}

public void connectionOf (Node a){
    if (hm.containsKey(a)){
        for (Node b: hm.get(a)){
            System.out.println(b.name);
        }
    }
}

public int numberOfVertex (){
   return hm.keySet().size();
}

public void breadthFirst (Node root){
    LinkedList <Node> queue = new LinkedList<>();  
    HashSet <Node> set = new HashSet<>();
    set.add(root); 
    queue.addFirst(root);

    while (!queue.isEmpty()){
        Node v = queue.removeLast();
        displayNode(v);
        for (Node n : hm.get(v)){
            if(!set.contains(n) == true){
                queue.addFirst(n);
                set.add(n);
            }
        }
    }
}

public void depthFirstSearch (Node root){
    LinkedList <Node> stack = new LinkedList<>();
    HashSet <Node> markedSet = new HashSet<>();
    markedSet.add(root);
    stack.addFirst(root);
    displayNode(root);
    while (!stack.isEmpty()){
        Node v = stack.peekFirst();
        Iterator <Node> itr = hm.get(v).iterator();
        while (itr.hasNext()){
            Node n = itr.next();
            if (!markedSet.contains(n)){
                markedSet.add(n);
                displayNode(n);
                stack.addFirst(n);
                break;
            }else if(!itr.hasNext()){
                stack.removeFirst();
            }
        }
           
    }
}


public void displayNode (Node a) {
    System.out.println(a.name);
}

}