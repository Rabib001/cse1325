import java.util.ArrayList;

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
	
	public void addPublication(Publication publication)
	{
		publications.add(publication);
	}
	
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
	
	public void  checkOut(int publicationIndex, int patronIndex)
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

	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\nLibrary Name: ").append(name).append("\n");
		
		for(int i=0; i<publications.size(); i++)
		{
			stringBuilder.append("[").append(i).append("] ").append(publications.get(i)).append("\n");
		}
		return stringBuilder.toString();
	}
}
