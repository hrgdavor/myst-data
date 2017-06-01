package hr.hrg.myst.data;

public interface EntityMeta<T,ID,E extends Enum<E>> {

	Class<T> getEntityClass();

	Class<E> getEntityEnum();

	String getTableName();

	int getColumnCount();

	ImmutableList<E> getColumns();

	ImmutableList<String> getColumnNames();

	E getPrimaryColumn();

	E getColumn(String name);
	
	E getColumn(int ordinal);

	String getColumnNamesStr();

	Object[] entityGetValues(T v);

	T entityFromValues(Object[] v);

	ID entityGetPrimary(T instance);
}
