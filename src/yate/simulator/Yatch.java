package yate.simulator;

import java.lang.Thread;

public class Yatch extends Thread {
	
	private AdminEnergia admin;
	private byte velocidad = 0;
	private int nivelsol = Config.NIVEL_INICIAL_SOL;
	private int segundosTranscurridos;
	
	public Yatch() {
		
		admin = new AdminEnergia(this); //Instanciacion del admin de energia,
		admin.agregarBaterias(Config.NUMERO_BATERIAS); //Agrega las baterias al admin
		admin.agregarPaneles(Config.NUMERO_PANELES); //Agrega los paneles al admin
		admin.start();
		//admin.getArrays(); //Metodo para verificar los paneles y las baterias
		
		
	}
	
	public void cambiarVelocidad(int i) {
		this.velocidad += (byte) i;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}
	
	public int[] getnivelbaterias() {
		return this.admin.getniveles();
	}
	
	public int getNivelSol() {
		return nivelsol;
	}
	
	public void changeNivelSol() {
		if ((this.nivelsol - Config.DESCARGA_SOL) < 0) {
			this.nivelsol = 0;}
		
		else {
			this.nivelsol -= Config.DESCARGA_SOL;	
		}
		
	}
	
	public int getSegundos() {
		if (segundosTranscurridos > Config.DURACION_SIMULACION/1000)
			return segundosTranscurridos-1;
		else
			return segundosTranscurridos;
	}
	
	public void run() {
		
		segundosTranscurridos = 0;
		int cont = 0;
		int contVel = 0;
		
		while (segundosTranscurridos <= Config.DURACION_SIMULACION/1000) { //Iteracion que detendra el hilo cuando el tiempo configurado termine
			try {
				
			if (segundosTranscurridos < Config.DURACION_SIMULACION/1000)
				this.admin.descargar(velocidad); //Descarga bateria dependiendo de la velocidad a la que se encuentre
				
			if (cont == Config.LAPSO_DESCARGA-1 && !(segundosTranscurridos==10) && !(this.nivelsol <= 0)) { //Revisa si ha pasado el lapso de tiempo para que baje el sol
				this.changeNivelSol();// Cambia el nivel del sol que veran los paneles
				cont = 0;
			}else {
				cont++;
			}
			System.out.println(contVel);
			if (contVel == Config.LAPSO_AUMENTO_VELOCIDAD-1 && !(segundosTranscurridos ==10) && !(this.velocidad >= Config.MAXIMO_VELOCIDAD)) { //Revisa si es hora de subirle la velocidad al yate, y si es posible
				this.cambiarVelocidad(1);
				contVel = 0;
			}else {
				contVel++;
			}
			
			
			segundosTranscurridos++;
			
			 			Thread.sleep(1000);
			
		}catch (Exception expn)  {
        	System.out.println(expn);}
			
		}
			}
}
	
