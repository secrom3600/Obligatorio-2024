/**
 * 
 */
package src.uy.edu.um.TADs.binarytree.hash;

import uy.edu.um.adt.linkedlist.MyList;

public interface MyHash<Key, Value> {

	/**
	 * Agrega la clave dentro del hash
	 * @param key
	 * @param value
	 */
	void put(Key key, Value value);

	/**
	 * Retorna null si no existe la clave si no el valor asociado
	 * @param key
	 * @return
	 */
	Value get(Key key);

	/**
	 * Retorna true la clave existe false en caso contrario
	 * @param key
	 * @return
	 */
	boolean contains(Key key);

	/**
	 * Remueve un elemento con la key indicada
	 * @param key
	 */
	void remove(Key key);
	
	/**
	 * Obtiene la lista de keys disponibles del hash
	 * @return
	 */
	MyList<Key> keys();

	/**
	 * Obtiene la lista de values disponibles del hash
	 * @return
	 */
	MyList<Value> values();

	/**
	 * Obtiene la cantidad de elementos dentro del hash
	 * @return
	 */
	int size();
	
}
