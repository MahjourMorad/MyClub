package appli;



import java.sql.*;
import javax.swing.*;
/**
 * @author MAHJOUR MORAD
 * @author LAMYAA RAKIK*/
public class dbconnect {
	Connection con=null;
	/** 
	 * etablir la connection avec la db*/
	public static Connection java_db(){
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
			return con;
		}catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;

		}
	}

}
