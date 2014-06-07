package pg_con_test;
import java.io.*;
import java.sql.*;
import java.lang.*;
import org.postgresql.*;
public class Pg_con_test {

	public static void main(String[] args) {
		try{
			Class.forName("postgresql.Driver");
		}catch(ClassNotFoundException e){
			System.err.println("Class Not Found:"+e.getMessage());
		}
		try{
			String url = "jdbc:postgresql://192.168.42.103:5447/postgres";
			Connection db = DriverManager.getConnection(url, "postgres", "New1234!");
			Statement s = db.createStatement();
			ResultSet rs = s.executeQuery("select �й�, �̸��� from �л�");
			while(rs.next()){
				int id = rs.getInt("�й�");
				String name = rs.getString("�̸���");
				System.out.println("�й�"+id+", �̸�:"+name);
			}
			rs.close();
			s.close();
			db.close();
				
			
		}catch (SQLException e){
			System.err.println("SQL error : "+e.getMessage());
		}
		
	}

}