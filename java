    import java.util.PriorityQueue;

    class BinaryHeap {
        private PriorityQueue<Integer> heap;

        public BinaryHeap() {
            heap = new PriorityQueue<>();
        }

        public void insert(int key) {
            heap.add(key);
        }

        public Integer extractMin() {
            return heap.poll();
        }
    }

    import java.util.HashMap;
    import java.util.LinkedList;

    class HashTable<K, V> {
        private int size;
        private LinkedList<Entry<K, V>>[] table;

        public HashTable(int size) {
            this.size = size;
            table = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                table[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {
            int index = hash(key) % size;
            LinkedList<Entry<K, V>> list = table[index];
            for (Entry<K, V> entry : list) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }
            list.add(new Entry<>(key, value));
        }

        public V get(K key) {
            int index = hash(key) % size;
            LinkedList<Entry<K, V>> list = table[index];
            for (Entry<K, V> entry : list) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
            return null;
        }

        private int hash(K key) {
            return Math.abs(key.hashCode());
        }

        private static class Entry<K, V> {
            K key;
            V value;

            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }
