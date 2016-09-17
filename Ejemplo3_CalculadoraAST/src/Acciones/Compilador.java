package Acciones;

import Analizadores.Lexico;
import Analizadores.Nodo;
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
public class Compilador
{
    
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
        
        try
        {
            analizador_sintactico.parse();
            d.raiz = analizador_sintactico.raiz;
        }
        catch (Exception ex)
        {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("! ============================================================ Analisis Abortado");
            JOptionPane.showMessageDialog(null,"Analisis abortado","Ejemplo 3 - JFLex/Cup y AST",JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("! ============================================================ Analisis Completado");
        JOptionPane.showMessageDialog(null,"Analisis terminado con exito","Ejemplo 3 - JFLex/Cup y AST",JOptionPane.INFORMATION_MESSAGE);
    }      
    
}
