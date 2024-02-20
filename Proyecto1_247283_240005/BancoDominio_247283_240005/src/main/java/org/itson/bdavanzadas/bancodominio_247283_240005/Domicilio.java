/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

/**
 * La clase Domicilio representa la información de una dirección
 *
 * @author Christopher
 * @author Francisco
 */
public class Domicilio {

// Atributos de la clase
    private int id;
    private String calle, colonia, numeroExterior;

    // Constructor por defecto
    public Domicilio() {
    }

    /**
     * Constructor parametrizado con todos los atributos, incluyendo el id.
     *
     * @param id Identificador único del domicilio.
     * @param calle Nombre de la calle del domicilio.
     * @param colonia Nombre de la colonia del domicilio.
     * @param numeroExterior Número exterior del domicilio.
     */
    public Domicilio(int id, String calle, String colonia, String numeroExterior) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroExterior = numeroExterior;
    }

    /**
     * Constructor parametrizado sin id (asume que el id se generará en otro
     * lugar, como en una base de datos).
     *
     * @param calle Nombre de la calle del domicilio.
     * @param colonia Nombre de la colonia del domicilio.
     * @param numeroExterior Número exterior del domicilio.
     */
    public Domicilio(String calle, String colonia, String numeroExterior) {
        this.calle = calle;
        this.colonia = colonia;
        this.numeroExterior = numeroExterior;
    }

    /**
     * Obtiene el identificador único del domicilio.
     *
     * @return El id del domicilio.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del domicilio.
     *
     * @param id El nuevo identificador único del domicilio.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la calle del domicilio.
     *
     * @return El nombre de la calle.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle del domicilio.
     *
     * @param calle El nuevo nombre de la calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el nombre de la colonia del domicilio.
     *
     * @return El nombre de la colonia.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece el nombre de la colonia del domicilio.
     *
     * @param colonia El nuevo nombre de la colonia.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el número exterior del domicilio.
     *
     * @return El número exterior.
     */
    public String getNumeroExterior() {
        return numeroExterior;
    }

    /**
     * Establece el número exterior del domicilio.
     *
     * @param numeroExterior El nuevo número exterior.
     */
    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    /**
     * Método toString para representar el objeto como una cadena.
     *
     * @return Representación en cadena del objeto Domicilio.
     */
    @Override
    public String toString() {
        return "Domicilio{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", numeroExterior=" + numeroExterior + '}';
    }

}
