package edu.upvictoria.fpoo;

public class SQL_Test {

    public static void main(String[] args){
        Commands sql = new Commands();

        sql.UseTable("/home/sebastian/Escritorio");
        sql.CreateTable("Hola","Juan, Eduardo, Erick");
        sql.InsertTable("Hola", "Elias");
    }

}
