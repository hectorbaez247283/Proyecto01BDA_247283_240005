/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.dto;

import java.util.Date;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cuenta;

/**
 *
 * @author Chris
 */
public class TransaccionDTO {

    private float monto;
    private String fechaRealizada;
    private Cuenta cuenta;

    public TransaccionDTO() {
    }

    public TransaccionDTO(float monto, String fechaRealizada, Cuenta cuenta) {
        this.monto = monto;
        this.fechaRealizada = fechaRealizada;
        this.cuenta = cuenta;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(String fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
