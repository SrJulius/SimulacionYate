package yate.simulator;

public class Config {
	
	public final static int CONSUMO_BATERIAS = 20; //Cantidad de bateria que consume el yate por velocidad
	public final static int CARGA_BATERIAS = 15; //Cantidad que le carga el panel a una bateria estando el sol al 100%
	public final static int CAPACIDAD_BATERIAS = 300; //Capacidad total que pueden almacenar de las baterias
	
	public final static int NIVEL_INICIAL_SOL = 100; //Porcentaje con el que empieza el sol
	public final static int DESCARGA_SOL = 2; //Porcentaje que baja el sol despues del lapso establecido
	public final static int LAPSO_DESCARGA = 2; //Laspso en segundos que durara el sol en bajar el porcentaje en segundos
	
	public final static int NUMERO_BATERIAS = 2; //Numero de baterias que tendra el yate
	public final static int NUMERO_PANELES  = 3; //Numero de paneles que tendra el yate
	
	public final static int LAPSO_AUMENTO_VELOCIDAD = 5; //Lapso de tiempo en segundos que durara el yate en cambiar de velocidad
	public final static int MAXIMO_VELOCIDAD = 5; //Nivel maximo de velocidad que alcanza el yate
	
	public final static int DURACION_SIMULACION = 70000; //Duracion de la simulacion en milisegundos, debe ser un valor entre 60,000 y 90,000 (1 minuto y minuto y medio)

}
