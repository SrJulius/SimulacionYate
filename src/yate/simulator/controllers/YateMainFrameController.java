package yate.simulator.controllers;

import yate.simulator.Yatch;
import yate.simulator.gui.YateMainFrame;

public class YateMainFrameController {
	private YateMainFrame controlledFrame;
	private Yatch yate;
	
	
	
	
	public YateMainFrameController(Yatch pyate) {
		this.yate = pyate;
	}

	public void setWindow(YateMainFrame pFrame) {
		controlledFrame = pFrame;
	}
	
	public int getSolDisplay() {
		return yate.getNivelSol();
	}
	public int[] getBateriasDisplay() {
		return yate.getnivelbaterias();
	}
	public int getVelocidadDisplay() {
		return yate.getVelocidad();
	}
	public int getSegundosDisplay() {
		return yate.getSegundos();
	}
}
