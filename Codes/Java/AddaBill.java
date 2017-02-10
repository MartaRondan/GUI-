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

public class AddaBill extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JTextField Price = null;
	JTextField id = null;
	JTextField date = null;
	JTextField Service = null;
	JTextField msg = null;
	JTextField Email = null;

	public AddaBill(){
		
		this.setSize(300,300);
		this.setVisible(true);
		this.setTitle("Dr. Strange Love Practice");
		this.setLayout(new GridLayout(8,2));
		
		JLabel pLabel = new JLabel("Patient ID: ");
		id = new JTextField(20);
		this.add(pLabel);
		this.add(id);
		
		JLabel serviceL = new JLabel("Service: ");
		Service = new JTextField(20);
		this.add(serviceL);
		this.add(Service);
		
		
		JLabel PriceL = new JLabel("Price: ");
		Price = new JTextField(20);
		this.add(PriceL);
		this.add(Price);
		
		
		
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
	    	    String dt = Service.getText();
	    	    String tm = Price.getText();
	    	    String pai = "NO";
	    	  
	    	    
	    	    if (stmt.execute("INSERT INTO `gui`.`billing` (`patient_id`,`service`, `price`, `paid`) VALUES ('"+pid+"' , '"+dt+"', '"+tm+"', '"+pai+"');")) {
	    	        stmt.getResultSet();
	    	    }
 
	    	   
	    	} catch (SQLException ex) {
	    	    
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	
	
	JOptionPane.showMessageDialog(this,"Bill ready");
		
	}
	
}



