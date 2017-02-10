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
import javax.swing.JWindow;


public class Login extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	JFrame Jframe = new JFrame();
	JTextField username = null;
	JTextField password = null;



	public Login(){



		this.setSize(300,300);
		this.setVisible(true);
		this.setTitle("Dr. StrangeLove Practice");
		this.setLayout(new GridLayout(3,2,1,1));



		JLabel userL = new JLabel("Username: ");
		username = new JTextField(20);
		this.add(userL);
		this.add(username);



		JLabel passL = new JLabel("Password: ");
		password = new JTextField(20);
		this.add(passL);
		this.add(password);



		JButton login = new JButton("Login");
		login.addActionListener(this);
		login.setActionCommand("login");
		this.add(login);



		JButton quit = new JButton("Quit"); 
		quit.addActionListener(this);
		quit.setActionCommand("Quit");
		this.add(quit);




		validate();
		repaint();




	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getActionCommand().equals("login")){



			try {

				Class.forName("com.mysql.jdbc.Driver").newInstance();

			}catch(Exception e1 ){}


			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;



			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");


				stmt = conn.createStatement();



				String un = username.getText();
				String ps = password.getText();



				if (stmt.execute("SELECT * FROM `gui`.`users` WHERE (`Username` = '"+un+"' and `Password` = '"+ps+"');")) {
					rs = stmt.getResultSet();
				}



				while(rs.next()){



					String type = rs.getString("type");


					if(type.equals("doctor")){

						this.setVisible(false);
						JOptionPane.showMessageDialog(this,"Hello Dr.StrangeLove");


						new DrStrangeLove();


					}
					else if(type.equals("secretary")){

						this.setVisible(false);
						JOptionPane.showMessageDialog(this,"Hello Betty");


						new Secretary();

					}

					else if(type.equals("billing")){

						this.setVisible(false);
						JOptionPane.showMessageDialog(this,"Hello Chris!");


						new Billing();


					}

				} 

			} catch (SQLException ex) {

				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}





		}

		else if(e.getActionCommand().equals("quit")){


		}

	}

}
