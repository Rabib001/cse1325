package library;

/**
 * Represents a custom exception for invalid runtime in a Video object.
 */

public class InvalidRuntimeException extends ArithmeticException
{
	/**
     * Constructs a new InvalidRuntimeException.
     */
	 
	public InvalidRuntimeException()
	{
		super();
	}
	
	/**
     * Constructs a new InvalidRuntimeException with the specified message.
     *
     * @param message The error message.
     */
	
	public InvalidRuntimeException(String message)
	{
		super(message);
	}
	
	/**
     * Constructs a new InvalidRuntimeException with a specific message based on the video title and runtime.
     *
     * @param title   The title of the video.
     * @param runtime The invalid runtime value.
     */

	public InvalidRuntimeException(String title, int runtime)
	{
		super(title+" has invalid runtime "+runtime);
	}
}