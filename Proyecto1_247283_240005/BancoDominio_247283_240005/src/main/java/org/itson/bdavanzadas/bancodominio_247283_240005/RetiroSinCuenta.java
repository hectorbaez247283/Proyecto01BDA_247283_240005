/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

/**
 * La clase RetiroSinCuenta representa un retiro de efectivo sin utilizar una
 * cuenta bancaria
 *
 * @author Christopher
 * @author Francisco
 */
public class RetiroSinCuenta {

    //Atributos de la clase
    private Transaccion transaccion;
    private int folio;
    private String contraseña, estado;

    // Constructor por defecto
    public RetiroSinCuenta() {
    }

    /**
     * Constructor parametrizado con todos los atributos.
     *
     * @param transaccion Objeto Transaccion asociado al retiro sin cuenta.
     * @param folio Número de folio del retiro sin cuenta.
     * @param contraseña Contraseña del retiro sin cuenta.
     * @param estado Estado del retiro sin cuenta.
     */
    public RetiroSinCuenta(Transaccion transaccion, int folio, String contraseña, String estado) {
        this.transaccion = transaccion;
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    /**
     * Obtiene el objeto Transaccion asociado al retiro sin cuenta.
     *
     * @return Objeto Transaccion asociado al retiro sin cuenta.
     */
    public Transaccion getTransaccion() {
        return transaccion;
    }

    /**
     * Establece el objeto Transaccion asociado al retiro sin cuenta.
     *
     * @param transaccion Nuevo objeto Transaccion asociado al retiro sin
     * cuenta.
     */
    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    /**
     * Obtiene el número de folio del retiro sin cuenta.
     *
     * @return Número de folio del retiro sin cuenta.
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Establece el número de folio del retiro sin cuenta.
     *
     * @param folio Nuevo número de folio del retiro sin cuenta.
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Obtiene la contraseña del retiro sin cuenta.
     *
     * @return Contraseña del retiro sin cuenta.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del retiro sin cuenta.
     *
     * @param contraseña Nueva contraseña del retiro sin cuenta.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el estado del retiro sin cuenta.
     *
     * @return Estado del retiro sin cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del retiro sin cuenta.
     *
     * @param estado Nuevo estado del retiro sin cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método toString para representar el objeto como una cadena.
     *
     * @return Representación en cadena del objeto RetiroSinCuenta.
     */
    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "transaccion=" + transaccion + ", folio=" + folio + ", contraseña=" + contraseña + ", estado=" + estado + '}';
    }

}
