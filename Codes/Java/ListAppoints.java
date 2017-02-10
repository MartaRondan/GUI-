import java.awt.BorderLayout;
import java.awt.GridLayout;
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




public class ListAppoints extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListAppoints(){


		this.setSize(300,300);
		this.setVisible(true);

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

		}catch(Exception e ){}


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object [][]data = new Object[10][3];

		try {
			conn =
					DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

			stmt = conn.createStatement();

			if (stmt.execute("SELECT * FROM `gui`.`appointments`;")) {
				rs = stmt.getResultSet();
			}

			int rowCounter = 0;

			while(rs.next()){

				String patientId = rs.getString("patient_id");
				data[rowCounter][0] = patientId;

				String date = rs.getString("date");
				data[rowCounter][1] = date;

				String time = rs.getString("time");
				data[rowCounter][2] = time;

				rowCounter++;

				String[] columnNames = {"patient_id","date","time"};

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
