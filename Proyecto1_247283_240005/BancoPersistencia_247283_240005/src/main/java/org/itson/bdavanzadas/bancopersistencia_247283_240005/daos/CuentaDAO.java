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
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.Conexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.CuentaDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;

/**
 *
 * @author Chris
 */
public class CuentaDAO implements ICuenta {

    final IConexion conexion;
    String cadenaConexion = "jdbc:mysql://localhost:3306/banco_247283_240005", usuario = "root", contra = "Avenged21@";
    IConexion c = new Conexion(cadenaConexion, usuario, contra);
    ClienteDAO cDAO = new ClienteDAO(c);

    public CuentaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cuenta agregarCuenta(CuentaDTO cuentaDTO) throws PersistenciaException {
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
                        throw new PersistenciaException("No se pudo obtener el ID de la cuenta.");
                    }
                }

            } else {
                throw new PersistenciaException("No se pudo agregar la cuenta.");
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al intentar agregar la cuenta", e);
        }
    }

    @Override
    public void agregarSaldo(int numeroCuenta, float saldo) throws PersistenciaException {
        String sql = "UPDATE Cuentas SET saldoPesosMx = saldoPesosMx + ? WHERE numeroCuenta = ?";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sql)) {

            comandoSQL.setFloat(1, saldo);
            comandoSQL.setInt(2, numeroCuenta);

            int resultado = comandoSQL.executeUpdate();

            if (resultado != 1) {
                throw new PersistenciaException("No se pudo agregar saldo a la cuenta.");
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al intentar agregar saldo a la cuenta", e);
        }
    }

    @Override
    public float obtenSaldo(int numeroCuenta) throws PersistenciaException {
        String sentenciaSQL = "SELECT saldoPesosMx FROM Cuentas WHERE numeroCuenta = ?";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {

            comandoSQL.setInt(1, numeroCuenta);

            try ( ResultSet resultado = comandoSQL.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getFloat("saldoPesosMx");
                } else {
                    throw new PersistenciaException("No se encontró la cuenta con el número especificado.");
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener el saldo por número de cuenta", e);
        }
    }

    private int generarNumeroCuentaAleatorio() {

        return 100000 + new Random().nextInt(900000);
    }

    @Override
    public Cuenta obtenerCuenta(int numeroCuenta) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Cuentas WHERE numeroCuenta = ?";
        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {

            comandoSQL.setInt(1, numeroCuenta);

            try ( ResultSet resultado = comandoSQL.executeQuery()) {
                if (resultado.next()) {
                    Cuenta cuenta = new Cuenta();
                    cuenta.setId(resultado.getInt("idCuenta"));
                    cuenta.setNumeroCuenta(resultado.getInt("numeroCuenta"));
                    cuenta.setFechaApertura(resultado.getString("fechaApertura"));
                    cuenta.setSaldoPesosMx(resultado.getFloat("saldoPesosMx"));
                    cuenta.setEstado(resultado.getString("estado"));

                    cuenta.setCliente(cDAO.buscarCliente(resultado.getInt("idCliente")));
                    return cuenta;
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la cuenta por número: " + e.getMessage(), e);
        }

        // Si no se encuentra ninguna cuenta con ese número, devuelve null
        return null;
    }
}
