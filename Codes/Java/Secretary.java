import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Secretary extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	JTextField clientID = null;



	public Secretary(){




		this.setSize(500,400);
		this.setTitle("Dr. Strange Love Practice");
		this.setVisible(true);



		JPanel pan = new JPanel();
		this.add(pan);



		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);	



		JMenu patients = new JMenu("Patients");
		menubar.add(patients);



		JMenuItem records = new JMenu("Patient Records");
		patients.add(records);
		records.addActionListener(this);



		JMenuItem NewPatient = new JMenuItem("New Patient");
		records.add(NewPatient);
		NewPatient.addActionListener(this);
		NewPatient.setActionCommand("NewPatient");



		JMenuItem call = new JMenu("Phone calls");
		patients.add(call);
		call.addActionListener(this);



		JMenuItem newCall = new JMenuItem("New Call");
		call.add(newCall);
		newCall.addActionListener(this);
		newCall.setActionCommand("newCall");



		JMenuItem listCalls = new JMenuItem("List of Calls");
		call.add(listCalls);
		listCalls.addActionListener(this);
		listCalls.setActionCommand("listCalls");



		JMenuItem remove = new JMenuItem("Remove Patient");
		records.add(remove);
		remove.addActionListener(this);
		remove.setActionCommand("remove");



		JMenuItem list = new JMenuItem("List of Patients");
		records.add(list);
		list.addActionListener(this);
		list.setActionCommand("list");



		JMenuItem appoint = new JMenu("Appointments");
		patients.add(appoint);



		JMenuItem Appoint = new JMenuItem("New Appointment");
		appoint.add(Appoint);
		Appoint.addActionListener(this);
		Appoint.setActionCommand("Appoint");



		JMenuItem listAppoints = new JMenuItem("List of Appointment");
		appoint.add(listAppoints);
		listAppoints.addActionListener(this);
		listAppoints.setActionCommand("listAppoints");



		JMenu billing = new JMenu("Billing");
		menubar.add(billing);



		JMenuItem Bill = new JMenuItem("Patient's bill");
		billing.add(Bill);
		Bill.addActionListener(this);
		Bill.setActionCommand("Bill");



		JMenuItem ListBill = new JMenuItem("List of Bills");
		billing.add(ListBill);
		ListBill.addActionListener(this);
		ListBill.setActionCommand("ListBill");


		
		
		JMenu doctor = new JMenu("Doctor");
		menubar.add(doctor);



		JMenuItem message = new JMenu("Messages");
		doctor.add(message);
		message.addActionListener(this);



		JMenuItem NewMessage = new JMenuItem("New Message");
		message.add(NewMessage);
		NewMessage.addActionListener(this);
		NewMessage.setActionCommand("NewMessage");



		JMenuItem ListMessage = new JMenuItem("List of Messages");
		message.add(ListMessage);
		ListMessage.addActionListener(this);
		ListMessage.setActionCommand("ListMessage");



		JMenu quit = new JMenu("Quit");	
		menubar.add(quit);

		JMenuItem logout = new JMenuItem("Logout");
		quit.add(logout);
		logout.addActionListener(this);
		logout.setActionCommand("logout");


		validate(); 
		repaint();  

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getActionCommand().equals("NewPatient")){
			new NewPat();
		}

		else if(e.getActionCommand().equals("remove")){
			new RemovePatient();
		}

		else if(e.getActionCommand().equals("list")){
			new List();
		}

		else if(e.getActionCommand().equals("Appoint")){
			new Appoints();
		}

		else if(e.getActionCommand().equals("listAppoints")){
			new ListAppoints();
		}

		else if(e.getActionCommand().equals("newCall")){
			new newCall();
		}

		else if(e.getActionCommand().equals("listCalls")){
			new ListCalls();
		}

		else if(e.getActionCommand().equals("NewMessage")){
			new NewMessage();
		}

		else if(e.getActionCommand().equals("ListMessage")){
			new ListMessage();
		}

		else if(e.getActionCommand().equals("ListBill")){ 
			new ListBill();
		}

		else if(e.getActionCommand().equals("Bill")){
			new Bill();
		}

		else if(e.getActionCommand().equals("logout")){
			new Login();
		}
	}

}
