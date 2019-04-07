
USE ControlRecepcion
GO

ALTER PROCEDURE spInsertarRecepcionPalta
@idLote INT,
@FechaRegistro VARCHAR(40),
@GuiaRemision VARCHAR(20),
@Viaje VARCHAR(100),
@Observacion VARCHAR(150)
AS BEGIN
	INSERT INTO RECEPCION_PALTA (IdLote, IdEstado, rPalta_FechRegistro, rPalta_Guia_Remis, rPalta_Viaje, rPalta_Obser)
	VALUES(@idLote, 1, (SELECT CAST(convert(date, @FechaRegistro, 103) AS DATE)), @GuiaRemision, @Viaje, @Observacion)
END
GO

CREATE PROCEDURE spActualizarRecepcionPalta
@idLote INT,
@FechaRegistro VARCHAR(100),
@GuiaRemision VARCHAR(20),
@Viaje VARCHAR(100),
@Observacion VARCHAR(150),
@IdRecepcionPalta INT
AS BEGIN
	UPDATE RECEPCION_PALTA
		SET idLote = @idLote,
			rPalta_FechRegistro	= (SELECT CAST(convert(date, @FechaRegistro, 103) AS DATE)),
			rPalta_Guia_Remis = @GuiaRemision,
			rPalta_Viaje = @Viaje,
			rPalta_Obser = @Observacion
	WHERE
		idRecepcionPalta = @IdRecepcionPalta
END
GO

/*
-- INSERTANDO ESTADOS --
SELECT * FROM VARIEDAD

INSERT INTO ESTADO (esta_Descr) VALUES('ACTIVO'),('INACTIVO')
GO

SELECT * FROM VERSION_SOFTWARE

INSERT INTO VERSION_SOFTWARE VALUES('1.0')

update version_software set [verSoft_Descr] = '2.0'

select * from VARIEDAD
SELECT sucu.idSucursal , emp.empr_Descr, sucu.sucu_Descr, est.esta_Descr FROM SUCURSAL AS sucu INNER JOIN ESTADO AS est ON sucu.idEstado = est.idEstado INNER JOIN EMPRESA AS emp ON emp.idEmpresa = sucu.idEmpresa


SELECT cult.idCultivo,  cult.cult_Descr , est.esta_Descr FROM CULTIVO AS cult INNER JOIN ESTADO AS est ON cult.idEstado = est.idEstado
*/

CREATE PROCEDURE spInsertarDetalleRecepcionPalta 
@idRecepcionPalta INT,
@codigoBarra VARCHAR(100),
@fechaPesado VARCHAR(100),
@tara NUMERIC(15,2),
@pesoBruto NUMERIC(15,2),
@cantidad INT,
@peso NUMERIC(15,4),
@pesoTotal NUMERIC(15,4),
@pesoNeto NUMERIC(15,4),
@reproceso BIT,
@observacion VARCHAR(100)
AS BEGIN
	INSERT INTO DETALLE_RECEPCION_PALTA
		(
		idRecepcionPalta,
		dRPalta_CoBar,
		dRPalta_Fech_Pesa, 
		dRPalta_Tara, 
		dRPalta_Peso_Bruto, 
		dRPalta_Canti, 
		dRPalta_Peso, 
		dRPalta_PTota, 
		dRPalta_PNeto, 
		dRPalta_esReproceso, 
		dRPalta_Observacion,
		idEstado)
		--VALUES(@idRecepcionPalta, @codigoBarra, CAST(@fechaPesado AS DATETIME), @tara, @pesoBruto, @cantidad, @peso, @pesoTotal, @pesoNeto, @reproceso, @observacion, 1)
		VALUES(@idRecepcionPalta, @codigoBarra, CAST(GETDATE() AS DATETIME), @tara, @pesoBruto, @cantidad, @peso, @pesoTotal, @pesoNeto, @reproceso, @observacion, 1)
END 
GO

