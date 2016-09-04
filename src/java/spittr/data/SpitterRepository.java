package spittr.data;

import java.util.List;

import spittr.Spitter;

public interface SpitterRepository {
	Spitter findSpitterById(String username);
	void addSpitter(Spitter spitter);
	List<Spitter> showAllSpitters();
}
