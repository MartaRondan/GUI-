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

public class NewPat extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	JTextField name = null;
	JTextField email = null;
	JTextField address = null; 
	JTextField contact = null;



	public NewPat(){


		this.setSize(300,300);
		this.setVisible(true);
		this.setLayout(new GridLayout(5,2));



		JLabel nameL = new JLabel("Name: ");
		name = new JTextField(20);
		this.add(nameL);
		this.add(name);


		JLabel emailL = new JLabel("Email: ");
		email = new JTextField(20);
		this.add(emailL);
		this.add(email);


		JLabel addL = new JLabel("Address: ");
		address = new JTextField(20);
		this.add(addL);
		this.add(address);


		


		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setActionCommand("submit");
		this.add(submit);


		JButton reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setActionCommand("clearButton");
		this.add(reset);


		validate();
		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("submit")){
			submit();
		}

		if(e.getActionCommand().equals("reset")){

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


			String nam = name.getText();
			String emai = email.getText();
			String addres = address.getText();
			
			String note = null;


			if (stmt.execute("INSERT INTO `gui`.`patient` (`Name`, `Email`, `Address`,`Notes`) VALUES ('"+nam+"', '"+emai+"', '"+addres+"',  '"+note+"');")) {
				rs = stmt.getResultSet();
			}

			System.out.println("Sucessfully saved");

		} catch (SQLException ex) {
			
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
		JOptionPane.showMessageDialog(this,"Patient Sucessfully Added");

	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
