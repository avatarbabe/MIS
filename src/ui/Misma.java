package ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Misma extends JFrame {

	public Misma() {
		setTitle("MISMA");
		setPreferredSize(new Dimension(400, 400));
		loadLogin();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
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
