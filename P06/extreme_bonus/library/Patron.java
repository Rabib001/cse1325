package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Represents a library patron.
 */
 
public class Patron
{
	private String name;
	private String email;
	
	public Patron(String name, String email)
	{
		this.name=name;
		this.email=email;
	}
	
	public void save(BufferedWriter bw) throws IOException
	{
		bw.write(name+"\n");
		bw.write(email+"\n");
	}

	public Patron(BufferedReader br) throws IOException
	{
		this.name=br.readLine();
		this.email=br.readLine();

	}
	@Override
	public String toString()
	{
		return " " + name + "(" + email + ")";
	}
	
}