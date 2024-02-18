/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia_247283_240005.dto;

import java.util.Objects;
import org.itson.bdavanzadas.bancodominio_247283_240005.Domicilio;

/**
 *
 * @author lv1821
 */
public class ClienteDTO {

    private String nombre, apellidoPaterno, apellidoMaterno, contraseña, telefono;
    private String fechaNacimiento;
    private Domicilio domicilio;

    public ClienteDTO() {
    }

    public ClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String contraseña, String telefono, String fechaNacimiento, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    public ClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String fechaNacimiento, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }
    
    


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 31 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 31 * hash + Objects.hashCode(this.contraseña);
        hash = 31 * hash + Objects.hashCode(this.telefono);
        hash = 31 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 31 * hash + Objects.hashCode(this.domicilio);
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
        final ClienteDTO other = (ClienteDTO) obj;
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

    @Override
    public String toString() {
        return "ClienteDTO{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", contrase\u00f1a=" + contraseña + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio + '}';
    }
}
