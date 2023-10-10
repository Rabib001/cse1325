package mdi;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import library.Library;
import library.Publication;
import library.Video;
import library.InvalidRuntimeException;
import library.Patron;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager
{
	private Library library;

	public LibraryManager(Library library)
	{
		this.library=library;
	}

	public void saveLibrary()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the filename to save: ");
		String filename=scanner.nextLine();

		try(BufferedWriter bw =new BufferedWriter(new FileWriter(filename)))
		{
			library.save(bw);
			System.out.print("Library saved successfully to "+filename);
		}
		catch(IOException e)
		{
			System.out.print("Unable to save library to "+filename);
		}
	}

	public void openLibrary()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the filename to open: ");
		String filename=scanner.nextLine();

		try (BufferedReader br =new BufferedReader(new FileReader(filename)))
		{
			Library newLibrary=new Library(br);
			library=newLibrary;
			System.out.println("Library opened successfully from " + filename);
		} 
		catch (IOException e) 
		{
            System.out.println("Unable to open the library from " + filename);
		}
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

		System.out.println(library.patronMenu());
		scanner.nextLine(); 
        System.out.print("Enter the index of the patron: ");

		int patronIndex = scanner.nextInt();

        try 
		{
            library.checkOut(publicationIndex, patronIndex);
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

	public void listPatrons()
	{
		System.out.println("Patrons:");
		String patronMenu = library.patronMenu();
        System.out.println(patronMenu);
	}

	public void addPatron()
	{
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter patron name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patron email: ");
        String email = scanner.nextLine();
        library.addPatron(new Patron(name, email));
        System.out.println("Patron added successfully");

		String patronMenu = library.patronMenu();
        System.out.println(patronMenu);
	}

	public void loadData() {
        loadLibraryData(library);
    }

	private void loadLibraryData(Library library) {
		String filePath = "library.txt";
	
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			List<Publication> publications = new ArrayList<>();
			List<Patron> patrons = new ArrayList<>();
			boolean isPublicationsSection = false;
			boolean isVideosSection = false;
			boolean isPatronsSection = false;
	
			while ((line = reader.readLine()) != null) {
				line = line.trim();
	
				if (line.isEmpty()) {
					continue;
				}
	
				if (line.equals("Publications:")) {
					isPublicationsSection = true;
					isVideosSection = false;
					isPatronsSection = false;
				} else if (line.equals("Videos:")) {
					isPublicationsSection = false;
					isVideosSection = true;
					isPatronsSection = false;
				} else if (line.equals("Patrons:")) {
					isPublicationsSection = false;
					isVideosSection = false;
					isPatronsSection = true;
				} else {
					if (isPublicationsSection) {
						String[] parts = line.split(", ");
						if (parts.length >= 3) {
							String title = parts[0];
							String author = parts[1];
							int copyright = Integer.parseInt(parts[2]);
							Publication publication = new Publication(title, author, copyright);
							publications.add(publication);
						}
					} else if (isVideosSection) {
						String[] parts = line.split(", ");
						if (parts.length >= 4) {
							String title = parts[0];
							String director = parts[1];
							int copyright = Integer.parseInt(parts[2]);
							int runtime = Integer.parseInt(parts[3].split(" ")[0]);
							try {
								Video video = new Video(title, director, copyright, runtime);
								publications.add(video);
							} catch (InvalidRuntimeException e) {
								System.out.println("Invalid runtime exception: " + e.getMessage());
							}
						}
					} else if (isPatronsSection) {
						String[] parts = line.split(", ");
						if (parts.length >= 2) {
							String name = parts[0];
							String email = parts[1];
							Patron patron = new Patron(name, email);
							patrons.add(patron);
						}
					}
				}
			}
	
			publications.forEach(library::addPublication);
			patrons.forEach(library::addPatron);
		} catch (IOException e) {
			System.err.println("Error reading from the file: " + e.getMessage());
		}
	}
	

	public static void main(String[] args)
	{		
		Library library = new Library("Husain's Library");	
        LibraryManager manager = new LibraryManager(library);
		manager.loadData(); 
        Scanner scanner = new Scanner(System.in);

        while (true) 
		{
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. List all Publications and Videos");
            System.out.println("2. Add a new Publication");
            System.out.println("3. Add a new Video");
            System.out.println("4. Check out a Publication or Video");
            System.out.println("5. Check in a Publication or Video");
			System.out.println("6. Save Library");
			System.out.println("7. Open Library");
            System.out.println("8. Quit");

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
                    manager.saveLibrary();
                    break;
				case 7:
                    manager.openLibrary();
                    break;
                case 8:
                    System.out.println("Exiting Library Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
	}
}
