package com.examenFinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.examenFinal.controller.ZooService;

public class App1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ZooService service;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					App1 frame = new App1();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(600, 400);
		contentPane = new JPanel();
		service = new ZooService();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPanel AnimalPanel = service.getView().getContentPane(); 
		
		setContentPane(AnimalPanel);
	}

}
