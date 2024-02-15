/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

/**
 *
 * @author lv1821
 */
public class Transferencia {

    Transaccion transaccion;
    Cuenta cuentaOrig, cuentaDes;

    public Transferencia() {
    }

    public Transferencia(Transaccion transaccion, Cuenta cuentaOrig, Cuenta cuentaDes) {
        this.transaccion = transaccion;
        this.cuentaOrig = cuentaOrig;
        this.cuentaDes = cuentaDes;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public Cuenta getCuentaOrig() {
        return cuentaOrig;
    }

    public void setCuentaOrig(Cuenta cuentaOrig) {
        this.cuentaOrig = cuentaOrig;
    }

    public Cuenta getCuentaDes() {
        return cuentaDes;
    }

    public void setCuentaDes(Cuenta cuentaDes) {
        this.cuentaDes = cuentaDes;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "transaccion=" + transaccion + ", cuentaOrig=" + cuentaOrig + ", cuentaDes=" + cuentaDes + '}';
    }

}
