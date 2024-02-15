/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

/**
 *
 * @author lv1821
 */
public class RetiroSinCuenta {

    private int folio;
    private String contraseña;
    private Transaccion transaccion;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(int folio, String contraseña, Transaccion transaccion) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.transaccion = transaccion;
    }

}
