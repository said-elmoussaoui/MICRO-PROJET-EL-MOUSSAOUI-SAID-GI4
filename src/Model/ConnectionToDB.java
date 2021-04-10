package Model;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionToDB{
	private  Connection connection = null;
	private  Statement statement = null;
	public ConnectionToDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_project","root","");
			statement = connection.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void close()  {
		try {
		if(this.connection != null) connection.close();
		}catch(SQLException er) {
			er.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ConnectionToDB db = new ConnectionToDB();
	}
}
