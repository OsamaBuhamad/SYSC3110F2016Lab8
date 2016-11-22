import java.io.Serializable;

public class BuddyInfo implements Serializable{
	
	private String name,address, number;
	private int age;
	
	

	
	public BuddyInfo(String name, String address, String number,int age){
		this.name=name;
		this.address=address;
		this.number=number;
		this.age = age;
	}
	
	public BuddyInfo(BuddyInfo b){
		this.name = b.getName();
		this.address = b.getAddress();
		this.number = b.getNumber();
		this.age = b.getAge(); 
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public boolean isOver18(){
		if(age>18)
			return true;
		return false;
	}
	
	public String greeting(){
		return "Hi from "+name; 
	}

	public boolean equals(BuddyInfo bd){
		return (this.name.equals(bd.getName()) && this.address.equals(bd.getAddress()) && this.number.equals(bd.getNumber()));
	}


	@Override
	public String toString() {
		return  name + "$" + address + "$" + number+"$"+age;
	}

	public static BuddyInfo importt(String str) {
		
		String[] s = str.split("\\$");
		BuddyInfo b = new BuddyInfo(s[0],s[1],s[2],Integer.valueOf(s[3]));
		return b;
	}

	

}
