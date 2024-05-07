package edu.upvictoria.fpoo;
import java.io.*;

public class Commands{

    String folderPath;

    public void CreateTable(String fName){
        try{
            FileWriter fw = new FileWriter(folderPath + "/" + fName + ".csv");
            fw.append("\n");
            fw.close();
            System.out.println("Tabla " + fName + " creada correctamente");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void UseTable(String path) {
        File archivo = new File(path);
        if (!archivo.exists()) {
            System.out.println("Ruta no encontrada");

        } else {
            this.folderPath = path;
            System.out.println("Ruta encontrada: " + folderPath);
        }
    }

    public void InsertTable(String fName, String columns){
        try{
            FileWriter fw = new FileWriter(folderPath + "/" + fName + ".csv", true);
            fw.append(columns);
            fw.append("\n");
            fw.close();
            System.out.println("Datos insertados en la tabla " + fName + " correctamente");
        }catch (IOException e){
            System.out.println("Error al insertar datos en la tabla " + fName);
            e.printStackTrace();
        }
    }

    public void DeleteTable(String fName) {
        try {
            File Eliminar = new File(folderPath + "/" + fName + ".csv");
            if (Eliminar.exists()) {
                if (Eliminar.delete()) {
                    System.out.println("Tabla " + fName + " eliminada correctamente");
                }else {
                    System.out.println("Error al eliminar datos en la tabla " + fName);
                }
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println("Error al eliminar datos en la tabla " + fName);
        }
    }

    public void SelectTable(String fName) {
        try {
            File file = new File(folderPath + "/" + fName + ".csv");
            if (file.exists()) {
                System.out.println("Tabla " + fName + " encontrada");
            } else {
                System.out.println("La tabla " + fName + " no existe");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ShowTable() {
        try {
            File directory = new File(folderPath);
            if (!directory.exists()) {
                System.out.println("No existen tablas creadas");
            } else {
                File[] files = directory.listFiles();
                if (files != null && files.length > 0) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println(file.getName());
                        }
                    }
                } else {
                    System.out.println("No existen tablas en la ruta especificada");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}