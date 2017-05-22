package edu.grupp1.ui;

import edu.grupp1.domain.User;

public interface ISubject {
	
	public void addObserver(Misma misma);
	public void removeObserver(Misma misma);
	public void notifyObserver(Misma misma);
	
}
