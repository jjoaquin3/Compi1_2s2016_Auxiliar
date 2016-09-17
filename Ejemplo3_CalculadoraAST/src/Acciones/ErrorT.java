package Acciones;

/**
 *
 * @author joaquin
 */
public class ErrorT
{
    public String lexema, tipo, linea, columna, descripcion;
   
    public ErrorT(){}
    
    public ErrorT(String lex, int lin, int col, String tip, String des)
    {
        this.lexema = lex;
        this.linea= String.valueOf(lin+1);
        this.columna= String.valueOf(col+1);
        this.tipo=tip;
        this.descripcion=des;
    }
    
    public ErrorT(String lex, String tip, String des)
    {
        this.lexema=lex;
        this.tipo=tip;
        this.descripcion=des;
    }
       
}
