/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;

//import javax.swing.JTable;
//import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;


/**
 *
 * @author oscar
 */

public class Utilitarios {

  public boolean EscribirEnArchivo(String nombreArchivo, TableModel modeloTabla, String rutaCompletaArchivo) {
    PrintWriter pw = null;
    try {
        File archivoAGuardar = new File(rutaCompletaArchivo); // Usa directamente la ruta completa
        FileWriter fw = new FileWriter(archivoAGuardar);
        pw = new PrintWriter(fw);

        int numColumnas = modeloTabla.getColumnCount();
        int numFilas = modeloTabla.getRowCount();

        // Escribir encabezados de columna
        for (int i = 0; i < numColumnas; i++) {
            pw.print(modeloTabla.getColumnName(i));
            if (i < numColumnas - 1) {
                pw.print(","); // Separador de columnas
            }
        }
        pw.println(); // Nueva línea después de los encabezados

        // Escribir datos de la tabla
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                Object valor = modeloTabla.getValueAt(i, j);
                pw.print((valor != null) ? valor.toString() : ""); // Evitar NullPointerException al obtener el valor
                if (j < numColumnas - 1) {
                    pw.print(","); // Separador de columnas
                }
            }
            pw.println(); // Nueva línea después de cada fila
        }
        return true; // Indica que la escritura fue exitosa

    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo " + rutaCompletaArchivo + ": " + e.getMessage());
        return false; // Indica que hubo un error en la escritura
    } finally {
        // Asegurarse de cerrar el PrintWriter en el bloque finally
        if (pw != null) {
            pw.close();
        }
    }
}  
 public String seleccionarRutaGuardado() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Guardar archivo");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
    fileChooser.setFileFilter(filter);

    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String rutaSeleccionada = selectedFile.getAbsolutePath();
        System.out.println("Ruta seleccionada para guardar: " + rutaSeleccionada); // <-- AGREGAR ESTA LÍNEA
        return rutaSeleccionada;
    }
    return null; // El usuario canceló la operación
}

    public String seleccionarRutaCarga() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo a cargar");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null; // El usuario canceló la operación
    }
    
}