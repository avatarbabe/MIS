package ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Misma extends JFrame {

	public Misma() {
		setTitle("MISMA");
		loadLogin();
		setPreferredSize(new Dimension(400, 400));
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void loadLogin() {
		getContentPane().removeAll();
		JPanel login = new Login();
		add(login);

	}

	public static void main(String[] args) {
		Misma mis = new Misma();
	}

}
