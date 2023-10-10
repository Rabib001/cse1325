package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;


/**
*A library resource that can be checked out by a patron.
*/

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

		/**
     * Constructor to create a Publication object from a BufferedReader.
     *
     * @param br The BufferedReader containing the publication data.
     * @throws IOException If there is an issue reading data from the BufferedReader.
     */
	
	 public Publication(BufferedReader br) throws IOException
	 {
		 this.title=br.readLine();
		 this.author=br.readLine();
		 this.copyright=Integer.parseInt(br.readLine());
 
		 String loanedStatus=br.readLine();
		 if(loanedStatus.equals("checked in"))
		 {
			 loanedTo=null;
			 dueDate=null;
		 }
		 else if(loanedStatus.equals("checked out"))
		 {
			String patronInfo=br.readLine();
			 loanedTo=new Patron(patronInfo,"");
			 String dueDateString= br.readLine();
			 dueDate=LocalDate.parse(dueDateString);
		 }
	 }

	/**
     * Save the Publication object to a BufferedWriter.
     *
     * @param bw The BufferedWriter to write the data to.
     * @throws IOException If there is an issue writing data to the BufferedWriter.
     */

	public void save(BufferedWriter bw) throws IOException
	{
		bw.write(title+"\n");
		bw.write(author+"\n");
		bw.write(Integer.toString(copyright)+"\n");

		if(loanedTo==null)
		{
			bw.write("checked in\n");
		}
		else
		{
			bw.write("checked out\n");
			bw.write(loanedTo+"\n");
			bw.write(dueDate.toString()+"\n");
		}
	}
	
	/**
	*Checks out the publication to a patron.
	*
	*@param patron The name of the patron checking out the publication.
	*/
	
	//constructor
	
	//Methods
	public void checkOut(Patron patron)
	{
		this.loanedTo = patron;
		
		this.dueDate = LocalDate.now().plusDays(14);
	}
	
	public void checkIn()
	{
		loanedTo=null;
		dueDate=null;
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