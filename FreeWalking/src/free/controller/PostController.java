package free.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import free.domain.File;
import free.domain.Post;
import free.domain.Tour;
import free.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService service;
	
	@RequestMapping(value="postList.do", method=RequestMethod.GET)
	public String listAllPost(String postUserId, int postPlaceId, Model model) {
		List<Post> posts = service.findPostByPlaceId(postPlaceId);
		
		System.out.println("postUserId : " + postUserId);
		System.out.println("postPlaceId : " + postPlaceId);
		
		model.addAttribute("placeId", postPlaceId);
		model.addAttribute("userId", postUserId);
		model.addAttribute("posts", posts);
		return "postList";
	}
	
	@RequestMapping(value="detail.do")
	public String detailPost(int postId, Model model){
		Post post = service.findPostByPostId(postId);
		List<File> files = service.findFileByPostId(postId);
		model.addAttribute("post", post);
		model.addAttribute("files", files);
		return "postDetail";
	}
	
	@RequestMapping(value="regist.do", method=RequestMethod.GET)
	public String createPost(String placeId, String userId, Model model){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Date date = Date.valueOf(sdf.format(c1.getTime()));
        model.addAttribute("registDate", date);
        
		model.addAttribute("placeId", placeId);
		model.addAttribute("userId", userId);
		return "postForm";
	}
	
	@RequestMapping(value="regist.do", method=RequestMethod.POST)
	public String createPost(HttpServletRequest req, RedirectAttributes redirectAttribute) throws IOException {

		String imgPath = req.getServletContext().getInitParameter("imgPath");
		int sizeLimit = 1024*1024*10;
		MultipartRequest multi = new MultipartRequest(req, imgPath, sizeLimit,"utf-8",new DefaultFileRenamePolicy());
		
		List<File> files = new ArrayList<>();

		Enumeration e = multi.getFileNames();
		String formName;
		String fileName;

		while (e.hasMoreElements()) {
			formName = (String) e.nextElement();
			fileName = multi.getFilesystemName(formName);

			if (fileName != null) {
				File file = new File();
				file.setName(multi.getFilesystemName(formName));
				file.setType(multi.getContentType(formName));
				files.add(file);
			}
		}
		
		Post post = new Post();
		post.setTitle(multi.getParameter("title"));
		post.setContents(multi.getParameter("contents"));
		post.setPlaceId(Integer.valueOf(multi.getParameter("placeId")));
		post.setRegisterId(multi.getParameter("userId"));
		post.setRegistDate(Date.valueOf(multi.getParameter("registDate")));
		post.setFiles(files);
		
		service.registerPost(post, files);
		
		redirectAttribute.addAttribute("postUserId", post.getRegisterId());
		redirectAttribute.addAttribute("postPlaceId", post.getPlaceId());
		
		return "redirect:/postList.do";
	}
	
	@RequestMapping("image.do")
	public void createImage(int postId, int index, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<File> files = service.findFileByPostId(postId);
		String path = "C:/yorizori/";
		String fileName = null;
		InputStream in = null;

		resp.setContentType(files.get(index).getType());
		fileName = path + files.get(index).getName();
		in = new BufferedInputStream(new FileInputStream(fileName));

		OutputStream out = resp.getOutputStream();
		byte[] buf = new byte[8096];
		int readByte = 0;

		while (-1 < (readByte = in.read(buf))) {
			out.write(buf, 0, readByte);
		}
		in.close();
		out.close();

	}

	@RequestMapping(value="update.do", method=RequestMethod.GET)
	public String updatePost(int postId, Model model) {
		Post post = service.findPostByPostId(postId);
		List<File> files = post.getFiles();
		model.addAttribute("post", post);
		model.addAttribute("files", files);
		return "postModify";
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String updatePost(Post post) {
		System.out.println(post.getId());
		service.modifyPost(post);
		return "redirect:/detail.do?postId=" + post.getId();
	}
	
	@RequestMapping("delete.do")
	public String deletePost(String userId, int postId, int postPlaceId, RedirectAttributes redi) {
		service.removePost(postId);
		redi.addAttribute("postPlaceId", postPlaceId);
		redi.addAttribute("postUserId", userId);
		
		return "redirect:/postList.do";
	}
}
