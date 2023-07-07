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
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	// 結果取得メソッド
	public List<Employee> findAll(){
		// Employeeオブジェクトを格納するempList（配列）
		List<Employee> empList = new ArrayList<>();
		
		try( Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			// SQL文の準備
			String sql = "SELECT id, name, age FROM employee";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// 実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表からレコードごとに取り出し、empListに入れなおす
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Employee employee = new Employee(id,name,age);
				empList.add(employee);
			}
		}catch(SQLException e) {	// データベースに接続した時SQLエラーを取得
			e.printStackTrace();
			return null;
		}
		return empList;
	}
}
