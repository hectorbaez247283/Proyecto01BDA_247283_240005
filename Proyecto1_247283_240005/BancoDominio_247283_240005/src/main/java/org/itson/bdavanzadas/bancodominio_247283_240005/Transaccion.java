/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

import java.util.Date;

/**
 *
 * @author Christopher
 * @author Francisco
 */
public class Transaccion {

    //Atributos de la clase
    private int id;
    private float monto;
    private Date fechaRealizada;
    private Cuenta cuenta;

    // Constructor por defecto
    public Transaccion() {
    }

    /**
     * Constructor parametrizado con todos los atributos, incluyendo el id.
     *
     * @param id Identificador único de la transacción.
     * @param monto Monto de la transacción.
     * @param fechaRealizada Fecha en la que se realizó la transacción.
     * @param cuenta Cuenta asociada a la transacción.
     */
    public Transaccion(int id, float monto, Date fechaRealizada, Cuenta cuenta) {
        this.id = id;
        this.monto = monto;
        this.fechaRealizada = fechaRealizada;
        this.cuenta = cuenta;
    }

    /**
     * Constructor parametrizado sin id (asume que el id se generará en otro
     * lugar, como en una base de datos).
     *
     * @param monto Monto de la transacción.
     * @param fechaRealizada Fecha en la que se realizó la transacción.
     * @param cuenta Cuenta asociada a la transacción.
     */
    public Transaccion(float monto, Date fechaRealizada, Cuenta cuenta) {
        this.monto = monto;
        this.fechaRealizada = fechaRealizada;
        this.cuenta = cuenta;
    }

    /**
     * Obtiene el identificador único de la transacción.
     *
     * @return El id de la transacción.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la transacción.
     *
     * @param id El nuevo identificador único de la transacción.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el monto de la transacción.
     *
     * @return El monto de la transacción.
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transacción.
     *
     * @param monto El nuevo monto de la transacción.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la fecha en la que se realizó la transacción.
     *
     * @return La fecha en la que se realizó la transacción.
     */
    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    /**
     * Establece la fecha en la que se realizó la transacción.
     *
     * @param fechaRealizada La nueva fecha en la que se realizó la transacción.
     */
    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    /**
     * Obtiene la cuenta asociada a la transacción.
     *
     * @return La cuenta asociada a la transacción.
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Establece la cuenta asociada a la transacción.
     *
     * @param cuenta La nueva cuenta asociada a la transacción.
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Método toString para representar el objeto como una cadena.
     *
     * @return Representación en cadena del objeto Transaccion.
     */
    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", monto=" + monto + ", fechaRealizada=" + fechaRealizada + ", cuenta=" + cuenta + '}';
    }

}
