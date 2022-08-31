package yate.simulator;


public class PanelSolar {
	
	private int cargaDeBateria = Config.CARGA_BATERIAS;
	private int cargaAmount;
	private Yatch yate;
	
	public PanelSolar(Yatch pyate){
		yate = pyate;
		
	}
	
	public int carga() {
		cargaAmount = this.cargaDeBateria * yate.getNivelSol() / 100; //Calcula lo que puede cargar a una bateria basado en el porcentaje del sol y nuestra confugiracion de carga
		return cargaAmount;
	}

}
