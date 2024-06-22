package src.uy.edu.um.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil
{

    public static String[] readFile(String path)
    {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                lines.add(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return lines.toArray(new String[0]);
    }

}
