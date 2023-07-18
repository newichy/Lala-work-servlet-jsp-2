package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {

	// データベース接続に使う情報

	//	H2データベース用
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	//	MySQL用
	//	private final String JDBC_URL = "jdbc:mysql://localhost:3306/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	// 全件取得メソッド
	public List<Employee> findAll() {
		// Employeeオブジェクトを格納するempList（配列）
		List<Employee> empList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SQL文の準備
			String sql = "SELECT id, name, age FROM employee ORDER BY id ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// 実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からレコードごとに取り出し、empListに入れなおす
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
		} catch (SQLException e) { // データベースに接続した時SQLエラーを取得
			e.printStackTrace();
			throw new IllegalStateException("データベースに接続できません");
//			return null;
		}
		return empList;
	}

	// 名前検索メソッド	
	public List<Employee> findAllByName(String name) {
		List<Employee> empList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SQL文の準備
			String sql = "SELECT * FROM employee WHERE name LIKE ? ORDER BY id ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// プレースホルダーを置換
			pStmt.setString(1, "%" + name + "%");

			System.out.println("DAO findEmployeeByName() by : " + name);

			// 実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からレコードごとに取り出し、empListに入れなおす
			while (rs.next()) {
				String id = rs.getString("ID");
				String _name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Employee employee = new Employee(id, _name, age);
				empList.add(employee);
			}
		} catch (SQLException e) { // データベースに接続した時SQLエラーを取得
			e.printStackTrace();
			return null;
		}
		return empList;
	}

	// 一件取得メソッド
	public Employee findEmployeeById(String id) {
		Employee employee = null;

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SQL文の準備
			String sql = "SELECT name, age FROM employee WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// プレースホルダーを置換
			pStmt.setString(1, id);

			System.out.println("DAO findEmployeeById() by id: " + id);

			// 実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からレコードごとに取り出し、empListに入れなおす
			if (rs.next()) {
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				employee = new Employee(id, name, age);
			}

		} catch (SQLException e) { // データベースに接続した時SQLエラーを取得
			e.printStackTrace();
			return null;
		}
		return employee;
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

	public boolean remove(String id) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// DELETE文の準備
			String sql = "DELETE FROM employee WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// プレースホルダーを置換
			pStmt.setString(1, id);

			// SQLの実行、成功件数を返すので受け取る
			int result = pStmt.executeUpdate();

			// 成功件数１の時 true
			return (result == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 新規レコード
	public boolean insert(Employee emp) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// INSERT文の準備実行
			String sql = "INSERT INTO employee VALUES(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());

			int result = pStmt.executeUpdate();

			return (result == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Employee emp) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// INSERT文の準備実行
			String sql = "UPDATE employee SET name=?, age=? WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, emp.getName());
			pStmt.setInt(2, emp.getAge());
			pStmt.setString(3, emp.getId());

			int result = pStmt.executeUpdate();

			return (result == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
