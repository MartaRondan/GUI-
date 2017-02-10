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

public class Prescription extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	JTextField id = null;
	JTextField med01 = null;
	JTextField med02 = null;

	public Prescription(){

		this.setSize(300,300);
		this.setVisible(true);
		this.setLayout(new GridLayout(5,2));

		JLabel idLabel = new JLabel("Patient ID: ");
		id = new JTextField(20);
		this.add(idLabel);
		this.add(id);

		JLabel drug1Lbl = new JLabel("Drug: ");
		med01 = new JTextField(20);
		this.add(drug1Lbl);
		this.add(med01);

		JLabel drug2Lbl = new JLabel("Drug: ");
		med02 = new JTextField(20);
		this.add(drug2Lbl);
		this.add(med02);

		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(this);
		sendButton.setActionCommand("sendButton");
		this.add(sendButton);

		
		validate();
		repaint();


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("sendButton")){
			sendButton();
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
			conn =
					DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

			stmt = conn.createStatement();


			String pid = id.getText();
			String dr1 = med01.getText();
			String dr2 = med02.getText();


			if (stmt.execute("INSERT INTO `gui`.`prescription` (`patient_id`, `med01`, `med02`) VALUES ('"+pid+"', '"+dr1+"', '"+dr2+"');")) {
				rs = stmt.getResultSet();
			}

			
		} catch (SQLException ex) {

			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

}

