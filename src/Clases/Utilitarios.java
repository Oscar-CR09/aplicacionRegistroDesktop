/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
*/
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author oscar
 */
/*
public class Utilitarios {
    
    public static String ruta = System.getProperty("user.dir")+"\\src\\Archivos";
    
    public void TablaArchivo(int nColumnas,String nombreArchivo,DefaultTableModel tabla){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Object[] filas = new Object[nColumnas];
        
        try {
            /* crea un objeto file, el contructor recibe la 
            rutadel archivo del cualquiero saber sus propiedades
            */
       /*     
            archivo = new File (ruta+"\\"+ nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            
            while((linea=br.readLine())!=null){
                filas[0]=linea;
                for (int j = 1; j < nColumnas; j++) {
                    filas[j]=br.readLine();
                }
                
                tabla.addRow(filas);
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Agregue un registro para crear el archivo");
        }
         finally {
            try {
                if(null!=fr)
                    fr.close();
            } catch (IOException e2) {
                JOptionPane.showMessageDialog(null,e2.getMessage());
            }
        }

}
    public void EscribirEnArchivo(String nombreArchivo, DefaultTableModel tabla){
        FileWriter archivo=null;
        PrintWriter pw =null;
        try {
            archivo = new FileWriter(Utilitarios.ruta + "\\"+nombreArchivo);
            for (int filas = 0; filas < tabla.getRowCount(); filas++) {
                for (int columnas = 0; columnas < tabla.getColumnCount(); columnas++) {
                    pw.println(tabla.getValueAt(filas, columnas));
                    
                }
            }
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            try {
                if(null!=archivo)
                    archivo.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
    }
}
*/
public class Utilitarios {

    public boolean EscribirEnArchivo(String nombreArchivo, TableModel modeloTabla) {
        PrintWriter pw = null;
        try {
            FileWriter fw = new FileWriter(nombreArchivo);
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
            System.err.println("Error al escribir en el archivo " + nombreArchivo + ": " + e.getMessage());
            return false; // Indica que hubo un error en la escritura
        } finally {
            // Asegurarse de cerrar el PrintWriter en el bloque finally
            if (pw != null) {
                pw.close();
            }
        }
    }
}