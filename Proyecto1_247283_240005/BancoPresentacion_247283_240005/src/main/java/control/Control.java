/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cliente;
import org.itson.bdavanzadas.bancodominio_247283_240005.Domicilio;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.Conexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.daos.ClienteDAO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.ClienteDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;
import org.itson.bdavanzadas.bancopresentacion_247283_240005.interfaz.FrmRegistroCliente;

/**
 *
 * @author Christopher
 * @author Francisco
 */
public class Control {

    private static final Logger LOG = Logger.getLogger(FrmRegistroCliente.class.getName());

    String cadenaConexion = "jdbc:mysql://localhost:3306/banco_247283_240005", usuario = "root", contra = "151204";
    IConexion c = new Conexion(cadenaConexion, usuario, contra);
    ClienteDAO cliDAO = new ClienteDAO(c);

    public static void setImageLabel(JFrame frame, JLabel labelName, String root) {
        ImageIcon img = new ImageIcon(root);
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        frame.repaint();
    }

    public static void soloLetras(KeyEvent e) {
        char c = e.getKeyChar();
        // Solo permite la entrada de letras con acentos (áéíóúüÁÉÍÓÚÜ)
        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= 'á' && c <= 'ü') || (c >= 'Á' && c <= 'Ü'))) {
            e.consume(); // Ignora el evento si no es una letra con acentos
            Toolkit.getDefaultToolkit().beep(); // Emite un sonido de advertencia
        }
    }

    public static void soloNumeros(KeyEvent e) {
        char c = e.getKeyChar();
        // Solo permite la entrada de números
        if (!((c >= '0' && c <= '9'))) {
            e.consume(); // Ignora el evento si no es un número 

            Toolkit.getDefaultToolkit().beep(); // Emite un sonido de advertencia
        }
    }

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
}
