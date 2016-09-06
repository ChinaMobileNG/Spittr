package spittr.data;

import java.util.List;

import spittr.Spitter;

public interface SpitterRepository {
	Spitter findSpitterByUsername(String username);
	void addSpitter(Spitter spitter);
	List<Spitter> showAllSpitters();
	Spitter validateSpitter(String username,String password);
}
