package Acciones;

import Analizadores.Nodo;
import java.util.ArrayList;

/**
 *
 * @author joaquin
 */
public class Data
{
    public ArrayList<ErrorT> lista_errores;
    public Nodo raiz;
    protected Varios varios;
    
    public Data()
    {
        this.lista_errores = new ArrayList<>();
        varios = new Varios();
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
    
    public void graficar()
    {
        if(this.raiz==null)
            return;
        
        Graficador g = new Graficador();
        g.graficarAST(raiz);
    }
    
}