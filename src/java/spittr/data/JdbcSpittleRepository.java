package spittr.data;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {
	private static final String SELECT_SPITTLE_BY_ID = "select * from spittle where id = ?";
	private JdbcOperations jdbcOperations;
	

	@Autowired
	public JdbcSpittleRepository(JdbcOperations jdbcOperations) {
		// TODO Auto-generated constructor stub
		this.jdbcOperations=jdbcOperations;
	}

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
	public Spittle findSpittleById(Long id) {
		// TODO Auto-generated method stub
		return jdbcOperations.queryForObject(SELECT_SPITTLE_BY_ID,new SpittleRowMapper() ,id);
	}
	
	private static final class SpittleRowMapper implements RowMapper<Spittle> {

		@Override
		public Spittle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Spittle(
					resultSet.getString("message"),
					resultSet.getDate("time"),
					Double.valueOf(resultSet.getString("latitude")), 
					Double.valueOf(resultSet.getString("longtitude"))
					);
		}
		
	}

}
