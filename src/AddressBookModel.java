import java.util.ArrayList;
import java.util.Observable;
import java.util.Set;

import javax.swing.DefaultListModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;


public class AddressBookModel extends Observable implements Serializable {
//	private ArrayList <BuddyInfo> buddyList;
	
	private DefaultListModel<BuddyInfo> buddyList = new DefaultListModel<BuddyInfo>();
	private ArrayList<BuddyInfo> imported_buddyList;
	private ArrayList<BuddyInfo> buddyList2 = new ArrayList<BuddyInfo>();
	private Set allBuddies = null;
	
	public AddressBookModel(){
		buddyList = new DefaultListModel<BuddyInfo>(); 
		imported_buddyList= new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo b){
		if(b != null){
		buddyList.addElement(b);
		setChanged();
		notifyObservers();
		}
		
	}
	
	public void removeBuddy(int i){
		if (i>=0 && i<buddyList.size()){
			buddyList.remove(i);
			
			setChanged();
			notifyObservers();
			 
		}
	}
	
	public void editBuddy(int i, String name, String address, String number, int age){
		buddyList.getElementAt(i).setName(name);
		buddyList.getElementAt(i).setAddress(address);
		buddyList.getElementAt(i).setNumber(number);
		buddyList.getElementAt(i).setAge(age);
		
		
		setChanged();
		notifyObservers();
	}
	
	public DefaultListModel<BuddyInfo> getBuddyList() {
		return buddyList;
	}
	
	public DefaultListModel getBuddyList2() {
		return buddyList;
	}
	
	public BuddyInfo getBuddyAt(int index){
		return buddyList.getElementAt(index);
	}
	
	public int size(){
		return buddyList.size();
	}
	
	public void clear(){
		buddyList.clear();
	}
	
	public void buddyListt(){
		for(int i =0 ; i<buddyList.size();i++){
			buddyList2.add(buddyList.get(i));
		}
	}
	
	public void export(){

		
		PrintWriter out = null;
		try {
			out = new PrintWriter("myFile.txt");
			for(int i=0;i<=buddyList.size()-1;i++)
			{
				String s =  buddyList.get(i).toString();
				out.println(s);
				//out.newLine();
			
			}//end of for 
			
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		buddyListt();
		//allBuddies.addAll(buddyList2);
		//allBuddies.addAll(imported_buddyList);
		
	}
	
	public ArrayList<BuddyInfo> importAddressBook (String fileName){
		 // The name of the file to open.
        String fileName1 = fileName;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName1);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

         
            BuddyInfo b=null;
            int i=0;
            while((line = bufferedReader.readLine()) != null) {
            	this.imported_buddyList.add(b.importt(line));
            }   

            // Always close files.
            bufferedReader.close(); 
           // return this.imported_buddyList;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName1 + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName1 + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		return imported_buddyList;
    
	}
	
	

	public void printimportedList(){
		for(int i=0; i<imported_buddyList.size();i++){
			System.out.println(imported_buddyList.get(i).toString());
		}
	}
	
public void objectExport(){
		
		try {
			FileOutputStream out = new FileOutputStream("objectout.txt");
			ObjectOutputStream oout = new ObjectOutputStream(out);
			for (BuddyInfo b : buddyList2) {
				oout.writeObject(b);
				out.close();
		         
			}
			
		} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
	}
	
	public BuddyInfo objectImport(){
		BuddyInfo bd = null;
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objectout.txt"));
			bd = (BuddyInfo) ois.readObject();
			System.out.println("Object: " + bd);//ois.readObject());
			
			//System.out.println("" + ois.readObject());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return bd;
	}
	
	public static void main (String[] args){
		BuddyInfo buddy = new BuddyInfo("Bolt","123 Jam","123",33);
		
		String input = "Totti$123 Roma$1927$40";
		
		AddressBookModel ab = new AddressBookModel();
		ab.addBuddy(buddy);
		ab.export();
		
	//	buddy = BuddyInfo.importt(input); 
		System.out.println(buddy.toString());
		System.out.println("done");
		
		ab.objectExport();
		BuddyInfo b2 = ab.objectImport();
		System.out.println(b2.equals(buddy));
	}
	

}
