package edu.upvictoria.fpoo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Switch {
    private String folderPath;

    public void Swtch(String comando) {
        String[] dividir = comando.split("\\s+");
        String comandoW = dividir[0].toUpperCase();

        switch (comandoW) {
            case "CREATE":
                if (dividir.length > 1 && dividir[1].equalsIgnoreCase("TABLE")) {
                    if (dividir.length > 2) {
                        CreateTable(dividir[2], dividir[3].toLowerCase());
                    } else {
                        System.out.println("Falta nombre de la tabla");
                    }
                } else {
                    System.out.println("Comando invalido");
                }
                break;

            case "USE":
                String ut = dividir[1];
                UseTable(ut);
                break;

            case "INSERT": //PRUEBA
                if (dividir.length > 2) {
                    String fn = dividir[1];
                    String col = dividir[2];
                    InsertTable(fn, col);
                } else {
                    System.out.println("ERROR");
                }
                break;

            case "DROP":
                if (dividir.length > 1 && dividir[1].equalsIgnoreCase("TABLE")) {
                    if (dividir.length > 2) {
                        DropTable(dividir[2]);
                    } else {
                        System.out.println("Tabla no encontrada");
                    }
                } else {
                    System.out.println("Comando invalido");
                }
                break;

            case "SELECT":
                if (dividir.length > 1) {
                    SelectTable(dividir[1]);
                } else {
                    System.out.println("Comando invalido");
                }
                break;

            case "SHOW":
                if (dividir[1].equalsIgnoreCase("TABLE")) {
                    ShowTable();
                } else {
                    System.out.println("Comando invalido");
                }
                break;

            case "VALUES": //PRUEBA
                if (dividir.length > 2) {
                    String v1 = dividir[1];
                    String v2 = dividir[2];
                    InsertTable(v1, v2);
                } else {
                    System.out.println("ERROR");
                }
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void CreateTable(String fName, String columns) {
        try {
            FileWriter fw = new FileWriter(folderPath + "/" + fName + ".csv");
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
            this.folderPath = path;
            System.out.println("Ruta encontrada: " + folderPath);
        }
    }

    public void InsertTable(String fName, String columns) {
        try {
            FileWriter fw = new FileWriter(folderPath + "/" + fName + ".csv");
            fw.append(columns);
            fw.append("\n");
            fw.close();
            System.out.println("Datos insertados correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void DropTable(String fName) {
        try {
            File Eliminar = new File(folderPath + "/" + fName + ".csv");
            if (Eliminar.exists()) {
                if (Eliminar.delete()) {
                    System.out.println("Tabla eliminada correctamente");
                } else {
                    System.out.println("No se encontro la tabla");
                }
            }
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ValueTable(String fName, String columns) {
        try {
            FileWriter fw = new FileWriter(folderPath + "/" + fName + ".csv", true);
            fw.append(columns);
            fw.append("\n");
            fw.close();
            System.out.println("Datos insertados correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}