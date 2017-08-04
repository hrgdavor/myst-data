package hr.hrg.myst.data;

import java.sql.ResultSet;

public interface ResultSetHandler {
	public <T> T getFromResultSet(ResultSet rs, int offset, Class<T> expectedClass, Class<?> ...typeParameters);
}
