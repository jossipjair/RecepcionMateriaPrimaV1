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


CREATE TABLE RECEPCION_PALTA
(
	idRecepcionPalta INT NOT NULL IDENTITY,
	idLote INT NOT NULL,
	idEstado INT NOT NULL,
	rPalta_FechRegistro DATETIME NOT NULL,
	rPalta_Guia_Remis VARCHAR(20) NOT NULL,
	rPalta_Viaje VARCHAR(100) NOT NULL,
	rPalta_Obser VARCHAR(150) NOT NULL,

	CONSTRAINT pk_RecepcionPalta
	PRIMARY KEY(idRecepcionPalta),
	CONSTRAINT fk_Lote_Recepcion
	FOREIGN KEY(idLote) REFERENCES Lote(idLote),
	CONSTRAINT fk_Estado_RecepcionFruta
	FOREIGN KEY(idEstado) REFERENCES Estado(idEstado)
)	
GO


CREATE TABLE DETALLE_RECEPCION_PALTA
(
	idDetalleRecepcionPalta INT NOT NULL IDENTITY,
	idRecepcionPalta INT NOT NULL,
	idEstado INT NOT NULL,
	dRPalta_CoBar VARCHAR(100) NOT NULL,
	dRPalta_Fech_Pesa DATETIME NOT NULL,
	dRPalta_Fech_Proc DATETIME,
	dRPalta_Tara NUMERIC(15,2) NOT NULL,
	dRPalta_Peso_Bruto NUMERIC(15,2) NOT NULL,
	dRPalta_Canti INT NOT NULL,
	dRPalta_Peso NUMERIC(15,2) NOT NULL, 
	dRPalta_PTota NUMERIC(15,2) NOT NULL, 
	dRPalta_PNeto NUMERIC(15,2) NOT NULL, 
	dRPalta_esReproceso BIT,
	dRPalta_esProcesado BIT,
	dRPalta_Observacion VARCHAR(100),
	CONSTRAINT pk_DetalleRecepcionPalta
	PRIMARY KEY(idDetalleRecepcionPalta),
	CONSTRAINT fk_Estado_DetalleRecepcion
	FOREIGN KEY(idEstado) REFERENCES ESTADO(idEstado),
	CONSTRAINT fk_Recepcion_DetalleRecepcion
	FOREIGN KEY(idRecepcionPalta) REFERENCES RECEPCION_PALTA(idRecepcionPalta),
	UNIQUE (dRPalta_CoBar)
)
GO


CREATE TABLE USUARIO
(
	idUsuario INT NOT NULL IDENTITY,
	usua_usuario VARCHAR(20) NOT NULL,
	usua_password VARCHAR(20) NOT NULL,
	CONSTRAINT pk_Usuario
	PRIMARY KEY(idUsuario)
)
GO

CREATE TABLE PRIVILEGIO
(
	idPrivilegio INT NOT NULL IDENTITY,
	idUsuario INT NOT NULL,
	priv_DescTabla VARCHAR(100) NOT NULL,
	priv_Estado BIT NOT NULL,
	CONSTRAINT pk_Privilegio
	PRIMARY KEY(idPrivilegio),
	CONSTRAINT fk_Usuario_Privilegio
	FOREIGN KEY(idUsuario) REFERENCES USUARIO(idUsuario)
)
GO

CREATE TABLE VERSION_SOFTWARE
(
	idVersionSoftware INT NOT NULL IDENTITY,
	verSoft_Descr VARCHAR(20) NOT NULL,
	CONSTRAINT pk_VersionSoftware
	PRIMARY KEY(idVersionSoftware)
)
GO
/*
SELECT dr.idDetalleRecepcion, dr.dRec_Fech_Pesa, dr.dRec_Fech_Proc, dr.dRec_Tara, dr.dRec_Peso_Bruto, dr.dRec_Canti,
		dr.dRec_Peso, dr.dRec_PTota, dr.dRec_PNeto, dr.dRec_esReproceso, dr.dRec_esProcesado
FROM DETALLE_RECEPCION AS dr INNER JOIN RECEPCION_FRUTA AS rf ON dr.idRecepcion = rf.idRecepcion
GO

--REIMPRIMIR PALETA
CREATE PROCEDURE spReimprimirPaleta
@FechaInicio DATE,
@FechaFin DATE
AS BEGIN
SELECT 
		lot.lote_NCort AS [LOTE],
		rf.rFrut_Guia_Remis AS [GUIA DE REMISION] ,
		rf.rFrut_Viaje AS [VIAJE],
		dr.dRec_Fech_Pesa AS [FECHA PESADO], 
		dr.dRec_Fech_Proc AS [FECHA PROCESO], 
		dr.dRec_Tara AS [TARA],  
		dr.dRec_Peso_Bruto AS [PESO BRUTO], 
		dr.dRec_Canti AS [JABAS],
		dr.dRec_Peso AS [PESO], 
		dr.dRec_PTota AS [PESO TOTAL], 
		dr.dRec_PNeto AS [PESO NETO], 
		dr.dRec_esReproceso AS [REPROCESO], 
		dr.dRec_esProcesado AS [PROCESADO],
		dr.dRec_CoBar AS [COD. BARRA]
FROM 
		DETALLE_RECEPCION AS dr 
		INNER JOIN RECEPCION_FRUTA AS rf ON dr.idRecepcion = rf.idRecepcion
		INNER JOIN LOTE AS lot ON rf.idLote = lot.idLote
WHERE 
		dr.dRec_Fech_Pesa BETWEEN @FechaInicio AND @FechaFin
END
GO*/