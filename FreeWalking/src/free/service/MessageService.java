package free.service;

import java.util.List;

import free.domain.Message;

public interface MessageService {

	public boolean registerMessage(Message message);
	
	public boolean removeMessage(int messageId);
	
	public List<Message> findMessageByFromMemberId(String fromMemberId);
	
	public List<Message> findMessageByToMemberId(String toMemberId);
	
	public int findUnreadMessageByToMemberId(String toMemberId);
}
