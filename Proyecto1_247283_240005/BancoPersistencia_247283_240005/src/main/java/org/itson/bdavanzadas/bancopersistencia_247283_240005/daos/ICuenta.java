/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.daos;

import org.itson.bdavanzadas.bancodominio_247283_240005.Cuenta;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.dto.CuentaDTO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;

/**
 *
 * @author Chris
 */
public interface ICuenta {

    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException;

    public void agregarSaldo(int numeroCuenta, float saldo) throws PersistenciaException;
    
    public float obtenSaldo (int numeroCuenta)throws PersistenciaException;
    

}
