import java.awt.BorderLayout;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public  class DrStrangeLove extends JFrame implements ActionListener{
	public static void main(String[] args){
		new DrStrangeLove();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JScrollPane Panel;
	private JTable Jtable;

	JTextField id = null;


	public DrStrangeLove(){




		this.setSize(400,300);
		this.setTitle("Dr. Strange Love Pratice");
		this.setVisible(true);
		this.setLayout(new BorderLayout());


		JMenuBar menu01 = new JMenuBar();
		this.setJMenuBar(menu01);

		JMenu pat = new JMenu ("Patients");
		menu01.add(pat);



		JMenuItem NewPat = new JMenuItem ("New Patient");
		pat.add(NewPat);
		NewPat.addActionListener(this);
		NewPat.setActionCommand("NewPat");

		JMenuItem Rem = new JMenuItem ("Remove Patient");
		pat.add(Rem);
		Rem.addActionListener(this);
		Rem.setActionCommand("Rem");

		JMenuItem List = new JMenuItem ("Patient List");
		pat.add(List);
		List.addActionListener(this);
		List.setActionCommand("List");

		JMenuItem search = new JMenuItem ("Search by ID");
		pat.add(search);
		search.addActionListener(this);
		search.setActionCommand("search");

		



		JButton submit = new JButton("Login");

		submit.addActionListener(this);

		this.add(submit);



		JMenu medication = new JMenu("Medication");
		menu01.add(medication);



		JMenuItem presc = new JMenu ("Prescriptions");
		medication.add(presc);
		presc.addActionListener(this);



		JMenuItem NewPresc = new JMenuItem ("New Pescription");
		presc.add(NewPresc);
		NewPresc.addActionListener(this);
		NewPresc.setActionCommand("NewPresc");


		JMenuItem drugs = new JMenu ("Drugs");
		medication.add(drugs);
		drugs.addActionListener(this);



		JMenuItem addDrug = new JMenuItem ("Add");
		drugs.add(addDrug);
		addDrug.addActionListener(this);
		addDrug.setActionCommand("addDrug");



		JMenuItem DrugsList = new JMenuItem ("Drugs List");
		drugs.add(DrugsList);
		DrugsList.addActionListener(this);
		DrugsList.setActionCommand("DrugsList");



		JMenu quit = new JMenu("Quit");	
		menu01.add(quit);



		JMenuItem logout = new JMenuItem("Logout");
		quit.add(logout);
		logout.addActionListener(this);
		logout.setActionCommand("logout");





		try {



			Class.forName("com.mysql.jdbc.Driver").newInstance();




		}catch(Exception e ){}




		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object [][]data = new Object[20][10];
		String read = "NO";



		try {


			conn =
					DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");


			stmt = conn.createStatement();


			if (stmt.execute("SELECT * FROM `gui`.`message`"));{
				rs = stmt.getResultSet();
			}



			int rowCounter = 0;

			System.out.println("test");

			while(rs.next()){
				if(rs.getString("read") != "YES"){

					String mess_id = rs.getString("mess_id");
					data[rowCounter][0] = mess_id;

					String patient_id = rs.getString("patient_id");
					data[rowCounter][1] = patient_id;

					String Name = rs.getString("Name");
					data[rowCounter][2] = Name;

					String Email = rs.getString("Email");
					data[rowCounter][3] = Email;


					String Date = rs.getString("Date");
					data[rowCounter][4] = Date;

					String Time = rs.getString("Time");
					data[rowCounter][5] = Time;

					String Message = rs.getString("Message");
					data[rowCounter][6] = Message;

					//String read1 = rs.getString("read");
					//data[rowCounter][7] = read1;

					rowCounter++;

					String[] columnNames = {"mess_id","patient_id","Name","Email","Date","Time","Message"};



					Jtable = new JTable(data, columnNames);
				}}

		} catch (SQLException ex) {

			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		JButton update = new JButton ("Update");
		update.addActionListener(this);
		update.setActionCommand("update");

		Panel = new JScrollPane(Jtable);
		this.add(Panel);
		this.setVisible(true);
		this.add(update, BorderLayout.SOUTH);

		repaint();
		validate();			    
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getActionCommand().equals("NewPat")){
			new NewPat();
		}

		else if(e.getActionCommand().equals("Rem")){
			new RemovePatient();
		}

		else if(e.getActionCommand().equals("List")){
			new List();
		}

		else if(e.getActionCommand().equals("presc")){
			new Prescription();
		}

		else if(e.getActionCommand().equals("NewPresc")){
			new NewPrescription();
		}

		else if(e.getActionCommand().equals("DrugsList")){
			new DrugsList();
		}

		else if(e.getActionCommand().equals("update")){
			update();
		}

		else if(e.getActionCommand().equals("logout")){
			new Login();
		}


		else if(e.getActionCommand().equals("search")){
			new search();

		}}
	
	
	


	public void update(){
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

		}catch(Exception e ){}


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object [][]data = new Object[10][5];
		String message = "You don't have any messages";


		try {
			conn =
					DriverManager.getConnection("jdbc:mysql://127.0.0.1:1000/gui?user=root&password=");

			stmt = conn.createStatement();


			if (stmt.execute("UPDATE `gui`.`message` SET `read` ='YES' WHERE `read`='NO';")){
				rs = stmt.getResultSet();

			}
			if (stmt.execute("DELETE FROM `gui`.`message` WHERE `read`='YES';")) {
    	        rs = stmt.getResultSet();
    	        System.out.println(message);
    	        
    	    }
				
		} catch (SQLException ex) {

			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}



	}

	
		
		
	}







