package Control.DAO;

import Modelo.MonitorVO;
import Modelo.Conexion.Conexion;
import Vista.VistaMonitor;
// PreparedStatement permite ejecutar consultas SQL precompiladas, mejorando la seguridad y rendimiento.
import com.mysql.jdbc.PreparedStatement;
// Estas clases son esenciales para interactuar con bases de datos mediante JDBC.
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// ArrayList es una colección dinámica que facilita el manejo de conjuntos de datos.
import java.util.ArrayList;
// DefaultTableModel es una implementación de TableModel para gestionar datos tabulares en componentes Swing.
import javax.swing.table.DefaultTableModel;

public class MonitorDAO {

    // Declaración de una variable de tipo Connection para gestionar la conexión a la base de datos.
    private Connection con;
    // Declaración de una variable de tipo Statement para ejecutar consultas SQL.
    private Statement st;
    // Declaración de una variable de tipo ResultSet para almacenar los resultados de consultas SQL.
    private ResultSet rs;
    // Declaración de una variable de tipo VistaMenu, para manejar la interfaz gráfica del menú.
    private VistaMonitor vista = new VistaMonitor();

    public MonitorDAO() {
        // Inicializa las variables de conexión y resultados a null
        this.con = null;
        this.st = null;
        this.rs = null;
    }

// Método que retorna una lista de objetos MonitorVO, obtenidos desde la base de datos.
    public ArrayList<MonitorVO> listaDeMonitores() {
        // Creación de una nueva lista para almacenar objetos MonitorVO.
        ArrayList<MonitorVO> listaClientes = new ArrayList<>();
        // Consulta SQL para seleccionar todos los registros de la tabla "cliente".
        String consulta = "SELECT * FROM monitores";
        try {
            // Obtiene una conexión a la base de datos.
            con = Conexion.getConexion();
            // Crea una declaración SQL.
            st = (Statement) con.createStatement();
            // Ejecuta la consulta y obtiene un conjunto de resultados.
            rs = st.executeQuery(consulta);
            // Recorre los resultados y crea objetos MonitorVO, agregándolos a la lista.
            while (rs.next()) {
                listaClientes.add(new MonitorVO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("fecha_de_nacimiento"),
                        rs.getString("correo")
                ));
            }
            // Cierra la declaración y desconecta de la base de datos.
            st.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error, mostrando un mensaje en la interfaz.
            e.printStackTrace();
            vista.error("Ocurrió un error inesperado en la consulta con la Base de Datos");
        }
        // Retorna la lista de clientes obtenida de la base de datos.
        return listaClientes;
    }

    // Método para actualizar datos de un cliente en la base de datos.
    public void actualizarDatos(MonitorVO objMonitor) {
        // Consulta de actualización con PreparedStatement
        String modificacion = "UPDATE `monitores` SET `id`=?, `nombre`=?, `telefono`=?, `direccion`=?, `fecha_de_nacimiento`=? , `correo`=? WHERE `Id`=?";
        try {
            // Obtiene una conexión a la base de datos
            con = Conexion.getConexion();
            // Crea una consulta preparada
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(modificacion);
            // Establece los parámetros de la consulta
            pst.setInt(1, objMonitor.getId());
            pst.setString(2, objMonitor.getNombre());
            pst.setString(3, objMonitor.getTelefono());
            pst.setString(4, objMonitor.getDireccion());
            pst.setString(5, objMonitor.getFechadeNacimiento());
            pst.setString(6, objMonitor.getCorreo());
            pst.setInt(7, objMonitor.getId());// Este último ? es para el WHERE
            // Ejecuta la consulta de actualización
            pst.executeUpdate();
            // Cierra la declaración y desconecta de la base de datos
            pst.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            // Imprime la traza de la excepción en caso de error
            ex.printStackTrace();
            // Manejo de excepciones en caso de error, mostrando un mensaje en la interfaz.
            this.vista.errorConsola("NO MODIFICADO");
        }
    }

    public void insertarDatos(MonitorVO objMonitor) {
        try {
            // Obtiene una conexión a la base de datos
            con = Conexion.getConexion();
            // Consulta de inserción con PreparedStatement
            String insercion = "INSERT INTO monitores VALUES (?, ?, ?, ?, ?, ?)";
            // Crea una consulta preparada
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(insercion);

            // Establece los parámetros de la consulta
            pst.setInt(1, objMonitor.getId());
            pst.setString(2, objMonitor.getNombre());
            pst.setString(3, objMonitor.getTelefono());
            pst.setString(4, objMonitor.getFechadeNacimiento());
            pst.setString(5, objMonitor.getDireccion());
            pst.setString(6, objMonitor.getCorreo());

            // Ejecuta la consulta de inserción
            pst.executeUpdate();

            // Cierra la declaración y desconecta de la base de datos
            pst.close();
            Conexion.desconectar();

        } catch (SQLException ex) {
            // Manejo de excepciones en caso de error
            ex.printStackTrace();
            vista.errorConsola("HUBO UN ERROR DURANTE LA INSERCION");
        }
    }

    public void eliminarProveedor(int id) {
        String consulta = "DELETE FROM monitores where id='" + id + "'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            this.vista.error("NO ELIMINADO");
        }
    }

    // Método para cargar datos desde la base de datos y construir un DefaultTableModel para una tabla Swing.
    public DefaultTableModel cargarDatosTabla() {
        try {
            // Consulta SQL para obtener los datos de la tabla cliente.
            String consulta = "SELECT * FROM monitores";
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            // Crear un modelo de tabla para contener los datos.
            DefaultTableModel modelo = new DefaultTableModel();
            // Obtener los nombres de las columnas de metadatos y agregarlos al modelo.
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                modelo.addColumn(rs.getMetaData().getColumnName(i));
            }
            // Rellenar el modelo de tabla con los datos obtenidos de la base de datos.
            while (rs.next()) {
                Object[] fila = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelo.addRow(fila);
            }
            // Agregar una fila adicional al principio con los nombres de las columnas.
            Object[] nombresColumnas = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                nombresColumnas[i - 1] = modelo.getColumnName(i - 1);
            }
            modelo.insertRow(0, nombresColumnas);
            // Devolver el modelo de tabla creado.
            return modelo;

        } catch (SQLException e) {
            // Imprime la traza de la excepción en caso de error.
            e.printStackTrace();
        }
        // En caso de error, retorna null.
        return null;
    }
}
