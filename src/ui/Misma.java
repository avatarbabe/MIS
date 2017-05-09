package ui;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Misma extends JFrame {

	public Misma() {
		setTitle("MISMA");
		loadLogin();
		setPreferredSize(new Dimension(600, 500));
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}

	public void loadLogin() {
		getContentPane().removeAll();
		JPanel login = new Login(getWindow());
		add(login);

	}

	public static void main(String[] args) {
		Misma mis = new Misma();
	}
	
	public Misma getWindow(){
		return this;
	}

	public void loadRegisterRoutes() {
		getContentPane().removeAll();
		JPanel registerRoutes = new RegisterRoutes(this);
		add(registerRoutes);
		pack();
		
	}
	public void loadRegisterFuel() {
		getContentPane().removeAll();
		JPanel registerFuel = new RegisterFuel();
		add(registerFuel);
		pack();
	

}
	}
