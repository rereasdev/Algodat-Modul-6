package fix1;

import java.util.Scanner;

public class Graph {
    private final int maksVerteks = 20;
    private final Vertex list[];
    private final int adjc[][];
    private int nverteks;
    private final List tumpukan;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Graph() {
        list = new Vertex[maksVerteks];
        adjc = new int[maksVerteks][maksVerteks];
        nverteks = 0;
        for (int j = 0; j < maksVerteks; j++) {
            for (int i = 0; i < maksVerteks; i++) {
                adjc[j][i] = 0;
            }
        }
        tumpukan = new List();
    }

    public void addverteks(String label) {
        list[nverteks++] = new Vertex(label);
    }

    public void addgaris(int stat, int end) {
        adjc[stat][end] = 1;
    }

    public void tampilkanverteks(int vertks) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Edge " +ANSI_GREEN + list[vertks].label + ANSI_RESET);
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
        System.out.print("pilihan ( program akan berakhir apabila inputan melebihi pilihan ) :");
        int b = scan.nextInt();
        // agar tigdak kelebihan
        if (b <= a) {
            int c = z[b];
            tampilkanverteks(c);
        } else {
            System.out.println("input salah program berakhir");
        }
    }
}