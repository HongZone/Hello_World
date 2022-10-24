package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;


@WebServlet("/addMemberServlet")
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddMemberServ() {
        super();

    }

    //get 방식의 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// content 타입을 지정.
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("/addMemberser 페이지입니다");
		String empId = request.getParameter("employee_id");
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");
				System.out.println(empId);
				
				//입력
				EmpDAO dao = new EmpDAO();
				EmployeeVO empVO = new EmployeeVO(0,lName,email,hireDate,jobId);
				dao.insertEmp(empVO);
				
				
//				System.out.println("사원번호:"+ dao.empnum());
//				System.out.println("이름 :"+lName);
//				System.out.println("메일:"+email);
//				System.out.println("입사날짜:"+hireDate);
//				System.out.println("직종:"+jobId);
				
				PrintWriter out = response.getWriter(); //출력스트림
				out.print("<h1>입력결과: </h1>");
				out.print("<h4>사원번호: "+dao.empnum()+"</h4>");
				out.print("<h4>이름 : "+lName+"</h4>" );
				out.print("<h4>메일: "+email+"</h4>");
				out.print("<h4>입사날짜: "+hireDate+"</h4>" );
				out.print("<h4>직종: "+jobId+"</h4>");
				
	}

	//post방식의 요청 시 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
//		doGet(request, response);
		PrintWriter out = response.getWriter(); //사용자의 브라우저(출력스트림 생성)
		out.print("<h3> Post 방식의 요청</h>");
	}

}
