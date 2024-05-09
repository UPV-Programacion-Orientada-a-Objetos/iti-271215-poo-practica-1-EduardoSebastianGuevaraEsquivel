package edu.upvictoria.fpoo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App{

    static Switch sw = new Switch();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            try{
                System.out.print(">SQL: ");
                String comando = br.readLine().trim();

                if (!comando.endsWith(";")) {
                    System.out.println("Falta punto y coma");
                    continue;
                }
                
                comando = comando.substring(0, comando.length() -1);
                sw.Swtch(comando);

                if (comando.equals("salir")){
                    return;
                }

            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}