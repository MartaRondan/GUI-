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

public class ListMessage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public ListMessage(){

		this.setSize(300,300);
		this.setVisible(true);

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

		}catch(Exception e ){}


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object [][]data = new Object[20][10];

		try {
			conn =
					DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

			stmt = conn.createStatement();

			if (stmt.execute("SELECT * FROM `gui`.`message`;")) {
				rs = stmt.getResultSet();
			}
				
			int rowCounter = 0;

			while(rs.next()){
				
				

				String patient_id = rs.getString("patient_id");
				data[rowCounter][0] = patient_id;

				String Name = rs.getString("Name");
				data[rowCounter][1] = Name;

				String Email = rs.getString("Email");
				data[rowCounter][2] = Email;

				String Date = rs.getString("Date");
				data[rowCounter][3] = Date;

				String Time = rs.getString("Time");
				data[rowCounter][4] = Time;

				String Message = rs.getString("Message");
				data[rowCounter][5] = Message;

				rowCounter++;

				String[] columnNames = {"patient_id","Name","Email","Date","Time","Message"};


				JTable table = new JTable(data, columnNames);
				JScrollPane jscroll = new JScrollPane(table);
				this.add(jscroll);

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

