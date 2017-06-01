package hr.hrg.myst.data;

public interface Update<T,E extends Enum<E>> {
	public UpdateDelta<E> getDelta();
}
