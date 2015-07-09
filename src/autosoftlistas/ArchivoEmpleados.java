package autosoftlistas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Velasquez
 */
public class ArchivoEmpleados {
    private final String camino;

    public ArchivoEmpleados(String camino) {
        this.camino = camino;
    }

    public void guardar(ListaEmpleados listaEmpleados) {
        try {
            FileWriter fileWriter = new FileWriter(camino, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Iterator iterator = listaEmpleados.iterator(); iterator.hasNext();) {
                frmEmpleados empleados = (frmEmpleados) iterator.next();
                printWriter.println(empleados);
            }

            printWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ListaEmpleados leer() {
        ListaEmpleados listaEmpleados = new ListaEmpleados();

        FileReader fileReader;
        try {

            File file = new File(camino);

            if (file.exists()) {
                fileReader = new FileReader(file);

                BufferedReader bufferReader = new BufferedReader(fileReader);
                String linea;

                while ((linea = bufferReader.readLine()) != null) {
                    String[] campoEmpleado = linea.split(" ");
                    Estudiante estudiante = new Estudiante(campoEstudiante[0], campoEstudiante[1], Double.parseDouble(campoEstudiante[2]));
                    listaEstudiante.insertarAlfinal(estudiante);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return listaEstudiante;
    }

}
}
