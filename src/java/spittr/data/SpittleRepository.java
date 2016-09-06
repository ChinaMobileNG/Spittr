package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepository {
	void createSpittles(long max,int count);
	Spittle findSpittleById(Long id);
	void addSpittle(Spittle spittle);
	List<Spittle> findAllSpittles();
}
