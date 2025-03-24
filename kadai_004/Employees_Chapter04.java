package kadai_004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employees_Chapter04 {

	public static void main(String[] args) {
		
		 	Connection employees = null;
	        Statement statement = null;
	
		 try {
	            // データベースに接続
			 	employees = DriverManager.getConnection(
	                "jdbc:mysql://localhost/challenge_java",
	                "root",
	                "A28-0167d"
	            );
	            
	            System.out.println("データベース接続成功"+employees);
	            
	         // SQLクエリを準備
	            statement = employees.createStatement();
	            String sql = """
	            		CREATE TABLE users (
	            		 id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	            		 name VARCHAR(60) NOT NULL,
	            		 email VARCHAR(255)NOT NULL,
	            		 age INT(11),
	            		 address VARCHAR(255)
	            		 );
	            		""";
	            
	         //　SQLクエリを実行（DBMSに送信）
	            int rcdCnt = statement.executeUpdate(sql);
	            System.out.println("社員テーブルを作成しました:更新レコード数="+rcdCnt);

		 } catch(SQLException e) {
	            System.out.println("エラー発生：" + e.getMessage());
	        } finally {
	            // 使用したオブジェクトを解放
	            if( statement != null ) {
	                try { statement.close(); } catch(SQLException ignore) {}
	            }
	            if( employees != null ) {
	                try { employees.close(); } catch(SQLException ignore) {}
	            }
	        }
	    }
	
	}
