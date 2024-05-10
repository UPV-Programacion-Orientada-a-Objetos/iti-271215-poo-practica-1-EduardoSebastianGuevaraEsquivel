package edu.upvictoria.fpoo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Commands {

    File folderPath;

    public void setFolderPath(String path) {
        this.folderPath = new File(path);
    }

    void CreateTable(String fName, String columns, String type) {
        try {
            FileWriter fw = new FileWriter(folderPath + "/" + fName + ".csv");
            fw.equals(columns + type + " NOT NULL PRIMARY KEY");
            fw.append(columns);
            fw.append("\n");
            fw.close();
            System.out.println("Tabla creada correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void UseTable(String path) {
        File archivo = new File(path);
        if (!archivo.exists()) {
            System.out.println("Ruta no encontrada");
        } else {
            setFolderPath(path);
            System.out.println("Ruta encontrada: " + folderPath);
        }
    }

    public void InsertTable(String fName, String columns) {
        try {
            if (folderPath != null) {
                FileWriter fw = new FileWriter(new File(folderPath, fName + ".csv"), true);
                fw.write(columns + "\n");
                fw.close();
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("Ruta no especificada");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void DropTable(String fName) {
        try {
            if (folderPath != null) {
                File fileToDelete = new File(folderPath, fName + ".csv");
                if (fileToDelete.exists()) {
                    if (fileToDelete.delete()) {
                        System.out.println("Tabla eliminada correctamente");
                    } else {
                        System.out.println("Error al eliminar la tabla ");
                    }
                } else {
                    System.out.println("Error al eliminar la tabla ");
                }
            } else {
                System.out.println("Ruta no especificada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void SelectTable(String fName) {
        try {
            if (folderPath != null) {
                File file = new File(folderPath, fName + ".csv");
                if (file.exists()) {
                    System.out.println("Tabla encontrada");
                } else {
                    System.out.println("La tabla no existe");
                }
            } else {
                System.out.println("Ruta no especificada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ShowTable() {
        try {
            if (folderPath != null && folderPath.exists()) {
                File[] files = folderPath.listFiles();
                if (files != null && files.length > 0) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println(file.getName());
                        }
                    }
                } else {
                    System.out.println("No existen tablas en la ruta especificada");
                }
            } else {
                System.out.println("Ruta no especificada o no existe");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}