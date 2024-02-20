-- DROP DATABASE IF EXISTS banco_247283_240005;

CREATE DATABASE banco_247283_240005;
USE banco_247283_240005;


DROP TABLE IF EXISTS Transferencia;
DROP TABLE IF EXISTS Retiro_Sin_Cuenta;
DROP TABLE IF EXISTS Transaccion;
DROP TABLE IF EXISTS Cuenta;
DROP TABLE IF EXISTS Clientes;
DROP TABLE IF EXISTS Domicilio;

CREATE TABLE Domicilios (
idDomicilio BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
calle VARCHAR (100) NOT NULL,
colonia VARCHAR (100) NOT NULL,
numeroExterior VARCHAR (12) NOT NULL
);

CREATE TABLE Clientes (
idCliente BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre VARCHAR (100) NOT NULL,
apellidoPaterno VARCHAR (100) NOT NULL,
apellidoMaterno VARCHAR (100),
contraseña VARCHAR (15) NOT NULL,
telefono VARCHAR(10) NOT NULL,
fechaNacimiento DATE NOT NULL,
idDomicilio BIGINT NOT NULL,
FOREIGN KEY (idDomicilio) REFERENCES Domicilios (idDomicilio)
);

CREATE TABLE Cuentas (
idCuenta BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
numeroCuenta BIGINT NOT NULL,
fechaApertura DATE NOT NULL,
saldoPesosMx FLOAT NOT NULL,
estado VARCHAR(30) NOT NULL,
idCliente BIGINT NOT NULL,
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
idTransaccion BIGINT NOT NULL,
idCuenta BIGINT NOT NULL,
FOREIGN KEY (idTransaccion) REFERENCES Transacciones (idTransaccion),
FOREIGN KEY (idCuenta) REFERENCES Cuentas (idCuenta)
);

CREATE TABLE Retiro_Sin_Cuenta (
idTransaccion BIGINT NOT NULL,
folio BIGINT NOT NULL,
contraseña VARCHAR (8) NOT NULL,
estado VARCHAR (30) NOT NULL,
FOREIGN KEY (idTransaccion) REFERENCES Transacciones (idTransaccion)
);


select * from clientes;