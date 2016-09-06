package spittr.data;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {
	private static final String SELECT_SPITTLE_BY_ID = "select * from spittle where spittle_id = ?";
	private static final String INSERT_SPITTLE="insert into spittle(message,time,longtitude,latitude,id) "
			+ " values(:message,:time,:longtitude,:latitude,:id)";
	private static final String FIND_ALL_SPITTLES = "select * from spittle";
	private JdbcOperations jdbcOperations;
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	

	@Autowired
	public JdbcSpittleRepository(JdbcOperations jdbcOperations,
			NamedParameterJdbcOperations namedParameterJdbcOperations) {
		// TODO Auto-generated constructor stub
		this.jdbcOperations=jdbcOperations;
		this.namedParameterJdbcOperations=namedParameterJdbcOperations;
	}

	@Override
	public void createSpittles(long max, int count) {
		// TODO Auto-generated method stub
		for(int i=0;i<count;i++){
			addSpittle(new Spittle(
					"Spittle message "+i,
					new Date(System.currentTimeMillis()), 
					Double.valueOf(new Random().nextDouble()*100),
					Double.valueOf(new Random().nextDouble()*100),
					Long.valueOf(i)));
		}
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
					Double.valueOf(resultSet.getString("longtitude")),
					Long.valueOf(resultSet.getString("spittle_id"))
					);
		}
		
	}

	@Override
	public void addSpittle(Spittle spittle) {
		// TODO Auto-generated method stub
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("message", spittle.getMessage());
		parameter.put("time", spittle.getTime());
		parameter.put("longtitude", spittle.getLongtitude());
		parameter.put("latitude", spittle.getLatitude());
		parameter.put("id", spittle.getId());
		
		namedParameterJdbcOperations.update(INSERT_SPITTLE, parameter);
	}

	@Override
	public List<Spittle> findAllSpittles() {
		// TODO Auto-generated method stub
		List<Spittle> spittles = jdbcOperations.query(FIND_ALL_SPITTLES,new SpittleRowMapper());
		return spittles;
	}

}
