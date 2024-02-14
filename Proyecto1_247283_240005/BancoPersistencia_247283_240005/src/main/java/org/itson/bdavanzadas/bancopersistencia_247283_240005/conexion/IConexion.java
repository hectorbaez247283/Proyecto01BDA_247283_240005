/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion;

import java.sql.*;

/**
 *
 * @author lv1821
 */
public interface IConexion {
    public Connection crearConexion() throws SQLException;
}
