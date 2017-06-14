package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.MessageDao;
import free.domain.Message;

@Repository
public class MessageDaoLogic implements MessageDao {

	private static final String SQL_INSERT_MESSAGE = "INSERT INTO message_free VALUES(message_free_seq.nextVal, ?, ?,?,?)";
	private static final String SQL_DELETE_MESSAGE = "DELETE FROM message_free WHERE id = ?";
	private static final String SQL_SELECT_MESSAGE_ID = "SELECT * FROM message_free WHERE id = ?";
	private static final String SQL_SELECT_MESSAGE_TOMEMBERID = "SELECT * FROM message_free WHERE toMemberId= ? order by id desc";
	private static final String SQL_SELECT_MESSAGE_FROMMEBERID = "SELECT * FROM message_free WHERE fromMemberId=?";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean createMessage(Message message) {
		return jdbcTemplate.update(SQL_INSERT_MESSAGE, new Object[] { message.getContents(), message.getRegistDate(),
				message.getFromMemberId(), message.getToMemberId() }) > 0;
	}

	@Override
	public boolean deleteMessage(int messageId) {
		return jdbcTemplate.update(SQL_DELETE_MESSAGE, new Object[] { messageId }) > 0;
	}

	@Override
	public Message searchMessageById(int messageId) {
		return (Message)jdbcTemplate.queryForObject(SQL_SELECT_MESSAGE_ID, new Object[]{messageId}, MessageDaoLogic::mappingMessage);
	}

	@Override
	public List<Message> searchMessageByToMemberId(String memberId) {
		return jdbcTemplate.query(SQL_SELECT_MESSAGE_TOMEMBERID, new Object[]{memberId}, MessageDaoLogic::mappingMessage);
	}

	@Override
	public List<Message> searchMessageByFromMemberId(String memberId) {
		return jdbcTemplate.query(SQL_SELECT_MESSAGE_FROMMEBERID, new Object[]{memberId}, MessageDaoLogic::mappingMessage);
	}

	private static Message mappingMessage(ResultSet rs, int rowNum) throws SQLException {
		Message m = new Message();
		m.setId(rs.getInt("id"));
		m.setContents(rs.getString("contents"));
		m.setRegistDate(rs.getString("registDate"));
		m.setFromMemberId(rs.getString("fromMemberId"));
		m.setToMemberId(rs.getString("toMemberId"));
		return m;
	}

}
