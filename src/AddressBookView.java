import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JList;
import javax.swing.*; 



public class AddressBookView extends JFrame  implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private static JButton temp;
	 private static JMenuBar menuBar;
	 private AddressBookModel addressBook;
	 private ActionListener action;
	 JList aList ;
	 	JTextArea textarea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textarea); 
		JScrollPane pane;
	/**
	 * constructor
	 */
	public AddressBookView(AddressBookModel addressBook, ActionListener action)
	{
		this.addressBook=addressBook;
		aList = new JList(addressBook.getBuddyList());
		this.action=action;
		
		
		
	}
	



	public void makeView(){
		JFrame f =  new JFrame("Address book frame");
	      f.setSize(500, 500);
	      f.setLayout(new BorderLayout());
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      pane = new JScrollPane(aList);
	      textarea.setSize(300, 200);
	      pane.setSize(300, 300);
	      
	      textarea.setEditable(false);
	      
	     
	      temp = new JButton("Hello!");
	      temp.setBackground(Color.white);
	       temp.addActionListener(action);
	        f.getContentPane().add(temp, BorderLayout.SOUTH);
	    

	      
	      JMenuBar menuBar = new JMenuBar( );
	      f.setJMenuBar(menuBar);

	      JMenu createMenu = new JMenu( "Create" );
	      menuBar.add( createMenu );
	      JMenu EditMenu = new JMenu( "Edit" );
	      menuBar.add( EditMenu );
	      JMenu saveMenu = new JMenu( "Save" );
	      menuBar.add( saveMenu );
	      JMenu displayMenu = new JMenu( "Display" );
	      menuBar.add( displayMenu );
	      
	      
	      JMenuItem item;
	 	 
	      item = new JMenuItem ( "Create an Address Book?" );
	      item.addActionListener(action);
	      createMenu.add( item );
	      item = new JMenuItem ( "Create a Buddy?" );
	      item.addActionListener(action);
	  	  createMenu.add( item );   
	  	  
	      item = new JMenuItem ( "Edit Buddy?" );
	      item.addActionListener(action );
	      EditMenu.add( item );
	      item = new JMenuItem ( "Delete a Buddy?" );
	      item.addActionListener(action);
	  	  EditMenu.add( item ); 
	  	  
	  	item = new JMenuItem ( "Save the Address Book" );
	      item.addActionListener(action);
	      saveMenu.add( item );
	      
	      item = new JMenuItem ( "Display the Address Book" );
	      item.addActionListener(action );
	  	  displayMenu.add( item );
	  	  
	  	 item = new JMenuItem ( "load the Address Book" );
	      item.addActionListener(action );
	  	  displayMenu.add( item );
	  	//f.add(buddyList);
	  	f.add(pane, BorderLayout.CENTER);
	    
			f.setVisible(true);
	}
	

	public JList getJList(){
		return aList;
	}




	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		aList.setModel(addressBook.getBuddyList2());
	}
	

	

	
	
}

