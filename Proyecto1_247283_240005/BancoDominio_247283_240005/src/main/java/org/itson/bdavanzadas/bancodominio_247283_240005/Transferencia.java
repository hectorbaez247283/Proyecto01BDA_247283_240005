/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

/**
 *
 * @author lv1821
 */
public class Transferencia {

    Transaccion transaccion;
    Cuenta cuenta;

    public Transferencia() {
    }

    public Transferencia(Cuenta cuenta, Transaccion transaccion) {
        this.cuenta = cuenta;
        this.transaccion = transaccion;
    }

}
