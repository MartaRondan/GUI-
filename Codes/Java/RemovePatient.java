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
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class RemovePatient extends JFrame implements ActionListener {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JTextField patient_id = null;
	
	
	
	public RemovePatient(){
		
		
		this.setSize(300,300);
		this.setVisible(true);
		this.setTitle("Dr. Strange Love Practice");
		this.setLayout(new GridLayout(3,2,1,1));
		
		JLabel idLabel = new JLabel("Patient ID: ");
		patient_id = new JTextField(20);
		this.add(idLabel);
		this.add(patient_id);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(this);
		delete.setActionCommand("delete");
		this.add(delete);
		
		validate();
		repaint();
		
	}
	
		

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("delete")){
			
			try {
				
				  Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				}catch(Exception ex ){}
				
				
				Connection conn = null;
		    	Statement stmt = null;
		    	ResultSet rs = null;
		    	Object [][]data = new Object[20][4];
		    	
		    	try {
		    		
		    		
		    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

		    	    stmt = conn.createStatement();
		    	    
		    	    String p_id = patient_id.getText();
		    	    
		    	    if (stmt.execute("DELETE FROM `gui`.`patient` WHERE (`patient_id` = '"+p_id+"');")) {
		    	        rs = stmt.getResultSet();
		    	        
		    	    }
		    	    
		    	} catch (SQLException ex) {
		    		
		    		System.out.println("SQLException: " + ex.getMessage());
		    		System.out.println("SQLState: " + ex.getSQLState());
		    		System.out.println("VendorError: " + ex.getErrorCode());
		    		
		    	  }
		    	
		    	JOptionPane.showMessageDialog(this,"Patient file removed!");
		}
	}
}

