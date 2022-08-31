package yate.simulator;

public class Bateria {
	
	private int nivel_de_carga = Config.CAPACIDAD_BATERIAS;
	
	public Bateria() {}

	public int getNivelDeCarga() {
		return nivel_de_carga;
	}
	

	public void descargarBateria(int pDescarga) {
		
		this.nivel_de_carga -= pDescarga;
		
	}
	
	public void cargarBateria(int pCarga) {
		this.nivel_de_carga = nivel_de_carga + pCarga;
		
	}
}


