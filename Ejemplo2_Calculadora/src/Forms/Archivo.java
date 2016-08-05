package Forms;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joaquin
 */
public class Archivo 
{
    //Para admnistrar
    public int indice;
    public Boolean es_nuevo;
    public String ruta_archivo, nombre_fichero;
    
    //Para GUI
    public javax.swing.JSplitPane split0;
    private javax.swing.JScrollPane gui_jScrollPane1;
    public javax.swing.JEditorPane txt_entrada;
    
    private javax.swing.JScrollPane gui_jScrollPane2;
    public javax.swing.JEditorPane txt_salida;
    
    public Archivo()
    {
        split0 = new javax.swing.JSplitPane();
        gui_jScrollPane1 = new javax.swing.JScrollPane();
        txt_entrada = new javax.swing.JEditorPane();
        gui_jScrollPane2 = new javax.swing.JScrollPane();
        txt_salida = new javax.swing.JEditorPane();
                
        split0.setDividerLocation(375);
        split0.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        
        Font f = this.txt_entrada.getFont();
        this.txt_entrada.setFont(new Font("Consolas", f.getStyle(), 14));
        
        gui_jScrollPane1.setViewportView(txt_entrada);

        split0.setTopComponent(gui_jScrollPane1);

        gui_jScrollPane2.setAutoscrolls(true);
        
        txt_salida.setFont(new Font("Consolas", 1, 14)); // NOI18N
        txt_salida.setBackground(Color.BLACK);
        txt_salida.setForeground(Color.RED);
        txt_salida.setCaretColor(Color.GREEN);
        gui_jScrollPane2.setViewportView(txt_salida);

        split0.setRightComponent(gui_jScrollPane2);
    }
    
    
    public void guardar(Home h)
    {                     
        if(this.es_nuevo==true)
        {
            this.guardarcomo(h);
            return;
        }
        try 
        {                                 
            FileWriter fichero = new FileWriter(this.ruta_archivo);
            try (PrintWriter pw = new PrintWriter(fichero)) 
            {
                pw.write(this.txt_entrada.getText());
                this.es_nuevo=false;
            }
            JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Ejemplo 1 - JFLex/Cup",JOptionPane.INFORMATION_MESSAGE);                                    
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Ejemplo 1 - JFLex/Cup",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void guardarcomo(Home h) 
    {
        FileNameExtensionFilter filtrotxt;
        JFileChooser dialogoguardar=new JFileChooser();

        //Filtro
        filtrotxt = new FileNameExtensionFilter("Archivos de operaciones aritmeticas (*.ari)", "ari");
        dialogoguardar.setFileFilter(filtrotxt);

        dialogoguardar.showSaveDialog(h);
        File fichero =dialogoguardar.getSelectedFile();

        if(fichero !=null)
        {
            nombre_fichero=dialogoguardar.getSelectedFile().getName();
            try (FileWriter ficheroguardando = new FileWriter(fichero+".ari")) 
            {
                this.es_nuevo=false;
                ficheroguardando.write(this.txt_entrada.getText());                

                //aqui se modifica el titulo
                //this.setTitle(nombrefichero);
                this.ruta_archivo= fichero+".ari";
                JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Ejemplo 1 - JFLex/Cup",JOptionPane.INFORMATION_MESSAGE);
            } 
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Ejemplo 1 - JFLex/Cup",JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }        
    }
    
}

//----------------------------------------------------------------------------->
                    //Atte.   José Joaquin Cacao Chub
                    //Carné:  2012-12577
                    //Correo: jjcacao2@gmail.com
//----------------------------------------------------------------------------->