package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.MessageDao;
import free.domain.Message;
import free.service.MessageService;

@Service
public class MessageServiceLogic implements MessageService {
	@Autowired
	private MessageDao dao;

	@Override
	public boolean registerMessage(Message message) {
		return dao.createMessage(message);
	}

	@Override
	public boolean removeMessage(int messageId) {
		return dao.deleteMessage(messageId);
	}

	@Override
	public List<Message> findMessageByFromMemberId(String fromMemberId) {
		return dao.searchMessageByFromMemberId(fromMemberId);
	}

	@Override
	public List<Message> findMessageByToMemberId(String toMemberId) {
		return dao.searchMessageByToMemberId(toMemberId);
	}

	@Override
	public int findUnreadMessageByToMemberId(String toMemberId) {
		return 0;
	}

}
