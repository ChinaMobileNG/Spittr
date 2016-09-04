package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

	private JdbcOperations jdbcOperations;
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	private static final String INSERT_SPITTER ="insert into spitter (username,password,first_name,last_name"
			+ ") values (:username,:password,:first_name,:last_name)";
	private static final String SELECT_SPITTER_BY_USERNAME = "select * from spitter where username = ?";
	
	@Autowired
	public JdbcSpitterRepository(JdbcOperations jdbcOperations,
			NamedParameterJdbcOperations namedParameterJdbcOperations) {
		// TODO Auto-generated constructor stub
		this.jdbcOperations=jdbcOperations;
		this.namedParameterJdbcOperations=namedParameterJdbcOperations;
	}

	@Override
	public void addSpitter(Spitter spitter) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("username", spitter.getUsername());
		paramMap.put("password", spitter.getPassword());
		paramMap.put("first_name", spitter.getFirstName());
		paramMap.put("last_name", spitter.getLastName());
		
		namedParameterJdbcOperations.update(INSERT_SPITTER,paramMap);
		
	}

	@Override
	public Spitter findSpitterById(String username) {
		// TODO Auto-generated method stub
		return jdbcOperations.queryForObject(SELECT_SPITTER_BY_USERNAME, new SpitterRowMapper(),username);
	}
	
	private static final class SpitterRowMapper implements RowMapper<Spitter>{

		@Override
		public Spitter mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Spitter(
					resultSet.getString("first_name"), 
					resultSet.getString("last_name"), 
					resultSet.getString("username"),
					resultSet.getString("password")
					);
		}
		
	}

	@Override
	public List<Spitter> showAllSpitters() {
		// TODO Auto-generated method stub
		return null;
	}

}
