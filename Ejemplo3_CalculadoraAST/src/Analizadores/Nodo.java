package Analizadores;

import java.util.ArrayList;

/**
 *
 * @author joaquin
 */
public class Nodo
{
    public String valor;
    public int linea, columna, id;
    public ArrayList<Nodo> hijos;
    
    public Nodo(){}
    
    public Nodo(String v)
    {
        this.valor= v;
        this.hijos =new ArrayList<Nodo>();        
    }
    
    public Nodo(String v, int l, int c)
    {
        this.valor = v;
        this.linea = l;
        this.columna = c;
        this.hijos =new ArrayList<Nodo>();
    }
    
}
