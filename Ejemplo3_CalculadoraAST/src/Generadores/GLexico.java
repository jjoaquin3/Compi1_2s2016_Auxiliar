package Generadores;

import java.io.File;

/**
 *
 * @author joaquin
 */
public class GLexico 
{
    public static void main(String[] args) 
    {
        String path="src/Analizadores/lexico.jflex";
        generarLexer(path);
    } 
    
    public static void generarLexer(String path)
    {
        File file=new File(path);
        jflex.Main.generate(file);
    } 
}
