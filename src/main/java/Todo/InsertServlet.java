package Todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset utf-8;");
	
		String title = request.getParameter("what");
		String name = request.getParameter("who");
		String sequence = request.getParameter("rank");

		System.out.println("제목 : " + title + " 작성자 : " + name + "우선순위 : " + sequence);

		TodoDto dto = new TodoDto();
		dto.setTitle(title);
		dto.setName(name);
		dto.setSequence(Integer.parseInt(sequence));
		
		TodoDao dao = TodoDao.getInstance();
		dao.insertTodo(dto);
		
		response.sendRedirect("index.jsp");
	}

}
