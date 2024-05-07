package edu.upvictoria.fpoo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
       readLine();
    }

    public static String readLine() {
        Commands c = new Commands();
        c.UseTable("/home/sebastian/Escritorio");
        Key leer = new Key();

        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            leer.funcion(br.readLine());
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al leer el entrada");
        }
        return line;
    }
}