import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class AddressBookController implements ActionListener {
	
	private AddressBookModel model;
	private AddressBookView view; 

	AddressBookController(AddressBookModel model){
		
		this.model=model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Create an Address Book?".equals(e.getActionCommand()))
		{
			
			//AddressBookPanel p= new AddressBookPanel();
			String inputValue = JOptionPane.showInputDialog("Please Enter the Address Book Name");
			
				System.out.println("the input is "+inputValue);
			//	temp.setText("Adderss book created");
				
		}else if ("Create a Buddy?".equals(e.getActionCommand()))
		{
			
			//JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
			
			
	        
			String inputValue = JOptionPane.showInputDialog("Please Enter the Buddy Name");
			String inputValue2 = JOptionPane.showInputDialog("Please Enter the Address ");
			String inputValue3 = JOptionPane.showInputDialog("Please Enter the number");
			String inputValue4 = JOptionPane.showInputDialog("Please Enter the Age");
			
			BuddyInfo b= new BuddyInfo(inputValue,inputValue2,inputValue3,Integer.parseInt(inputValue4));	
		
			model.addBuddy(b);
			System.out.println("a buddy was added to the book! his/her info: "+inputValue+", "+inputValue2+", "+inputValue3);
			System.out.println("the size of the book is :"+model.getBuddyList().size());
		//	temp.setText("buddy was added");
			
		}else if ("Save the Address Book".equals(e.getActionCommand())){
			
			
			model.export();
			/*
			
			BufferedWriter out = null;
			try {
				out = new BufferedWriter(new FileWriter("myFile.txt"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(int i=0;i<=(model.getBuddyList().size() -1);i++)
			{
				String s = model.getBuddyList().get(i).getName()+"  "+
						model.getBuddyList().get(i).getAddress()+
						   "  "+model.getBuddyList().get(i).getNumber()+"\n"; 
				try {
					out.write(s);
					out.newLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//end of for 
			
			try {
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				*/		
			
		} else if ("Display the Address Book".equals(e.getActionCommand())){
			
			System.out.println("DISPLAY THE BOOK");
			System.out.println(model.getBuddyList().toString());
			model.notifyObservers();
			
		//	textarea.setText(addressBook.getBuddyList().toString());
			//textarea.setText(buddyList);
			//this.add(aList);
			
		}else if ( "Edit Buddy?" .equals(e.getActionCommand())){
			
			System.out.println("EDIT");
			int i = view.getJList().getSelectedIndex();
			
			if(i != -1){
				String inputValue = JOptionPane.showInputDialog("Please Enter the Buddy Name");
				String inputValue2 = JOptionPane.showInputDialog("Please Enter the Address ");
				String inputValue3 = JOptionPane.showInputDialog("Please Enter the number");
				String inputValue4 = JOptionPane.showInputDialog("Please Enter the age");
				BuddyInfo b = new BuddyInfo(inputValue, inputValue2,inputValue3,Integer.parseInt(inputValue4));
				model.addBuddy(b);
				model.removeBuddy(i);
				
			}
			
		}else if ( "Delete a Buddy?" .equals(e.getActionCommand())){
			
			System.out.println("DELETE");
			int i = view.getJList().getSelectedIndex();
			
			if(i != -1){
				
				model.removeBuddy(i);
				
			}
			
		}else if ("load the Address Book".equals(e.getActionCommand())){
			//model.importt();
			//String inputValue = JOptionPane.showInputDialog("Please Enter file name");
			model.importAddressBook("myFile.txt");
			model.printimportedList();
			//model.getImportedList().toString();
			//model.notifyObservers();
			
		}
      

	}
	
	public void setView(AddressBookView view){
		this.view=view;
	}
	
	public void setModel(AddressBookModel model){
		this.model=model;
	}
	
	public static void main(String[] args)
	{
		
		
		AddressBookModel aBook = new AddressBookModel();
		AddressBookController bookController = new AddressBookController(aBook);
		AddressBookView addressBookgui= new AddressBookView(aBook, bookController);
		aBook.addObserver(addressBookgui);
		bookController.setView(addressBookgui);
		addressBookgui.makeView();

		

	}

}
