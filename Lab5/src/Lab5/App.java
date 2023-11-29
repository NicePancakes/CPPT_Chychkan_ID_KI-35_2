package Lab5;

import java.io.*;
import java.util.Scanner;

import Lab5.TBPrinter.TBMode;

public class App {
    public static void main(String[] args) throws Exception {
        double x;
        PrintStream out = System.out;
        String filler = new String("#");

        try {
            Scanner in = new Scanner(System.in);

            TBPrinter printer = new TBPrinter();
            
             Equations eq = new Equations();

             out.print("Read X from file ? (y/n)\n: ");
             if (in.next().equals("y")) {

                 out.print("Enter mode\nt - for text\nb - for binary\n: ");
                 TBMode mode = in.next().equals("t") ? TBMode.Text : TBMode.Binary;
                 
                 out.print("Enter file name: ");
                 in.nextLine();
                 String fName = in.nextLine();

                 x = printer.readRes(fName, mode);
             } else {
                 out.print("Enter X: ");
                 x = in.nextDouble();
             }

             out.println("X is: " + x);

             double res = eq.calculate(x);

             out.print("Enter mode\nt - for text\nb - for binary\n: ");
             TBMode mode = in.next().equals("t") ? TBMode.Text : TBMode.Binary;
             
             out.print("Enter file name to write: ");
             in.nextLine();
             String fName = in.nextLine();

             printer.writeRes(fName, mode, res);

             in.close();
        } catch (FileNotFoundException ex) {
            out.print(ex.getMessage());
        }
    }
}
