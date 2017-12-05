
package test;

import java.util.List;
import java.util.Scanner;

public class main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {        
        Scanner scan = new Scanner(System.in);
        DiGraph g = new DiGraph();
        g.add("DOME", "GKB 3", 5);
        g.add("ICT", "DOME", 8);
        g.add("GKB 1", "ICT", 8);
        g.add("GKB 2", "DOME", 6);
        g.add("GKB 2", "ICT", 1);
        g.add("GKB 2", "LAB", 3);
        g.add("GKB 3", "GKB 4", 2);
        g.add("GKB 3", "ICT", 8);
        g.add("GKB 4", "GKB 2", 1);
        g.add("LAB", "GKB 1", 1);
        g.add("LAB", "GKB 4", 1);
//        System.out.println(g);

        System.out.println("DOME");
        System.out.println("ICT");
        System.out.println("GKB 1");
        System.out.println("GKB 2");
        System.out.println("GKB 3");
        System.out.println("GKB 4");
        System.out.println("LAB");
        
        System.out.print("Masukkan titik awal : ");
        String a = scan.nextLine().toUpperCase();
        System.out.print("Masukkan titik akhir : ");
        String b = scan.nextLine().toUpperCase();
       
        System.out.println(ANSI_GREEN+a+ANSI_RESET+" ke "+ANSI_GREEN+b+ANSI_RESET);
        try{
            List<String> path = g.getPath(a, b);
            path.forEach((each) -> {
                System.out.println(each);
            });
        }
        catch(Exception e){
            System.out.println("Edge tidak ada");
        }
    }
   
}