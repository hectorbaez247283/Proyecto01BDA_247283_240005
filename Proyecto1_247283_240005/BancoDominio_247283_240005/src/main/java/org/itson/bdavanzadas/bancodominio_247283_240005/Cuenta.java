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

    private int id, numeroCuenta;
    private String fechaApertura;
    private float saldoPesosMx;
    private String estado;
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(int id, int numeroCuenta, String fechaApertura, float saldoPesosMx, String estado, Cliente cliente) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldoPesosMx = saldoPesosMx;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Cuenta(int numeroCuenta, String fechaApertura, float saldoPesosMx, String estado, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldoPesosMx = saldoPesosMx;
        this.estado = estado;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public float getSaldoPesosMx() {
        return saldoPesosMx;
    }

    public void setSaldoPesosMx(float saldoPesosMx) {
        this.saldoPesosMx = saldoPesosMx;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", numeroCuenta=" + numeroCuenta + ", fechaApertura=" + fechaApertura + ", saldoPesosMx=" + saldoPesosMx + ", estado=" + estado + ", cliente=" + cliente + '}';
    }

}
