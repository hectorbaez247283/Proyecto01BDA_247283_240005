/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

/**
 *
 * @author lv1821
 */
public class Domicilio {

    private int id;
    private String calle, colonia, numeroExterior;

    public Domicilio() {
    }

    public Domicilio(int id, String calle, String colonia, String numeroExterior) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroExterior = numeroExterior;
    }

    public Domicilio(String calle, String colonia, String numeroExterior) {
        this.calle = calle;
        this.colonia = colonia;
        this.numeroExterior = numeroExterior;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", numeroExterior=" + numeroExterior + '}';
    }

}
