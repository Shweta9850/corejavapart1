package EmailApplication;

import java.util.Random;
import java.util.Scanner;

public class Email {
	public Scanner s = new Scanner(System.in);
	private String fname;
	private String lname;
	private String dept;
	private String email;
	private String password;
	private int mailCapacity = 500;
	private String alter_email;

	public Email(String fname, String lname) {
		this.fname = fname;
		this.lname  =lname;
		System.out.println("New Employee: " + this.fname + " " + this.lname);
		
		this.dept = this.setDept();
		this.password = this.generate_password(8);
		this.email = this.generate_email();
	}

	private String generate_email() {
		return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".company.com";
	}

	private String setDept() {
		System.out.println("\n***** Assign Department Code For Employee ***** \n1 For Sales \n2 For Development \n3 For Accounting \n0 For None");
		boolean flag = false;
		do {
			System.out.println("Enter Department Code");
			int choice=s.nextInt();
			switch(choice) {
			case 1:
				return "Sales";
			case 2:
				return "Development";
			case 3:
				return "Accounting";
			case 0:
				return "None";
			default:
				System.out.println("Invalid choice please choose it again");
			}
		
		}while(!flag);
		return null;
	}
	
	private String generate_password(int length) {
		Random r = new Random();
		String Capital_chars ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars="abcdefghijklmnopqrstuvwxyz";
		String numbers="0123456789";
		String symbols="!@#$%^&*";
		String values=Capital_chars+Small_chars+numbers+symbols;
		String password="";
		for(int i=0;i<length;i++) {
			password=password+values.charAt(r.nextInt(values.length()));
		}
		return password;
	}
	
	public void set_password() {
		boolean flag=false;
		do {
			System.out.println("Do you want to change your password!(Y/N)");
			char choice=s.next().charAt(0);
			if(choice=='Y'||choice=='y') {
				flag=true;
				System.out.println("Enter current password: ");
				String temp=s.next();
				if(temp.equals(this.password)) {
					System.out.println("Enter new password: ");
					this.password=s.next();
					System.out.println("Password changed successfully");
				}
				else {
					System.out.println("Incorrect password");
				}
			}else if(choice=='N'||choice=='n'){
				flag=true;
				System.out.println("Password change option cancelled!");
			}
				else {
					System.out.println("Enter valid choice");
				}
			
		}while(!flag);
	}
	
	public void set_mailcap() {
		System.out.println("Current capacity= " + this.mailCapacity + "mb");
		System.out.println("Enter new mail capacity: ");
		this.mailCapacity=s.nextInt();
		System.out.println("Mail capacity is successfully changed");
	}
	
	public void alternate_email() {
		System.out.println("Enter new alternate mail: ");
		this.alter_email=s.next();
		System.out.println("Alternate email is set");
	}
	
	public void getInfo() {
		System.out.println("Name: " + this.fname + " " + this.lname);
		System.out.println("Department: " + this.dept);
		System.out.println("Email: " + this.email);
		System.out.println("Password: " + this.password);
		System.out.println("Mailbox Capacity: " + this.mailCapacity + "mb");
		System.out.println("Alternate mail: " + this.alter_email);
		
	}
}


