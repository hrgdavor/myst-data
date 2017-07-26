package hr.hrg.myst.data;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class ImmutableList<T> implements Iterable<T>, List<T>{
	private final T[] items;

	
	@SafeVarargs
	public static final <T> ImmutableList<T> safe(T... in){
		return new ImmutableList<>(true,in);
	}
	
	/** Creates ImmutableList by cloning the provided array. Use {@link #safe(Object...)} 
	 * 
	 * @param in
	 */
	@SafeVarargs
	public ImmutableList(T ...in){
		items = in.clone();
	}
	
	/** Private constructor that accepts the array directly, knowing that it's reference will not be leaked.
	 * 
	 * @param priv private parameter to enable access to this constructor
	 * @param in
	 */
	@SafeVarargs
	private ImmutableList(boolean priv, T... in){
	   items = in; 
	}

	@SuppressWarnings("unchecked")
	public ImmutableList(List<T> in){
		items = (T[]) in.toArray();
	}

    public int size() {
        return items.length;
    }

    public boolean isEmpty() {
        return items.length == 0;
    }
    
    public T get(int i){
        return items[i];
    }
    
    @Override
    public boolean contains(Object elem){
        if(elem == null) return false;
        for(T inArr: items){
            if(inArr.equals(elem)) return true;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    public ImmutableList<T> removeMakeNew(T elem){
        if(!contains(elem)) return this;
        T[] newArr = (T[]) Array.newInstance(items.getClass().getComponentType(), items.length-1);
        int i=0;
        for(; i<newArr.length; i++){
            if(items[i].equals(elem)) break;
            newArr[i] = items[i];
        }
        i++;
        for(; i<items.length; i++){
            newArr[i-1] = items[i];
        }
        return new ImmutableList<T>(true,newArr);
    }
        
    public ImmutableList<T> addMakeNew(T elem){
        if(elem == null) throw new IllegalArgumentException("Null value not allowd inside this list !");
        return add(elem,null);
    }

    public ImmutableList<T> add(T elem, Comparator<T> comparator){
        if(contains(elem)) return this;
        T[] newArr = Arrays.copyOf(items, items.length+1);
        newArr[items.length] = elem;
        if(comparator != null) Arrays.sort(newArr, comparator);
        return new ImmutableList<T>(true,newArr);
    }
    
    public ImmutableList<T> sortMakeNew(Comparator<T> comparator){
        T[] newArr = Arrays.copyOf(items, items.length);
        Arrays.sort(newArr, comparator);
        return new ImmutableList<T>(true,newArr);
    }

	@SuppressWarnings("unchecked")
	public ImmutableList<T> moveBack(T elem) {
		if(items.length == 0) return this;

        T[] newArr = (T[]) Array.newInstance(items.getClass().getComponentType(), items.length);
        T found = null;

        for(int i=0; i<newArr.length-1; i++){
            if(items[i].equals(elem)) found = items[i];
            if(found == null)
            	newArr[i] = items[i];
            else
            	newArr[i] = items[i+1];
        }
        newArr[newArr.length-1] = found == null ? items[newArr.length-1] : found;
        
        return new ImmutableList<T>(true,newArr);
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			@Override
			public boolean hasNext() {
				return i<items.length;
			}

			@Override
			public T next() {
			    if(i>= items.length) throw new NoSuchElementException("length: "+items.length+" requested: "+i);
				return items[i++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public Object[] toArray() {
		Object[] ret = new Object[items.length];
		System.arraycopy(items, 0, ret, 0, items.length);
		return ret;
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> T[] toArray(T[] a) {
		if(a.length < items.length){
			a = (T[]) Array.newInstance(a.getClass().getComponentType(), items.length);
		}
		System.arraycopy(items, 0, a, 0, items.length);			
		return a;
	}

	@Override
	public boolean add(T e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object object : c) {
			if(!this.contains(object)) return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();		
	}

	@Override
	public T set(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object elem) {
        if(elem == null) return -1;
        for(int i=0; i<items.length; i++){
            if(items[i] != null && items[i].equals(elem)) return i;
        }
        return -1;
	}

	@Override
	public int lastIndexOf(Object elem) {
        if(elem == null) return -1;
        for(int i=items.length-1; i>0; i--){
            if(items[i] != null && items[i].equals(elem)) return i;
        }
        return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		if(fromIndex >= items.length || toIndex > items.length){
			throw new ArrayIndexOutOfBoundsException(items.length);
		}
		@SuppressWarnings("unchecked")
		T[] newArr = (T[]) Array.newInstance(items.getClass().getComponentType(), toIndex-fromIndex);
		System.arraycopy(items, 0, newArr, fromIndex, newArr.length);			
		ImmutableList<T> ret = new ImmutableList<>(true, newArr); 
		return ret;
	}
	
}