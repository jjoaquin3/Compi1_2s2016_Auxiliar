package Main;

import Acciones.Data;
import Acciones.Compilador;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

/**
 *
 * @author joaquin
 */
public class Home extends javax.swing.JFrame 
{
    public Home() 
    {
        initComponents();
        this.iniciarEditor();
        data = new Data();
    }
    
    private void iniciarEditor()
    {        
        this.txtentrada.setContentType("text/java");  
        txtentrada.setFont(new Font("Comic Sans", txtentrada.getFont().getStyle(), 14));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lcaret = new javax.swing.JLabel();
        scrollentrada = new javax.swing.JScrollPane();
        txtentrada = new javax.swing.JEditorPane();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        iabrir = new javax.swing.JMenuItem();
        isalir = new javax.swing.JMenuItem();
        menuEjecutar = new javax.swing.JMenu();
        icompilar = new javax.swing.JMenuItem();
        igraficar = new javax.swing.JMenuItem();
        ierrores = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        iacercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejemplo 1 - JFLex/Cup");
        setResizable(false);

        lcaret.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lcaret.setText(":D");

        txtentrada.addCaretListener(new javax.swing.event.CaretListener()
        {
            public void caretUpdate(javax.swing.event.CaretEvent evt)
            {
                txtentradaCaretUpdate(evt);
            }
        });
        scrollentrada.setViewportView(txtentrada);

        barraMenu.setForeground(new java.awt.Color(255, 255, 255));
        barraMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

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

        igraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/kazam-countdown.png"))); // NOI18N
        igraficar.setText("Graficar");
        igraficar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                igraficarActionPerformed(evt);
            }
        });
        menuEjecutar.add(igraficar);

        ierrores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/kazam-recording.png"))); // NOI18N
        ierrores.setText("Errores");
        ierrores.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ierroresActionPerformed(evt);
            }
        });
        menuEjecutar.add(ierrores);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lcaret)
                .addContainerGap(523, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollentrada, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(508, Short.MAX_VALUE)
                .addComponent(lcaret)
                .addGap(6, 6, 6))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(scrollentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 27, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtentradaCaretUpdate(javax.swing.event.CaretEvent evt)//GEN-FIRST:event_txtentradaCaretUpdate
    {//GEN-HEADEREND:event_txtentradaCaretUpdate
        try 
        {
            int posicion = txtentrada.getCaretPosition();
            int fila = (posicion == 0) ? 1 : 0;
            for (int offset = posicion; offset > 0;)
            {
                offset = Utilities.getRowStart(txtentrada, offset) - 1;
                fila++;
            }
            int offset = Utilities.getRowStart(txtentrada, posicion);
            int columna = posicion - offset + 1;
            lcaret.setText("Linea: "+fila+"       Columna: "+columna);
        } 
        catch (BadLocationException ex) 
        {Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_txtentradaCaretUpdate

    private void iabrirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_iabrirActionPerformed
    {//GEN-HEADEREND:event_iabrirActionPerformed
        JFileChooser filechooserabrir = new JFileChooser();
        filechooserabrir.setFileSelectionMode( JFileChooser.FILES_ONLY );
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (*.txt)", "txt");
        filechooserabrir.setFileFilter(filtro);
        int seleccion = filechooserabrir.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION )
        {       
            try 
            {
                BufferedReader bufferreader;
                File file = filechooserabrir.getSelectedFile();
                bufferreader = new BufferedReader(new FileReader(file.getAbsolutePath()));  
                String linea, contenido= "";

                while ((linea = bufferreader.readLine())!=null)
                    contenido += linea +"\n";
                
                this.txtentrada.setText(contenido);
                bufferreader.close();
            } 
            catch (IOException ex) 
            {Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }//GEN-LAST:event_iabrirActionPerformed

    private void isalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_isalirActionPerformed
    {//GEN-HEADEREND:event_isalirActionPerformed
        Object [] opciones = {"Si","No"};
        String sms = "Esta a punto de salir, quiere continuar";
        int eleccion =  JOptionPane.showOptionDialog(this,sms,"Ejemplo 3 - JFLex/Cup y AST",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
            System.exit(0);        
    }//GEN-LAST:event_isalirActionPerformed

    Data data;
    private void icompilarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_icompilarActionPerformed
    {//GEN-HEADEREND:event_icompilarActionPerformed
        if(txtentrada.getText().length()!=0 || !txtentrada.getText().equals(""))
        {
            Compilador compilador = new Compilador();
            data = new Data();
            compilador.analizar(this.txtentrada.getText(), data);
        }
    }//GEN-LAST:event_icompilarActionPerformed

    private void iacercadeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_iacercadeActionPerformed
    {//GEN-HEADEREND:event_iacercadeActionPerformed
        JOptionPane.showMessageDialog(null,"José Joaquin Cacao Chub\nCarnet: 2012-12577\n"
                + "Guatemala Septiempre de 2016","Acerca de",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_iacercadeActionPerformed

    private void ierroresActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ierroresActionPerformed
    {//GEN-HEADEREND:event_ierroresActionPerformed
        data.reporteErrores();
    }//GEN-LAST:event_ierroresActionPerformed

    private void igraficarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_igraficarActionPerformed
    {//GEN-HEADEREND:event_igraficarActionPerformed
        data.graficar();
    }//GEN-LAST:event_igraficarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem iabrir;
    private javax.swing.JMenuItem iacercade;
    private javax.swing.JMenuItem icompilar;
    private javax.swing.JMenuItem ierrores;
    private javax.swing.JMenuItem igraficar;
    private javax.swing.JMenuItem isalir;
    private javax.swing.JLabel lcaret;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuEjecutar;
    private javax.swing.JScrollPane scrollentrada;
    private javax.swing.JEditorPane txtentrada;
    // End of variables declaration//GEN-END:variables
    
}
