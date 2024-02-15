/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

import java.util.Date;

/**
 *
 * @author lv1821
 */
public class Cuenta {

    private int numeroCuenta;
    private String contraseña;
    private float saldoPesosMx;
    private Date fechaApertura;
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(int numeroCuenta, String contraseña, float saldoPesosMx, Date fechaApertura, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.contraseña = contraseña;
        this.saldoPesosMx = saldoPesosMx;
        this.fechaApertura = fechaApertura;
        this.cliente = cliente;
    }

    public Cuenta(String contraseña, float saldoPesosMx, Date fechaApertura, Cliente cliente) {
        this.contraseña = contraseña;
        this.saldoPesosMx = saldoPesosMx;
        this.fechaApertura = fechaApertura;
        this.cliente = cliente;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public float getSaldoPesosMx() {
        return saldoPesosMx;
    }

    public void setSaldoPesosMx(float saldoPesosMx) {
        this.saldoPesosMx = saldoPesosMx;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", contrase\u00f1a=" + contraseña + ", saldoPesosMx=" + saldoPesosMx + ", fechaApertura=" + fechaApertura + '}';
    }

}
