package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployeeSample {
	static final String URL = "jdbc:h2:tcp://localhost/~/example";

	public static void main(String[] args) {
		
		//データベースに接続			   ★getConnection(URL, "ユーザー名", "パスワード")
		try (Connection conn = DriverManager.getConnection(URL, "sa", "")) { // try with resource文 エラーならばファイルを自動的に閉じる
			
			//SELECT文を準備
			String sql = "SELECT id, name, age FROM employee";
			PreparedStatement pStmt =conn.prepareStatement(sql);	// SQLのプリペアードステートメントを作成
			
			//プリペアードステートメントを実行し、結果表をResultSetで取得
			ResultSet rs = pStmt.executeQuery();	// executeQuery() と executeUpdate() がある
			
			//結果表に格納されたレコードの内容を表示
			while(rs.next()) {	//next()を使って、rsに次のデータがあれば"true"を返す。対象レコードを一つずつ進める。
				//
				String id = rs.getString("id");	//各レコードの値の取り出し
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.println("ID:" + id);
				System.out.println("名前:" + name);
				System.out.println("年齢:" + age + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
