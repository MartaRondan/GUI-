import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Bill extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	JTextField id = null;

	public Bill(){
		
		
		this.setSize(300,300);
		this.setVisible(true);
		this.setTitle("Dr. StrangeLove Practice");
		this.setLayout(new GridLayout(3,2,1,1));
		
		JLabel idLabel = new JLabel("Patient ID: ");
		id = new JTextField(20);
		this.add(idLabel);
		this.add(id);
		
		JButton search = new JButton("Search");
		search.addActionListener(this);
		search.setActionCommand("search");
		this.add(search);
		
		JButton quit = new JButton("Quit"); 
		quit.addActionListener(this);
		quit.setActionCommand("Quit");
		this.add(quit);
		
		
		validate();
		repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
				if(e.getActionCommand().equals("search")){
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception ex ){}
			
			
			Connection conn = null;
	    	Statement stmt = null;
	    	ResultSet rs = null;
	    	Object [][]data = new Object[20][4];
	    	
	    	try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

	    	    stmt = conn.createStatement();
	    	    
	    	    String pid = id.getText();
	    	    
	    	    if (stmt.execute("SELECT * FROM `gui`.`billing` WHERE (`patient_id` = '"+pid+"');")) {
	    	        rs = stmt.getResultSet();
	    	    }
	    	    
	    	    
	    	    int rowCounter = 0;
	    	    
	    	    JFrame viewTable = new JFrame();
    	    	viewTable.setSize(400, 400);
    	  
	    	    
	    	    while(rs.next()){
	    	    	
	    	    	String patient_id = rs.getString("patient_id");
	    	    	data[rowCounter][0] = patient_id;
	    	    	System.out.println(patient_id);
	    	    	
	    	    	String service = rs.getString("service");
	    	    	data[rowCounter][1] = service;
	    	    	
	    	    	String price = rs.getString("price");
	    	    	data[rowCounter][2] = price;
	    	    	
	    	    	String paid = rs.getString("paid");
	    	    	data[rowCounter][3] = paid;
	    	    	
	    	    	rowCounter++;
	    	    	
	    	    	String[] columnNames = {"patient_id","service","price","paid"};
	    	    	
	    	    			JTable table = new JTable(data, columnNames);
	    	    			JScrollPane jsp = new JScrollPane(table);
	    	    		  	viewTable.setVisible(true);
	    	    			viewTable.add(jsp);
	    	    			
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
}
