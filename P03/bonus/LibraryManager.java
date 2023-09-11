import java.util.Scanner;

public class LibraryManager
{
	public static void main(String[] args)
	{
		Library library= new Library("Husain's Library\n");
		library.addPublication(new Publication("The Call of the Wild","Jack London", 1903));
		library.addPublication(new Publication("To Kill a Mockingbird","Harper Lee", 1960));
		library.addPublication(new Publication("One Hundred Years of Sloitude","Gabriel Garcia Marquez", 1967));
		
		Patron patron=new Patron("Rabib Husain","rabib@gmail.com");
		library.addPatron(patron);
		
		System.out.println(library);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Which book to check out? ");
		int publicationIndex= scanner.nextInt();
		
		System.out.print(library.patronMenu());
		
		scanner.nextLine();
		System.out.print("\nWho are you? ");
		//System.out.print(library.patronMenu());
		int patronIndex=scanner.nextInt();
		
		try
		{
			library.checkOut(publicationIndex, patronIndex);
			System.out.println("Book checked out successfully.");
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Invalid publication index. Enter valid index");
		}
		
		System.out.println("Husain's Library");
		System.out.println(library);
		
		scanner.close();
	}
}

