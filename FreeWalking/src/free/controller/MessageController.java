package free.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import free.domain.MemberTour;
import free.domain.Message;
import free.service.MemberTourService;
import free.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	MessageService mservice;
	@Autowired
	MemberTourService mtoservice;

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
	
	@RequestMapping(value="regmessage.ajax", method=RequestMethod.POST)
	public @ResponseBody boolean regMessage(String uid, String content,String fromid){
		//현재날짜
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy/MM/dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		Message msg = new Message(content, dTime, fromid, uid);
		
		System.out.println(uid);
		System.out.println(content);
		System.out.println(fromid);
		System.out.println ( dTime );
		
		return mservice.registerMessage(msg);
	}
	
	@RequestMapping(value="finduser.ajax", method=RequestMethod.POST)
	public @ResponseBody List<MemberTour> selectUser(String tid){
		System.out.println(tid);
		List<MemberTour> list = mtoservice.findMemberByMemberTour(Integer.parseInt(tid));
		
		return list;
	}
	
}
