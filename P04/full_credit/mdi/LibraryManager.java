package mdi;
import java.util.Scanner;
import library.Library;
import library.Publication;
import library.Video;
import library.InvalidRuntimeException;


public class LibraryManager
{
	public static void main(String[] args)
	{
		Library library= new Library("Husain's Library");
		
		library.addPublication(new Publication("The Call of the Wild","Jack London", 1903));
		library.addPublication(new Publication("To Kill a Mockingbird","Harper Lee", 1960));
		library.addPublication(new Publication("One Hundred Years of Sloitude","Gabriel Garcia Marquez", 1967));
		
		try
		{
		library.addPublication(new Video("The Shawshank Redemption", "Frank Darabont", 1994, 142));
		library.addPublication(new Video("Pulp Fiction", "Quentin Tarantino", 1994, 154));
		library.addPublication(new Video("Inception", "Christopher Nolan", 2010, 148));
		}
		catch(InvalidRuntimeException e)
		{
			System.out.println("Invalid runtime exception: "+e.getMessage());
		}
		
		System.out.println(library);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Which publication to check out? ");
		int publicationIndex= scanner.nextInt();
		
		scanner.nextLine();
		System.out.print("Who are you? ");
		String patronName=scanner.nextLine();
		
		try
		{
			library.checkOut(publicationIndex, patronName);
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
