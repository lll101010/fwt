package free.dao;

import java.util.List;

import free.domain.Message;

public interface MessageDao {
	
	public boolean createMessage(Message message);
	
	public boolean deleteMessage(int messageId);
	
	public Message searchMessageById(int messageId);
	
	public List<Message> searchMessageByToMemberId(String memberId);
	
	public List<Message> searchMessageByFromMemberId(String memberId);
	

}
