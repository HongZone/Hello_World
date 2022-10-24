package co.edu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	//servlet 관리
	//url 주소와 실행할 서블릿을 map타입으로 관리
	Map<String, Command> map = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException {
		map.put("/first.do", new FirstImpl());
		map.put("/second.do", new SecondImpl());
		map.put("/third.do", new ThirdImpl()); 
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); //http:/localhost:8081/HelloWeb/first.do
		String contextPath = req.getContextPath(); //uri에서 프로젝트 정보를 반환해주는 메소드
		String path = uri.substring(contextPath.length());
		
//		System.out.println("uri: " +uri);
//		System.out.println("contextPath: " +contextPath);
//		System.out.println("path: " +path);
//		
		Command command = map.get(path);
		command.exec(req,resp);
	}
	
	
}
