import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MaxSizeHashMap<K, V>
{
	private int maxSize;
	
	private Map<K, V> wrappedMap;
	
	public MaxSizeHashMap(int maxSize)
	{
		this.maxSize = maxSize;
		wrappedMap = new HashMap<K, V>();
	}
	
	public void put(K key, V value) throws MaxSizeExceededException, DuplicateKeyException
	{
		if (wrappedMap.size() >= maxSize && !wrappedMap.containsKey(key))
		{
			throw new MaxSizeExceededException("Size of HashMap exceeded " + maxSize + ".");
		}
		else if (wrappedMap.containsKey(key))
		{
			throw new DuplicateKeyException("HashMap already contains key " + key + ".");
		}
		else
		{
			wrappedMap.put(key, value);
	    }
	}
	
	public V remove(String key)
	{
		return wrappedMap.remove(key);
	}
	
	public boolean isFull()
	{
		return wrappedMap.size() == maxSize;
	}
	
	public boolean isEmpty()
	{
		return wrappedMap.isEmpty();
	}
	
	public boolean containsKey(String key)
	{
		return wrappedMap.containsKey(key);
	}
	
	public Set<Entry<K, V>> getEntrySet()
	{
		return wrappedMap.entrySet();
	}
}