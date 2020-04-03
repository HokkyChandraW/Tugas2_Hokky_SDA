import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        Scanner inp = new Scanner(System.in);
        try {
            File file = new File("out.txt");
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String data = read.nextLine();
                String splitter[] = data.split(":");
                ll.add(splitter[0]);

                if (ll.searchData(splitter[0]) != null) {
                    ll.searchData(splitter[0]).getData().addTitle(splitter[1]);
                }

            }
            read.close();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        ll.bubbleSort();
        // tampilan program
        while (true) {
            System.out.print(
                    "\n--------LinkedList Program--------\n\n1. Look for editor's name \n2. Show all data of the editor\n3. Look for an editor and show their articles\n4. Exit\n\nInput your choise : ");
            int option = Integer.parseInt(inp.nextLine());
            if (option == 1) {
                System.out.print("Enter the editor name : ");
                String editor = inp.nextLine();
                ll.searchContainsEditor(editor);
            } else if (option == 2) {
                ll.display();
                System.out.println("");
            } else if (option == 3) {
                System.out.print("input : ");
                String editor = inp.nextLine();
                ll.menubaru(editor);
            } else if (option == 4) {
                System.exit(1);
            } else {
                System.out.println("Choise unrecognized, choose another option\n");
            }

        }
    }
}