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

    private Transaccion transaccion;
    private int folio;
    private String contraseña, estado;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(Transaccion transaccion, int folio, String contraseña, String estado) {
        this.transaccion = transaccion;
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "transaccion=" + transaccion + ", folio=" + folio + ", contrase\u00f1a=" + contraseña + ", estado=" + estado + '}';
    }

}
