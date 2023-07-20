package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dept.Dept;

public class DeptDAO {

	//	H2データベース用
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/twoTables";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	// 全件取得メソッド
	public List<Dept> findAll() {
		// Deptオブジェクトを格納するdeptList（配列）
		List<Dept> deptList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SQL文の準備
			String sql = "SELECT id, name FROM dept ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// 実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からレコードごとに取り出し、empListに入れなおす
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				Dept dept = new Dept(id, name);
				deptList.add(dept);
			}
		} catch (SQLException e) { // データベースに接続した時SQLエラーを取得
			e.printStackTrace();
			throw new IllegalStateException("データベースに接続できません");
			// return null;
		}
		return deptList;
	}

	// 一件取得メソッド
	public Dept findDeptById(String id) {
		Dept dept = null;

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SQL文の準備
			String sql = "SELECT id, name FROM dept WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// プレースホルダーを置換
			pStmt.setString(1, id);

			System.out.println("DAO findDeptById() by id: " + id);

			// 実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からレコードごとに取り出し、empListに入れなおす
			if (rs.next()) {
				String _id = rs.getString("ID");
				String name = rs.getString("NAME");
				dept = new Dept(_id, name);
			}

		} catch (SQLException e) { // データベースに接続した時SQLエラーを取得
			e.printStackTrace();
			return null;
		}
		return dept;
	}
	
	public boolean isAlreadyUsedId(String id) {

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SQL文の準備
			String sql = "SELECT id FROM dept WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// プレースホルダーを置換
			pStmt.setString(1, id);

			// 実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果があればtrue
			if (rs.next()) {
				System.out.println("DeptDAO isAlreadyUsedId() by id: " + id + " result:true");
				return true;
			}

		} catch (SQLException e) { // データベースに接続した時SQLエラーを取得
			e.printStackTrace();
			System.out.println("DeptDAO isAlreadyUsedId() by id: " + id + " result:false");
			return false;
		}
		return false;
	}
	
	// 新規レコード
		public boolean insert(Dept dept) {
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
				// INSERT文の準備実行
				String sql = "INSERT INTO dept VALUES(?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, dept.getId());
				pStmt.setString(2, dept.getName());

				int result = pStmt.executeUpdate();

				return (result == 1);

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
}
