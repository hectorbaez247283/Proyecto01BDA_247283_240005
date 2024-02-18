/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cliente;
import org.itson.bdavanzadas.bancodominio_247283_240005.Domicilio;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.ClienteDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.persistenciaException;

/**
 *
 * @author lv1821
 */
public class ClienteDAO implements ICliente {

    private boolean inicioSesionExitoso = false;

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws persistenciaException {
        String sentenciaSQLDomicilio = "INSERT INTO Domicilios (calle, colonia, numeroExterior) VALUES (?, ?, ?)";
        String sentenciaSQLCliente = "INSERT INTO Clientes (nombre, apellidoPaterno, apellidoMaterno, contraseña, telefono, fechaNacimiento, idDomicilio) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQLDomicilio = conexion.prepareStatement(sentenciaSQLDomicilio, Statement.RETURN_GENERATED_KEYS);  PreparedStatement comandoSQLCliente = conexion.prepareStatement(sentenciaSQLCliente, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQLDomicilio.setString(1, cliente.getDomicilio().getCalle());
            comandoSQLDomicilio.setString(2, cliente.getDomicilio().getColonia());
            comandoSQLDomicilio.setString(3, cliente.getDomicilio().getNumeroExterior());

            int resultadoDomicilio = comandoSQLDomicilio.executeUpdate();

            if (resultadoDomicilio == 0) {
                throw new persistenciaException("No se pudo insertar el domicilio");
            }

            ResultSet resDomicilio = comandoSQLDomicilio.getGeneratedKeys();
            resDomicilio.next();
            int idDomicilio = resDomicilio.getInt(1);

            comandoSQLCliente.setString(1, cliente.getNombre());
            comandoSQLCliente.setString(2, cliente.getApellidoPaterno());
            comandoSQLCliente.setString(3, cliente.getApellidoMaterno());
            comandoSQLCliente.setString(4, cliente.getContraseña());
            comandoSQLCliente.setString(5, cliente.getTelefono());
            comandoSQLCliente.setString(6, cliente.getFechaNacimiento());
            comandoSQLCliente.setInt(7, idDomicilio);

            int resultadoCliente = comandoSQLCliente.executeUpdate();

            LOG.log(Level.SEVERE, "Se ha agregado {0} cliente", resultadoCliente);

            ResultSet resCliente = comandoSQLCliente.getGeneratedKeys();
            resCliente.next();

            Cliente clienteSave = new Cliente(resCliente.getInt(1), cliente.getNombre(), cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(), cliente.getContraseña(), cliente.getTelefono(), cliente.getFechaNacimiento(),
                    cliente.getDomicilio());

            return clienteSave;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar", e);
            throw new persistenciaException("No se pudo agregar el cliente", e);
        }
    }

    @Override
    public void iniciarSesion(String telefono, String contraseña) throws persistenciaException {
        String sql = "SELECT * FROM Clientes WHERE telefono = ? AND contraseña = ?";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sql)) {

            // Establecer los parámetros en la consulta
            comandoSQL.setString(1, telefono);
            comandoSQL.setString(2, contraseña);

            // Ejecutar la consulta
            try ( ResultSet resultado = comandoSQL.executeQuery()) {
                if (resultado.next()) {
                    // Se encontró un cliente con las credenciales proporcionadas
                    inicioSesionExitoso = true;
                } else {
                    // No se encontró un cliente con esas credenciales
                    inicioSesionExitoso = false;
                }
            }

        } catch (SQLException e) {
            // Manejar la excepción adecuadamente
            throw new persistenciaException("Error al intentar iniciar sesión", e);
        }
    }

    public boolean isInicioSesionExitoso() {
        return inicioSesionExitoso;
    }

    @Override
    public void actualizaCliente(ClienteDTO cliente) throws persistenciaException {
        String sentenciaSQLDomicilio = "UPDATE Domicilios SET calle=?, colonia=?, numeroExterior=? WHERE idDomicilio=?";
        String sentenciaSQLCliente = "UPDATE Clientes SET nombre=?, apellidoPaterno=?, apellidoMaterno=?, telefono=? WHERE idCliente=?";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQLDomicilio = conexion.prepareStatement(sentenciaSQLDomicilio);  PreparedStatement comandoSQLCliente = conexion.prepareStatement(sentenciaSQLCliente)) {

            // Establecer los parámetros en la consulta del Domicilio
            comandoSQLDomicilio.setString(1, cliente.getDomicilio().getCalle());
            comandoSQLDomicilio.setString(2, cliente.getDomicilio().getColonia());
            comandoSQLDomicilio.setString(3, cliente.getDomicilio().getNumeroExterior());

            // Ejecutar la consulta del Domicilio
            int resultadoDomicilio = comandoSQLDomicilio.executeUpdate();

            // Verificar el resultado de la ejecución del Domicilio
            if (resultadoDomicilio != 1) {
                // Manejar el caso en que no se haya actualizado el Domicilio
                throw new persistenciaException("No se pudo actualizar el Domicilio.");
            }

            // Establecer los parámetros en la consulta del Cliente
            comandoSQLCliente.setString(1, cliente.getNombre());
            comandoSQLCliente.setString(2, cliente.getApellidoPaterno());
            comandoSQLCliente.setString(3, cliente.getApellidoMaterno());
            comandoSQLCliente.setString(4, cliente.getTelefono());

            // Ejecutar la consulta del Cliente
            int resultadoCliente = comandoSQLCliente.executeUpdate();

            // Verificar el resultado de la ejecución del Cliente
            if (resultadoCliente != 1) {
                // Manejar el caso en que no se haya actualizado el Cliente
                throw new persistenciaException("No se pudo actualizar el Cliente.");
            }

        } catch (SQLException e) {
            // Manejar la excepción adecuadamente
            throw new persistenciaException("Error al intentar actualizar el cliente", e);
        }
    }

    @Override
    public Cliente eliminarCliente(ClienteDTO cliente) throws persistenciaException {

        return null;

    }

    @Override
    public ClienteDTO buscarCliente(int id) throws persistenciaException {
        String sentenciaSQL = "SELECT * FROM Clientes WHERE idCliente = ?";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {

            // Establecer el parámetro en la consulta
            comandoSQL.setInt(1, id);

            // Ejecutar la consulta
            try ( ResultSet resultado = comandoSQL.executeQuery()) {
                if (resultado.next()) {
                    // Se encontró un cliente con el ID proporcionado
                    return construirClienteDesdeResultSet(resultado);
                } else {
                    // No se encontró un cliente con ese ID
                    throw new persistenciaException("No se encontró un cliente con el ID proporcionado.");
                }
            }

        } catch (SQLException e) {
            // Manejar la excepción adecuadamente
            throw new persistenciaException("Error al intentar buscar el cliente", e);
        }
    }

// Método auxiliar para construir un objeto ClienteDTO desde un ResultSet
    private ClienteDTO construirClienteDesdeResultSet(ResultSet resultado) throws SQLException {
        Domicilio domicilio = construirDomicilioDesdeResultSet(resultado);

        return new ClienteDTO(
                resultado.getString("nombre"),
                resultado.getString("apellidoPaterno"),
                resultado.getString("apellidoMaterno"),
                resultado.getString("telefono"),
                resultado.getString("fechaNacimiento"),
                domicilio
        );
    }

// Método auxiliar para construir un objeto DomicilioDTO desde un ResultSet
    private Domicilio construirDomicilioDesdeResultSet(ResultSet resultado) throws SQLException {
        return new Domicilio(
                resultado.getInt("idDomicilio"),
                resultado.getString("calle"),
                resultado.getString("colonia"),
                resultado.getString("numeroExterior")
        );
    }

    @Override
    public List<Cliente> consultarTodos() throws persistenciaException {

        return null;

    }

}
