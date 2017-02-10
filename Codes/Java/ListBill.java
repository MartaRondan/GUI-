import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ListBill extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public ListBill(){
		
		this.setSize(300,300);
		this.setVisible(true);
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			Connection conn = null;
	    	Statement stmt = null;
	    	ResultSet rs = null;
	    	Object [][]data = new Object[20][3];
	    	
	    	try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

	    	    stmt = conn.createStatement();
	    	    
	    	    if (stmt.execute("SELECT * FROM `gui`.`billing`;")) {
	    	        rs = stmt.getResultSet();
	    	    }
	    	    
	    	    int rowCounter = 0;
	    	    
	    	    while(rs.next()){
	    	    	
	    	    	String patientId = rs.getString("patient_id");
	    	    	data[rowCounter][0] = patientId;
	    	    	
	    	    	String service = rs.getString("service");
	    	    	data[rowCounter][1] = service;
	    	    	
	    	    	String price = rs.getString("price");
	    	    	data[rowCounter][2] = price;
	    	    	
	    	    	rowCounter++;
	    	    	
	    	    	String[] columnNames = {"patient_id","service","price"};
	    	    	
	    	    	
	    	    			JTable table = new JTable(data, columnNames);
	    	    			JScrollPane jscroll = new JScrollPane(table);
	    	    			this.add(jscroll);
	    	    			
	    	    		validate();
	    	    		repaint();
	    	    }

	    	   
	    	} catch (SQLException ex) {
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	
	}

}