package Todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		long id = Integer.parseInt(request.getParameter("id"));
		String regDate = request.getParameter("regDate");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String name = request.getParameter("name");

		TodoDto dto = new TodoDto();
		dto.setId(id);
		dto.setName(name);
		dto.setRegDate(regDate);
		dto.setSequence(sequence);
		dto.setTitle(title);
		dto.setType(type);

		TodoDao dao = TodoDao.getInstance();
		dao.updateTodo(dto);

		response.sendRedirect("index.jsp");
	}

}
