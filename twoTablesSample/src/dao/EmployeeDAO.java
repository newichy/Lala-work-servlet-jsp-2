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
import model.dept.FindDeptByIdLogic;

public class EmployeeDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/twoTables";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private final String SQL_FIND_ALL = 
			"SELECT "
			+ "  e.id AS id, "
			+ "  e.name AS name, "
			+ "  e.age AS age, "
			+ "  d.id AS dept_id, "
			+ "  d.name AS dept_name "
			+ " FROM employee e "
			+ "  JOIN dept d "
			+ "  ON e.dept_id = d.id "
			+ " ORDER BY e.id";
	
	private final String SQL_FIND_BY_NAME =
			"SELECT "
			+ "  e.id AS id, "
			+ "  e.name AS name, "
			+ "  e.age AS age, "
			+ "  d.id AS dept_id, "
			+ "  d.name AS dept_name "
			+ " FROM employee e "
			+ "  JOIN dept d "
			+ "  ON e.dept_id = d.id "
			+ " WHERE e.name like ? "
			+ " ORDER BY e.id";
	private final String SQL_FIND_BY_DEPT_ID =
	"SELECT "
	+ "  e.id AS id, "
	+ "  e.name AS name, "
	+ "  e.age AS age, "
	+ "  d.id AS dept_id, "
	+ "  d.name AS dept_name "
	+ " FROM employee e "
	+ "  JOIN dept d "
	+ "  ON e.dept_id = d.id "
	+ " WHERE d.id = ? "
	+ " ORDER BY e.id";
	
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {			
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept_id = rs.getString("dept_id");
				String dept_name = rs.getString("dept_name");
				Dept dept = new Dept(dept_id, dept_name);
				Employee employee = new Employee(id, name, age, dept);
				empList.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException("データベースに接続できません。");
			// return null;
		}
		return empList;
	}
	
	public boolean isAlreadyUserdId(String id) {
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "SELECT id FROM employee WHERE id = ?";
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

	public boolean insert(Employee employee) {
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
	
			String sql = "INSERT INTO employee (id, name, age, dept_id) "
					+ " VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, employee.getId());
			pStmt.setString(2, employee.getName());
			pStmt.setInt(3, employee.getAge());
			pStmt.setString(4, employee.getDept().getId());
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

	public Employee findEmployeeById(String id) {
		Employee employee = null;
		
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "SELECT id, name, age, dept_id FROM employee "
					+ " WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept_id = rs.getString("dept_id");
				FindDeptByIdLogic logic = new FindDeptByIdLogic();
				Dept dept = logic.execute(dept_id);
				employee = new Employee(id, name, age, dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employee;
	}

	public boolean update(Employee employee) {
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
	
			String sql = "UPDATE employee " 
			           + " SET name = ?, age = ?, dept_id = ? "
					   + " WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, employee.getName());
			pStmt.setInt(2, employee.getAge());
			pStmt.setString(3,  employee.getDept().getId());
			pStmt.setString(4, employee.getId());
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
	
			String sql = "DELETE FROM employee WHERE id = ?";
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

	public List<Employee> findEmpListByName(String _name) {
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
			
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_NAME);
			pStmt.setString(1, "%"+_name+"%");
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept_id = rs.getString("dept_id");
				String dept_name = rs.getString("dept_name");
				Dept dept = new Dept(dept_id, dept_name);
				Employee emp = new Employee(id, name, age, dept);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}

	public List<Employee> findEmpListByDeptId(String dept_id) {
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = 
				DriverManager.getConnection
				    (JDBC_URL, DB_USER, DB_PASS)) {
			
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_DEPT_ID);
			pStmt.setString(1, dept_id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept_name = rs.getString("dept_name");
				Dept dept = new Dept(dept_id, dept_name);
				Employee emp = new Employee(id, name, age, dept);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}

}
