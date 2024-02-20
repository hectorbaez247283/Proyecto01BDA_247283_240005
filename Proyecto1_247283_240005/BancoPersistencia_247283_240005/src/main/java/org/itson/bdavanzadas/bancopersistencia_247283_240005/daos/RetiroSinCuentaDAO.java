/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;

/**
 *
 * @author Chris
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuenta {

    final IConexion conexion;

    public RetiroSinCuentaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void generarFolio(int numeroCuenta) throws PersistenciaException {

    }

}
