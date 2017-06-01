package hr.hrg.myst.data;

/** Setter that checks if the value has changed
 * 
 * @author hrg
 *
 * @param <E>
 */
public interface EnumSetterChecked<E extends Enum<E>>{

	/** Type safe version using enum from code
	 * 
	 * @param column Enum for column
	 * @param value new value
	 * @return true if new value is different
	 */
	public boolean trySetValue(E column, Object value);

	/** Index based version for looping.
	 * 
	 * @param ordinal column index
	 * @param value new value
	 * @return true if new value is different
	 */
	public boolean trySetValue(int ordinal, Object value);
}
