/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio_247283_240005;

import java.util.Objects;

/**
 * Clase que maneja los datos de cliente
 *
 * @author Christopher
 * @author Francisco
 */
public class Cliente {

    //Atributos de la clase
    private int id;
    private String nombre, apellidoPaterno, apellidoMaterno, contraseña, telefono;
    private String fechaNacimiento;
    private Domicilio domicilio;

    /**
     * Constructor por defecto. Crea una instancia de Cliente con valores
     * predeterminados.
     */
    public Cliente() {
    }

    /**
     * Constructor completo que inicializa todos los atributos del cliente.
     *
     * @param id Identificador único del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param contraseña Contraseña del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param domicilio Objeto Domicilio asociado al cliente.
     */
    public Cliente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String contraseña, String telefono, String fechaNacimiento, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    /**
     * Constructor que omite el ID y la contraseña. Utilizado al crear un
     * cliente sin ID asignado.
     *
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param domicilio Objeto Domicilio asociado al cliente.
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String contraseña, String telefono, String fechaNacimiento, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    /**
     * Constructor que omite el ID, la contraseña y la fecha de nacimiento.
     * Utilizado para casos en los que no se proporciona información completa al
     * crear un cliente.
     *
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param domicilio Objeto Domicilio asociado al cliente.
     */
    public Cliente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return El id del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del cliente.
     *
     * @param id El nuevo identificador único del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     *
     * @return El apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     *
     * @param apellidoPaterno El nuevo apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     *
     * @return El apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del cliente.
     *
     * @param apellidoMaterno El nuevo apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la contraseña del cliente.
     *
     * @return La contraseña del cliente.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del cliente.
     *
     * @param contraseña La nueva contraseña del cliente.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     *
     * @return La fecha de nacimiento del cliente.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     *
     * @param fechaNacimiento La nueva fecha de nacimiento del cliente.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el domicilio del cliente.
     *
     * @return El domicilio del cliente.
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * Establece el domicilio del cliente.
     *
     * @param domicilio El nuevo domicilio del cliente.
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return El número de teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     *
     * @param telefono El nuevo número de teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Genera un código hash único para el cliente basado en sus atributos.
     *
     * @return El código hash del cliente.
     */
    @Override
    public int hashCode() {
        // Implementación estándar de generación de hash usando los atributos del objeto
        int hash = 3;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 41 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 41 * hash + Objects.hashCode(this.contraseña);
        hash = 41 * hash + Objects.hashCode(this.telefono);
        hash = 41 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 41 * hash + Objects.hashCode(this.domicilio);
        return hash;
    }

    /**
     * Compara este cliente con otro objeto para verificar si son iguales.
     *
     * @param obj El objeto a comparar con el cliente.
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return Objects.equals(this.domicilio, other.domicilio);
    }

    /**
     * Devuelve una representación en cadena del cliente.
     *
     * @return Una cadena que representa el cliente y sus atributos.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", contrase\u00f1a=" + contraseña + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio + '}';
    }

}
