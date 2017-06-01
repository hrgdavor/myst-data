package hr.hrg.myst.data;

public interface UpdateDelta<E extends Enum<E>>{

	/**
	 * Utility Object that represents null value in array, so it can be recognised during a loop.<br>
	 * 
	 */
	public static final Object NULL_VALUE = "myst.null";	
	
	public boolean isEmpty();
	
	public boolean isChanged(E column);

	public boolean isChanged(int ordinal);
	
}