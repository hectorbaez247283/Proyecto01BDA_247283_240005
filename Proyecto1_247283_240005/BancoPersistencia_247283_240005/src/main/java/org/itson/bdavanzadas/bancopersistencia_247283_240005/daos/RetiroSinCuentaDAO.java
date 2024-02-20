/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import org.apache.commons.lang3.RandomStringUtils;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cuenta;
import org.itson.bdavanzadas.bancodominio_247283_240005.RetiroSinCuenta;
import org.itson.bdavanzadas.bancodominio_247283_240005.Transaccion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.Conexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.RetiroSinCuentaDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;

/**
 *
 * @author Chris
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuenta {

    final IConexion conexion;
    String cadenaConexion = "jdbc:mysql://localhost:3306/banco_247283_240005", usuario = "root", contra = "Avenged21@";
    IConexion c = new Conexion(cadenaConexion, usuario, contra);
    CuentaDAO cDAO = new CuentaDAO(c);
    TransaccionDAO tDAO = new TransaccionDAO(c);

    public RetiroSinCuentaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void generarFolio(int numeroCuenta) throws PersistenciaException {
        Cuenta cuenta = cDAO.obtenerCuenta(numeroCuenta);

        if (cuenta != null) {
            int folio = generarFolioAleatorio();
            String contraseña = generarContraseñaAleatoria();
            String estado = "En proceso";

            Transaccion transaccion = new Transaccion();
            transaccion.setMonto(0);
            transaccion.setFechaRealizada(new Date());
            transaccion.setCuenta(cuenta);

            // Inserta la transacción en la base de datos
            tDAO.insertarTransaccion(transaccion);

            // Asegúrate de que el ID de la transacción se haya generado correctamente
            if (transaccion.getId() > 0) {
                RetiroSinCuentaDTO retiroSinCuenta = new RetiroSinCuentaDTO();
                retiroSinCuenta.setFolio(folio);
                retiroSinCuenta.setContraseña(contraseña);
                retiroSinCuenta.setEstado(estado);
                retiroSinCuenta.setTransaccion(transaccion);

                // Inserta el retiro sin cuenta en la base de datos
                insertarRetiroSinCuenta(retiroSinCuenta);
            } else {
                // Maneja el caso en el que el ID de la transacción no se ha generado correctamente
                JOptionPane.showMessageDialog(null, "Error al generar el folio: No se pudo obtener el ID de la transacción.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            throw new PersistenciaException("La cuenta no existe");
        }
    }

    private int generarFolioAleatorio() {
        // Implementa la lógica para generar un folio aleatorio
        return (int) (Math.random() * 1000000);
    }

    private String generarContraseñaAleatoria() {
        // Genera una contraseña aleatoria de 8 dígitos
        return RandomStringUtils.randomNumeric(8);
    }

    public void insertarRetiroSinCuenta(RetiroSinCuentaDTO retiroSinCuenta) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Retiro_Sin_Cuenta (idTransaccion, folio, contraseña, estado) VALUES (?, ?, ?, ?)";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {

            int idTransaccion = retiroSinCuenta.getTransaccion().getId();
            // Establece los parámetros en la consulta
            comandoSQL.setLong(1, idTransaccion);
            comandoSQL.setInt(2, retiroSinCuenta.getFolio());
            comandoSQL.setString(3, retiroSinCuenta.getContraseña());
            comandoSQL.setString(4, retiroSinCuenta.getEstado());

            // Ejecuta la consulta
            comandoSQL.executeUpdate();

        } catch (SQLException e) {
            // Maneja la excepción adecuadamente
            throw new PersistenciaException("Error al intentar insertar el retiro sin cuenta", e);
        }
    }

    public void actualizarRetiroSinCuenta(RetiroSinCuentaDTO retiroSinCuenta) throws PersistenciaException {
        String sentenciaSQL = "UPDATE Retiro_Sin_Cuenta SET estado=? WHERE idTransaccion=?";

        try ( Connection conexion = this.conexion.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {

            // Establece los parámetros en la consulta
            comandoSQL.setString(1, retiroSinCuenta.getEstado());
            comandoSQL.setLong(2, retiroSinCuenta.getTransaccion().getId());

            // Ejecuta la consulta
            int resultado = comandoSQL.executeUpdate();

            // Verifica el resultado de la ejecución
            if (resultado != 1) {
                // Maneja el caso en que no se haya actualizado ninguna fila (ID de transacción no encontrado)
                throw new PersistenciaException("No se pudo encontrar el retiro sin cuenta para actualizar");
            }

        } catch (SQLException e) {
            // Maneja la excepción adecuadamente
            throw new PersistenciaException("Error al intentar actualizar el retiro sin cuenta", e);
        }
    }

    @Override
    public RetiroSinCuenta realizaRetiro(RetiroSinCuentaDTO rsc) throws PersistenciaException {

        return null;

    }

}
