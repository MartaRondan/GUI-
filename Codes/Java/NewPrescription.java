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

public class NewPrescription extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField id = null;
	JTextField date = null;
	JTextField drugs = null;
	JTextField msg = null;
	JTextField Email = null;

	public NewPrescription(){
		
		this.setSize(300,300);
		this.setVisible(true);
		this.setTitle("Dr. Strange Love Practice");
		this.setLayout(new GridLayout(8,2));
		
		JLabel pLabel = new JLabel("Patient Name: ");
		id = new JTextField(20);
		this.add(pLabel);
		this.add(id);
		
		JLabel drugL = new JLabel("Drug id: ");
		drugs = new JTextField(20);
		this.add(drugL);
		this.add(drugs);
		
		
		JLabel dateLabel = new JLabel("Date: ");
		date = new JTextField(20);
		this.add(dateLabel);
		this.add(date);
		
		
		
		JLabel msgLabel = new JLabel("Prescription: ");
		msg = new JTextField(20);
		this.add(msgLabel);
		this.add(msg);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setActionCommand("sendButton");
		this.add(submit);
		
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
			submit();
		}
		
		//if(e.getActionCommand().equals("clearButton")){
			//clearButton();
		//}
		// TODO Auto-generated method stub
		
	}
	
	public void submit(){
		
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			Connection conn = null;
	    	Statement stmt = null;
	    	try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

	    	    stmt = conn.createStatement();


	    	    String pid = id.getText();
	    	    String dt = date.getText();
	    	    String tm = drugs.getText();
	    	    String pmsg = msg.getText();
	    	  
	    	    
	    	    if (stmt.execute("INSERT INTO `gui`.`prescription` (`patient_Name`,`Drug_id`, `date`, `prescription`) VALUES ('"+pid+"' , '"+dt+"', '"+tm+"', '"+pmsg+"');")) {
	    	        stmt.getResultSet();
	    	    }
 
	    	   
	    	} catch (SQLException ex) {
	    	    
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	
	
	JOptionPane.showMessageDialog(this,"Your prescription was saved");
		
	}
	
}



