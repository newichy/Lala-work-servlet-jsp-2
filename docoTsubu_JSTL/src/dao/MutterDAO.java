package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	// データベース接続情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Mutter> findAll() {
		
		List<Mutter> mutterList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS) ){
			// SELECT文の準備
			String sql = "SELECT id,name,text FROM mutter ORDER BY id DESC";	// DESC：降順
			PreparedStatement pStmt = conn.prepareStatement(sql);				// ASC:昇順
			
			// SELECT文を実行
			ResultSet rs = pStmt.executeQuery();
			
			// 実行結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id,userName,text);
				mutterList.add(mutter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}
	
	
	public boolean create(Mutter mutter) {
		
		// データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			// INSERT文の準備、IDはオートインクリメントなので不要
			String sql = "INSERT INTO mutter(name, text) VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」を設定
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			
			// INSERT文を実行、resultには追加された行数が入る
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
