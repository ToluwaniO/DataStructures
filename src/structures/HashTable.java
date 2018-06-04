package structures;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable<K, V> {

    private class HashNode {
        K key;
        V value;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            HashNode node = (HashNode)obj;
            return node.key == key;
        }
    }

    private final int MAX_CAPACITY = 128;
    private ArrayList<LinkedList<HashNode>> bucket;

    public HashTable() {
        bucket = new ArrayList<>();
    }

    public void add(K key, V value) {
        add(new HashNode(key, value));
    }

    private void add(HashNode node) {
        int hash = node.key.hashCode();
        int index = hash % MAX_CAPACITY;
        LinkedList<HashNode> list = bucket.get(index);
        if(list == null) {
            list = new LinkedList<>();
        }
        list.remove(node);
        list.add(node);
        bucket.add(index, list);
    }

    public V get(K key) {
        HashNode node = new HashNode(key, null);
        int hash = key.hashCode();
        int index = hash % MAX_CAPACITY;
        LinkedList<HashNode> list = bucket.get(index);
        if(list == null) return null;
        for (HashNode h : list) {
            if(node.equals(h)) {
                return h.value;
            }
        }
        return null;
    }

}
