    #include <vector>
    #include <algorithm>

    class BinaryHeap {
    private:
        std::vector<int> heap;
    public:
        void insert(int key) {
            heap.push_back(key);
            std::push_heap(heap.begin(), heap.end(), std::greater<int>());
        }

        int extract_min() {
            if (!heap.empty()) {
                std::pop_heap(heap.begin(), heap.end(), std::greater<int>());
                int min_val = heap.back();
                heap.pop_back();
                return min_val;
            } else {
                return -1; // Или другое значение по умолчанию
            }
        }
    };

    #include <iostream>
    #include <string>
    #include <vector>

    class HashTable {
    private:
        std::vector<std::vector<std::pair<std::string, int>>> table;
        int size;

    public:
        HashTable(int size) : size(size), table(size) {}

        void insert(const std::string& key, int value) {
            int index = hash(key) % size;
            table[index].push_back(std::make_pair(key, value));
        }

        int get(const std::string& key) {
            int index = hash(key) % size;
            for (const auto& pair : table[index]) {
                if (pair.first == key) {
                    return pair.second;
                }
            }
            return -1; // Или другое значение по умолчанию
        }

    private:
        unsigned int hash(const std::string& key) {
            unsigned int hashValue = 0;
            for (char c : key) {
                hashValue = hashValue * 31 + c;
            }
            return hashValue;
        }
    };
