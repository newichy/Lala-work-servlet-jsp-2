package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.dept.Dept;

public class DeptDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/twoTables";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
		
	public List<Dept> findAll() {
		List<Dept> deptList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name FROM dept ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Dept dept = new Dept(id, name);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException("データベースに接続できません。");
			// return null;
		}
		return deptList;
	}
	
	public Dept findDeptById(String id) {
		Dept dept = null;
		
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "SELECT id, name FROM dept "
					+ " WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				dept = new Dept(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return dept;
	}

	public boolean isAlreadyUsedId(String id) {
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "SELECT id FROM dept WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
	
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insert(Dept dept) {
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
	
			String sql = "INSERT INTO dept (id, name) "
					+ " VALUES (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, dept.getId());
			pStmt.setString(2, dept.getName());
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	public boolean remove(String id) {
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
	
			String sql = "DELETE FROM dept WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	public boolean update(Dept dept) {
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
	
			String sql = "UPDATE dept " 
			           + " SET name = ? "
					   + " WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, dept.getName());
			pStmt.setString(2, dept.getId());
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	

}
