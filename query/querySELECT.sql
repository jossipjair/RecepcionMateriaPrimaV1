	SELECT dr.idDetalleRecepcionPalta,	
	
	dr.dRPalta_Fech_Pesa, 
	dr.dRPalta_Peso_Bruto, 
	dr.dRPalta_Tara,
	 dr.dRPalta_Canti,
	  dr.dRPalta_Peso, 
	  dr.dRPalta_PTota, 
	  dr.dRPalta_PNeto, 
	  dr.dRPalta_esReproceso, 
	  dr.dRPalta_esProcesado, 
	  dr.dRPalta_Observacion,
	  dr.dRPalta_Fech_Proc,
	  dr.dRPalta_CoBar
	FROM DETALLE_RECEPCION_PALTA AS dr 
	INNER JOIN RECEPCION_PALTA AS dp ON dr.idRecepcionPalta = dp.idRecepcionPalta
	WHERE dp.idRecepcionPalta = 55


SELECT * FROM DETALLE_RECEPCION_PALTA
--SELECT * FROM RECEPCION_PALTA --DET: 2 - 3 - 6 - 12

/*SELECT  dr.idDetalleRecepcionPalta,dr.dRPalta_Fech_Pesa,dr.dRPalta_Peso_Bruto, dr.dRPalta_Tara, dr.dRPalta_Canti, dr.dRPalta_Peso, dr.dRPalta_PTota, 
dr.dRPalta_PNeto, dr.dRPalta_esReproceso, dr.dRPalta_esProcesado, dr.dRPalta_Observacion, 
dr.dRPalta_Fech_Proc, dr.dRPalta_CoBar 
FROM DETALLE_RECEPCION_PALTA AS dr 
WHERE dr.idRecepcionPalta = 4 AND dr.idEstado = 1*/


--SELECT dr.idDetalleRecepcionPalta,dr.dRPalta_Fech_Pesa, dr.dRPalta_Peso_Bruto, dr.dRPalta_Tara, dr.dRPalta_Canti, dr.dRPalta_Peso, dr.dRPalta_PTota, dr.dRPalta_PNeto, dr.dRPalta_esReproceso, dr.dRPalta_esProcesado, dr.dRPalta_Observacion, dr.dRPalta_CoBar FROM DETALLE_RECEPCION_PALTA AS dr INNER JOIN RECEPCION_PALTA AS dp ON dr.idRecepcionPalta = dp.idRecepcionPalta INNER JOIN ESTADO AS est ON dr.idEstado = est.idEstado WHERE dp.idRecepcionPalta = 1 AND est.idEstado = 1



