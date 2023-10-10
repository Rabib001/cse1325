package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * Represents a library that holds a collection of publications.
 */

public class Library
{
	private String name;
	private ArrayList<Publication> publications;
	
	public Library(String name)
	{
		this.name=name;
		this.publications=new ArrayList<>();
	}

	/**
     * Saves the library's information to a BufferedWriter.
     *
     * @param bw The BufferedWriter to write the information to.
     * @throws IOException If an I/O error occurs during writing.
     */

	public void save(BufferedWriter bw) throws IOException
	{
		bw.write(name+"\n");
		bw.write(publications.size()+"\n");

		for (Publication publication:publications)
		{
			if(publication instanceof Video)
			{
				bw.write("video\n");
				((Video) publication).save(bw);
			}
			else if(publication instanceof Publication)
			{
				bw.write("publication\n");
				publication.save(bw);
			}
		}
	}

	/**
     * Constructs a Library object from a BufferedReader.
     *
     * @param br The BufferedReader to read from.
     * @throws IOException If an I/O error occurs while reading.
     */

	public Library(BufferedReader br) throws IOException
	{
		this.name=br.readLine();
		this.publications=new ArrayList<>();

		//Read the number of objects that were written to the file first, say to an int named size.
		int numPublication = Integer.parseInt(br.readLine());

		for(int i=0; i<numPublication; i++)
		{
			String type=br.readLine();

			if(type.equals("video"))
			{
				Video video=new Video(br);
				publications.add(video);
			}
			else if(type.equals("publication"))
			{
				Publication publication=new Publication(br);
				publications.add(publication);
			}
		}
	}
	
	/**
     * Adds a publication to the library's collection.
     *
     * @param publication The publication to add.
     */
	
	public void addPublication(Publication publication)
	{
		publications.add(publication);
	}
	
	/**
     * Checks out a publication to a patron by its index in the collection.
     *
     * @param publicationIndex The index of the publication to check out.
     * @param patron           The name of the patron checking out the publication.
     */
	 
	public void checkOut(int publicationIndex, String patron)
	{
		if(publicationIndex>=0 && publicationIndex<publications.size())
		{
			Publication publication = publications.get(publicationIndex);
			publication.checkOut(patron);			
		}
		else
		{
			throw new IndexOutOfBoundsException("Invalid publication Index");
		}
	}

	/**
     * Checks in a publication by its index in the collection.
     *
     * @param publicationIndex The index of the publication to check in.
     * @throws IndexOutOfBoundsException If the publication index is invalid.
     */

	public void checkIn(int publicationIndex)
	{
		if(publicationIndex>=0 && publicationIndex<publications.size())
		{
			Publication publication = publications.get(publicationIndex);
			publication.checkIn();			
		}
		else
		{
			throw new IndexOutOfBoundsException("Invalid publication Index");
		}
	}
	
	/**
     * Returns a string representation of the library, including its name and the list of publications.
     *
     * @return A string representation of the library.
     */
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Library Name: ").append(name).append("\n");
		
		for(int i=0; i<publications.size(); i++)
		{
			stringBuilder.append("[").append(i).append("] ").append(publications.get(i)).append("\n");
		}
		return stringBuilder.toString();
	}
}