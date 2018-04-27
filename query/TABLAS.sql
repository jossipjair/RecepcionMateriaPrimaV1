CREATE DATABASE ControlRecepcion
GO

USE ControlRecepcion
GO

CREATE TABLE ESTADO
(
	idEstado INT NOT NULL IDENTITY,
	esta_Descr VARCHAR(50) NOT NULL,
	UNIQUE(Esta_Descr),
	CONSTRAINT pk_Estado
	PRIMARY KEY(IdEstado)
)
GO


CREATE TABLE EMPRESA
(
	idEmpresa INT NOT NULL IDENTITY,
	idEstado INT NOT NULL,
	empr_Descr VARCHAR(100) NOT NULL,
	UNIQUE(empr_Descr),
	CONSTRAINT pk_idEmpresa
	PRIMARY KEY(idEmpresa),
	CONSTRAINT fk_Estado_Empresa
	FOREIGN KEY(idEstado) REFERENCES Estado(idEstado)
)
GO

CREATE TABLE SUCURSAL
(
	idSucursal INT NOT NULL IDENTITY,
	idEstado INT NOT NULL,
	idEmpresa INT NOT NULL,
	sucu_Descr VARCHAR(50) NOT NULL,
	UNIQUE(Sucu_Descr),
	CONSTRAINT pk_Sucursal
	PRIMARY KEY(IdSucursal),
	CONSTRAINT fk_Empresa_Sucursal
	FOREIGN KEY(IdEmpresa) REFERENCES Empresa(IdEmpresa),
	CONSTRAINT fk_Estado_Sucursal
	FOREIGN KEY(IdEstado) REFERENCES Estado(IdEstado)
)
GO

CREATE TABLE CULTIVO
(
	idCultivo INT NOT NULL IDENTITY,
	idEstado INT NOT NULL,
	cult_Descr VARCHAR(50) NOT NULL,

	CONSTRAINT pk_Fruto
	PRIMARY KEY(idCultivo),
	CONSTRAINT fk_Estado_Fruto
	FOREIGN KEY(idEstado) REFERENCES Estado(idEstado)
)
GO

CREATE TABLE VARIEDAD
(
	idVariedad INT NOT NULL IDENTITY,
	idCultivo INT NOT NULL,
	idEstado INT NOT NULL,
	vari_Descr VARCHAR(50) NOT NULL,

	CONSTRAINT pk_Variedad
	PRIMARY KEY(IdVariedad),
	CONSTRAINT fk_Cultivo_Variedad
	FOREIGN KEY(idCultivo) REFERENCES Cultivo(idCultivo),
	CONSTRAINT fk_Estado
	FOREIGN KEY(IdEstado) REFERENCES Estado(IdEstado)
)
GO

CREATE TABLE LOTE
(
	idLote INT NOT NULL IDENTITY,
	idEstado INT NOT NULL,
	idSucursal INT NOT NULL,
	idVariedad INT NOT NULL,
	lote_Descr VARCHAR(100) NOT NULL,
	lote_NCort VARCHAR(10) NOT NULL,

	CONSTRAINT pk_Lote
	PRIMARY KEY(IdLote),
	CONSTRAINT fk_Estado_Lote
	FOREIGN KEY(idEstado) REFERENCES Estado(idEstado),
	CONSTRAINT fk_Sucursal_Lote
	FOREIGN KEY(idSucursal) REFERENCES Sucursal(idSucursal),
	CONSTRAINT fk_Variedad_Lote
	FOREIGN KEY(idVariedad) REFERENCES Variedad(idVariedad)
)
GO


CREATE TABLE RECEPCION_FRUTA
(
	idRecepcion INT NOT NULL IDENTITY,
	idLote INT NOT NULL,
	idEstado INT NOT NULL,
	rFrut_Fech_Pesa DATETIME NOT NULL,
	rFrut_Guia_Remis VARCHAR(20) NOT NULL,
	rFrut_Viaje VARCHAR(4) NOT NULL,
	rFrut_Obser VARCHAR(150) NOT NULL,
	rFrut_esProcesado BIT,
	CONSTRAINT pk_Recepcion
	PRIMARY KEY(idRecepcion),
	CONSTRAINT fk_Lote_Recepcion
	FOREIGN KEY(idLote) REFERENCES Lote(idLote),
	CONSTRAINT fk_Estado_RecepcionFruta
	FOREIGN KEY(idEstado) REFERENCES Estado(idEstado)
)	
GO


CREATE TABLE DETALLE_RECEPCION
(
	idDetalleRecepcion INT NOT NULL IDENTITY,
	idRecepcion INT NOT NULL,
	dRec_CoBar VARCHAR(100) NOT NULL,
	dRec_Fech_Proc DATETIME NOT NULL,
	dRec_Tara NUMERIC(15,2) NOT NULL,
	dRec_Peso_Bruto NUMERIC(15,4) NOT NULL,
	dRec_Canti INT NOT NULL,
	dRec_Peso NUMERIC(15,4) NOT NULL, 
	dRec_PTota NUMERIC(15,4) NOT NULL, 
	dRec_PNeto NUMERIC(15,4) NOT NULL, 
	dRec_esReproceso BIT,

	CONSTRAINT pk_DetalleRecepcion
	PRIMARY KEY(idDetalleRecepcion),
	CONSTRAINT fk_Recepcion_DetalleRecepcion
	FOREIGN KEY(idRecepcion) REFERENCES RECEPCION_FRUTA(idRecepcion)
)
GO

