import java.time.LocalDate;

public class Publication
{
	private String title;
	private String author;
	private int copyright;
	private Patron loanedTo;
	private LocalDate dueDate;
	
	//constructor
	public Publication(String title, String author, int copyright)
	{
		this.title=title;
		this.author=author;
		this.copyright=copyright;
		
		int currentYear = LocalDate.now().getYear();
		
		if(copyright<1900 || copyright>currentYear)
		{
			throw new IllegalArgumentException("Invalid copyright year. It should be between 1900 and " + currentYear);
		}
	}
	
	//Methods
	public void checkOut(Patron patron)
	{
		this.loanedTo = patron;
		
		this.dueDate = LocalDate.now().plusDays(14);
	}

	@Override
	public String toString()
	{
		String result = "Title: " + title + "\n" + "Author: " + author + "\n" + "Copyright Date: " + copyright + "\n";
		
		if(loanedTo != null)
		{
			result += "Loaned to: " + loanedTo + "\n" + "Due date: " + dueDate + "\n";
		}
		return result;
	}	
	
}
