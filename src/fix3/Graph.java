
package fix3;
import java.util.*;

public class Graph<T extends Comparable<T>>{
    public enum State { UNVISITED, VISITED, COMPLETE };

    private final ArrayList<Vertex> vertices;
    private final ArrayList<Edge> edges;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Graph(){
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void add(T from, T to, int cost){
        Edge temp = findEdge(from, to);
        if (temp != null){
            System.out.println("Edge " + from + ", " + to + " Sudah ada. mengubah berat.");
            temp.cost = cost;
        }
        else{
            Edge e = new Edge(from, to, cost);
            edges.add(e);
        }
    }

    private Vertex findVertex(T v){
        for (Vertex each : vertices){
            if (each.value.compareTo(v)==0)
                    return each;
        }
        return null;
    }

    private Edge findEdge(Vertex v1, Vertex v2){
        for (Edge each : edges){
            if (each.from.equals(v1) && each.to.equals(v2)){
                return each;
            }
        }
        return null;
    }

    private Edge findEdge(T from, T to){
        for (Edge each : edges){
            if (each.from.value.equals(from) && each.to.value.equals(to)){
                return each;
            }
        }
        return null;
    }

    private boolean Dijkstra(T v1){
        if (vertices.isEmpty()) return false;
        resetDistances();
        Vertex source = findVertex(v1);
        if (source==null) return false;
        source.minDistance = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(source);
        while (!pq.isEmpty()){
            Vertex u = pq.poll();
            for (Vertex v : u.outgoing){
                Edge e = findEdge(u, v);
                if (e==null) return false;
                int totalDistance = u.minDistance + e.cost;
                if (totalDistance < v.minDistance){
                    pq.remove(v);
                    v.minDistance = totalDistance;
                    v.previous = u;
                    pq.add(v);
                }
            }
        }
        return true;
    }

    private List<String> getShortestPath(Vertex target){
        List<String> path = new ArrayList<>();
        if (target.minDistance==Integer.MAX_VALUE){
            path.add("Path tidak ditemukan");
            return path;
        }
        for (Vertex v = target; v !=null; v = v.previous){
            if(v.minDistance != 0){
                path.add("Ke "+ANSI_GREEN+v.value +ANSI_RESET+ " : cost : " + v.minDistance);
            }
            else{
                path.add("");
            }
        }
        Vertex v = target;
        System.out.print("Total jarak yang di tempuh : "+v.minDistance);
        Collections.reverse(path);
        return path;
    }

    private void resetDistances(){
        for (Vertex each : vertices){
            each.minDistance = Integer.MAX_VALUE;
            each.previous = null;
        }
    }

    public List<String> getPath(T from, T to){
        boolean test = Dijkstra(from);
        if (test==false) return null;
        List<String>  path = getShortestPath(findVertex(to));
        return path;
    }

    @Override
    public String toString(){
        String retval = "";
        for (Vertex each : vertices){
                retval += each.toString() + "\n";
        }
        return retval;
    }

    public String edgesToString(){
            String retval = "";
            for (Edge each : edges){
                    retval += each + "\n";
            }
            return retval;
    }

    class Vertex implements Comparable<Vertex>{
        T value;
        Vertex previous = null;
        int minDistance = Integer.MAX_VALUE;
        List<Vertex> incoming;
        List<Vertex> outgoing;
        State state;

        public Vertex(T value){
            this.value = value;
            incoming = new ArrayList<>();
            outgoing = new ArrayList<>();
            state = State.UNVISITED;
        }

        @Override
        public int compareTo(Vertex other){
            return Integer.compare(minDistance, other.minDistance);
        }

        public void addIncoming(Vertex vert){
                incoming.add(vert);
        }
        
        public void addOutgoing(Vertex vert){
                outgoing.add(vert);
        }

        @Override
        public String toString(){
            
            String retval = "";
            retval += "Vertex: " +ANSI_GREEN+ value +ANSI_RESET+ " : ";
            retval += " In: ";
            for (Vertex each : incoming) 
                retval+= ANSI_GREEN+"["+each.value + "] "+ANSI_RESET;
            retval += "\n\t\tOut: ";
            for (Vertex each : outgoing) 
                retval += ANSI_GREEN+"["+each.value + "] "+ANSI_RESET;
            return retval;
        }
}

    class Edge{
        Vertex from;
        Vertex to;
        int cost;
        public Edge(T v1, T v2, int cost){
            from = findVertex(v1);
            if (from == null){
                    from = new Vertex(v1);
                    vertices.add(from);
            }
            to = findVertex(v2);
            if (to == null){
                    to = new Vertex(v2);
                    vertices.add(to);
            }
            this.cost = cost;

            from.addOutgoing(to);
            to.addIncoming(from);
        }
        
        @Override
        public String toString(){
            return "Edge Dari : " +ANSI_GREEN+ from.value +ANSI_RESET+ " Ke : "+ANSI_GREEN + to.value +ANSI_RESET+ " Berat : " + cost;
        }
    }
}