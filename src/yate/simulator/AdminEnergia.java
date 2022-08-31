package yate.simulator;

import java.util.ArrayList;


public class AdminEnergia extends Thread{
	
	private ArrayList<Bateria> lista_baterias;
	private ArrayList<PanelSolar> lista_paneles;
	private Yatch yate;
	
	public AdminEnergia(Yatch pYate) {
		
		yate = pYate;
		this.lista_baterias = new ArrayList<Bateria>();
		this.lista_paneles = new ArrayList<PanelSolar>();
		
		
	}
	

	public void agregarBaterias(int pNumBaterias) {
		for(int i = 0; i < pNumBaterias ;i++) {
			
			Bateria bat = new Bateria();
			this.lista_baterias.add(bat);
			}
	}
	
	public void agregarPaneles(int pNumPaneles) {
	for (int i = 0; i < pNumPaneles ;i++) {
			PanelSolar pan = new PanelSolar(yate);
			this.lista_paneles.add(pan);
			}
	}
	
	
		public void getArrays() {
		for(int i = 0; i <lista_baterias.size();i++) {
			System.out.println("--->"+lista_baterias.get(i));
		}
		
		for (int i = 0; i <lista_paneles.size();i++) {
			System.out.println("--->"+lista_paneles.get(i));
			
		}
	}
		
		
		public void descargar(byte pVelocidad) { //Metodo para descargar por velocidad del yate
			
			Bateria bateria;
			int requiere = pVelocidad*Config.CONSUMO_BATERIAS;
			
			for (int x = 0; x < lista_baterias.size();x++) {
				bateria = lista_baterias.get(x);
				
				if (bateria.getNivelDeCarga() >= requiere ) {
					bateria.descargarBateria(requiere);
					break;
					}
				else {
					continue;
				}
			}
			
		}
		
		public void descargar(int pConsumo) { //Metodo para descargar mediante un nuevo objeto cualquiera que requiera energia, consumira mendiante este metodo
			
			Bateria bateria;
			
			for (int x = 0; x < lista_baterias.size();x++) {
				bateria = lista_baterias.get(x);
				
				if (bateria.getNivelDeCarga() >= pConsumo ) {
					bateria.descargarBateria(pConsumo);
					break;
					}
				else {
					continue;
				}
			}
			
		}
		
		
		public int[] getniveles() { //Recorre el ArrayList de las baterias, obtienes los niveles de cada una de las baterias y los retorna a todos en un array
			
			int[] nivelesDeBateria = new int[Config.NUMERO_BATERIAS];
			for (int i = 0; i < Config.NUMERO_BATERIAS;i++) {
				Bateria bat = lista_baterias.get(i);
				int niv = bat.getNivelDeCarga();
				nivelesDeBateria[i] = niv;
			}
			
			
			return nivelesDeBateria;
		}
		
		
		
		
		public void run() { //Este hilo se va a encargar de recargar las baterias constantemente
			int i = 0;
			Bateria bateria;
			int numero_paneles = this.lista_paneles.size();
			PanelSolar paneles = lista_paneles.get(0);
			
			try {
			
				while(i <= Config.DURACION_SIMULACION/1000) {
					
					for (int x = 0; x < lista_baterias.size();x++) {
						bateria = lista_baterias.get(x);
						if (bateria.getNivelDeCarga() < Config.CAPACIDAD_BATERIAS){
							int carga = paneles.carga()*numero_paneles; //Calcula lo que le puede cargar a una bateria
							
							
							if (bateria.getNivelDeCarga() + carga > Config.CAPACIDAD_BATERIAS) { //Mide a ver si la carga que se le va a dar a la bateria excede su nivel de carga maximo
								int diferencia = bateria.getNivelDeCarga() + carga - Config.CAPACIDAD_BATERIAS; //Saca la diferencia que se le debe restar a la carga para que sea acorde a la bateria
								bateria.cargarBateria(carga - diferencia); //Manda la carga a la bateria seleccionada quitandole la diferencia
								break;
								
							} else {
								bateria.cargarBateria(carga); //Si la carga no rebasa la capacidad de la bateria, simplemente se la agrega
								break;
							}
						
							
						}else {
							continue;
					}
				}i++;
				Thread.sleep(1000); //Pone el hilo a dormir por un segundo
			}
			
			
		} catch (Exception expn)  {
        	System.out.println(expn);  
			
		}
			}
		
}
	
	

