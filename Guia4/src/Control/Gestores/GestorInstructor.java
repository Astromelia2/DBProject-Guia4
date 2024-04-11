package Control.Gestores;

import Control.DAO.InstructorDAO;
import Modelo.InstructorVO;
import Vista.VistaInstructor;
import Vista.VistaTabla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestorInstructor implements ActionListener {

    private ArrayList<InstructorVO> listaInstructores;
    private InstructorDAO miInstructorDAO = new InstructorDAO();
    private InstructorVO objInstructor = new InstructorVO();
    private VistaInstructor vista;
    private VistaTabla vistaTabla = new VistaTabla();
    private GestorBienvenida gestor;


    public GestorInstructor() {
        this.vista = new VistaInstructor();
        this.vista.btnVolver.addActionListener(this);
        this.vista.btnSeleccionar.addActionListener(this);
        this.vista.btnCrear.addActionListener(this);
        this.vista.btnLista.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
    }

    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setResizable(false);
        this.vista.setVisible(true);
    }

    public void iniciar(GestorBienvenida vuelta) {
        gestor = vuelta;
        this.vista.setLocationRelativeTo(null);
        llenarCombo();
        this.vista.setResizable(false);
        this.vista.setVisible(true);
    }

    private void llenarCombo() {
        vista.comboxInstructores.removeAllItems();        
        vista.comboxInstructores.addItem("Seleccionar");
        listaInstructores = miInstructorDAO.listaDeInstructores();
        for (int i = 0; i < listaInstructores.size(); i++) {
            vista.comboxInstructores.addItem(listaInstructores.get(i).getNombre());
        }
    }

    // Método para verificar si hay campos de texto vacíos
    private boolean camposTextoVacios() {
        return this.vista.txtId.getText().isEmpty()
                || this.vista.txtNombre.getText().isEmpty()
                || this.vista.txtDireccion.getText().isEmpty()
                || this.vista.txtFechadeNacimiento.getText().isEmpty()
                || this.vista.txtTelefono.getText().isEmpty()
                || this.vista.txtCorreo.getText().isEmpty();
    }

    // Método para verificar si un nombre ya existe en el ComboBox
    private boolean nombreExistenteEnComboBox(String nombre) {
        int itemCount = this.vista.comboxInstructores.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (nombre.equals(this.vista.comboxInstructores.getItemAt(i))) {
                return true; // El nombre ya existe en el ComboBox
            }
        }
        return false; // El nombre no existe en el ComboBox
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Boton volver
        if (e.getSource() == vista.btnVolver) {
            vista.setVisible(false);
            gestor.iniciar();
        } 
        if (e.getSource() == vista.btnSeleccionar) {
            this.vista.txtId.setEditable(false);
            listaInstructores = miInstructorDAO.listaDeInstructores();
            String strNombre = (String) vista.comboxInstructores.getSelectedItem();
            for (InstructorVO objInstructor : listaInstructores) {
                if (strNombre.equals(objInstructor.getNombre())) {
                    this.vista.txtId.setText(Integer.toString(objInstructor.getId()));
                    this.vista.txtNombre.setText(objInstructor.getNombre());
                    this.vista.txtDireccion.setText(objInstructor.getDireccion());
                    this.vista.txtFechadeNacimiento.setText(objInstructor.getFechadeNacimiento());
                    this.vista.txtTelefono.setText(objInstructor.getTelefono());
                    this.vista.txtCorreo.setText(objInstructor.getCorreo());

                }
            }
        }
        if (e.getSource() == this.vista.btnCrear) {
            vista.txtId.setEditable(true);
            listaInstructores = miInstructorDAO.listaDeInstructores();
            int id = Integer.parseInt(this.vista.txtId.getText());
            String nombre = this.vista.txtNombre.getText();
            String direccion = this.vista.txtDireccion.getText();
            String fechadeNacimiento = this.vista.txtFechadeNacimiento.getText();
            String telefono = this.vista.txtTelefono.getText();
            String correo = this.vista.txtCorreo.getText();
            if (camposTextoVacios()) {
                this.vista.error("TODOS LOS CAMPOS DEBEN ESTAR LLENOS");
            } else {
                // Verificar si el nombre ya está en el ComboBox
                if (!nombreExistenteEnComboBox(nombre)) {
                    // El nombre no existe en el ComboBox, proceder con la inserción
                    this.objInstructor.setId(id);
                    this.objInstructor.setNombre(nombre);
                    this.objInstructor.setDireccion(direccion);
                    this.objInstructor.setFechadeNacimiento(fechadeNacimiento);
                    this.objInstructor.setTelefono(telefono);
                    this.objInstructor.setCorreo(correo);
                    this.miInstructorDAO.insertarDatos(objInstructor);
                    this.vista.msg("INSTRUCTOR AGREGADO CON EXITO");
                    llenarCombo();
                    vista.limpiar();
                }
            }
        }

        if (e.getSource() == this.vista.btnModificar) {
            listaInstructores = miInstructorDAO.listaDeInstructores();
            String nombre = (String) this.vista.comboxInstructores.getSelectedItem();
            if (vista.txtNombre.getText().isEmpty() || vista.txtDireccion.getText().isEmpty() || vista.txtCorreo.getText().isEmpty() || vista.txtTelefono.getText().isEmpty()) {
                vista.error("NO SE PERMITEN ESPACIOS VACIOS");
            } else {
                for (InstructorVO objInstructor : miInstructorDAO.listaDeInstructores()) {
                    if (objInstructor.getNombre().equals(nombre)) {
                        objInstructor.setNombre(this.vista.txtNombre.getText());
                        objInstructor.setDireccion(this.vista.txtDireccion.getText());
                        objInstructor.setFechadeNacimiento(this.vista.txtFechadeNacimiento.getText());
                        objInstructor.setTelefono(this.vista.txtTelefono.getText());
                        objInstructor.setCorreo(this.vista.txtCorreo.getText());
                        this.miInstructorDAO.actualizarDatos(objInstructor);
                        this.vista.msg("INSTRUCTOR MODIFICADO");
                        this.vista.limpiar();
                        llenarCombo();
                        break; 
                    }
                }
            }
        }
        if (e.getSource() == this.vista.btnEliminar) {
            vista.txtId.setEditable(true);
            listaInstructores = miInstructorDAO.listaDeInstructores();
            String nombre = (String) this.vista.comboxInstructores.getSelectedItem();
            for (InstructorVO objInstructor : miInstructorDAO.listaDeInstructores()) {
                if (objInstructor.getNombre().equals(nombre)) {
                    int Id = objInstructor.getId();
                    this.miInstructorDAO.eliminarInstructor(Id);
                    this.vista.msg("INSTRUCTOR ELIMINADO");
                    this.vista.limpiar();
                    llenarCombo();
                    break;
                }
            }
        }
         if(e.getSource() == this.vista.btnLista){
            this.vistaTabla.mostrarVentana(this.miInstructorDAO.cargarDatosTabla(), "CLIENTES");
        }
    }
}
