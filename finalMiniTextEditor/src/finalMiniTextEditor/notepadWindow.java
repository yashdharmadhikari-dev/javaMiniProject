//started : 24/01/2022
//pending task: 1. Implementation on font styles. 
//				2. Adding listener to Menu section



/*Day 2: 
 * PENDING WORK - GIVE SHORTCUTS TO MENU ITEMS
 *				  LIST 4 ITEMS & REDO THE LOGIC OF LIST
 **/


package finalMiniTextEditor;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JButton;

public class notepadWindow {
	
	String helperStatement = "Welcome to Mini Text Editor\n\nHere are some"
			+ " point's that you should keep in mind of while using our application: "
			+"\n\n1. You need to select at least two of the list for effects to be seen."+
			"\n2.There is no way to restore the text once not saved and deleted."+"\n"
					+ "3. You must need basic computer knowledge to operate our application."
			+"\n4. If you get across any error/bugs/improvement suggestion. Please mail us at 221yash0006@gmail.com \n"
			+ "5. Refer Help section again if needed.";
	
	String color[] = {"RED","BLUE","GREEN","PINK","BLACK","YELLOW","GRAY"};
	String size[] = {"10","20","30","40","50","60","70"};
	String style[] = {"Simple","Bold","Italic","Bold + Italic"};

	public static JFrame frmMiniTextEditor;
	public static List list, list_1,list_2,list_3;
	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		notepadWindow note = new notepadWindow();
		note.frmMiniTextEditor.setVisible(true);
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public notepadWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//JOptionPane.showMessageDialog(textArea, helperStatement);
		frmMiniTextEditor = new JFrame(); 
		frmMiniTextEditor.setForeground(UIManager.getColor("Button.focus"));
		frmMiniTextEditor.setTitle("Mini Text Editor");
		frmMiniTextEditor.setBounds(100, 100, 600, 700);
		frmMiniTextEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMiniTextEditor.getContentPane().setLayout(new BorderLayout(0, 0));
		frmMiniTextEditor.setVisible(true);
		
		Panel panel = new Panel();
		frmMiniTextEditor.getContentPane().add(panel, BorderLayout.NORTH);
		
		list = new List();
		panel.add(list);
		
		list_1 = new List();
		panel.add(list_1);
		
		list_2 = new List();
		panel.add(list_2);
		
		list_3 = new List();
		panel.add(list_3);
		
		
		
		
		int i = 0; 	//counter
		for(i=0;i<color.length;i++) {
			list.add(color[i]);
		}
		
		for(i=0;i<style.length;i++) {
			list_2.add(style[i]);
		}
		
		for(i=0;i<size.length;i++) {
			list_1.add(size[i]);
		}
		
		
		list.addItemListener(new ListHandler() );
		list_1.addItemListener(new ListHandler());
		list_2.addItemListener(new ListHandler());


		textArea = new JTextArea();
		frmMiniTextEditor.getContentPane().add(textArea, BorderLayout.CENTER);
		
		
		JButton btnNewButton = new JButton("Clear Text");
		frmMiniTextEditor.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		btnNewButton.addActionListener(new ActionHandler());					//code complete
			
		
		JMenuBar menuBar = new JMenuBar();
		frmMiniTextEditor.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnNewMenu.add(mntmNew);
		mntmNew.addActionListener(new ActionHandler());
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new saveText());
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new writeText());
		
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {				
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(textArea,"Thankyou for using Mini - Text Editor");
			
				System.exit(1);
				
				//implement the confirmation box
				//code incomplete
			}
			
		});
		
		
		JMenu mnNewMenu_1 = new JMenu("Insert");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmImage = new JMenuItem("image");
		mnNewMenu_1.add(mntmImage);
		mntmImage.setToolTipText("Under Work");
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmHelp = new JMenuItem("help");
		mnNewMenu_2.add(mntmHelp);
		mntmHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(textArea, helperStatement);
			}
			
		});
		
		JMenu mnNewMenu_3 = new JMenu("About");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmAbout = new JMenuItem("about");
		mnNewMenu_3.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String design = "**************************************************";
				String about = "\n\nThis Application is developed by: \n\n1. Siddesh Madkaikar\n2. Vipul Belhekar\n3. Yash Dharmadhikari\n\nGuided By -";
				String endDetails = "\n\n		Mrs. Ditty Varagase\n	(Lecturer in Computer Engineering, DBIT)\n\n ";
				String design_2 = "***********************MINI TEXT EDITOR*************************";
				
				JOptionPane.showMessageDialog(textArea,"***********************MINI TEXT EDITOR*************************"+ about + endDetails + design_2);
			}
			
		});
		
		
		//ImageIcon icon = new ImageIcon(this.getClass().getResource("/giphy.gif"));
		
	}


public class ListHandler implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		
		
		int x = Integer.parseInt(list_1.getSelectedItem());
		
		if(arg0.getSource().equals(list)) {
		// TODO Auto-generated method stub
		if(list.getSelectedItem().equals("RED"))
			textArea.setForeground(Color.RED);
		if(list.getSelectedItem().equals("BLUE"))
			textArea.setForeground(Color.BLUE);
		if(list.getSelectedItem().equals("GREEN"))
			textArea.setForeground(Color.GREEN);
		if(list.getSelectedItem().equals("PINK"))
			textArea.setForeground(Color.PINK);
		if(list.getSelectedItem().equals("BLACK"))
			textArea.setForeground(Color.BLACK);
		if(list.getSelectedItem().equals("YELLOW"))
			textArea.setForeground(new Color(155,155,0));
		if(list.getSelectedItem().equals("GRAY"))
			textArea.setForeground(Color.DARK_GRAY);
		}
		
		else if(arg0.getSource().equals(list_1)) {
		

		if(list_1.getSelectedItem().equals("10"))
			 textArea.setFont(new Font("Arial",1,10));
		if(list_1.getSelectedItem().equals("20"))
			textArea.setFont(new Font("Arial",1,20));
		if(list_1.getSelectedItem().equals("30"))
			textArea.setFont(new Font("Arial",1,30));
		if(list_1.getSelectedItem().equals("40"))
			textArea.setFont(new Font("Arial",1,40));
	    if(list_1.getSelectedItem().equals("50"))
			textArea.setFont(new Font("Arial",1,50));
		if(list_1.getSelectedItem().equals("60"))
			textArea.setFont(new Font("Arial",1,60));
		if(list_1.getSelectedItem().equals("60"))
			textArea.setFont(new Font("Arial",1,70));
		}
		else {
			if(list_2.getSelectedItem().equals("Simple"))
				textArea.setFont(new Font("Arial",0,x));
		if(list_2.getSelectedItem().equals("Bold"))
				textArea.setFont(new Font("Times New Roman",1,x));
		if(list_2.getSelectedItem().equals("Italic"))
				textArea.setFont(new Font("Script",2,x));
		if(list_2.getSelectedItem().equals("Bold + Italic"))
				textArea.setFont(new Font("Serif",3,x));
		
	}
		}
		
	
	}
}
