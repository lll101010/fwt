package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.PlaceDao;
import free.domain.Place;

@Repository
public class PlaceDaoLogic implements PlaceDao {
	private static final String SQL_INSERT_PLACE = "INSERT INTO place_free VALUES(place_free_seq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_PLACE = "UPDATE place_free SET name=?, latitude=?, longitude=?, country=?, address=?, contents=?";
	private static final String SQL_DELETE_PLACE = "DELETE FROM place_free WHERE id=?";
	private static final String SQL_SELECT_PLACE_ID = "SELECT * FROM place_free WHERE id=?";
	private static final String SQL_SELECT_ALL_PLACE = "SELECT * FROM place_free";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean createPlace(Place place) {
		return jdbcTemplate.update(SQL_INSERT_PLACE,
				new Object[] { place.getName(), place.getLatitude(), place.getLongitude() }, place.getCountry(), place.getAddress(), place.getContents(), place.getCity(), place.getNameKor()) > 0;
	}

	@Override
	public boolean updatePlace(Place place) {
		return jdbcTemplate.update(SQL_UPDATE_PLACE,
				new Object[] { place.getName(), place.getLatitude(), place.getLongitude(), place.getCountry(), place.getAddress(), place.getContents(), place.getCity(), place.getNameKor() }) > 0;
	}

	@Override
	public boolean deletePlace(int placeId) {
		return jdbcTemplate.update(SQL_DELETE_PLACE, new Object[] { placeId }) > 0;
	}

	@Override
	public Place searchPlaceById(int placeId) {
		return (Place) jdbcTemplate.queryForObject(SQL_SELECT_PLACE_ID, new Object[] { placeId },
				PlaceDaoLogic::mappingPlace);
	}

	@Override
	public List<Place> searchAllPlace() {
		return jdbcTemplate.query(SQL_SELECT_ALL_PLACE, new Object[] {}, PlaceDaoLogic::mappingPlace);
	}

	private static Place mappingPlace(ResultSet rs, int rowNum) throws SQLException {
		Place p = new Place();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setLatitude(rs.getString("latitude"));
		p.setLongitude(rs.getString("longitude"));
		p.setCountry(rs.getString("country"));
		p.setAddress(rs.getString("address"));
		p.setContents(rs.getString("contents"));
		p.setCity(rs.getString("city"));
		p.setNameKor(rs.getString("nameKor"));
		return p;
	}

}
