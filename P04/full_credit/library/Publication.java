package library;
import java.time.LocalDate;

/**
*A library resource that can be checked out by a patron.
*/

public class Publication
{
	private String title;
	private String author;
	private int copyright;
	private String loanedTo;
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
	
	/**
	*Checks out the publication to a patron.
	*
	*@param patron The name of the patron checking out the publication.
	*/
	
	//constructor
	
	//Methods
	public void checkOut(String patron)
	{
		this.loanedTo = patron;
		
		this.dueDate = LocalDate.now().plusDays(14);
	}
	
	/**
	*Returns a string representation of the publication.
	*
	*@return A string representation of the publication.
	*/

	@Override
	public String toString()
	{
		return toStringBuilder ("Publication ", "");
	}	
	
	/**
	*
	*@param pre The prefix to add beforre the basic fields.
	*@param mid The suffix to add after the basic fields.
	*return A formatted string representation.
	*/
	
	protected String toStringBuilder (String pre, String mid)
	{
		StringBuilder result = new StringBuilder();
		result.append(pre).append("\"").append(title).append("\" by ").append(author).append(", copyright ").append(copyright);
		result.append(mid);
		
		if (loanedTo !=null)
		{
			result.append(" \n: loaned to ").append(loanedTo).append(" until ").append(dueDate).append("\n");
		}
		return result.toString();
	}
	
}