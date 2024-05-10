package edu.upvictoria.fpoo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;

class CommandsTest {

    Commands commands = new Commands();

    @Test
    void testCreateTable() {
        commands.CreateTable("Prueba1", "nombre", " VARCHAR(50)");
        assertTrue(new File(commands.folderPath + "/Prueba1.csv").exists());

        commands.CreateTable("", "nombre", " VARCHAR(50)");
        assertFalse(new File(commands.folderPath + "/.csv").exists());

        commands.CreateTable("Prueba2", "", " VARCHAR(50)");
        assertTrue(new File(commands.folderPath + "/Prueba2.csv").exists());
    }

    @Test
    void testUseTable() {
        commands.UseTable("Prueba1");
        if (commands.folderPath != null) {
            assertEquals("Valido", commands.folderPath.toString());
        }
        commands.UseTable("Prueba2");
        assertNull(commands.folderPath);
    }


    @Test
    void testInsertTable() {
        commands.setFolderPath("Prueba1");
        commands.InsertTable("", "Hola");
        assertTrue(new File(commands.folderPath + "/Prueba1.csv").length() > 0);

        commands.InsertTable("Prueba2", "Hola");
        assertFalse(new File(commands.folderPath + "/Prueba2.csv").exists());
    }

    @Test
    void testDropTable() {
        commands.setFolderPath("rutaValida");
        commands.DropTable("Prueba1");
        assertFalse(new File(commands.folderPath + "/Prueba1.csv").exists());

        commands.DropTable("Prueba2");
        commands.DropTable("Prueba1");
        assertFalse(new File(commands.folderPath + "/Prueba1.csv").exists());
    }

    @Test
    void testSelectTable() {
        commands.setFolderPath("rutaValida");
        commands.SelectTable("Prueba1");
        commands.SelectTable("Prueba2");
    }

    @Test
    void testShowTable() {
        commands.setFolderPath("rutaValida");
        commands.ShowTable();
        commands.ShowTable();
        commands.ShowTable();
    }
}
