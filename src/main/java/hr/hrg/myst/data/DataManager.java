package hr.hrg.myst.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"rawtypes","unchecked"})
public class DataManager {
	
	Logger log = LoggerFactory.getLogger(DataManager.class);
	
	Map<Class, List<ChangeListener>> listeners = new HashMap<>();

	public <ID, O, E extends Enum<E>> void addChangeListener(ChangeListener<ID, O, E> listener, Class<O> clazz){
		synchronized (clazz) {
			List<ChangeListener> list = listeners.get(clazz);
			if(list == null) {
				list = new ArrayList<>();
				listeners.put(clazz, list);
			}
			list.add(listener);
		}
	}

	public <T,ID,E extends Enum<E>> void fireUpdate(DataUpdate<T,ID,E> update){
		List<ChangeListener> list = listeners.get(update.getMeta().getEntityClass());
		if(list != null){
			for (ChangeListener listener : list) {
				try {
					listener.recordChanged(update);
				} catch (Throwable e) {
					log.error("Error notifying a listener: "+e.getMessage(),e);
				}
			}
		}
	}

	public <T> void fireDelete(Object id, T old, Class<T> clazz){
		List<ChangeListener> list = listeners.get(clazz);
		if(list != null){
			for (ChangeListener listener : list) {
				try {
					listener.recordDeleted(id, old);
				} catch (Throwable e) {
					log.error("Error notifying a listener: "+e.getMessage(),e);
				}
			}
		}
	}

	public <T> void fireAdded(Object id, T obj, Class<T> clazz){
		List<ChangeListener> list = listeners.get(clazz);
		if(list != null){
			for (ChangeListener listener : list) {
				try {
					listener.recordAdded(id, obj);
				} catch (Throwable e) {
					log.error("Error notifying a listener: "+e.getMessage(),e);
				}
			}
		}
	}
	
}
