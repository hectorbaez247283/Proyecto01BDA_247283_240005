/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

import java.util.Date;
import java.util.Objects;

/**
 * La clase cuenta representa una cuenta de banco.
 *
 * @author Christopher
 * @author Francisco
 */
public class Cuenta {

    //Atributos de la clase
    private int id, numeroCuenta;
    private String fechaApertura;
    private float saldoPesosMx;
    private String estado;
    private Cliente cliente;

    // Constructor por defecto
    public Cuenta() {
    }

    // Constructor parametrizado con todos los atributos
    public Cuenta(int id, int numeroCuenta, String fechaApertura, float saldoPesosMx, String estado, Cliente cliente) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldoPesosMx = saldoPesosMx;
        this.estado = estado;
        this.cliente = cliente;
    }

    // Constructor parametrizado sin id (asume que el id se generará en otro lugar, como en una base de datos)
    public Cuenta(int numeroCuenta, String fechaApertura, float saldoPesosMx, String estado, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldoPesosMx = saldoPesosMx;
        this.estado = estado;
        this.cliente = cliente;
    }

    // Método getter para id
    public int getId() {
        return id;
    }

    // Método setter para id
    public void setId(int id) {
        this.id = id;
    }

    // Método getter para numeroCuenta
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    // Método setter para numeroCuenta
    public void setNumeroCuenta(int numeroCuenta) {
        // Implementación del método setter
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Metodo getter para FechaApertura
     *
     * @return fehcaApertura
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Establece la fecha de apertura de la cuenta.
     *
     * @param fechaApertura La nueva fecha de apertura de la cuenta.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Obtiene el saldo en pesos mexicanos de la cuenta.
     *
     * @return El saldo en pesos mexicanos de la cuenta.
     */
    public float getSaldoPesosMx() {
        return saldoPesosMx;
    }

    /**
     * Establece el saldo en pesos mexicanos de la cuenta.
     *
     * @param saldoPesosMx El nuevo saldo en pesos mexicanos de la cuenta.
     */
    public void setSaldoPesosMx(float saldoPesosMx) {
        this.saldoPesosMx = saldoPesosMx;
    }

    /**
     * Obtiene el estado actual de la cuenta.
     *
     * @return El estado actual de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la cuenta.
     *
     * @param estado El nuevo estado de la cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el cliente asociado a la cuenta.
     *
     * @return El cliente asociado a la cuenta.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la cuenta.
     *
     * @param cliente El nuevo cliente asociado a la cuenta.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Genera un código hash único para la cuenta basado en sus atributos.
     *
     * @return El código hash de la cuenta.
     */
    @Override
    public int hashCode() {
        // Implementación estándar de generación de hash usando los atributos del objeto
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + this.numeroCuenta;
        hash = 37 * hash + Objects.hashCode(this.fechaApertura);
        hash = 37 * hash + Float.floatToIntBits(this.saldoPesosMx);
        hash = 37 * hash + Objects.hashCode(this.estado);
        hash = 37 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    /**
     * Compara esta cuenta con otro objeto para verificar si son iguales.
     *
     * @param obj El objeto a comparar con la cuenta.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        // Implementación estándar de comparación de igualdad usando los atributos del objeto
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        if (this.id != other.id) {
            return false;
        }
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

    /**
     * Devuelve una representación en cadena de la cuenta.
     *
     * @return Una cadena que representa la cuenta y sus atributos.
     */
    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", numeroCuenta=" + numeroCuenta + ", fechaApertura=" + fechaApertura + ", saldoPesosMx=" + saldoPesosMx + ", estado=" + estado + ", cliente=" + cliente + '}';
    }

}