CREATE PROCEDURE spActualizarDetalleRecepcionPalta
@idRecepcionPalta INT,
@codigoBarra VARCHAR(100),
@fechaPesado VARCHAR(100),
@tara NUMERIC(15,2),
@pesoBruto NUMERIC(15,2),
@cantidad INT,
@peso NUMERIC(15,4),
@pesoTotal NUMERIC(15,4),
@pesoNeto NUMERIC(15,4),
@reproceso BIT,
@observacion VARCHAR(100),
@idDetalle INT
AS BEGIN
	UPDATE DETALLE_RECEPCION_PALTA
	SET idRecepcionPalta = @idRecepcionPalta,
		dRPalta_CoBar = @codigoBarra,
		dRPalta_Fech_Pesa = CAST(@fechaPesado AS DATETIME),
		dRPalta_Tara = @tara,
		dRPalta_Peso_Bruto = @pesoBruto,
		dRPalta_Canti = @cantidad,
		dRPalta_Peso = @peso,
		dRPalta_PTota = @pesoTotal,
		dRPalta_PNeto = @pesoNeto,
		dRPalta_esReproceso = @reproceso,
		dRPalta_Observacion = @observacion
	WHERE
		idDetalleRecepcionPalta = @idDetalle
END	
GO

CREATE PROCEDURE spDarBajaDetalleRecepcionPalta
@idDetalle INT
AS BEGIN
	UPDATE dbo.DETALLE_RECEPCION_PALTA
	SET	idEstado = 2
END
GO	

CREATE PROCEDURE spMostrarRecepcionPalta
AS BEGIN
SELECT	rp.idRecepcionPalta, 
		lot.lote_NCort, vari.vari_Descr,
		--FORMAT(rp.rPalta_FechRegistro, 'dd/MM/yyyy'),
		rp.rPalta_FechRegistro,
		rp.rPalta_Guia_Remis, 
		rp.rPalta_Viaje, 
		rp.rPalta_Obser 
FROM RECEPCION_PALTA AS rp 
		INNER JOIN LOTE AS lot ON rp.idLote = lot.idLote 
		INNER JOIN VARIEDAD AS vari ON lot.idVariedad = vari.idVariedad
WHERE rp.idEstado = 1
END
GO

CREATE PROCEDURE spMostrarDetalleRecepcionPalta
@idRecepcionPalta INT
AS BEGIN
SELECT	dr.idDetalleRecepcionPalta, 
		--FORMAT(dRPalta_Fech_Pesa, 'dd/MM/yyyy hh:mm:ss tt'),
		dRPalta_Fech_Pesa,
		dr.dRPalta_Peso_Bruto, 
		dr.dRPalta_Tara, 
		dr.dRPalta_Canti, 
		dr.dRPalta_Peso, 
		dr.dRPalta_PTota, 
		dr.dRPalta_PNeto, 
		dr.dRPalta_esReproceso, 
		dr.dRPalta_esProcesado, 
		dr.dRPalta_Observacion, 
		--FORMAT(dr.dRPalta_Fech_Proc, 'dd/MM/yyyy hh:mm:ss tt'), 
		dr.dRPalta_Fech_Proc,
		dr.dRPalta_CoBar 
FROM DETALLE_RECEPCION_PALTA AS dr 
WHERE dr.idEstado = 1 
AND dr.idRecepcionPalta =@idRecepcionPalta
END
GO

ALTER AUTHORIZATION ON DATABASE::ControlRecepcion TO SA


CREATE PROCEDURE spMostrarDataReimprimir
@fechaInicio varchar(50),
@fechaFin varchar(50)
AS BEGIN

	SELECT 
		dr.[dRPalta_Peso_Bruto],
		dr.[dRPalta_Tara],
		dr.[dRPalta_Canti],
		dr.[dRPalta_Peso],
		dr.[dRPalta_PTota],
		dr.[dRPalta_PNeto],
		rp.[rPalta_Viaje],
		lot.[lote_NCort],
		vari.[vari_Descr],
		FORMAT(dr.[dRPalta_Fech_Pesa], 'dd/MM/yyyy hh:mm:ss tt'),
		rp.[rPalta_Guia_Remis],
		rp.[rPalta_Obser], 
		FORMAT(dr.[dRPalta_Fech_Proc], 'dd/MM/yyyy hh:mm:ss tt')
	FROM 
			RECEPCION_PALTA AS rp 
			INNER JOIN DETALLE_RECEPCION_PALTA AS dr ON dr.idRecepcionPalta = rp.idRecepcionPalta
			INNER JOIN LOTE AS lot ON rp.idLote = lot.idLote
			INNER JOIN VARIEDAD AS vari ON lot.idVariedad = vari.idVariedad
	WHERE 
		rp.idEstado = 1
END
GO

CREATE PROCEDURE sp_Login
@Usuario varchar(20),
@Password varchar(20)
AS BEGIN
	SELECT idUsuario
	FROM USUARIO
	WHERE usua_usuario = @Usuario
	AND usua_password = @Password
END
GO

exec sp_login 'jossip', 'jossip'

INSERT INTO USUARIO VALUES('jossip','jossip')