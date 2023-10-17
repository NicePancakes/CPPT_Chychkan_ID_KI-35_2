import java.io.*;
import java.util.*;

public class Lab1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int n;
        char[][] arr;
        String filler;

        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");

        n = in.nextInt();
        in.nextLine();

        System.out.print("\nВведіть символ-заповнювач: ");

        filler = in.nextLine();

        if (filler.length() != 1)
        {
            System.out.print("\nНе коректний символ заповнювач");

            fout.flush();
            fout.close();

            return;
        }

        int average_n = (int)Math.ceil((double)n / 2);
        arr = new char[n][];

        if(n % 2 == 0)
        {
            for(int i = 0, j = 0; i < n; i++)
            {
                if(i <= average_n)
                {
                    if(i == average_n)
                    {
                        arr[i] = new char[i];
                    }
                    else
                    {
                        arr[i] = new char[i + 1];
                        j++;
                    }
                }
                else
                {
                    j--;
                    arr[i] = new char[j];
                }
            }
        }
        else
        {
            for(int i = 0, j = 0; i < n; i++)
            {
                if(i < average_n)
                {
                    arr[i] = new char[i + 1];
                    j++;
                }
                else
                {
                    j--;
                    arr[i] = new char[j];
                }
            }
        }


        char normalizedFiller = (char) filler.codePointAt(0);
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                if(i < average_n && j == arr[i].length - 1)
                {
                    arr[i][j] = '-';
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                }
                else
                {
                    arr[i][j] = normalizedFiller;
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                }
            }
            System.out.print("\n");
            fout.print("\n");
        }


/*
        for(int i = 0; i < correctNRows; i++)
        {
            if (i == 0)
            {
                for(int j = 0; j < arr[i].length; j++)
                {
                    System.out.print("+ ");
                    fout.print("+ ");
                }
            }

            System.out.print("\n");
            fout.print("\n");

            for(int j = 0; j < arr[i].length; j++)
            {
                arr[i][j] = normalizedFiller;
                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }

            System.out.print("\n");
            fout.print("\n");

            if (i == correctNRows - 1)
            {
                for(int j = 0; j < arr[i].length; j++)
                {
                    System.out.print("+ ");
                    fout.print("+ ");
                }
            }
        }
*/
        fout.flush();
        fout.close();
    }
}
