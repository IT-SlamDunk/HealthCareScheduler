package com.jht.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jht.mapper.TimeMapper;
import com.jht.model.MemberDTO;
import com.jht.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	TimeMapper tm;

	@Autowired
	MemberService ms; // MemberService ms = new MemberService();

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

//	컨트롤러의 핵심 코드 : url 주소값에는 이 코드로 인해 /가 자동으로 삽입된다
//  url 주소가 매핑한 주소와 일치하게 되면 아래의 메서드가 실행된다 
	@RequestMapping(value = "/", method = RequestMethod.GET)
//										  개발자가 따로 데이터 전송 방식을 POST로 지정(html, js나 ajax를 통해서)하지 않는 이상
//										  항상 GET으로  전송하는 것이 기본 (일반적으로 form 태그에서만 POST 방식을 사용) 

	public String home(Locale locale, Model model) {
//		       리턴타입  메서드명
// 컨트롤러에서의 메서드명은 크게 의미 없으니 별 생각하지 말 것		

		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		System.out.println(tm.getTime());

		model.addAttribute("serverTime", formattedDate);
//							formattedDate가 담긴 변수  formattedDate가 2023년 11월 22일(수) 시간대를 나타낸다
//							응용하여 model에 있는 값으로 자바에 있는 값에 가져갈 수 있다

		return "home";

//		home으로_메서드 호출부로 반환되어 home 메서드가 실행된다
//		home 메서드 호출부는 servlet-context.xml로 가서 실행된다

//		url 주소값과 리턴받는 값이 다를 때에는 이렇게 메서드에 변수가 할당되어서 리턴받는 값에 따라 url 명령 결과가 달라지지만,
//		아래처럼 url 주소값과 매핑한 파일 이름이 일치할 때에는 따로 하지 않아도 된다

		/*
		 * servlet-context.xml의 매핑 메서드 호출부를 담당하는 코드 <beans:bean
		 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		 * <beans:property name="prefix" value="/WEB-INF/views/" /> <beans:property
		 * name="suffix" value=".jsp" /> </beans:bean>
		 */
	}

	/*
	 * @RequestMapping(value = "MemberRegisterForm", method = RequestMethod.GET)
	 * public void abcdefg(Model model) { // 위의 메서드들과 다르게 변수명에 따로 대입된 값과 리턴받는 값이
	 * 없지만, 매핑값과 jsp 이름이 일치하기에 리턴받는 값과 매개 변수가 불필요 (스프링에서 일치하면 자동 매핑되도록 세팅되어 있음)
	 * model.addAttribute("memberid", "hong1234"); }
	 * 
	 * 
	 * @RequestMapping(value = "member/MemberRegisterForm", method =
	 * RequestMethod.GET) public void abcdefg(Model model) {
	 * model.addAttribute("memberid", "hong1234"); }
	 */

	@RequestMapping(value = "member", method = RequestMethod.GET)
//	매핑 메서드에서 매핑하는 이 값은 DB에서 받는 member 값과는 상관이 없다
	public void abcdefg(Model model) {
	}

	@RequestMapping(value = "member", method = RequestMethod.POST)
//	매핑 메서드에서 매핑하는 이 값은 DB에서 받는 member 값과는 상관이 없다
	public void abcdef(MemberDTO member) {
		ms.write(member);
	}
	
// 	@RequestMapping(value = "memberlist", method = RequestMethod.GET)
	
//  위의 코드는 아래의 코드와 같다_PostMapping으로 작성한다면 Post 방식으로 전송된다 
	
	@GetMapping("memberlist")
	public void memberlist(Model model) {
		model.addAttribute("list", ms.list());
	}

	@GetMapping("memberdetail")
	public void memberdetail(MemberDTO member, Model model) {
		model.addAttribute("detail", ms.detail(member));
		ms.detail(member);
//						DB에 삽입되는 레코드인 사용자 아이디의 값을 넣어도 된다
		

	}
	@PostMapping("modify")
	public String membermodify(MemberDTO member, RedirectAttributes rttr) {
		ms.modify(member);
		
	//	return "memberdetail"; 
	//  forward 방식의 memberdetail.jsp로의 이동 (전송이 한번만 이루어져 업데이트_수정된 컬럼의 값이 반영되지 않는다)
		
		rttr.addAttribute("id", member.getId());
		return "redirect:/memberdetail"; 
	// redirect 방식의 memberdetail.jsp로의 이동  (전송이 두 번 이루어져 업데이트_수정된 컬럼의 값이 반영된다)
	}
	
	
	@PostMapping("remove")
	public String memberremove(MemberDTO member) {
		ms.remove(member);
		return "redirect:/memberlist";
	// 삭제 후 redirect는 사용자로부터 전송받는 데이터가 없기에 getAttribute를 받지 않고 바로 실행시키면 된다
	}
	

//  회원 상세 조회에서 매핑한 id값을 home.jsp로 보낸다

//  만약, value 값이 form 태그의 메서드 전송 방식이 다르다면 값이 같아도 파일 경로를 다르게 인식해서 잡아준다 
	
	@GetMapping("logForm")
		public void loginForm() {
	}
	
	@PostMapping("login")
		public String login(MemberDTO member, HttpSession session) {
			ms.login(member);
	      if(ms.login(member) != null) {
	            session.setAttribute("login",ms.login(member));		     // (session에 select 값 저장)
				return "redirect:/memberlist";
			}else {
				return "logForm";
			 /* return "login";   */
			}
		}
			// DB에서 조회한 id의 값(ms.login(member))이 null 값이
			// 로그인 성공 (session에 id값 저장) 후 목록 화면으로 이동
			// 그렇지 않으면 로그인 실패 후 로그인 화면으로 이동 
	
	
	@PostMapping("logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "logForm";
	}
	
}

// 폴더 경로를 매핑해주는 첫번째 방법
/*		@RequestMapping(value = "board", method = RequestMethod.GET)
			public void boardfile1(Model model) {
		}*/

// 매핑 메서드의 실행
//      메서드의 return 반환 값이 있을 때는  value 값 무시하고 return 값 따라 실행

// ☆ 실행하는 jsp 파일이 다르면 따로 return과 반환 값을 작성해주어야 한다





