package exceptions1;

//https://github.com/acenelio/exceptions1-java

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppII {

    public static void main (String[]args){
        method1();
        System.out.println("end of program");

    }

    public static void method1(){
        System.out.println("*****Method1 start*****");
        method2();
        System.out.println("*****Method1 end*****");



    }
    public static void method2() {
        System.out.println("*****Method2 start*****");
        Scanner in = new Scanner(System.in);

        try{
            String[] vect = in.nextLine().split(" ");
            int position = in.nextInt();
            System.out.println(vect[position]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position");
            //e.printStackTrace(); //mostra toda a chamada de métodos da exceção
            //  in.next();
        }
        catch(InputMismatchException e){
            System.out.println("Input error du karalho");
        }
        in.close();
        System.out.println("*****Method2 end*****");
    }


}
