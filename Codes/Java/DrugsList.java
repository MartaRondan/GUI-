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




public class DrugsList extends JFrame implements ActionListener {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public DrugsList(){




		this.setSize(300,300);
		this.setTitle("Dr. Strange Love Practice");
		this.setVisible(true);




		try {


			Class.forName("com.mysql.jdbc.Driver").newInstance();



		}catch(Exception e ){}

		
		

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object [][]data = new Object[20][4];

		
		
		try {
			
			
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

			stmt = conn.createStatement();

			if (stmt.execute("SELECT * FROM `gui`.`drugs`;")) {
				rs = stmt.getResultSet();
			
			
			}

			
			int rowCounter = 0;

			
			while(rs.next()){
				
				
				String Drug_id = rs.getString("Drug_id");
				data[rowCounter][0] = Drug_id;

				
				String Drug_Name = rs.getString("Drug_Name");
				data[rowCounter][1] = Drug_Name;

				
				String Drug_register = rs.getString("Drug_register");
				data[rowCounter][2] = Drug_register;

				
				rowCounter++;

				
				String[] columnNames = {"Drug_id","Drug_Name","Drug_Register"};

				
				JTable Jtable = new JTable(data, columnNames);
				JScrollPane Panel = new JScrollPane(Jtable);
				this.add(Panel);
				
				

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
