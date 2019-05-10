package exceptions1;
//https://github.com/acenelio/exceptions1-java


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppFinally {

    public static void main(String[]args){

        File file = new File("C:\\Users\\danie\\Downloads\\JAVINHAS2\\excecoes\\in.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }

        }
        catch(FileNotFoundException e){
            System.out.println("Error opening file: " + e.getMessage());
        }
        finally{
            if(sc!=null){
                sc.close();
            }
        }

    }
}
