package hr.hrg.myst.data;

public interface ColumnMeta {
	/** 
	 * @return column name in database
	 */
	public String getColumnName();
	
	/** 
	 * @return name in Enum and the name of the field in the Entity class
	 */
	public String name();
	
	/** 
	 * @return type of the field
	 */
	public Class<?> getType();
	
	/** 
	 * @return if the value is primitive type (int,long...etc) in the implemented entity class.
	 */
	public boolean isPrimitive();
	
	public int ordinal();
}
