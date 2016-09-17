package Acciones;

import Analizadores.Nodo;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin
 */
public class Graficador
{
    protected int contador;
    protected String ruta_dot, ruta_png;
    
    public Graficador()
    {
        ////Creo una carpeta en /home/usuario/SalidasDot, en donde va estar todo
        File folder = new File(System.getProperty("user.home") + File.separator +"SalidasDot");        
        if(!folder.exists())
            folder.mkdirs();
        
        //Rutas para el .dot y la imagen .png
        ruta_dot = System.getProperty("user.home") + File.separator +"SalidasDot"+File.separator+"ast.dot"; 
        ruta_png = System.getProperty("user.home") + File.separator +"SalidasDot"+File.separator+"ast.png"; 
    }    
    
    public void graficarAST(Nodo raiz)
    {   
        this.armar_Cuerpo_dot(raiz);                
        this.crearGrafo();        
        Varios v = new Varios();
        v.autoAbrir(ruta_png);        
    }
    
    private void crearGrafo()
    {
        String[] cmd = new String[5]; 
        cmd[0] = this.parametroDOT();   //"dot" para linux-unix //"dot.exe"; //"dot"; para mac, creo
        cmd[1] = "-Tpng";
        cmd[2] = ruta_dot;
        cmd[3] = "-o";   
        cmd[4] = ruta_png;
        Runtime rt = Runtime.getRuntime();
        
        try 
        {
            //Hace la llamada al sistema y ejecuta la variable cmd
            rt.exec( cmd );                                    
        } 
        catch (IOException ex) { Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    private String parametroDOT()
    {        
        String OS = System.getProperty("os.name").toLowerCase();		
        
        if (OS.contains("win"))
            return "dot.exe";
        else if (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0)
            return "dot";
        else if (OS.contains("mac")) 
            return "dot";        
        return "dot";
    }
    
    private void armar_Cuerpo_dot(Nodo raiz)
    {
        contador=0;
        StringBuffer buffer=new StringBuffer();
        buffer.append("\ndigraph G {\r\nnode [shape=doublecircle, style=filled, color=khaki1, fontcolor=black];\n");        
        this.listarNodos(raiz, buffer);
        this.enlazarNodos(raiz, buffer);        
        buffer.append("}");        
        Varios v = new Varios();
        v.creararchivo(ruta_dot, buffer.toString());
    }
    
    private void listarNodos(Nodo praiz, StringBuffer buffer)
    {        
        buffer.append("node").append(contador).append("[label=\"").append(praiz.valor).append("\"];\n");
        praiz.id=contador;  
        contador++;
        for(Nodo temp:praiz.hijos)
            listarNodos(temp,buffer);
    }
    
    private void enlazarNodos(Nodo praiz, StringBuffer buffer)
    {        
        for(Nodo temp:praiz.hijos)
        {            
            buffer.append("\"node").append(praiz.id).append("\"->");
            buffer.append("\"node").append(temp.id).append("\";\n");
            enlazarNodos(temp, buffer);
        }
    }
    
}

