/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import org.itson.bdavanzadas.bancodominio_247283_240005.RetiroSinCuenta;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.RetiroSinCuentaDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;

/**
 *
 * @author Chris
 */
public interface IRetiroSinCuenta {

    public void generarFolio(int numeroCuenta) throws PersistenciaException;

    public RetiroSinCuenta realizaRetiro(RetiroSinCuentaDTO rsc) throws PersistenciaException;
}
