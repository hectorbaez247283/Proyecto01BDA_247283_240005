/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cliente;
import org.itson.bdavanzadas.bancodominio_247283_240005.Domicilio;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.Conexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.daos.ClienteDAO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.daos.CuentaDAO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.ClienteDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;
import org.itson.bdavanzadas.bancopresentacion_247283_240005.interfaz.FrmMenu;
import org.itson.bdavanzadas.bancopresentacion_247283_240005.interfaz.FrmRegistroCliente;

/**
 *
 * @author Christopher
 * @author Francisco
 */
public class Control {

    private static final Logger LOG = Logger.getLogger(FrmRegistroCliente.class.getName());

    /*
    Atributos de clase.
     */
    String cadenaConexion = "jdbc:mysql://localhost:3306/banco_247283_240005", usuario = "root", contra = "151204";
    IConexion c = new Conexion(cadenaConexion, usuario, contra);
    ClienteDAO cliDAO = new ClienteDAO(c);
    CuentaDAO cDAO = new CuentaDAO(c);

    private static Cliente clienteActivo;

    /**
     * Asigna una imagen a una etiqueta y la escala al tamaño asignado para la
     * misma.
     *
     * @param frame Frame donde se encuentra el label.
     * @param labelName Etiqueta sobre la que se va a trabajar.
     * @param root Raíz donde se encuentra localizada la imagen.
     */
    public static void setImageLabel(JFrame frame, JLabel labelName, String root) {
        ImageIcon img = new ImageIcon(root);
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        frame.repaint();
    }

