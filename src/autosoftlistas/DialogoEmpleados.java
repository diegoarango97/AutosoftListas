package autosoftlistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Velasquez
 */
public class DialogoEmpleados extends JDialog {

    private JTextField jtfID, jtfCargo,jtfNombre, jtfApellido, jtfFechaNacimiento,jtfGenero ;
    private JButton jbtAceptar, jbtCancelar;
    private frmEmpleados empleados;

    public DialogoEmpleados(frmEmpleados e) {
        this.empleados = e;

        JPanel p1 = new JPanel(new GridLayout(3, 2));
        p1.add(new JLabel("ID"));
        p1.add(jtfID = new JTextField(6));

        p1.add(new JLabel("Cargo"));
        p1.add(jtfCargo = new JTextField(15));

        p1.add(new JLabel("Nombre"));
        p1.add(jtfNombre = new JTextField(15));

        p1.add(new JLabel("Apellido"));
        p1.add(jtfApellido = new JTextField(15));

        p1.add(new JLabel("Fecha de nacimiento"));
        p1.add(jtfFechaNacimiento = new JTextField(6));

        p1.add(new JLabel("Genero"));
        p1.add(jtfGenero = new JTextField(6));

        p1.add(new JLabel("Estado civil"));
        p1.add(jtfEstadoCivil = new JTextField(6));

        p1.add(new JLabel("Telefono"));
        p1.add(jtfTelefono = new JTextField(6));

        p1.add(new JLabel("Celular"));
        p1.add(jtfCelular = new JTextField(6));

        p1.add(new JLabel("Pais"));
        p1.add(jtfPais = new JTextField(6));

        p1.add(new JLabel("Departamento"));
        p1.add(jtfDepartamento = new JTextField(6));

        p1.add(new JLabel("Ciudad"));
        p1.add(jtfCiudad = new JTextField(6));

        p1.add(new JLabel("Direccion"));
        p1.add(jtfDireccion = new JTextField(6));

        p1.add(new JLabel("Correo"));
        p1.add(jtfCorreo = new JTextField(6));

        this.add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(jbtAceptar = new JButton("Aceptar"));
        p2.add(jbtCancelar = new JButton("Cancelar"));

        add(p2, BorderLayout.SOUTH);
        setTitle("Estudiante");
        setModal(true);

        if (estudiante != null) {
            // Vamos a actualizar
            jtfNombre.setText(estudiante.getNombre());
            jtfApellido.setText(estudiante.getApellido());
            jtfPromedio.setText(Double.toString(estudiante.getPromedio()));
        }

        jbtAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nombre = jtfNombre.getText();
                String apellido = jtfApellido.getText();

                try {
                    double promedio = Double.parseDouble(jtfPromedio.getText());
                    if (promedio >= 0 && promedio <= 5) {
                        if (estudiante == null) {
                            estudiante = new Estudiante(nombre, apellido, promedio);
                        } else {
                            estudiante.setNombre(nombre);
                            estudiante.setApellido(apellido);
                            estudiante.setPromedio(promedio);
                        }
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "promedio debe estar entre 0 y 5", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Promedio inválido", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        jbtCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setSize(350, 200);
        setLocationRelativeTo(rootPane);
        setVisible(true);
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
}

}
