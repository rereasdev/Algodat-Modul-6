package fix2;

public class List {
    private final int size = 20;
    private final int[] set;
    private int top;
    public Vertex[] adjc ;
    public double mindistance = Double.POSITIVE_INFINITY;

    public List() {
            set = new int[size];
            top = -1;
    }

    public void push (int t) {
            set[++top] = t;
    }

    public int pop () {
            return set[top--];
    }

    public int peek () {
            return set[top];
    }

    public boolean isEmpty() {
            return (top == -1);
    }

    public List preverious ;
}