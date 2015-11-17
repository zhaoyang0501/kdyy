package com.pzy.controller.front;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pzy.entity.Company;
import com.pzy.entity.MsgBoard;
import com.pzy.entity.Notice;
import com.pzy.entity.Problem;
import com.pzy.entity.Submission;
import com.pzy.entity.User;
import com.pzy.service.AreaService;
import com.pzy.service.CategoryService;
import com.pzy.service.CompanyService;
import com.pzy.service.ContestProblemService;
import com.pzy.service.MsgBoardService;
import com.pzy.service.NoticeService;
import com.pzy.service.ProblemService;
import com.pzy.service.SubmissionService;
import com.pzy.service.UserService;
/***
 * @author 263608237@qq.com
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProblemService problemService;
	@Autowired
	private SubmissionService submisstionService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private  ContestProblemService sontestProblemService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private MsgBoardService msgBoardService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping("index")
	public String index() {
		return "example.html";
	}
	
	@RequestMapping("company")
	public String company(Model model) {
		model.addAttribute("companys",companyService.findAll());
		return "company";
	}
	@RequestMapping("order")
	public String order(Model model) {
		model.addAttribute("companys",companyService.findAll());
		model.addAttribute("area",areaService.findAll());
		return "order";
	}
	@RequestMapping("company/{id}")
	public String companyDetail(@PathVariable Long id,Model model ) {
		model.addAttribute("bean",companyService.find(id));
		return "companydetail";
	}
	@RequestMapping("about")
	public String about() {
		return "about";
	}
	/***
	 * 跳转到注册
	 * @return
	 */
	@RequestMapping(value = "register",method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	/***
	 * 提交注册信息
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "register",method = RequestMethod.POST)
	public String doregister(User user,Model model ) {
		model.addAttribute("tip", "注册成功，请登录");
		userService.save(user);
		return "login";
	}
	/***
	 * 登录跳转
	 * @return
	 */
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	/***
	 * 点击登录按钮
	 * @return
	 */
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String dologin(String username,String password,Model model,HttpSession httpSession ) {
		User user=userService.login(username, password);
		model.addAttribute("categorys", categoryService.findAll());
		if(user==null){
			model.addAttribute("tip", "用户名密码不正确");
			return "login";
		}else{
			httpSession.setAttribute("user", user);
			return "problem";
		}
	}
	/***
	 * 退出
	 * @param httpSession
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "loginout",method = RequestMethod.GET)
	public String loginout(HttpSession httpSession, Model model) {
		model.addAttribute("categorys", categoryService.findAll());
		httpSession.removeAttribute("user");
		return "problem";
	}
}

