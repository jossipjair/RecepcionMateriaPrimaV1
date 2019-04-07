CREATE PROCEDURE spPesadoVsProcesado
@fechaPesado DATETIME,
@fechaProceso DATETIME
AS BEGIN

	DECLARE @procesadoJabas AS INT
	DECLARE @pesadoJabas AS INT
	DECLARE @pesadoNeto AS NUMERIC(15,4)
	DECLARE @procesadoNeto AS NUMERIC(15,4)

	--JABAS EN CANTIDADES--
	SET @procesadoJabas = (SELECT SUM([dRPalta_Canti])
					FROM [dbo].[DETALLE_RECEPCION_PALTA] 
					WHERE [dRPalta_esProcesado] = 1
					AND cast([dRPalta_Fech_Proc] as date) = '2018-03-09')

	SET @pesadoJabas = (SELECT SUM([dRPalta_Canti])
					FROM [dbo].[DETALLE_RECEPCION_PALTA] 
					WHERE [dRPalta_esProcesado] = 0
					AND cast([dRPalta_Fech_Pesa] as date)= CAST('2018-03-08 08:55:26.000' AS date))
	--PESO NETO--
	SET @procesadoNeto = (SELECT SUM([dRPalta_PNeto])
					FROM [dbo].[DETALLE_RECEPCION_PALTA] 
					WHERE [dRPalta_esProcesado] = 1
					AND cast([dRPalta_Fech_Proc] as date) = '2018-03-08')

	SET @pesadoNeto = (SELECT SUM([dRPalta_PNeto])
					FROM [dbo].[DETALLE_RECEPCION_PALTA] 
					WHERE [dRPalta_esProcesado] = 0
					AND cast([dRPalta_Fech_Pesa] as date)= '2018-03-08')
	SELECT @pesadoJabas AS [JABAS PESADAS], @procesadoJabas AS [JABAS PROCESADAS],
			 @pesadoNeto AS [PESO NETO PENDIENTE],@procesadoNeto AS [PESO NETO PROCESADO]
	FROM DETALLE_RECEPCION_PALTA
END
GO

select * from DETALLE_RECEPCION_PALTA
