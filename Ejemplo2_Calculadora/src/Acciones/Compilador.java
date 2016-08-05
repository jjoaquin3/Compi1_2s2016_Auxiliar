package Acciones;

import Analizadores.Lexico;
import Analizadores.Sintactico;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Joaquin
 */
public class Compilador 
{
    
    public Compilador()
    {
        
    }
    
    /*------------------------------------------------------------------
    *** Metodo para ejecutar los analizadores, se puede de las sig. formas
    ***
    ***     Lexico analizador_lexico =  new Lexico(new StringReader(entrada));
    ***     Sintactico analizador_sintactico = new Sintactico(analizador_lexico);        
    ***     analizador_sintactico.parse();
    ***     
    ***     Reader reader = new StringReader(entrada);
    ***     Lexico analizador_lexico =  new Lexico(reader);
    ***     Sintactico analizador_sintactico = new Sintactico(analizador_lexico);
    ***     analizador_sintactico.parse();
    ***
    ------------------------------------------------------------------*/
    public String Analizar(String entrada)
    {
        try 
        {
            //crear el lexico
            Lexico lexico = new Lexico(new StringReader(entrada));
            //crear el sintactico
            Sintactico parser = new Sintactico(lexico);
            
            //ejecutar el analisis
            parser.parse();
            
            JOptionPane.showMessageDialog(null, "Analisis Completo","Ejemplo",1);
            return parser.salida;
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un grave problema","Ejemplo",2);
            return "Hay Errores, revise la consola :D";
        }        
    }
    
}

//----------------------------------------------------------------------------->
                    //Atte.   José Joaquin Cacao Chub
                    //Carné:  2012-12577
                    //Correo: jjcacao2@gmail.com
//----------------------------------------------------------------------------->