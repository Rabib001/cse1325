public enum Color
{
	Purple(0x800080),Orange(0xFFA500),Maroon(0x800000),Pink(0xFFC0CB);
	
	private int rgb;
	
	private Color(int rgb)
	{
		this.rgb=rgb;
	}
	
	public String toString() 
    {
        return this.name() + " (0x" + String.format("%06X", rgb) + ")";
    }
}

