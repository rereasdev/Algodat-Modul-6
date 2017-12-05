package fix1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addverteks("DOME");
        graph.addverteks("ICT");
        graph.addverteks("GKB 1");
        graph.addverteks("GKB 2");
        graph.addverteks("GKB 3");
        graph.addverteks("GKB 4");
        graph.addverteks("LAB Informatika");

        graph.addgaris(0, 1);
        graph.addgaris(0, 4);
        graph.addgaris(1, 6);
        graph.addgaris(2, 1);
        graph.addgaris(3, 0);
        graph.addgaris(3, 2);
        graph.addgaris(3, 6);
        graph.addgaris(4, 3);
        graph.addgaris(5, 2);
        graph.addgaris(5, 4);
        graph.addgaris(5, 6);
        graph.addgaris(6, 2);

        System.out.print("Nim terakhir : ");
        Scanner scan = new Scanner(System.in);
        int nim = scan.nextInt();
        int result = nim % 7;
        graph.tampilkanverteks(result);
    }
}
