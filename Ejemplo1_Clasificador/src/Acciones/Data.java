package Acciones;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joaquin
 */
public class Data
{
    public ArrayList<ErrorT> lista_errores;
    public ArrayList<Token> lista_reservadas; 
    protected Varios varios;
    
    public Data()
    {
        this.lista_errores = new ArrayList<>();
        this.lista_reservadas = new ArrayList<>();
        varios = new Varios();
    }
    
    public void reporteReservadas()
    {   
        if(this.lista_reservadas.isEmpty())
            return;
        System.out.println("! ============================================================ Hay Palabras reservadas");
        
        StringBuilder salida = new StringBuilder();
        salida.append("Palabra Reservada, Linea, Columna, Descripcion\n");
        for(Token reservada:this.lista_reservadas)
        {
            salida.append(reservada.lexema).append(",").append(reservada.linea).append(",");
            salida.append(reservada.columna).append(",").append(reservada.descripcion).append("\n");
        }                
        varios.creararchivo("Reservadas.csv", salida.toString());
        varios.autoAbrir("Reservadas.csv");
    }
    
    public void reporteErrores()
    {
        if(this.lista_errores.isEmpty())
            return;
        
        System.out.println("! ============================================================ Hay Errores");
        
        StringBuilder salida = new StringBuilder();
        salida.append("Token, Linea, Columna, Tipo, Descripcion\n");
        for(ErrorT temp:this.lista_errores)
        {
            salida.append(temp.lexema).append(",").append(temp.linea).append(",").append(temp.columna).append(",");
            salida.append(temp.tipo).append(",").append(temp.descripcion).append("\n");
        }        
        varios.creararchivo("Errores.csv", salida.toString());
        varios.autoAbrir("Errores.csv");        
    }
}

//----------------------------------------------------------------------------->
                    //Atte.   José Joaquin Cacao Chub
                    //Carné:  2012-12577
                    //Correo: jjcacao2@gmail.com
//----------------------------------------------------------------------------->