package spittr.data;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Random;

import spittr.Spitter;
import spittr.Spittle;

//@Repository
public class MockSpittleRepository implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		List<Spittle> spittleList = new ArrayList<>();
		for(int i=0;i<count;i++){
			spittleList.add(new Spittle(
					"Spittle message "+i,
					new Date(System.currentTimeMillis()), 
					Double.valueOf(new Random().nextDouble()*100),
					Double.valueOf(new Random().nextDouble()*100),
					Long.valueOf(i)));
		}
		return spittleList;
	}
	
	@Override
	public Spittle findSpittleById(Long id){
		return new Spittle(
				"Spittle message "+id, 
				 new Date(System.currentTimeMillis()), 
				 Double.valueOf(new Random().nextDouble()*100),
				 Double.valueOf(new Random().nextDouble()*100), id);
	}

	public void addSpitter(Spitter spitter) {
		// TODO Auto-generated method stub
		
	}

	public Spitter findSpitterById(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
