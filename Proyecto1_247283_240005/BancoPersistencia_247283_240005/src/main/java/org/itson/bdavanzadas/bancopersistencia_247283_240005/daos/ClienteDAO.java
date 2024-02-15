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
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.ClienteDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.persistenciaException;

/**
 *
 * @author lv1821
 */
public class ClienteDAO implements ICliente {

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws persistenciaException {
        String sentenciaSQL = "INSERT INTO Cliente (nombre,apellidoPaterno,apellidoMaterno,contraseña, fechaNacimiento"
                + "idDomicilio) VALUES (?,?,?,?,?,?)";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL,
                Statement.RETURN_GENERATED_KEYS);) {

            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getContraseña());
            comandoSQL.setDate(5, (Date) cliente.getFechaNacimiento());
            comandoSQL.setObject(6, cliente.getDomicilio());
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.SEVERE, "Se han agregado {0}", resultado);
            ResultSet res = comandoSQL.getGeneratedKeys();
            res.next();

            Cliente clienteSave = new Cliente(res.getInt(1), cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getContraseña(),
                    cliente.getFechaNacimiento(), cliente.getDomicilio());
            return clienteSave;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar", e);
            throw new persistenciaException("No se pudo agregar el cliente", e);
        }
    }

    @Override
    public Cliente actualizaCliente(ClienteDTO cliente) throws persistenciaException {

        return null;

    }

    @Override
    public Cliente eliminarCliente(ClienteDTO cliente) throws persistenciaException {

        return null;

    }

    @Override
    public List<Cliente> consultarTodos() throws persistenciaException {

        return null;

    }

}
