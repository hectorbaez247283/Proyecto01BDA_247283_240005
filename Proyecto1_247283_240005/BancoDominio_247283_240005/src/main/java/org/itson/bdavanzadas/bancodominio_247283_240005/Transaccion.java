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
public class Transaccion {

    private int id;
    private float monto;
    private Date fechaRealizada;

    public Transaccion() {
    }

    public Transaccion(int id, float monto, Date fechaRealizada) {
        this.id = id;
        this.monto = monto;
        this.fechaRealizada = fechaRealizada;
    }

    public Transaccion(float monto, Date fechaRealizada) {
        this.monto = monto;
        this.fechaRealizada = fechaRealizada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", monto=" + monto + ", fechaRealizada=" + fechaRealizada + '}';
    }

}
