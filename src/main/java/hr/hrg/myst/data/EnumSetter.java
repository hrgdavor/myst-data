package hr.hrg.myst.data;

public interface EnumSetter<E extends Enum<E>>{

	/** Type safe version for coded usage.
	 * 
	 * @param column Enum for column
	 * @param value new value
	 */	
	public void setValue(E column, Object value);

	/** Index based version for looping.
	 * 
	 * @param ordinal column index
	 * @param value new value
	 * 
	 */	
	public void setValue(int ordinal, Object value);
}
