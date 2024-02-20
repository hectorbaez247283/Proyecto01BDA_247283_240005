/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.itson.bdavanzadas.bancodominio_247283_240005.Transaccion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.TransaccionDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;

/**
 *
 * @author Chris
 */
public class TransaccionDAO {

    final IConexion conexion;

    public TransaccionDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public void insertarTransaccion(Transaccion transaccion) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Transacciones (monto, fechaRealizada, idCuenta) VALUES (?, ?, ?)";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            // Establece los parámetros en la consulta
            comandoSQL.setFloat(1, transaccion.getMonto());

            // Convierte el String a un objeto java.sql.Timestamp
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date parsedDate = transaccion.getFechaRealizada();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            comandoSQL.setTimestamp(2, timestamp);

            comandoSQL.setInt(3, transaccion.getCuenta().getId());

            // Ejecuta la consulta
            int resultado = comandoSQL.executeUpdate();

            // Verifica el resultado de la ejecución
            if (resultado == 1) {
                // La transacción se ha insertado correctamente

                // Obtén el ID generado (si es necesario)
                try ( ResultSet generatedKeys = comandoSQL.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idGenerado = generatedKeys.getInt(1);
                        transaccion.setId(idGenerado);
                    } else {
                        // Maneja el caso en el que no se pudo obtener el ID generado
                        throw new PersistenciaException("No se pudo obtener el ID de la transacción.");
                    }
                }

                // Puedes agregar lógica adicional aquí, si es necesario
            } else {
                // Maneja el caso en que no se haya insertado la transacción
                throw new PersistenciaException("No se pudo insertar la transacción.");
            }

        } catch (SQLException e) {
            // Maneja la excepción adecuadamente
            throw new PersistenciaException("Error al intentar insertar la transacción", e);
        }
    }

    public boolean existeTransaccion(int idTransaccion) {
        String sentenciaSQL = "SELECT COUNT(*) FROM Transacciones WHERE idTransaccion = ?";
        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {

            comandoSQL.setInt(1, idTransaccion);
            ResultSet resultado = comandoSQL.executeQuery();

            if (resultado.next()) {
                int count = resultado.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            // Manejar la excepción adecuadamente
            e.printStackTrace(); // O puedes lanzar una excepción personalizada
        }
        return false;
    }

}
