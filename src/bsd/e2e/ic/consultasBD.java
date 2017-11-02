package bsd.e2e.ic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class consultasBD {
	
static String	SQL = 	"  select " + 
						"COMPOSITE_DN , " + 
						"count(COMPOSITE_DN) CANTIDAD " + 
						"from COMPOSITE_INSTANCE " + 
						"where CREATED_TIME >= trunc(sysdate-7) " + 
						"and STATE = 1 " + 
						"group by COMPOSITE_DN " + 
						"order by COMPOSITE_DN  desc";

	
public String obtieneFecha() 
{
	String F;
//	Context initCtx = new InitialContext();
//	Context envCtx = (Context) initCtx.lookup("java:comp/env");
//	DataSource ds = (DataSource)
//	  envCtx.lookup("jdbc/OSM");
//  
//	Connection conn = ds.getConnection();
//	Statement stmt = null;
//	ResultSet rs = null;
//	stmt = conn.createStatement();
//	rs = stmt.executeQuery(SQL);
//	while(rs.next()){
//		System.out.println("----Prueba----"+rs.getString("FECHA"));
//	conn.close();
//	
	Connection conn = null;
	Statement stmt =null;
	ResultSet rs = null;
	String URL = "jdbc:oracle:thin:@172.30.13.37:1521:OSM";
	String USER="MDWDESA_SOAINFRA";
	String PASS="OsmM4n4g3r$";
	
	try 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn =  DriverManager.getConnection(URL,USER,PASS);
		stmt =  conn.createStatement();
		rs = stmt.executeQuery(SQL);
		while(rs.next())
		{
			System.out.println("COMPOSITE_DN: "+ rs.getString(1)+"/STATE:"+rs.getString(2));
		}
	
		
	}	catch(SQLException se)
	{
		System.out.println("SQLError: " + se.getMessage()
		+ "Code: "+ se.getErrorCode());
		
	}catch (Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}finally {
	
	try {
		rs.close();
		stmt.close();
		conn.close();
	} catch (Exception e2) {
		e2.printStackTrace();
	}
	}
	


return null;
}


}
