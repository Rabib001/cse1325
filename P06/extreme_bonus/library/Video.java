package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Duration;

/**
*A library video that can be checked out by a patron.
*/

public class Video extends Publication  //subclass of Publication
{
	private Duration runtime;
	
	/**
     * Constructs a Video object with the specified properties.
     *
     * @param title             The title of the video.
     * @param author            The author or director of the video.
     * @param copyright         The copyright year of the video.
     * @param runtime           The duration of the video in minutes.
     */
	
	public Video(String title, String author, int copyright, int runtime)
	{
		super(title,author,copyright);
		
		if(runtime<=0)
		{
			throw new InvalidRuntimeException(title, runtime);
		}
		this.runtime=Duration.ofMinutes(runtime);
	}

	/**
     * Saves the video information to a BufferedWriter.
     *
     * @param bw The BufferedWriter to write to.
     * @throws IOException If an I/O error occurs while writing.
     */

	 public void save (BufferedWriter bw) throws IOException
	 {
		 super.save(bw);
		 bw.write(runtime.toMinutes()+"\n");
	 }

	 /**
     * Constructs a Video object from a BufferedReader.
     *
     * @param br The BufferedReader to read from.
     * @throws IOException If an I/O error occurs while reading.
     */
	
	public Video(BufferedReader br) throws IOException
	{
		//chain to your superclass' constructor to restore them.
		super(br);
		int runTimeMinutes= Integer.parseInt(br.readLine());
		this.runtime=Duration.ofMinutes(runTimeMinutes);
	}
	
	/**
     * Returns a string representation of the video.
     *
     * @return A string representation of the video.
     */
	
	@Override
	public String toString()
	{
		return toStringBuilder("Video ", " runtime " + runtime.toMinutes() + " minutes");
	}
}