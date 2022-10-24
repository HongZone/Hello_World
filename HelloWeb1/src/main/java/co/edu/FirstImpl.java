package co.edu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstImpl implements Command{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//first.do 를 호출하면 first.jsp 페이지 호출
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/first.jsp");
		rd.forward(req, resp);
//		resp.sendRedirect("jsp/first.jsp");
	}
}
