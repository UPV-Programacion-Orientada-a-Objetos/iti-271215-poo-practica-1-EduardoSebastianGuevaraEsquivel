package edu.upvictoria.fpoo;

public class SQL_Test {

    public static void main(String[] args){
        Commands sql = new Commands();

        sql.UseTable("/home/sebastian/Escritorio/Base de Datos/$PATH$");
        sql.CreateTable("Alumno");
        sql.InsertTable("Alumno", "nombre,edad,apellido");
        sql.ShowTable();
        sql.SelectTable("Alumno");
        sql.DeleteTable("Alumno");

    }

}
