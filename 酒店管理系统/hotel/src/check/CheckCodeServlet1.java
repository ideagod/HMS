package check;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * �����֤����֤�Ĺ��� 1.�õ�Session�е���֤�� 2.�õ��û��ύ��������֤�� 3.�����֤ 4.�����֤��Ĳ���
 * 
 * @author Administrator
 *
 */
@WebServlet("/CheckCodeServlet1")
public class CheckCodeServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
	
		HttpSession session = request.getSession();
		String seecode = (String) session.getAttribute("sesscode");
	
		String inputcode = request.getParameter("checkCode");
	

		if (inputcode.equalsIgnoreCase(seecode)) {
		
			request.getRequestDispatcher("/RegisterServlet").forward(request, response);
		} else {
		
			response.getWriter().append(
					"<script>alert('��֤�벻��ȷ���������룡');window.location.href='/hotel/jsp/register.jsp'</script>");

		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}
