package co.edu.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;

public class FrontController extends HttpServlet {
	
	Map<String, Command> control = new HashMap<>();
	
	@Override
	public void init() throws ServletException { //url 패턴과 실행할 
		control.put("/main.do", new MainControl());
		control.put("/memberAddForm.do", new MemberAddForm());
		control.put("/memberAdd.do", new MemberAddControl());
		
		control.put("/memberModifyForm.do", new MemberModifyForm());
		control.put("/memberModify.do", new MemberModify());
		
		control.put("/memberRemoveForm.do", new MemberRemoveForm());
		control.put("/memberRemove.do", new MemberRemove());
		
		control.put("/memberSearchForm.do", new MemberSearchForm());
		control.put("/memberSearch.do", new MemberSearch());
		
		control.put("/memberList.do", new MemberList());
		
		control.put("/loginFrom.do", new LoginForm());
		control.put("/login.do", new Login());
		control.put("/loginOut.do", new LogOut());
		
		
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Command command = control.get(path);
		command.exec(req, resp);
	}
}
