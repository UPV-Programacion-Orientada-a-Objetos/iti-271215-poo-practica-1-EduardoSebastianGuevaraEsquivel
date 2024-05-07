package edu.upvictoria.fpoo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Key extends Commands{

   private static Map<String, Runnable> hash = new HashMap<>();
    {
       hash.put("CREATE TABLE", ()-> CreateTable("")

       );
       hash.put("USE DATABASE", ()-> DeleteTable(""));
       hash.put("*INSERT", ()-> InsertTable(""," "));
       //hash.put("UPDATE", this::UpdateTable);
       hash.put("SELECT", ()-> SelectTable(""));
       hash.put("DELETE", ()-> DeleteTable(""));
       hash.put("SHOW TABLES", this::ShowTable);
    }

    public static void funcion(String l) {
        Runnable func = hash.get(l);
        if(func != null){
            func.run();
        }else{
            System.out.println("l");
        }
    }

    public void Scan(String line) throws IOException {
        boolean found = false;

        for (String palabras : hash.keySet()) {
            if (line.contains(palabras)) {
                found = true;
                funcion(palabras);
            }
        }
        if (!found) {
            throw new IOException("NOT");
        }
    }

}

