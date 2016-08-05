package Acciones;

import Analizadores.Lexico;
import Analizadores.Sintactico;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author joaquin
 */
public class Exe
{
    /*------------------------------------------------------------------
    *** Metodo para ejecutar los analizadores, algunas formas
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
    public void analizar(String entrada, Data d)
    {
        Reader reader = new StringReader(entrada);
        Lexico analizador_lexico =  new Lexico(reader);
        Sintactico analizador_sintactico = new Sintactico(analizador_lexico);
        
        /*Actualizando listas
        como todos los objetos en java son por referencia :D
        incluso tambien se pudo creado una variable del tipo Data en los 
        analizadores y pasarle un objeto de tipo data "d", pero por fines practicos
        solo se pasaron las listas :)
        */
        analizador_lexico.lista_errores = d.lista_errores;
        analizador_sintactico.lista_errores = d.lista_errores;
        analizador_sintactico.lista_reservadas = d.lista_reservadas;
        
        try
        {
            analizador_sintactico.parse();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Exe.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("! ============================================================ Analisis Abortado");
            JOptionPane.showMessageDialog(null,"Analisis abortado","Ejemplo 1 - JFLex/Cup",JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("! ============================================================ Analisis Completado");
        JOptionPane.showMessageDialog(null,"Analisis terminado con exito","Ejemplo 1 - JFLex/Cup",JOptionPane.INFORMATION_MESSAGE);
    }
}

//----------------------------------------------------------------------------->
                    //Atte.   José Joaquin Cacao Chub
                    //Carné:  2012-12577
                    //Correo: jjcacao2@gmail.com
//----------------------------------------------------------------------------->