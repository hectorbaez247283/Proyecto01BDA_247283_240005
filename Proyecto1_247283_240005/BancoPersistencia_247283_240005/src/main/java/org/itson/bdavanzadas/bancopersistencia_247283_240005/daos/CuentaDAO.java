/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import java.sql.*;
import java.time.LocalDate;
import java.util.Random;
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
    public Cuenta agregarCuenta(CuentaDTO cuentaDTO) throws persistenciaException {
        String sentenciaSQL = "INSERT INTO Cuentas (numeroCuenta, fechaApertura, saldoPesosMx, estado, idCliente) VALUES (?, ?, ?, ?, ?)";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            int numeroCuentaAleatorio = generarNumeroCuentaAleatorio();

            LocalDate fechaActual = LocalDate.now();
            String fechaApertura = fechaActual.toString();

            // Establecer los parámetros en la consulta
            comandoSQL.setInt(1, numeroCuentaAleatorio);
            comandoSQL.setString(2, fechaApertura);
            comandoSQL.setFloat(3, 0);
            comandoSQL.setString(4, "Activa");
            comandoSQL.setInt(5, cuentaDTO.getCliente().getId());

            // Ejecutar la consulta
            int resultado = comandoSQL.executeUpdate();

            if (resultado == 1) {

                try ( ResultSet generatedKeys = comandoSQL.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idGenerado = generatedKeys.getInt(1);

                        // Construir y devolver un objeto Cuenta con el ID generado
                        return new Cuenta(idGenerado, numeroCuentaAleatorio, fechaApertura, 0, "Activa", cuentaDTO.getCliente());
                    } else {
                        throw new persistenciaException("No se pudo obtener el ID de la cuenta.");
                    }
                }

            } else {
                throw new persistenciaException("No se pudo agregar la cuenta.");
            }

        } catch (SQLException e) {
            throw new persistenciaException("Error al intentar agregar la cuenta", e);
        }
    }

// Método para generar un número de cuenta aleatorio (puedes ajustar la lógica según tus necesidades)
    private int generarNumeroCuentaAleatorio() {
        // Aquí puedes implementar la lógica para generar un número de cuenta aleatorio
        // Puedes utilizar, por ejemplo, la clase Random o cualquier otra lógica que prefieras
        return 100000 + new Random().nextInt(900000); // Ejemplo: Números de cuenta de 6 dígitos
    }

}
