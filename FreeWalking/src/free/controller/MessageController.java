package free.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import free.domain.Message;
import free.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	MessageService mservice;

	@RequestMapping(value="getmessage.ajax", method = RequestMethod.POST)
	public @ResponseBody List<Message> getMessageById(String uid){
		
		System.out.println(uid);
		
		List<Message> list = mservice.findMessageByToMemberId(uid);
		
		return list;
	}
	
	@RequestMapping(value="delmessage.ajax", method=RequestMethod.POST)
	public @ResponseBody boolean deleteMessage(String mid){
		System.out.println(mid);
		return mservice.removeMessage(Integer.parseInt(mid));
	}
	
}
