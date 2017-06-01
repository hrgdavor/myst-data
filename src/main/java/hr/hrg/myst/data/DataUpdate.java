package hr.hrg.myst.data;

public class DataUpdate<T, ID, E extends Enum<E>> {

	private T old;
	private T updated;
	private ID id;
	private UpdateDelta<E> delta;
	private EntityMeta<T,ID,E> meta;

	public DataUpdate(ID id, T old, T updated, UpdateDelta<E> delta, EntityMeta<T,ID,E> meta){
		this.old = old;
		this.updated = updated;
		this.delta = delta;
		this.meta = meta;
	}
	
	public T getOld() {
		return old;
	}
	
	public T getUpdated() {
		return updated;
	}
	
	public UpdateDelta<E> getDelta() {
		return delta;
	}
	
	public ID getId() {
		return id;
	}
	
	public EntityMeta<T,ID,E> getMeta() {
		return meta;
	}

}
