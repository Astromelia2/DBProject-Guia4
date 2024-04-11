package Control.Gestores;

import Control.DAO.MonitorDAO;
import Modelo.MonitorVO;
import Vista.VistaMonitor;
import Vista.VistaTabla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestorMonitor implements ActionListener {

    private ArrayList<MonitorVO> listaMonitores;
    private MonitorDAO miMonitorDAO = new MonitorDAO();
    private MonitorVO objMonitor = new MonitorVO();
    private VistaMonitor vista;
    private VistaTabla vistaTabla = new VistaTabla();
    private GestorBienvenida gestor;


    public GestorMonitor() {
        //Escucha botones
        this.vista = new VistaMonitor();
        this.vista.btnVolver.addActionListener(this);
        this.vista.btnSeleccionar.addActionListener(this);
        this.vista.btnCrear.addActionListener(this);
        this.vista.btnLista.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
    }

    public void iniciar() {
        // Centra la vistaBienvenida en el centro de la pantalla
        this.vista.setLocationRelativeTo(null);

        this.vista.setResizable(false);
        // Hace visible la vistaBienvenida
        this.vista.setVisible(true);
    }

    public void iniciar(GestorBienvenida vuelta) {
        //Insercion de logica de las funciones necesaria
        gestor = vuelta;
        // Centra la vistaBienvenida en el centro de la pantalla
        this.vista.setLocationRelativeTo(null);
        llenarCombo();
        this.vista.setResizable(false);
        // Hace visible la vistaBienvenida
        this.vista.setVisible(true);
    }

    private void llenarCombo() {
        vista.comboxMonitores.removeAllItems(); // Limpia los elementos existentes en el ComboBox
        // Agregar la opción nula o predeterminada al principio del ComboBox
        vista.comboxMonitores.addItem("Seleccionar");
        listaMonitores = miMonitorDAO.listaDeMonitores();
        //Funcion que guarda en el ArrayList todos los clientes
        for (int i = 0; i < listaMonitores.size(); i++) {
            vista.comboxMonitores.addItem(listaMonitores.get(i).getNombre());
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
        int itemCount = this.vista.comboxMonitores.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (nombre.equals(this.vista.comboxMonitores.getItemAt(i))) {
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
        //Funcion para desplegar el usuario seleccionado en los textfield
        if (e.getSource() == vista.btnSeleccionar) {
            this.vista.txtId.setEditable(false);
            listaMonitores = miMonitorDAO.listaDeMonitores();
            String strNombre = (String) vista.comboxMonitores.getSelectedItem();
            for (MonitorVO objMonitor : listaMonitores) {
                if (strNombre.equals(objMonitor.getNombre())) {
                    this.vista.txtId.setText(Integer.toString(objMonitor.getId()));
                    this.vista.txtNombre.setText(objMonitor.getNombre());
                    this.vista.txtDireccion.setText(objMonitor.getDireccion());
                    this.vista.txtFechadeNacimiento.setText(objMonitor.getFechadeNacimiento());
                    this.vista.txtTelefono.setText(objMonitor.getTelefono());
                    this.vista.txtCorreo.setText(objMonitor.getCorreo());

                }
            }
        }
        // Agregar Monitor
        if (e.getSource() == this.vista.btnCrear) {
            vista.txtId.setEditable(true);
            listaMonitores = miMonitorDAO.listaDeMonitores();
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
                    this.objMonitor.setId(id);
                    this.objMonitor.setNombre(nombre);
                    this.objMonitor.setDireccion(direccion);
                    this.objMonitor.setFechadeNacimiento(fechadeNacimiento);
                    this.objMonitor.setTelefono(telefono);
                    this.objMonitor.setCorreo(correo);
                    this.miMonitorDAO.insertarDatos(objMonitor);
                    this.vista.msg("MONITOR AGREGADO CON EXITO");
                    llenarCombo();
                    vista.limpiar();
                }
            }
        }

        //Modificar cliente
        if (e.getSource() == this.vista.btnModificar) {
            listaMonitores = miMonitorDAO.listaDeMonitores();
            String nombre = (String) this.vista.comboxMonitores.getSelectedItem();
            if (vista.txtNombre.getText().isEmpty() || vista.txtDireccion.getText().isEmpty() || vista.txtCorreo.getText().isEmpty() || vista.txtTelefono.getText().isEmpty()) {
                vista.error("NO SE PERMITEN ESPACIOS VACIOS");
            } else {
                for (MonitorVO objMonitor : miMonitorDAO.listaDeMonitores()) {
                    if (objMonitor.getNombre().equals(nombre)) {
                        objMonitor.setNombre(this.vista.txtNombre.getText());
                        objMonitor.setDireccion(this.vista.txtDireccion.getText());
                        objMonitor.setFechadeNacimiento(this.vista.txtFechadeNacimiento.getText());
                        objMonitor.setTelefono(this.vista.txtTelefono.getText());
                        objMonitor.setCorreo(this.vista.txtCorreo.getText());
                        this.miMonitorDAO.actualizarDatos(objMonitor);
                        this.vista.msg("MONITOR MODIFICADO");
                        this.vista.limpiar();
                        llenarCombo();
                        break;  // Se detiene después de encontrar la primera coincidencia
                    }
                }
            }
        }
        // Eliminar Monitor
        if (e.getSource() == this.vista.btnEliminar) {
            vista.txtId.setEditable(true);
            listaMonitores = miMonitorDAO.listaDeMonitores();
            String nombre = (String) this.vista.comboxMonitores.getSelectedItem();
            for (MonitorVO objMonitor : miMonitorDAO.listaDeMonitores()) {
                if (objMonitor.getNombre().equals(nombre)) {
                    int Id = objMonitor.getId();
                    this.miMonitorDAO.eliminarMonitor(Id);
                    this.vista.msg("MONITOR ELIMINADO");
                    this.vista.limpiar();
                    llenarCombo();
                    break;
                }
            }
        }
         if(e.getSource() == this.vista.btnLista){
            this.vistaTabla.mostrarVentana(this.miMonitorDAO.cargarDatosTabla(), "CLIENTES");
        }
    }
}
