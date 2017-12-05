package fix2;

import java.util.*;

public class Graph {
    private final int maksVerteks = 20;
    private final Vertex list[];
    private final int adjc[][], weight[][];
    private int nverteks, berat;
    private final List tumpukan;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public Graph() {
        list = new Vertex[maksVerteks];
        adjc = new int[maksVerteks][maksVerteks];
        weight = new int[maksVerteks][maksVerteks];
        nverteks = 0;
        berat = 0;
        for (int j = 0; j < maksVerteks; j++) {
                for (int i = 0; i < maksVerteks; i++) {
                    adjc[j][i] = 0;
                    weight[j][i] = 0;
                }
        }
        tumpukan = new List();
    }

    public void addverteks(String label) {
            list[nverteks++] = new Vertex(label);
    }

    public void addgaris(int stat, int end, int wght) {
        weight[stat][end] = wght;
        adjc[stat][end] = 1;
    }

    public void tampilkanverteks(int e, int vertks) {
        berat += weight[e][vertks];
        Scanner scan = new Scanner(System.in);
        System.out.println("Edge " + ANSI_GREEN + list[vertks].label + ANSI_RESET+": (jarak yang di tempuh = "+ANSI_GREEN + berat + ANSI_RESET+")");
        System.out.println("Edge beriktnya : ");
        int a = 0;
        int z[] = new int[nverteks];
        // search vertex bersinggung
        for (int o = 0; o < nverteks; o++) {
            int check = adjc[vertks][o];
            if (check == 1) {
                System.out.println(++a + " . " + list[o].label);
                z[a] = o;
            }
        }

        System.out.print("pilihan ( program akan berakhir apabila inputan melebihi pilihan ) : ");
        int b = scan.nextInt();
        // agar tidak kelebihan
        if (b <= a) {
            int c = z[b];
            tampilkanverteks(vertks, c);
        } else {
            System.out.println("Input salah program berakhir");
            System.out.println("Total jarak yang di tempuh = " + ANSI_GREEN + berat + ANSI_RESET);
        }
    }
}
