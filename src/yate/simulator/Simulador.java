package yate.simulator;

import yate.simulator.controllers.YateMainFrameController;
import yate.simulator.gui.YateMainFrame;

public class Simulador {
	
	
	
	public static void main(String args[]) {
		Yatch yate = new Yatch();
		yate.start();
		
		YateMainFrameController controller = new YateMainFrameController(yate);
		YateMainFrame myyatewindow = new YateMainFrame("Simulador Yate Silent", controller );
		
		
		
		}
	
	
	
			
	}
		
		

