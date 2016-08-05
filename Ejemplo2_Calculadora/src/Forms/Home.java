package Forms;

import Acciones.Compilador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joaquin
 */
public class Home extends javax.swing.JFrame 
{

    public Home() 
    {
        initComponents();
        contador_nuevos=0;
        this.listaPestanias=new ArrayList<>();
    }

    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        panelPrincipal = new javax.swing.JPanel();
        panelPestanias = new javax.swing.JTabbedPane();
        scroll = new javax.swing.JScrollPane();
        txtcero = new javax.swing.JTextPane();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        inuevo = new javax.swing.JMenuItem();
        iabrir = new javax.swing.JMenuItem();
        iguardar = new javax.swing.JMenuItem();
        iguardarcomo = new javax.swing.JMenuItem();
        icerrar = new javax.swing.JMenuItem();
        isalir = new javax.swing.JMenuItem();
        menuEjecutar = new javax.swing.JMenu();
        icompilar = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        iacercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejemplo 2 - JFLex/Cup");
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(692, 609));

        panelPestanias.setAutoscrolls(true);
        panelPestanias.setFocusable(false);

        txtcero.setBackground(new java.awt.Color(0, 0, 0));
        txtcero.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        txtcero.setForeground(new java.awt.Color(255, 255, 255));
        txtcero.setText(" Aplicación que resuelve una lista de operaciones aritméticas\n\n  * Suma\n  * Resta\n  * Multiplicación\n  * Potencia\n  * Aumento\n  * Decremento\n  * Manejo de paréntesis\n\n------------------------------------------------------------------------------------\n\n * Extención del archivo de entrada: \".ari\"\n * Los Errores se imprimen en consola, NO en la interfaz grafica\n\n------------------------------------------------------------------------------------\n\n Abrir nueva pestaña\n\n -> Menu Archivo\n\t-> Opcion Nuevo\n\t-> Opcion Abrir\n\n------------------------------------------------------------------------------------\n\n Nombre: José Joaquin Cacao Chub\n Carné:   2012-12577\n Correo:  jjcacao2@gmail.com\n Tutor Académico: Organización de Lenguajes y Compiladores - Sección C\n Guatemala Agosto 2016");
        txtcero.setEnabled(false);
        scroll.setViewportView(txtcero);

        panelPestanias.addTab("Cero", scroll);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPestanias, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPestanias, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        barraMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        inuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-file-to-archive.png"))); // NOI18N
        inuevo.setText("Nuevo");
        inuevo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                inuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(inuevo);

        iabrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document-open.png"))); // NOI18N
        iabrir.setText("Abrir");
        iabrir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                iabrirActionPerformed(evt);
            }
        });
        menuArchivo.add(iabrir);

        iguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document-save.png"))); // NOI18N
        iguardar.setText("Guardar");
        iguardar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                iguardarActionPerformed(evt);
            }
        });
        menuArchivo.add(iguardar);

        iguardarcomo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document-save-as.png"))); // NOI18N
        iguardarcomo.setText("Guardar Como");
        iguardarcomo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                iguardarcomoActionPerformed(evt);
            }
        });
        menuArchivo.add(iguardarcomo);

        icerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/gtk-close.png"))); // NOI18N
        icerrar.setText("Cerrar Archivo");
        icerrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                icerrarActionPerformed(evt);
            }
        });
        menuArchivo.add(icerrar);

        isalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/boot.png"))); // NOI18N
        isalir.setText("Salir");
        isalir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                isalirActionPerformed(evt);
            }
        });
        menuArchivo.add(isalir);

        barraMenu.add(menuArchivo);

        menuEjecutar.setText("Ejecutar");
        menuEjecutar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        icompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/kt-start.png"))); // NOI18N
        icompilar.setText("Analizar");
        icompilar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                icompilarActionPerformed(evt);
            }
        });
        menuEjecutar.add(icompilar);

        barraMenu.add(menuEjecutar);

        menuAyuda.setText("?");
        menuAyuda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        iacercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ajuda-sobre.png"))); // NOI18N
        iacercade.setText("Acerca de ...");
        iacercade.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                iacercadeActionPerformed(evt);
            }
        });
        menuAyuda.add(iacercade);

        barraMenu.add(menuAyuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 705, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        
    private int contador_nuevos;
    public ArrayList<Archivo> listaPestanias;   
    private void inuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inuevoActionPerformed
        Archivo a = new Archivo();
        this.panelPestanias.addTab("new "+contador_nuevos, a.split0);
        a.indice=this.panelPestanias.getTabCount()-1;
        this.panelPestanias.setSelectedIndex(a.indice);
        this.listaPestanias.add(a);
        this.contador_nuevos++;
    }//GEN-LAST:event_inuevoActionPerformed

    private void iabrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iabrirActionPerformed
        JFileChooser filechooserabrir = new JFileChooser();
        filechooserabrir.setFileSelectionMode( JFileChooser.FILES_ONLY );
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Operaciones Aritmeticas (*.ari)", "ari");
        filechooserabrir.setFileFilter(filtro);
        int seleccion = filechooserabrir.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION )
        {       
            try {
                BufferedReader bufferreader;                 
                File file = filechooserabrir.getSelectedFile();
                bufferreader = new BufferedReader(new FileReader(file.getAbsolutePath()));  
                String linea, contenido= "";
                
                //leeendo linea a linea
                while ((linea = bufferreader.readLine())!=null)
                    contenido += linea +"\n";
                            
                //Agregando texto al editor
                Archivo a = new Archivo();
                a.nombre_fichero = file.getName();
                a.ruta_archivo = file.getAbsolutePath();
                a.txt_entrada.setText(contenido);
                this.panelPestanias.addTab(a.nombre_fichero, a.split0);
                a.indice=this.panelPestanias.getTabCount()-1;
                a.es_nuevo=false;
                this.panelPestanias.setSelectedIndex(a.indice);
                this.listaPestanias.add(a);
                                
                bufferreader.close();
            } 
            catch (IOException ex) 
            {Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }//GEN-LAST:event_iabrirActionPerformed

    private void iguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iguardarActionPerformed
        Archivo a =this.capturarArchivo();
        if(a==null)
            return;
        
        a.guardar(this);
        
        if(a.es_nuevo==false)
            this.panelPestanias.setTitleAt(a.indice, a.nombre_fichero);
    }//GEN-LAST:event_iguardarActionPerformed

    private void iguardarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iguardarcomoActionPerformed
        Archivo a =this.capturarArchivo();
        if(a==null)
            return;
        
        a.guardarcomo(this);
        
        if(a.es_nuevo==false)
            this.panelPestanias.setTitleAt(a.indice, a.nombre_fichero);
    }//GEN-LAST:event_iguardarcomoActionPerformed

    private void icerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icerrarActionPerformed
        int indice = this.panelPestanias.getSelectedIndex();
        if(indice==0)
            return;
        
        Boolean borrado = false;
        for(Archivo item:this.listaPestanias)
        {
            if(item.indice==indice)
            {
                Object [] opciones ={"Si","No"};
                String sms = "Esta a punto de cerrar el editor, quiere guadar los cambios";
                int eleccion =  JOptionPane.showOptionDialog(this,sms,"Ejemplo 2 - JFLex/Cup",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
                
                if (eleccion == JOptionPane.YES_OPTION)
                    item.guardar(this); 
                
                this.panelPestanias.remove(this.panelPestanias.getSelectedComponent());
                this.listaPestanias.remove(item);
                borrado=true;
                break;
            }                
        }
        
        this.panelPestanias.setSelectedIndex(indice-1);
        
        if(borrado==true)
        {
            for(Archivo item:this.listaPestanias)
            {
                if(item.indice>=indice)
                    item.indice=item.indice-1;
            }
        }
    }//GEN-LAST:event_icerrarActionPerformed

    private void isalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isalirActionPerformed
        Object [] opciones ={"Si","No"};
        String sms = "Esta a punto de salir, quiere continuar";
        int eleccion =  JOptionPane.showOptionDialog(this,sms,"Ejemplo 2 - JFLex/Cup",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {System.exit(0);}
    }//GEN-LAST:event_isalirActionPerformed

    private void icompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icompilarActionPerformed
        Archivo archivo = this.capturarArchivo();
        if(archivo==null)
            return;
        
        if(archivo.txt_entrada.getText().length()!=0 || !archivo.txt_entrada.getText().equals(""))
        {
            Compilador c = new Compilador();
            String salida = c.Analizar(archivo.txt_entrada.getText());
            archivo.txt_salida.setText(salida);  
        }                      
    }//GEN-LAST:event_icompilarActionPerformed

    private void iacercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iacercadeActionPerformed
        JOptionPane.showMessageDialog(null,"José Joaquin Cacao Chub\nCarnet: 2012-12577\nGuatemala Agosto 2016","Acerca de",1);
    }//GEN-LAST:event_iacercadeActionPerformed
   
    public Archivo capturarArchivo()
    {
        //Si esta seleccionada la pestaña 0, no hay editor
        //Si esta seleccionada una pestaña que no sea la 0, si hay editor
        //para ejecutar acciones
        int indice = this.panelPestanias.getSelectedIndex();
        if(indice==0)
            return null;
        
        for(Archivo item:this.listaPestanias)
        {
            if(item.indice==indice)
                return item;
        }        
        return null;
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem iabrir;
    private javax.swing.JMenuItem iacercade;
    private javax.swing.JMenuItem icerrar;
    private javax.swing.JMenuItem icompilar;
    private javax.swing.JMenuItem iguardar;
    private javax.swing.JMenuItem iguardarcomo;
    private javax.swing.JMenuItem inuevo;
    private javax.swing.JMenuItem isalir;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuEjecutar;
    private javax.swing.JTabbedPane panelPestanias;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextPane txtcero;
    // End of variables declaration//GEN-END:variables
    
}


//----------------------------------------------------------------------------->
                    //Atte.   José Joaquin Cacao Chub
                    //Carné:  2012-12577
                    //Correo: jjcacao2@gmail.com
//----------------------------------------------------------------------------->