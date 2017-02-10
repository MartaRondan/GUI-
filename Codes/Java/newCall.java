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

public class newCall extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField id = null;
	JTextField name = null;
	JTextField date = null;
	JTextField time = null;
	
	public newCall(){
	
		this.setSize(300,300);
		this.setVisible(true);
		this.setLayout(new GridLayout(5,2));
		
		JLabel idL = new JLabel("ID: ");
		id = new JTextField(20);
		this.add(idL);
		this.add(id);
		
		JLabel dateLabel = new JLabel("Date: ");
		date = new JTextField(20);
		this.add(dateLabel);
		this.add(date);
		
		JLabel timeLabel = new JLabel("Time: ");
		time = new JTextField(20);
		this.add(timeLabel);
		this.add(time);
		
		JButton sendButton = new JButton("Submit");
		sendButton.addActionListener(this);
		sendButton.setActionCommand("submit");
		this.add(sendButton);
		
		
		
		
		validate();
		repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("submit")){
			submit();
		}
		
		
		
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

	    	    String ptId = id.getText();
	    	    String dt = date.getText();
	    	    String tm = time.getText();
	    	   
	    	    
	    	    if (stmt.execute("INSERT INTO `gui`.`calls` (`patient_id`, `date`, `time`) VALUES ('"+ptId+"' , '"+dt+"', '"+tm+"');")) {
	    	        rs = stmt.getResultSet();
	    	    }
	    	    System.out.println("Calls updated");
	    	   
	    	} catch (SQLException ex) {
	    	   
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}

	
	    	JOptionPane.showMessageDialog(this,"Calls was updated");
	
	}}
	
	
	
		
	

