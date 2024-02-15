-- DROP DATABASE IF EXISTS banco_247283_240005;

CREATE DATABASE banco_247283_240005;
USE banco_247283_240005;


DROP TABLE IF EXISTS Transferencia;
DROP TABLE IF EXISTS Retiro_Sin_Cuenta;
DROP TABLE IF EXISTS Transaccion;
DROP TABLE IF EXISTS Cuenta;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Domicilio;

CREATE TABLE Domicilios (
idDomicilio BIGINT PRIMARY KEY AUTO_INCREMENT,
calle VARCHAR (100),
colonia VARCHAR (100),
numeroExterior VARCHAR (12)
);

CREATE TABLE Clientes (
idCliente BIGINT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR (100),
apellidoPaterno VARCHAR (100),
apellidoMaterno VARCHAR (100),
contraseña VARCHAR (15),
fechaNacimiento DATE,
idDomicilio BIGINT,
FOREIGN KEY (idDomicilio) REFERENCES Domicilios (idDomicilio)
);

CREATE TABLE Cuentas (
idCuenta BIGINT PRIMARY KEY AUTO_INCREMENT,
numeroCuenta BIGINT,
fechaApertura DATE,
saldoPesosMx FLOAT,
estado VARCHAR(30),
idCliente BIGINT,
FOREIGN KEY (idCliente) REFERENCES Clientes (idCliente)
);

CREATE TABLE Transacciones (
idTransaccion BIGINT PRIMARY KEY AUTO_INCREMENT,
monto FLOAT,
fechaRealizada DATETIME,
idCuenta BIGINT,
FOREIGN KEY (idCuenta) REFERENCES Cuentas (idCuenta)
);

CREATE TABLE Transferencias (
idTransaccion BIGINT,
idCuenta BIGINT,
FOREIGN KEY (idTransaccion) REFERENCES Transacciones (idTransaccion),
FOREIGN KEY (idCuenta) REFERENCES Cuentas (idCuenta)
);

CREATE TABLE Retiro_Sin_Cuenta (
idTransaccion BIGINT,
folio BIGINT,
contraseña VARCHAR (8),
estado VARCHAR (30),
FOREIGN KEY (idTransaccion) REFERENCES Transacciones (idTransaccion)
);


