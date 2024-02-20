/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import java.util.List;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cliente;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.ClienteDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;

/**
 *
 * @author lv1821
 */
public interface ICliente {

    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException;

    public Cliente iniciarSesion(String telefono, String contraseña) throws PersistenciaException;

    public void actualizaCliente(Cliente cliente) throws PersistenciaException;

    public Cliente eliminarCliente(ClienteDTO cliente) throws PersistenciaException;
    
    public Cliente buscarCliente (int id) throws PersistenciaException;

    public List<Cliente> consultarTodos() throws PersistenciaException;
}
