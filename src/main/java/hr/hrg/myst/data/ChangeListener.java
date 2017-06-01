package hr.hrg.myst.data;

public interface ChangeListener<T, ID, E extends Enum<E>> {

	public void recordDeleted(ID id, T old);
	
	public void recordAdded(ID id, T data);

	public void recordChanged(DataUpdate<T,ID,E> update);
}
