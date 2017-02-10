import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Billing extends JFrame implements ActionListener {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public Billing(){
			
			
			
			
			this.setSize(500,400);
			this.setTitle("Dr. Strangelove Practice");
			this.setVisible(true);
			
			JPanel jpanel = new JPanel();
			this.add(jpanel);
			
			
			
			JMenuBar menubar = new JMenuBar();
			this.setJMenuBar(menubar);
			
			
			
				JMenu print = new JMenu("Patient's Bill");
				menubar.add(print);
				
				
				
					JMenuItem search = new JMenuItem("Search");
					print.add(search);
					search.addActionListener(this);
					search.setActionCommand("search");
					
					
					JMenuItem add = new JMenuItem("Add a Bill");
					print.add(add);
					add.addActionListener(this);
					add.setActionCommand("AddaBill");
					
			
				
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
			
			if(e.getActionCommand().equals("search")){
				new Bill();
			}
			
			else if(e.getActionCommand().equals("logout")){
				logout();
			}
			
			else if(e.getActionCommand().equals("AddaBill")){
				new AddaBill();
			}
		}
		
		
		public void logout(){
			new Login();
			
		}

}
