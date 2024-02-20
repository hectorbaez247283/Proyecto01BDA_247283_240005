/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.dto;

import org.itson.bdavanzadas.bancodominio_247283_240005.Transaccion;

/**
 *
 * @author Chris
 */
public class RetiroSinCuentaDTO {

    private Transaccion transaccion;
    private int folio;
    private String contraseña, estado;

    public RetiroSinCuentaDTO() {
    }

    public RetiroSinCuentaDTO(int folio, String contraseña, String estado) {
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

}
