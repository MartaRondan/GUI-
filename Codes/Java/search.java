import java.awt.BorderLayout;
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

public class search extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JTextField id = null;
	

	
	
	

public search() {
		
	this.setSize(300,300);
	this.setVisible(true);
	this.setTitle("Dr. StrangeLove Practice");
	this.setLayout(new GridLayout(3,2));
	

	
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("search")){
			
			
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

		}catch(Exception ex ){}


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object [][]data = new Object[40][40];

		try {
			conn =
					DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

			stmt = conn.createStatement();

			String pid = id.getText();

			if (stmt.execute("SELECT * FROM `gui`.`patient` WHERE (`patient_id` = '"+pid+"');")) {
				rs = stmt.getResultSet();
			}


			int rowCounter = 0;

			JFrame viewTable = new JFrame();
			viewTable.setSize(400, 400);


			while(rs.next()){

				String patient_id = rs.getString("patient_id");
				data[rowCounter][0] = patient_id;
				System.out.println(patient_id);

				String name = rs.getString("Name");
				data[rowCounter][1] = name;

				String price = rs.getString("Email");
				data[rowCounter][2] = price;

				String add = rs.getString("Address");
				data[rowCounter][3] = add;
				
				String note = rs.getString("Notes");
				data[rowCounter][3] = add;

				rowCounter++;

				String[] columnNames = {"patient_id","Name","Email","Address","Notes"};

				JTable table = new JTable(data, columnNames);
				JScrollPane jsp = new JScrollPane(table);
				viewTable.setVisible(true);
				viewTable.add(jsp);
				
			
			

				
			}
			
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
			    
		}}}	
	
	
		
		
		
	


