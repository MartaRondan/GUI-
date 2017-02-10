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

public class NewMessage extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField id = null;
	JTextField date = null;
	JTextField time = null;
	JTextField msg = null;
	JTextField Email = null;
	String red = "NO";

	public NewMessage(){
		
		this.setSize(300,300);
		this.setVisible(true);
		this.setLayout(new GridLayout(8,2));
		
		JLabel pLabel = new JLabel("Patient ID: ");
		id = new JTextField(20);
		this.add(pLabel);
		this.add(id);
		
		JLabel EmailL = new JLabel("Email: ");
		Email = new JTextField(20);
		this.add(EmailL);
		this.add(Email);
		
		
		JLabel dateLabel = new JLabel("Date: ");
		date = new JTextField(20);
		this.add(dateLabel);
		this.add(date);
		
		JLabel timeLabel = new JLabel("Time: ");
		time = new JTextField(20);
		this.add(timeLabel);
		this.add(time);
		
		JLabel msgLabel = new JLabel("Message: ");
		msg = new JTextField(20);
		this.add(msgLabel);
		this.add(msg);
		
		JButton sendButton = new JButton("Submit");
		sendButton.addActionListener(this);
		sendButton.setActionCommand("submit");
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
		
		if(e.getActionCommand().equals("submit")){
			submit();
		}
		
		
		// TODO Auto-generated method stub
		
	}
	
	public void submit(){
		
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			Connection conn = null;
	    	Statement stmt = null;
	    	ResultSet rs = null;
	    	
	    	
	    	try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

	    	    stmt = conn.createStatement();


	    	    String pid = id.getText();
	    	    String em = Email.getText();
	    	    String dt = date.getText();
	    	    String tm = time.getText();
	    	    String pmsg = msg.getText();
	    	    
	    	  
	    	    
	    	    if (stmt.execute("INSERT INTO `gui`.`message` (`patient_id`, `Email`, `Date`, `Time`, `Message`, `read`) VALUES ('"+pid+"' ,'"+em+"' , '"+dt+"', '"+tm+"', '"+pmsg+"','"+red+"');")) {
	    	        rs = stmt.getResultSet();
	    	    }
 
	    	   
	    	} catch (SQLException ex) {
	    	    
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	    	JOptionPane.showMessageDialog(this,"Your message was sent");
	}
	
	
	

}