    /**
     * Limita las opciones del campo de texto a solo teclear letras.
     *
     * @param e Evento de teclas necesario.
     */
    public static void soloLetras(KeyEvent e) {
        char c = e.getKeyChar();
        // Solo permite la entrada de letras con acentos (áéíóúüÁÉÍÓÚÜ)
        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= 'á' && c <= 'ü') || (c >= 'Á' && c <= 'Ü'))) {
            e.consume(); // Ignora el evento si no es una letra con acentos
            Toolkit.getDefaultToolkit().beep(); // Emite un sonido de advertencia
        }
    }

    /**
     * Limita las opciones del campo de texto a solo teclear números.
     *
     * @param e Evento de teclas necesario.
     */
    public static void soloNumeros(KeyEvent e) {
        char c = e.getKeyChar();
        // Solo permite la entrada de números
        if (!((c >= '0' && c <= '9'))) {
            e.consume(); // Ignora el evento si no es un número 

            Toolkit.getDefaultToolkit().beep(); // Emite un sonido de advertencia
        }
    }

    /**
     * Limita los caracteres máximos permitidos en un campo de texto.
     *
     * @param e Evento de teclas necesario.
     * @param maxLength Longitud máxima del campo.
     * @param txt Campo de texto a trabajar.
     */
    public static void caracteresMaximos(KeyEvent e, int maxLength, JTextField txt) {
        char c = e.getKeyChar();

        // Solo permite la entrada si no se excede el límite de caracteres
        if (txt.getText().length() >= maxLength) {
            e.consume(); // Ignora el evento si se excede el límite
            Toolkit.getDefaultToolkit().beep(); // Emite un sonido de advertencia
        }
    }

    /**
     * Convierte la fecha seleccionada por un JDateChooser en una cadena con el
     * formato de fecha "yyyy-MM-dd".
     *
     * @param jdc Selector de fecha a utilizar.
     * @return Fecha formateada específica.
     */
    public String formatoFecha(JDateChooser jdc) {
        Date fechaSel = jdc.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = sdf.format(fechaSel);
        return fechaFormateada;
    }

    /**
     * Designa las opciones para el combobox de las cuentas del cliente.
     *
     * @param combo ComboBox donde se desplegarán las opciones.
     * @param cliente Cliente del cual se buscarán cuentas.
     */
    public void opcionesComboBox(JComboBox combo, Cliente cliente) {
        combo.setModel(new CuentasComboBoxModel(cliente));
    }

    /**
     * Registra un cliente en la base de datos, con las características dadas en
     * el parámetro. Si el cliente no se pudo registrar, se lanza
     * PersistenciaException.
     *
     * @param frame Frame sobre el que se trabaja.
     * @param nombre Nombre(s) del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param contrasenia Contraseña de la cuenta del cliente.
     * @param telefono Teléfono de contacto del cliente.
     * @param calle Calle de residencia del cliente.
     * @param colonia Colonia de residencia del cliente.
     * @param numExterior Número de residencia del cliente.
     * @return True si el cliente pudo registrarse.
     * @throws PersistenciaException Si existe un fallo con la capa de
     * persistencia.
     */
    public boolean registrarCliente(JFrame frame, String nombre, String apellidoPaterno,
            String apellidoMaterno, String fechaNacimiento, String contrasenia,
            String telefono, String calle, String colonia, String numExterior)
            throws PersistenciaException {
        try {
            Domicilio newD = new Domicilio(calle, colonia, numExterior);

            ClienteDTO newC = new ClienteDTO(nombre, apellidoPaterno, apellidoMaterno, contrasenia, telefono, fechaNacimiento, newD);

            try {
                Cliente cliSave = cliDAO.agregarCliente(newC);
                LOG.log(Level.INFO, cliSave.toString());
                JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.", "Registrar cliente", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "No se pudo agregar cliente: ", e);
                JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente: Uno o más datos no son válidos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return true;
        } catch (Exception e) {
        }
        return false;
    }

//    public Cliente iniciarSesion(String telefono, String contraseña) {
//        try {
//            cliDAO.iniciarSesion(telefono, contraseña);
//
//            if (cliDAO.isInicioSesionExitoso()) {
//                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
//                clienteActivo = cliDAO.iniciarSesion(telefono, contraseña);
//                return cliDAO.iniciarSesion(telefono, contraseña);
//            } else {
//                JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Verifica tus credenciales.");
//            }
//
//        } catch (PersistenciaException e) {
//            JOptionPane.showMessageDialog(null, "Error al intentar iniciar sesión: " + e.getMessage());
//        }
//        return null;
//    }
    
    /**
     * Muestra el saldo de la cuenta seleccionada en el combobox utilizando el
     * método setText de la etiqueta dada en el parámetro.
     *
     * @param comboBox Combobox donde se seleccionará la cuenta.
     * @param label Label donde se reflejará el saldo.
     */
    public void mostrarSaldo(JComboBox comboBox, JLabel label) {
        String numeroCuentaSeleccionado = (String) comboBox.getSelectedItem();

        // Verificar si el número de cuenta seleccionado no es nulo
        if (numeroCuentaSeleccionado != null) {
            // Realizar la consulta a la base de datos para obtener el saldo
            try ( Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra)) {
                String sql = "SELECT saldo FROM Cuentas WHERE numeroCuenta = ?";
                try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
                    statement.setString(1, numeroCuentaSeleccionado);

                    try ( ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            double saldo = resultSet.getDouble("saldo");
                            label.setText("$" + saldo);
                            // Puedes hacer lo que necesites con el saldo (por ejemplo, mostrarlo en una etiqueta)
                        } else {
                            System.out.println("No se encontró información para la cuenta " + numeroCuentaSeleccionado);
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Manejar la excepción según sea necesario
            }
        }
    }

    /**
     * Agrega saldo a la cuenta de un cliente.
     *
     * @param numeroCuenta Número de cuenta asociado.
     * @param monto Monto a añadir.
     */
    public void agregarSaldo(String numeroCuenta, String monto) {
        // Obtiene el ID de la cuenta y el monto de saldo desde tus campos de texto u otros componentes
        int cuentaNum = Integer.parseInt(numeroCuenta);
        float montoSaldo = Float.parseFloat(monto);

        try {
            // Llama al método en tu DAO para agregar el saldo
            cDAO.agregarSaldo(cuentaNum, montoSaldo);

            // Muestra un mensaje de éxito o realiza otras acciones según sea necesario
            JOptionPane.showMessageDialog(null, "Saldo agregado correctamente.");

        } catch (PersistenciaException ex) {
            // Maneja la excepción de persistencia (puedes mostrar un mensaje de error, por ejemplo)
            JOptionPane.showMessageDialog(null, "Error al agregar saldo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Cancela la cuenta dada por el combobox dado en el parámetro.
     *
     * @param numCuenta Combobox donde se va a obtener la cuenta a cancelar.
     */
    public void cancelarCuenta(String numCuenta) {

        // Verificar si el número de cuenta seleccionado no es nulo
        if (numCuenta != null) {
            // Realizar la actualización en la base de datos para cambiar el estado de la cuenta
            try ( Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra)) {
                String sql = "UPDATE Cuentas SET estado = 'cancelada' WHERE numeroCuenta = ?";
                try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
                    statement.setString(1, numCuenta);
                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "La cuenta " + numCuenta + " ha sido cancelada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo cancelar la cuenta " + numCuenta);
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Manejar la excepción según sea necesario
            }
        }
    }

    /**
     * Obtiene el cliente guardado en el contexto de iniciar sesión.
     *
     * @return Cliente con sesión activa.
     */
    public static Cliente getCliente() {
        return clienteActivo;
    }

    /**
     * Asigna el cliente con sesión activa con el Cliente dado en el parámetro.
     *
     * @param cliente Cliente con sesión activa.
     */
    public static void setCliente(Cliente cliente) {
        Control.clienteActivo = cliente;
    }

    /**
     * Limpia la variable que guarda el contexto del cliente activo.
     */
    public static void limpiarSesion() {
        clienteActivo = null;
    }
}
