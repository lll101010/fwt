package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.MemberLocationDao;
import free.domain.MemberLocation;
import free.domain.Message;

@Repository
public class MemberLocationDaoLogic implements MemberLocationDao{
	
	private static final String SQL_INSERT_MemberLocation = "INSERT INTO tourMember_location_free VALUES(location_free_seq.nextVal, ?, ?,?,?)";
	private static final String SQL_UPDATE_MemberLocation = "UPDATE tourMember_location_free SET latitude=?, longitude=? WHERE memberid=? and tourid = ?";
	private static final String SQL_SELECT_MemberLocation = "SELECT id,memberid,tourid,latitude,longitude FROM tourMember_location_free WHERE tourid = ? ORDER BY id desc";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean createMemberLocation(MemberLocation memberLocation) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_INSERT_MemberLocation, new Object[] {memberLocation.getMemberid(),memberLocation.getTourid(),memberLocation.getLatitude(),memberLocation.getLongitude()}) > 0;
	}

	@Override
	public boolean updateMemberLocation(MemberLocation memberLocation) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_UPDATE_MemberLocation, new Object[] {memberLocation.getLatitude(),memberLocation.getLongitude(),memberLocation.getMemberid(),memberLocation.getTourid()}) > 0;
	}

	@Override
	public List<MemberLocation> searchByTourid(int tourid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_SELECT_MemberLocation, new Object[]{tourid}, MemberLocationDaoLogic::mappingMemberLocation);
	}
	
	
	private static MemberLocation mappingMemberLocation(ResultSet rs, int rowNum) throws SQLException {
		MemberLocation ml = new MemberLocation();
		ml.setId(rs.getInt("id"));
		ml.setMemberid(rs.getString("memberid"));
		ml.setTourid(rs.getInt("tourid"));
		ml.setLatitude(rs.getString("latitude"));
		ml.setLongitude(rs.getString("longitude"));
		return ml;
	}

	
	
}
