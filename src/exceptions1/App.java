package exceptions1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        try {
            String[] vet = in.nextLine().split(" ");
            int position = in.nextInt();
            System.out.println(vet[position]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Posição invalida!");

        }
        catch(InputMismatchException e){
            System.out.println("Valor inválido");

        }

        System.out.println("Fim do programa");
        in.close();

    }
}
