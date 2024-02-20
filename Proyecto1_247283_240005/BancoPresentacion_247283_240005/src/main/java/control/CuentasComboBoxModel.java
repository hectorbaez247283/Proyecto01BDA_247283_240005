/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cliente;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cuenta;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.Conexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.daos.ClienteDAO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.ClienteDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.CuentaDTO;

/**
 *
 * @author Francisco
 * @author Christopher
 */
public class CuentasComboBoxModel extends DefaultComboBoxModel<String> {

    /**
     * Atributos de clase.
     */
    String cadenaConexion = "jdbc:mysql://localhost:3306/banco_247283_240005", usuario = "root", contra = "151204";
    IConexion c = new Conexion(cadenaConexion, usuario, contra);

    /**
     * Construye un objeto de tipo Opciones. Inserta las opciones posibles del
     * combobox.
     */
    public CuentasComboBoxModel(Cliente cliente) {
        // Obtener las cuentas asociadas al cliente desde la base de datos
        List<String> cuentasDelCliente = obtenerCuentasDelCliente(cliente);

        // Agregar las cuentas al modelo
        for (String numeroCuenta : cuentasDelCliente) {
            addElement(numeroCuenta);
        }
    }

    /**
     * Lista todas las cuentas vinculadas al cliente y obtiene solo el número de cuenta.
     * @param cliente Cliente del que se van a listar cuentas.
     * @return Lista con el número de cuenta de todas las cuentas del cliente.
     */
    private List<String> obtenerCuentasDelCliente(Cliente cliente) {
        List<String> cuentas = new ArrayList<>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra)) {
            String consulta = "SELECT numeroCuenta FROM Cuentas WHERE idCliente = ?";

            try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
                preparedStatement.setInt(1, cliente.getId());

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String numeroCuenta = resultSet.getString("numeroCuenta");
                        cuentas.add(numeroCuenta);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cuentas;
    }
}
