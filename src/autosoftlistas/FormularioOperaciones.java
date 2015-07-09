package autosoftlistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Velasquez
 */
public class FormularioOperaciones extends JFrame {

    private JButton jbtAgregar, jbtActualizar, jbtBorrar, jbtBuscar;
    private JList jlstEmpleados;
    private DefaultListModel defaultListModel;
    private DialogoEmpleados dialogoEmpleados;
    private ListaEmpleados listaEmpleados;
    private JTextField jtfNombre;
    private ArchivoEmpleados archivoEmpleados;

    public FormularioOperaciones() {
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(jbtAgregar = new JButton("Agregar"));
        p1.add(jbtActualizar = new JButton("Actualizar"));
        p1.add(jbtBorrar = new JButton("Borrar"));
        p1.add(jbtBuscar = new JButton("Buscar"));
        p1.add(jtfNombre = new JTextField(15));

        this.add(p1, BorderLayout.NORTH);

        defaultListModel = new DefaultListModel();
        listaEmpleados = new ListaEmpleados();

        archivoEmpleados = new ArchivoEmpleados("c:\\Empleados.txt");
        listaEmpleados = archivoEmpleados.leer();
        poblarJList();

        jlstEmpleados = new JList(defaultListModel);
        jlstEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.add(new JScrollPane(jlstEmpleados), BorderLayout.CENTER);

        jlstEmpleados.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int indiceSeleccionado = jlstEmpleados.getSelectedIndex();

                //JOptionPane.showMessageDialog(rootPane, "Indice seleccionado " + indiceSeleccionado);
            }
        });

        jbtAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                dialogoEmpleados = new DialogoEmpleados(null);

                frmEmpleados empleados = dialogoEmpleados.getEmpleados();
                listaEmpleados.insertarAlfinal(empleados);
                poblarJList();
                archivoEmpleados.guardar(listaEmpleados);

            }
        });

        jbtActualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstEmpleados.getSelectedIndex();

                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un empleado", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dialogoEmpleados = new DialogoEmpleados(listaEmpleados.infoEnPosicion(indiceSeleccionado + 1));
                    archivoEmpleados.guardar(listaEmpleados);
                    poblarJList();
                }
            }
        });

        jbtBorrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstEmpleados.getSelectedIndex();
                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un empleado", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(rootPane, "Realmente desea borrar el empleado seleccionado", "Confirmar Borrado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        listaEmpleados.borrar(indiceSeleccionado + 1);
                        archivoEmpleados.guardar(listaEmpleados);
                        poblarJList();
                    }
                }
            }
        });

        jbtBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String nombre = jtfNombre.getText().trim();
                if (!nombre.isEmpty()) {
                    frmEmpleados empleados = buscar(nombre);
                    if (empleados != null) {
                        dialogoEmpleados = new DialogoEmpleados(empleados);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "El empleado " + nombre + " no se encontro en la lista", "Resultado Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }

    private void poblarJList() {
        defaultListModel.removeAllElements();
        for (Iterator iterator = listaEmpleados.iterator(); iterator.hasNext();) {
            frmEmpleados empleados = (frmEmpleados) iterator.next();
            defaultListModel.addElement(empleados);
        }
    }

    private frmEmpleados buscar(String nombre) {
        for (Iterator iterator = listaEmpleados.iterator(); iterator.hasNext();) {
            frmEmpleados empleados = (frmEmpleados) iterator.next();
            if (empleados.getNombre().contains(nombre)) {
                return empleados;
            }
        }
        return null;
    }
}

    


