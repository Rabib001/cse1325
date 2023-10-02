package mdi;
import java.util.Scanner;
import java.math.BigInteger;
import library.Library;
import library.Publication;
import library.Video;
import library.InvalidRuntimeException;


public class LibraryManager
{
	private Library library;

	public LibraryManager(Library library)
	{
		this.library=library;
	}

	public void listPublications()
	{
		System.out.println("List of Publications and Videos:");
		System.out.println(library);
	}

	public void addPublication()
	{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter publication title: ");
			String title=scanner.nextLine();
			System.out.print("Enter author of the publication: ");
			String author=scanner.nextLine();
			System.out.print("Enter copyright year of the publication: ");
			int copyright=scanner.nextInt();
			scanner.nextLine();
			library.addPublication(new Publication(title, author, copyright));
			System.out.println("Publication added successfully");

			System.out.println(library);
	}	

	public void addVideo()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter video title: ");
		String title=scanner.nextLine();
		System.out.print("Enter author of the video: ");
		String director=scanner.nextLine();
		System.out.print("Enter copyright year of the video: ");
		int copyright=scanner.nextInt();
		System.out.print("Enter runtime of the video: ");
		int runtime=scanner.nextInt();

		try 
		{
            Video video = new Video(title, director, copyright, runtime);
            library.addPublication(video);
            System.out.println("Video added successfully.");
        } 
		catch (InvalidRuntimeException e) 
		{
            System.out.println("Invalid runtime exception: " + e.getMessage());
        }

		System.out.println(library);
	}

	public void checkOutPublication()
	{
		System.out.println(library);

		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the publication to check out: ");
        int publicationIndex = scanner.nextInt();

        scanner.nextLine(); 
		
        System.out.print("Enter the name of the patron: ");
        String patronName = scanner.nextLine();
	
        try 
		{
            library.checkOut(publicationIndex, patronName);
            System.out.println("Publication checked out successfully.");
        } 
		catch (IndexOutOfBoundsException e) 
		{
            System.out.println("Invalid publication index. Enter a valid index.");
        }

		System.out.println(library);
	}

	public void checkInPublication()
	{
		System.out.println(library);
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the publication to check in: ");
        int publicationIndex = scanner.nextInt();

        try 
		{
            library.checkIn(publicationIndex);
            System.out.println("Publication checked in successfully.");
        } 
		catch (IndexOutOfBoundsException e) 
		{
            System.out.println("Invalid publication index. Enter a valid index.");
        }

		System.out.println(library);
	}

	public static void main(String[] args)
	{		
		Library library = new Library("Husain's Library");	
        LibraryManager manager = new LibraryManager(library);
        
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

        Scanner scanner = new Scanner(System.in);

        while (true) 
		{
            System.out.println("Library Management System Menu:");
            System.out.println("1. List all Publications and Videos");
            System.out.println("2. Add a new Publication");
            System.out.println("3. Add a new Video");
            System.out.println("4. Check out a Publication or Video");
            System.out.println("5. Check in a Publication or Video");
            System.out.println("6. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
			{
                case 1:
                    manager.listPublications();
                    break;
                case 2:
                    manager.addPublication();
                    break;
                case 3:
                    manager.addVideo();
                    break;
                case 4:
                    manager.checkOutPublication();
                    break;
                case 5:
                    manager.checkInPublication();
                    break;
                case 6:
                    System.out.println("Exiting Library Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
	}
}
