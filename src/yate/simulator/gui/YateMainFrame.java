package yate.simulator.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.util.ArrayList;

import yate.simulator.Config;
import yate.simulator.controllers.YateMainFrameController;

public class YateMainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private YateMainFrameController controller;
	private ArrayList<JLabel> arrayLabelsBaterias;
	
	public YateMainFrame(String pTitle, YateMainFrameController pController) {
		super(pTitle);
		controller = pController; //Frame ve al controller
		controller.setWindow(this);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, 600, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		this.arrayLabelsBaterias = new ArrayList<JLabel>();
		this.initComponents();
		
		this.setVisible(true);
		
		
			
		}
		
	
	private void initComponents() {
				
		JLabel captionNivelSol = new JLabel("Nivel del sol que reciben los paneles: ");
		captionNivelSol.setBounds(10,20,250,20);
		this.add(captionNivelSol);
		
		JLabel nivelSol = new JLabel(Integer.toString(controller.getSolDisplay()));
		nivelSol.setBounds(230,20,100,20);
		this.add(nivelSol);
		
		JLabel captionVelocidad = new JLabel("Velocidad: ");
		captionVelocidad.setBounds(270,20,70,20);
		this.add(captionVelocidad);
		
		JLabel velocidad = new JLabel(Integer.toString(controller.getVelocidadDisplay()));
		velocidad.setBounds(335,20,50,20);
		this.add(velocidad);
		
		JLabel captionBaterias = new JLabel("Baterias");
		captionBaterias.setBounds(10,80,100,20);
		this.add(captionBaterias);
		
		JLabel captionSegundos = new JLabel("Segundos transcurridos: ");
		captionSegundos.setBounds(380,20,150,20);
		this.add(captionSegundos);
		
		JLabel segundos = new JLabel(Integer.toString(controller.getSegundosDisplay()));
		segundos.setBounds(540,20,150,20);
		this.add(segundos);
		
		
			
		int posiciony =	100;
		for (int i = 0; i<Config.NUMERO_BATERIAS;i++) {
			JLabel LBat = new JLabel();
			LBat.setBounds(10, posiciony, 160, 20);
			this.add(LBat);
			
			this.arrayLabelsBaterias.add(LBat);
			posiciony += 25; 
		}
		
		
		ActionListener actualizar = new ActionListener() { //Listener para actualizar displays
			public void actionPerformed(ActionEvent evnt) {
				
				nivelSol.setText(Integer.toString(controller.getSolDisplay())); //Actualiza el sol en los paneles
				
				int[] bateriasTotal = controller.getBateriasDisplay();
				for (int i = 0; i < Config.NUMERO_BATERIAS;i++) { //Actualiza el display de cada bateria que existe
					JLabel batlabel = arrayLabelsBaterias.get(i);
					batlabel.setText(Integer.toString(bateriasTotal[i]));
				}
				
				segundos.setText(Integer.toString(controller.getSegundosDisplay())); //Actualiza el display de los segundos
				
				velocidad.setText(Integer.toString(controller.getVelocidadDisplay()));
				
			}
		};
		
		Timer timer = new Timer(100, actualizar);
		timer.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   }
}