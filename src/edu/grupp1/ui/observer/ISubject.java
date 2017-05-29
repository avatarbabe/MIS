package edu.grupp1.ui.observer;

import edu.grupp1.domain.User;
import edu.grupp1.ui.swing.Misma;

public interface ISubject {
	
	public void addObserver(Misma misma);
	public void removeObserver(Misma misma);
	public void notifyObserver(Misma misma);
	
}
