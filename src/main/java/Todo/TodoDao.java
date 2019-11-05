package Todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
	private static TodoDao instance = new TodoDao();

	public static TodoDao getInstance() {
		return instance;
	}

	private TodoDao() {
	}

	public void insertTodo(TodoDto dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/db";
		String id = "root";
		String pw = "1234";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);

			String sql = "insert into todo(title,name,sequence) values(?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getSequence());

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}

	public List<TodoDto> selectTodo() {
		List<TodoDto> list = new ArrayList<TodoDto>();
		Connection con = null;
		PreparedStatement ps = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/db";
		String id = "root";
		String pw = "1234";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);

			String sql = "select id, title, name, sequence, type, regdate from todo";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TodoDto dto = new TodoDto();
				dto.setId(rs.getLong("id"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setSequence(rs.getInt("sequence"));
				dto.setType(rs.getString("type"));
				dto.setRegDate(rs.getString("regdate"));
				list.add(dto);
			}

			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return list;
	}

	public void updateTodo(TodoDto dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/db";
		String id = "root";
		String pw = "1234";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);

			String sql = null;
			if (dto.getType().equals("TODO")) {
				sql = "update todo set type = 'DOING' where id = ?;";
			} else {
				sql = "update todo set type = 'DONE' where id = ?;";
			}

			ps = con.prepareStatement(sql);
			ps.setLong(1, dto.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}
}