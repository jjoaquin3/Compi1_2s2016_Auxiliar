package Analizadores;

import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class Nodo {
    
    public String valor;    
    public int id, linea, columna;
    public ArrayList<Nodo> hijos;
    
    public Nodo()
    {        
    }
    
    public Nodo(String val)
    {
        this.valor = val;
        this.id=0;
        this.linea=0;
        this.columna=0;
        this.hijos = new ArrayList<Nodo>();
    }
    
    public Nodo(String val, int lin, int col)
    {
        this.valor = val;
        this.id=0;
        this.linea=lin;
        this.columna=col;
        this.hijos = new ArrayList<Nodo>();
    }
    
}
