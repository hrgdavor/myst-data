package hr.hrg.myst.data;

public interface EnumGetter<E extends Enum<E>> {
	/** Type safe version for coded usage.
	 * 
	 * @param column Enum for column
	 */	
	public Object getValue(E column);

	/** Index based version for looping.
	 * 
	 * @param ordinal column index
	 * 
	 */	
	public Object getValue(int ordinal);
}
