package mdi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import library.Library;
import library.Publication;
import library.Video;
import library.InvalidRuntimeException;
import library.Patron;

public class LibraryManager 
{
    public static void main(String[] args) 
	{
        Library library = new Library("Husain's Library\n");

        loadLibraryData(library);

        System.out.println(library);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Which publication to check out? ");
        int publicationIndex = scanner.nextInt();

        System.out.println(library.patronMenu());
        scanner.nextLine();
        System.out.print("Who are you? ");
        int patronIndex = scanner.nextInt();

        try 
		{
            library.checkOut(publicationIndex, patronIndex);
            System.out.println("Book checked out successfully.");
        } 
		catch (IndexOutOfBoundsException e) 
		{
            System.out.println("Invalid publication index. Enter a valid index.");
        }

        System.out.println("Husain's Library");
        System.out.println(library);

        scanner.close();
    }

    private static void loadLibraryData(Library library) 
	{
        String filePath = "library.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
		{
            String line;
            List<Publication> publications = new ArrayList<>();
            List<Patron> patrons = new ArrayList<>();

            while ((line = reader.readLine()) != null) 
			{
                line = line.trim();
                if (line.isEmpty()) 
				{
                    continue; 
                }

                if (line.equals("Publications:")) 
				{
                    while ((line = reader.readLine()) != null && !line.equals("Patrons:")) {
                        String[] parts = line.split(", ");
                        if (parts.length >= 3) 
						{
                            String title = parts[0];
                            String author = parts[1];
                            int copyright = Integer.parseInt(parts[2]);
                            Publication publication = new Publication(title, author, copyright);
                            publications.add(publication);
                        }
                    }
                }

                if (line.equals("Patrons:")) 
				{
                    while ((line = reader.readLine()) != null) 
					{
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

        } 
		catch (IOException e) 
		{
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }
}
