CREATE PROCEDURE spActualizarRecepcionPalta
@codigoBarra INT
AS BEGIN
	UPDATE DETALLE_RECEPCION_PALTA
		SET dRPalta_esProcesado = 0,
			dRPalta_Fech_Proc = CAST(GETDATE() AS DATETIME)
		WHERE idDetalleRecepcionPalta = @codigoBarra
END
GO

