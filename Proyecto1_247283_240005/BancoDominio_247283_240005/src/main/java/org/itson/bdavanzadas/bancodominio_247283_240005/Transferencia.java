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

    //Atributos de la clase
    Transaccion transaccion;

    // Constructor por defecto
    public Transferencia() {
    }

    // Constructor parametrizado con todos los atributos
    public Transferencia(Transaccion transaccion, Cuenta cuentaOrig, Cuenta cuentaDes) {
        this.transaccion = transaccion;

    }

    // Métodos getter y setter para transaccion
    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    // Método toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return "Transferencia{" + "transaccion=" + transaccion + '}';
    }

}
