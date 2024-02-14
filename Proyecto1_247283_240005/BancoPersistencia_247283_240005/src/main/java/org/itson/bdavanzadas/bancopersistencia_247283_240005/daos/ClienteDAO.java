/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import java.sql.*;
import java.util.List;
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
        String sentenciaSQL = "INSERT INTO Cliente (nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento"
                + "edad,idDomicilio) VALUES (?,?,?,?,?,?)";

        try (Connection conexion = this.conexion.crearConexion(); preparedStatement ) {

        } catch (Exception e) {
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
