package bsd.e2e.ic;

import java.sql.SQLException;

import javax.naming.NamingException;

public class Main {

	public static void main(String[] args) throws NamingException, SQLException {
		// TODO Auto-generated method stub
		
		
		consultasBD c = new consultasBD() ;
		

		String Fecha = c.obtieneFecha();
		
	

}
}