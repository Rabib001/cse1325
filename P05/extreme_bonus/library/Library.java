package library;
import java.util.ArrayList;

/**
 * Represents a library that holds a collection of publications.
 */

public class Library
{
	private String name;
	private ArrayList<Publication> publications;
	private ArrayList<Patron> patrons;

	public Library(String name)
	{
		this.name=name;
		this.publications=new ArrayList<>();
		this.patrons=new ArrayList<>();
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
     * Adds a patron.
     *
     * @param patron The patron to add.
     */
	
	 public void addPatron(Patron patron)
	 {
		patrons.add(patron);
	 }
	
	 public String patronMenu()
	{
		StringBuilder menu=new StringBuilder("\n\nPatrons:\n");
		 
		for (int i=0;i<patrons.size();i++)
		{
			menu.append("[").append(i).append("]").append(patrons.get(i)).append("\n");
		}
		return menu.toString();
	}
	/**
     * Checks out a publication to a patron by its index in the collection.
     *
     * @param publicationIndex The index of the publication to check out.
     * @param patron           The name of the patron checking out the publication.
     */
	 

	 public void checkOut(int publicationIndex, int patronIndex)
	 {
		 if(publicationIndex>=0 && publicationIndex<publications.size() && patronIndex>=0 && patronIndex<patrons.size())
		 {
			 Publication publication = publications.get(publicationIndex);
			 Patron patron=patrons.get(patronIndex);
			 publication.checkOut(patron);			
		 }
		 else
		 {
			 throw new IndexOutOfBoundsException("Invalid publication Index");
		 }
	 }

	/**
     * Checks in a publication to a patron by its index in the collection.
     *
     * @param publicationIndex The index of the publication to check in.
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