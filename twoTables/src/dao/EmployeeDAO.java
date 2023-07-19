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

public class EmployeeDAO {

	//	H2データベース用
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/twoTables";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	private final String SQL_FIND_ALL = "SELECT "
			+ "	e.id AS id, "
			+ "	e.name AS name, "
			+ "	e.age AS age, "
			+ "	e.dept_id AS dept_id, "
			+ "	d.name AS dept_name "
			+ " FROM employee e "
			+ " JOIN dept d "
			+ "	ON e.dept_id = d.id "
			+ " ORDER BY e.id;";

	// 全件取得メソッド
	public List<Employee> findAll() {
		// Employeeオブジェクトを格納するempList（配列）
		List<Employee> empList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SQL文の準備
			String sql = SQL_FIND_ALL;
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// 実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からレコードごとに取り出し、empListに入れなおす
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				String dept_id = rs.getString("DEPT_ID");
				String dept_name = rs.getString("DEPT_NAME");
				Dept dept = new Dept(dept_id, dept_name);
				Employee employee = new Employee(id, name, age, dept);
				empList.add(employee);
			}
		} catch (SQLException e) { // データベースに接続した時SQLエラーを取得
			e.printStackTrace();
			throw new IllegalStateException("データベースに接続できません");
			// return null;
		}
		return empList;
	}

	public boolean isAlreadyUsedId(String id) {

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SQL文の準備
			String sql = "SELECT id FROM employee WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// プレースホルダーを置換
			pStmt.setString(1, id);

			// 実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果があればtrue
			if (rs.next()) {
				System.out.println("DAO isAlreadyUsedId() by id: " + id + " result:true");
				return true;
			}

		} catch (SQLException e) { // データベースに接続した時SQLエラーを取得
			e.printStackTrace();
			System.out.println("DAO isAlreadyUsedId() by id: " + id + " result:false");
			return false;
		}
		return false;
	}

	// 新規レコード
	public boolean insert(Employee emp) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// INSERT文の準備実行
			String sql = "INSERT id, name, age, dept INTO employee VALUES(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());
			pStmt.setString(4, emp.getDept().getId());

			int result = pStmt.executeUpdate();

			return (result == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
