package step_one;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginServlet")//����web.xml��һ����ע�ᣬ�ڿ����У�������������
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = -6202847712652584835L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		System.out.println(username +" : "+pwd);
		String value = Util.getProperty(username, "users.properties");
		if(null != value && value.equals(pwd)){
			//����key/value�Ե�session������ȥ
			req.getSession().setAttribute("user", new User(username, pwd));
			//����session�Ĺ���ʱ��Ϊ5���ӣ�sessionʧЧ��-��session�������ˣ��������ȼ�����web.xml������
			req.getSession().setMaxInactiveInterval(60*5);
			//url��ַ�����ı�
			resp.sendRedirect("index.jsp");
		}else{
			//url��ַ�������ı�
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
	}
}
