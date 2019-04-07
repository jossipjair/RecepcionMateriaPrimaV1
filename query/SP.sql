CREATE PROCEDURE spMostrarImpresionTarja
@detalle AS INT
AS BEGIN
SELECT 
	CONVERT(VARCHAR(30), dr.dRPalta_Fech_Pesa,103) + ' ' + CONVERT(VARCHAR(50), dr.dRPalta_Fech_Pesa, 108),	
	dr.dRPalta_Fech_Pesa,
	cult.cult_Descr,
	vari.vari_Descr,
	lot.lote_NCort,
	rp.rPalta_Viaje,
	dr.dRPalta_PNeto,
	dr.dRPalta_Canti
FROM 
	DETALLE_RECEPCION_PALTA AS dr
	INNER JOIN RECEPCION_PALTA AS rp on dr.idRecepcionPalta = rp.idRecepcionPalta
	INNER JOIN LOTE AS lot ON rp.idLote = lot.idLote
	INNER JOIN VARIEDAD AS vari ON vari.idVariedad = lot.idVariedad
	INNER JOIN CULTIVO AS cult ON vari.idCultivo = cult.idCultivo
WHERE
	dr.idDetalleRecepcionPalta = @detalle
END
GO