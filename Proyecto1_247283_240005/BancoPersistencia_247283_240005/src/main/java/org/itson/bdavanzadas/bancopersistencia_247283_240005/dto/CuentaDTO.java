/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.dto;

import java.util.Objects;
import org.itson.bdavanzadas.bancodominio_247283_240005.Cliente;

/**
 *
 * @author Chris
 */
public class CuentaDTO {

    private int numeroCuenta;
    private String fechaApertura;
    private float saldoPesosMx;
    private String estado;
    private Cliente cliente;

    public CuentaDTO() {
    }

    public CuentaDTO(int numeroCuenta, String fechaApertura, float saldoPesosMx, String estado, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldoPesosMx = saldoPesosMx;
        this.estado = estado;
        this.cliente = cliente;
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
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.numeroCuenta;
        hash = 47 * hash + Objects.hashCode(this.fechaApertura);
        hash = 47 * hash + Float.floatToIntBits(this.saldoPesosMx);
        hash = 47 * hash + Objects.hashCode(this.estado);
        hash = 47 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaDTO other = (CuentaDTO) obj;
        if (this.numeroCuenta != other.numeroCuenta) {
            return false;
        }
        if (Float.floatToIntBits(this.saldoPesosMx) != Float.floatToIntBits(other.saldoPesosMx)) {
            return false;
        }
        if (!Objects.equals(this.fechaApertura, other.fechaApertura)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return Objects.equals(this.cliente, other.cliente);
    }

    @Override
    public String toString() {
        return "CuentaDTO{" + "numeroCuenta=" + numeroCuenta + ", fechaApertura=" + fechaApertura + ", saldoPesosMx=" + saldoPesosMx + ", estado=" + estado + ", cliente=" + cliente + '}';
    }

}
