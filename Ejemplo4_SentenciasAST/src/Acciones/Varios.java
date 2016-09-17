package Acciones;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin
 */
public class Varios
{
    public void autoAbrir(String ruta)
    {
        try
        {
            File f = new File(ruta);
            if(f.exists())
                Desktop.getDesktop().open(f);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Varios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void creararchivo(String pfichero,String pcontenido)
    {   
        FileWriter archivo = null;
   
        try{archivo = new FileWriter(pfichero);} 
        catch (IOException ex) 
        {Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);}

        File a = new File(pfichero);        
        if (!a.exists()){return;}   
        
        try(PrintWriter printwriter = new PrintWriter(archivo)) 
        {
            printwriter.print(pcontenido);
            printwriter.close();
        }
    }
}