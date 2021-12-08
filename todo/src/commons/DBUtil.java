package commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 톰캣 시작 시 한번만 실행. 마리아db에 연결
@WebListener
public class DBUtil implements ServletContextListener {
	public static Connection conn = null;

    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
    		Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://52.78.157.50:3306/todo", "root", "java1004");
			if (conn != null) {
				System.out.println("MariaDB Connect");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("MariaDB Connect Faild");
			e.printStackTrace();
		}
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
       try {
    	   conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
