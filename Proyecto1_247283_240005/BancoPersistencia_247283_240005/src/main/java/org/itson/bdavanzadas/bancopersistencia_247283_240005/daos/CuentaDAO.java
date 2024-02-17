/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import java.sql.*;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cliente;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cuenta;
import org.itson.bdavanzadas.bancodominio_247283_240005.Domicilio;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.CuentaDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.persistenciaException;

/**
 *
 * @author Chris
 */
public class CuentaDAO implements ICuenta {

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public CuentaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarCuenta(Cuenta cuenta) throws persistenciaException {
        String sentenciaSQL = "INSERT INTO Cuentas (numeroCuenta, fechaApertura, saldoPesosMx, estado, idCliente) VALUES (?, ?, ?, ?, ?)";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            // Establecer los parámetros en la consulta
            comandoSQL.setInt(1, cuenta.getNumeroCuenta());
            comandoSQL.setDate(2, new java.sql.Date(cuenta.getFechaApertura().getTime()));
            comandoSQL.setFloat(3, cuenta.getSaldoPesosMx());
            comandoSQL.setString(4, cuenta.getEstado());
            comandoSQL.setInt(5, cuenta.getCliente().getId());

            // Ejecutar la consulta
            int resultado = comandoSQL.executeUpdate();

            // Verificar el resultado de la ejecución
            if (resultado == 1) {
                // La cuenta se ha agregado correctamente

                // Obtener el ID generado (si es necesario)
                try ( ResultSet generatedKeys = comandoSQL.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idGenerado = generatedKeys.getInt(1);
                        cuenta.setId(idGenerado);
                    } else {
                        // Manejar el caso en el que no se pudo obtener el ID generado
                        throw new persistenciaException("No se pudo obtener el ID de la cuenta.");
                    }
                }

                // Puedes agregar lógica adicional aquí, si es necesario
            } else {
                // Manejar el caso en que no se haya agregado la cuenta
                throw new persistenciaException("No se pudo agregar la cuenta.");
            }

        } catch (SQLException e) {
            // Manejar la excepción adecuadamente
            throw new persistenciaException("Error al intentar agregar la cuenta", e);
        }
    }

}
