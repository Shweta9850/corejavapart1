package EmailApplication;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("***** Setting Mail For New Employee *****");
		System.out.println("Enter first name: ");
		String f_name=s.next();
		System.out.println("Enter last name: ");
		String l_name=s.next();
		
		Email em1 = new Email(f_name, l_name);
		int choice=-1;
		do {
			System.out.println("\n***** Mail Settings *****\nEnter your choice\n1.Show Info\n2.Change Password\n3.Change Mailbox Capacity\n4.Set Alternate Mail\n5.Exit");
			choice=s.nextInt();
			switch (choice) {
			case 1: 
				em1.getInfo();
				break;
			case 2:
				em1.set_password();
				break;
			case 3:
				em1.set_mailcap();
				break;
			case 4:
				em1.alternate_email();
				break;
			case 5:
				System.out.println("Thank you for using Application!");
				break;
			default:
				System.out.println("Invalid choice\nEnter proper choice again..");
			}
		}while(choice!=5);

	}

}
