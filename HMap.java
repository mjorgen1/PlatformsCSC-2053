public class HMap<K,V> {
  protected MapEntry<K,V>[] map; 
  protected final int DEFCAP = 100; //default capacity
  protected int currCap;  // current capacity
  protected int numPairs = 0;  // number of pairs in this map

  public HMap() {
     map = new MapEntry[DEFCAP];
     currCap = DEFCAP;
  }

  public HMap(int initCap) {
    map = new MapEntry[DEFCAP];
    currCap = initCap;
  }

  public V put(K k, V v) {
   //If an entry in this map with key k already exists then replace with new value
   // and return the existing value
   //add the (k,v) pair to the map using linear probing and return null
    if(k == null) { throw new IllegalArgumentException();}
    
    MapEntry<K,V> entry = new MapEntry<K,V>(k,v);
    int location = Math.abs(k.hashCode()) % currCap;
    while((map[location] != null)&& !(map[location].getKey().equals(k))) {
      location = (location + 1) % currCap;
    }
    if(map[location] == null) { //k not in map
      map[location] = entry;
      numPairs++;
      //System.out.println(location + " " + v + " " + ((VKey)(k)).getVid());
      return null;
    }
    else { //k already in map
      V temp = map[location].getValue();
      map[location] = entry;
      return temp; 
    }
  }

  public V get(K k) {
  //If an entry with key k exists, return the value, otherwise return null
    int location = Math.abs(k.hashCode()) % currCap;
    while((map[location] != null) && !(map[location].getKey().equals(k))) {
      location = (location + 1) % currCap;
    }
    if(map[location] == null)
      return null;
    else
      return map[location].getValue();
  } 

  public V remove(K k) {
  // Remove an entry with key k.  Set the location to null.  Be sure to check for linear probing. 
  // If an item had a conflict linear probing put it down the map, remove that item and re-add it
  // If key doesn't exist in the map, return null
    if(k == null)
      return null;
    //find the location of the key
    int location = Math.abs(k.hashCode()) % currCap;
    V value = null;
    while((map[location] != null)) {
      if(map[location].getKey().equals(k)) {
        value = map[location].getValue();
        map[location] = null;
      }
      else {
        V reVal = map[location].getValue();
        K key = map[location].getKey(); 
        map[location] = null;
        put(key, reVal);
      }
      location = (location + 1) % currCap;
    }
    return value;
  }

  public boolean contains(K k) {
  // Returns true if an entry in this map with key k exists;
  // Returns false otherwise
    boolean contains = false;
    if(k == null)
      return contains;
    int location = Math.abs(k.hashCode()) % currCap;
    while((map[location] != null) && !(map[location].getKey().equals(k))) {
      location = (location + 1) % currCap;
    }
    if(map[location] != null && map[location].getKey().equals(k))
        contains = true;
    return contains;
  }

  public int size() {
    return numPairs;
  }
}
