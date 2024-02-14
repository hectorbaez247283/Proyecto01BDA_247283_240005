/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author lv1821
 */
public class Conexion implements IConexion {

    final String cadenaConexion;
    final String usuario;
    final String contra;
    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());

    public Conexion(String cadenaConexion, String usuario, String contra) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contra = contra;
    }

    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra);
        LOG.log(Level.INFO, "Conexion establecida", cadenaConexion);
        return conexion;
    }

}
