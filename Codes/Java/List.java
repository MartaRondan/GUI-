import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class List extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public List(){



		this.setSize(300,300);
		this.setTitle("Dr. Strange Love Practice");
		this.setVisible(true);


		try {


			Class.forName("com.mysql.jdbc.Driver").newInstance();



		}catch(Exception e ){}

		

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object [][]data = new Object[10][5];

		
		
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");
			

			stmt = conn.createStatement();

			
			if (stmt.execute("SELECT * FROM `gui`.`patient`;")) {
				rs = stmt.getResultSet();
			
			}

			int rowCounter = 0;

			while(rs.next()){

				String patient_id = rs.getString("patient_id");
				data[rowCounter][0] = patient_id;

				String name = rs.getString("Name");
				data[rowCounter][1] = name;

				String email = rs.getString("Email");
				data[rowCounter][2] = email;

				String address = rs.getString("Address");
				data[rowCounter][3] = address;

				String phone = rs.getString("Contact");
				data[rowCounter][4] = phone;

				rowCounter++;
				

				String[] columnNames = {"Patient_id", "Name", "Email", "Address", "Contact"};

				JTable table = new JTable(data, columnNames);
				JScrollPane jsp = new JScrollPane(table);
				this.add(jsp);

				validate();
				repaint();
			}


		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	@Override 
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}


}

