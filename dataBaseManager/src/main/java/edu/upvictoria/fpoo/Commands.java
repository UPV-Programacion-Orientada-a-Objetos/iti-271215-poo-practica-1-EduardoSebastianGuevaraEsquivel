package edu.upvictoria.fpoo;
import java.io.*;

public class Commands {

    private static String folderPath;

    public void CreateTable(String fName, String columns){
        try{
            FileWriter fw = new FileWriter(folderPath + "/" + fName + ".csv");
            fw.append(columns);
            fw.append("\n");
            fw.close();
            System.out.println("Tabla creada correctamente");
        }catch (IOException e){
            System.out.println(e.getMessage());
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
            FileWriter fw = new FileWriter(folderPath + "/" + fName + ".csv");
            fw.append(columns);
            fw.append("\n");
            fw.close();
            System.out.println("Datos ingresados correctamente");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void DropTable(String fName) {
        try {
            File Eliminar = new File(folderPath + "/" + fName + ".csv");
            if (Eliminar.exists()) {
                if (Eliminar.delete()) {
                    System.out.println("Tabla eliminada correctamente");
                }else {
                    System.out.println("Error al eliminar la tabla ");
                }
            }else {
                System.out.println("Error al elinmar la tabla ");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void SelectTable(String fName) {
        try {
            File file = new File(folderPath + "/" + fName + ".csv");
            if (file.exists()) {
                System.out.println("Tabla encontrada");
            } else {
                System.out.println("La tabla no existe");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ValueTable(String columns) {
        try {
            String fName = "nombre";

            FileWriter fw = new FileWriter(folderPath + "/" + fName + ".csv");
            fw.append(columns);
            fw.append("\n");
            fw.close();
            System.out.println("Datos insertados correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}