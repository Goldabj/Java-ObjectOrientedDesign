package problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This universal object holds all possible fields into a hashmap. 
 * it supports get, set, addto, and increment methods
 * 
 * @author goldacbj
 *
 */
public class UniversalObject {
	private Map<String, Object> fields;
	

	public UniversalObject() {
		this.fields = new HashMap<>();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String fieldName) {
		return (T) fields.get(fieldName);
	}
	
	public <T> void set(String fieldName, T toSet) {
		fields.put(fieldName, toSet);
	}
	
	public void increment(String fieldName) {
		Object value = fields.get(fieldName);
		if(value == null) {
			fields.put(fieldName, 0);
			value = 0;
		}
		int val = (Integer) value;
		val++;
		fields.put(fieldName, val);
	}
	
	public <T extends Collection<S>, S> void addTo(String collectionName, S valueToAdd) {
		@SuppressWarnings("unchecked")
		Collection<S> collection = (T) fields.get(collectionName);
		if (collection == null) {
			collection = new ArrayList<S>();
		}
	
		collection.add(valueToAdd);
		fields.put(collectionName, collection);
	}
	
	public <T> String toString(Class<T> type) {
		Iterator<String> keyIter = fields.keySet().iterator();
		StringBuilder s = new StringBuilder();
		s.append(type.getName() + "{ \n");
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			Object val = fields.get(key);
			s.append("\t");
			s.append(key + ": " + val.toString() + " \n");
		}
		s.append("}\n");
		return s.toString();
		
		
	}

}
