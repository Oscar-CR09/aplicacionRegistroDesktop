/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Formuarios;

//import java.io.*;
import Clases.Utilitarios;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.table.TableModel;

/**
 *
 * @author oscar
 */
public class movTaxis extends javax.swing.JDialog {
    Object[] filas =new Object[5];
    Object[] otaxis = new Object[6];
    int fila;
    DefaultTableModel modeloTabla = new DefaultTableModel();

    // Define la ruta específica para guardar el archivo de movimientos
    private final String rutaGuardadoMovimientos = "/src/data"; // Reemplaza con tu ruta deseada
    private Utilitarios util = new Utilitarios();
    

    //javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel();
    
    

    /**
     * Creates new form movTaxis
     */
    public movTaxis(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarModelo();
        //cargarTaxis();
       // cargarMovimientos();
       
        
    }
    
    @SuppressWarnings("unchecked")
    private void configurarModelo(){
        modeloTabla.addColumn("# Placa");
        modeloTabla.addColumn("Tipo Movimiento");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Hora");
        modeloTabla.addColumn("Estado");
        tabla.setModel(modeloTabla);
                
    }
    
    /*
    private void cargarTaxis(){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
    fileChooser.setFileFilter(filter);
    int seleccion = fileChooser.showOpenDialog(this); // 'this' hace referencia al JDialog

    if (seleccion == JFileChooser.APPROVE_OPTION) {
        archivo = fileChooser.getSelectedFile();
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            cmbPlacaTaxi.removeAllItems();
            cmbTipo.removeAllItems();

            while ((linea = br.readLine()) != null) {
                String[] datosTaxi = linea.split(",");
                if (datosTaxi.length == 2) {
                    cmbPlacaTaxi.addItem(datosTaxi[0]);
                    cmbTipo.addItem(datosTaxi[1]);
                } else {
                    System.err.println("Advertencia: Línea ignorada en " + archivo.getName() + ": " + linea);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al cargar taxis desde " + archivo.getAbsolutePath() + ": " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(rootPane, "Error al cerrar archivo: " + e2.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(rootPane, "No se seleccionó ningún archivo para cargar los taxis.");
    }
}

    private void cargarMovimientos(){ 
        File archivo = null;
        FileReader fr =null;
        BufferedReader br = null;
        
        try {
            archivo =new File(System.getProperty("user.dir")+rutaGuardadoMovimientos,"Movimientos.txt");
            fr =new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            modeloTabla.setRowCount(0);
            while ((linea=br.readLine())!=null) {                
                filas[0]=linea;
                for (int j = 1; j < 5; j++) {
                    filas[j]=br.readLine();
                }
                modeloTabla.addRow(filas);
            }
            tabla.setModel(modeloTabla);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } finally {
            try {
                 if (null != fr){
                     fr.close();
                 }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(rootPane, e2.getMessage());
            }
        }
    
    }
/*
private void cargarMovimientos(){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
    fileChooser.setFileFilter(filter);
    int seleccion = fileChooser.showOpenDialog(this);

    if (seleccion == JFileChooser.APPROVE_OPTION) {
        archivo = fileChooser.getSelectedFile();
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            modeloTabla.setRowCount(0);

            while ((linea = br.readLine()) != null) {
                String[] datosMovimiento = linea.split(",");
                if (datosMovimiento.length == 5) {
                    modeloTabla.addRow(datosMovimiento);
                } else {
                    System.err.println("Advertencia: Línea ignorada en " + archivo.getName() + ": " + linea);
                }
            }
            tabla.setModel(modeloTabla);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al cargar movimientos desde " + archivo.getAbsolutePath() + ": " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(rootPane, "Error al cerrar archivo: " + e2.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(rootPane, "No se seleccionó ningún archivo para cargar los movimientos.");
    }
}
    */
    private void cargarTabla(){
        try {
            filas[0]=cmbPlacaTaxi.getSelectedItem().toString();
            filas[1]=cmbTipo.getSelectedItem().toString();
            filas[2]=fecha.getText();
            filas[3]=txtHora.getText() + ":"+ txtMinutos.getText();
            filas[4]=cmbEstado.getSelectedItem().toString();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.toString());
                                
        }
    }
    private void limpiarCampos() {
    if (cmbPlacaTaxi.getItemCount() > 0) {
        cmbPlacaTaxi.setSelectedIndex(0); // Selecciona el primer elemento o un valor por defecto
    }
    if (cmbTipo.getItemCount() > 0) {
        cmbTipo.setSelectedIndex(0);
    }
    fecha.setText("");
    txtHora.setText("");
    txtMinutos.setText("");
    if (cmbEstado.getItemCount() > 0) {
        cmbEstado.setSelectedIndex(0);
    }
}

    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbPlacaTaxi = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        txtHora = new javax.swing.JFormattedTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtMinutos = new javax.swing.JTextField();
        fecha = new datechooser.beans.DateChooserCombo();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnIncluirTabla = new javax.swing.JButton();
        btnModificarFilaTabla = new javax.swing.JButton();
        btnEliminarfilaTabla = new javax.swing.JButton();
        btnCerrarMenu = new javax.swing.JButton();
        btnActualizarArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimiento de Taxis");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimiento Taxi"));

        jLabel1.setText("Placa Taxi:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Fecha:");

        jLabel4.setText("Hora:");

        jLabel5.setText("Estado:");

        cmbPlacaTaxi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPlacaTaxi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPlacaTaxiActionPerformed(evt);
            }
        });

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraKeyReleased(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habilitado", "Desahabilitado" }));

        jLabel6.setText(":");

        txtMinutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMinutosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMinutosKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbPlacaTaxi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbEstado, 0, 153, Short.MAX_VALUE)))
                        .addGap(115, 115, 115))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbPlacaTaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla Movimiento"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIncluirTabla.setText("Incluir en la Tabla");
        btnIncluirTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirTablaActionPerformed(evt);
            }
        });

        btnModificarFilaTabla.setText("Modificar fila de Tabla");
        btnModificarFilaTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarFilaTablaActionPerformed(evt);
            }
        });

        btnEliminarfilaTabla.setText("Eliminar fila de tabla");
        btnEliminarfilaTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarfilaTablaActionPerformed(evt);
            }
        });

        btnCerrarMenu.setText("Cerrar y regresar al Menú");
        btnCerrarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarMenuActionPerformed(evt);
            }
        });

        btnActualizarArchivo.setText("Actualizar archivo de Texto");
        btnActualizarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIncluirTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificarFilaTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarfilaTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCerrarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnIncluirTabla)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarFilaTabla)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarfilaTabla)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrarMenu)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarArchivo)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPlacaTaxiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPlacaTaxiActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbPlacaTaxiActionPerformed

    private void btnIncluirTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirTablaActionPerformed
        // TODO add your handling code here:
        String hora = txtHora.getText()+":"+txtMinutos.getText();
        cargarTabla();
        modeloTabla.addRow(filas);
        tabla.setModel(modeloTabla);
        limpiarCampos();
        btnActualizarArchivo.setEnabled(true);
        
    }//GEN-LAST:event_btnIncluirTablaActionPerformed

    private void btnActualizarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarArchivoActionPerformed
        // TODO add your handling code here:
      /*
      FileWriter archivo = null;
      PrintWriter pw = null;
      
        try {
            pw=new PrintWriter(archivo);
             for (int filas = 0; fila < tabla.getRowCount(); filas++) {
                  for (int columnas = 0; columnas < tabla.getColumnCount(); columnas++) {
                  pw.println(tabla.getValueAt(filas, columnas));
                  }
             } 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } finally {
             try {
                 if (null != archivo){
                     archivo.close();
                 }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(rootPane, e2.getMessage());
            }
        }
        */
      
        String rutaParaGuardar = util.seleccionarRutaGuardado();
    //System.out.println("Ruta a pasar a EscribirEnArchivo: " + rutaParaGuardar); // <-- AGREGAR ESTA LÍNEA
    if (rutaParaGuardar != null) {
        if (util.EscribirEnArchivo("Movimiento.txt", modeloTabla, rutaParaGuardar)) {
            btnActualizarArchivo.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Guardado cancelado por el usuario.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }          
     
    
      
    }//GEN-LAST:event_btnActualizarArchivoActionPerformed

    private void btnModificarFilaTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarFilaTablaActionPerformed
        // TODO add your handling code here:
      
        for (int i = 0; i < 5; i++) {
            modeloTabla.setValueAt(filas[i], fila, i);
        }
        tabla.setModel(modeloTabla);
        btnActualizarArchivo.setEnabled(true);
        
    }//GEN-LAST:event_btnModificarFilaTablaActionPerformed

    private void btnEliminarfilaTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarfilaTablaActionPerformed
        // TODO add your handling code here:
        modeloTabla.removeRow(fila);
        tabla.setModel(modeloTabla);
        btnActualizarArchivo.setEnabled(true);
    }//GEN-LAST:event_btnEliminarfilaTablaActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        fila=tabla.rowAtPoint(evt.getPoint());
        seleccionarRegistro();
        
    }//GEN-LAST:event_tablaMouseClicked

    private void txtHoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyPressed
        // TODO add your handling code here:
        char c;
        c=evt.getKeyChar();
        if (c<'0'|| c>'9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtHoraKeyPressed

    private void btnCerrarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarMenuActionPerformed

    private void txtMinutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinutosKeyPressed
        // TODO add your handling code here:
        char c;
        c=evt.getKeyChar();
        if (c<'0'||c>'9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtMinutosKeyPressed

    private void txtMinutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinutosKeyReleased
        // TODO add your handling code here:
        int numEntero = Integer.parseInt(txtMinutos.getText());
        if (numEntero > 60) {
            txtMinutos.setText("59");
        }
    }//GEN-LAST:event_txtMinutosKeyReleased

    private void txtHoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyReleased
        // TODO add your handling code here:
        int numEntero = Integer.parseInt(txtHora.getText());
        if (numEntero>12) {
            txtHora.setText("12");
        }
    }//GEN-LAST:event_txtHoraKeyReleased

    private void seleccionarRegistro(){
        String valor1 = (String) tabla.getValueAt(fila, 0);
        for (int j = 0; j < cmbPlacaTaxi.getItemCount(); j++) {
            cmbPlacaTaxi.setSelectedIndex(j);
            if (valor1.equals(cmbPlacaTaxi.getSelectedItem().toString())) {
                j=cmbPlacaTaxi.getItemCount();
                
            }
            String valor2 = (String) tabla.getValueAt(fila, 1);
            for (int i = 0; i < cmbTipo.getItemCount(); i++) {
                cmbTipo.setSelectedIndex(i);
                if (valor2 == null ? cmbTipo.getSelectedItem().toString()==null: valor2.equals(cmbTipo.getSelectedItem().toString())) {
                    i=cmbTipo.getItemCount();
                }
            }
            fecha.setText((String) tabla.getValueAt(fila, 2));
            String cad = (String) tabla.getValueAt(fila, 3);
            int posi =cad.indexOf(":");
            String hora=cad.substring(0,posi);
            String minuto =cad.substring(posi+1,cad.length());
            txtHora.setText(hora);
            txtMinutos.setText(minuto);
            String valor3 = (String) tabla.getValueAt(fila, 4);
            for (int k = 0; k < cmbEstado.getItemCount(); k++) {
                cmbEstado.setSelectedIndex(k);
                if (valor3.equals(cmbEstado.getSelectedItem().toString())) {
                    k=cmbEstado.getItemCount();
                    
                }
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(movTaxis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(movTaxis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(movTaxis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(movTaxis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                movTaxis dialog = new movTaxis(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarArchivo;
    private javax.swing.JButton btnCerrarMenu;
    private javax.swing.JButton btnEliminarfilaTabla;
    private javax.swing.JButton btnIncluirTabla;
    private javax.swing.JButton btnModificarFilaTabla;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbPlacaTaxi;
    private javax.swing.JComboBox<String> cmbTipo;
    private datechooser.beans.DateChooserCombo fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtMinutos;
    // End of variables declaration//GEN-END:variables
}
