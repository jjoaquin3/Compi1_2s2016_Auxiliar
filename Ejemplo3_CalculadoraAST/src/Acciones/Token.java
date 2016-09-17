package Acciones;

/**
 *
 * @author joaquin
 */
public class Token
{
    public int linea, columna;
    public String descripcion, lexema;
    
    public Token()
    {
        this.linea=0;
        this.columna=0;
        this.descripcion="";
        this.lexema="";
    }
    
    public Token(String v, int l, int c, String d)
    {
        this.linea=l;
        this.columna=c;
        this.descripcion=d;
        this.lexema=v;
    }
}
