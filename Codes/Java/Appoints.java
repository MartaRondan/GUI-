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
import javax.swing.JTextField;

public class Appoints extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JTextField id = null;
	JTextField date = null;
	JTextField time = null;
	
	public Appoints(){
		
		this.setSize(300,300);
		this.setVisible(true);
		this.setLayout(new GridLayout(5,2));
		
		JLabel idLabel = new JLabel("ID: ");
		id = new JTextField(20);
		this.add(idLabel);
		this.add(id);
		
		JLabel dateLabel = new JLabel("Date: ");
		date = new JTextField(20);
		this.add(dateLabel);
		this.add(date);
		
		JLabel timeLabel = new JLabel("Time: ");
		time = new JTextField(20);
		this.add(timeLabel);
		this.add(time);
		
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(this);
		sendButton.setActionCommand("sendButton");
		this.add(sendButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		clearButton.setActionCommand("clearButton");
		this.add(clearButton);
		
		
		validate();
		repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("sendButton")){
			sendButton();
		}
		
		if(e.getActionCommand().equals("clearButton")){
			
		}

	}
	
	public void sendButton(){
		
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			Connection conn = null;
	    	Statement stmt = null;
	    	ResultSet rs = null;
	    	
	    	
	    	try {
	    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

	    	    stmt = conn.createStatement();


	    	    String p_Id = id.getText();
	    	    String dat = date.getText();
	    	    String tim = time.getText();
	    	    
	    	    
	    	    if (stmt.execute("INSERT INTO `gui`.`appointments` (`patient_id`, `date`, `time`) VALUES ('"+p_Id+"' , '"+dat+"', '"+tim+"');")) {
	    	        rs = stmt.getResultSet();
	    	    }
 
	    	   
	    	} catch (SQLException ex) {
	    	    
	    		
	    		
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}	
	}
}
