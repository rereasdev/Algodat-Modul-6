package fix2;

public class Vertex {
    public String label ;
    public boolean wasVisited ;
    public double bobot;
    List target;
	
    public Vertex(String lab) {
    	label = lab ;
	wasVisited = false ;
    }
}
