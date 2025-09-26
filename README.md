## Конспект: Структуры данных в Python, C++, Java

## 1. Бинарная и биномиальная кучи

Бинарная куча:

· Полное бинарное дерево.
· Свойства:
  · Все уровни заполнены, кроме, возможно, последнего.
  · Заполнение слева направо.
  · Min-куча: родитель ≤ дети; Max-куча: родитель ≥ дети.
· Реализуется через массив.

Биномиальная куча:

· Набор биномиальных деревьев разного размера.
· Свойства:
  · Ключ вершины ≥ ключа родителя.
  · Корень каждого дерева — минимальный ключ в нём.
· Поддерживает слияние куч.

Реализация:

· Python: модуль heapq (только min-heap), возможна реализация своего класса.
· C++: классы MinHeap, BinomialHeap с поддержкой вставки, удаления, слияния.
· Java: классы BinaryHeap, BinomialHeap с аналогичными операциями.
 

## 2. Куча Фибоначчи

· Не встроена в стандартные библиотеки.
· Поддерживает:
  · insert, unite, getMin, extractMin, decreaseKey, deleteElement.
· Реализуется через многосвязные деревья с оптимизацией операций.

Реализация:

· C++: шаблонный класс FibonacciHeap.
· Java: рекурсивный расчёт чисел Фибоначчи (не сама структура кучи).

 

## 3. Хеш-таблицы

· Структура «ключ–значение».
· Коллизии решаются:
  · Метод цепочек (chaining).
  · Открытая адресация.

Реализация:

· Python: встроенный dict, либо свой класс HashTable.
· C++: std::unordered_map или ручная реализация с цепочками.
· Java: Hashtable, HashMap из пакета java.util.

 

## Ключевые операции для всех структур:

· Вставка
· Удаление
· Поиск минимума (для куч)
· Слияние (для биномиальной и Фибоначчи)
· Обновление ключа

 

## Особенности языков:

· Python: простота, heapq, dict.
· C++: производительность, STL, ручная работа с памятью.
· Java: готовые классы в Collections, строгая типизация.

'''py
import heapq

class BinaryHeap:
    def __init__(self, initial_data=None):
        self.heap = []
        if initial_data is not None:
            for item in initial_data:
                self.insert(item)
    
    def insert(self, key):
        heapq.heappush(self.heap, key)
    
    def extract_min(self):
        if not self.heap:
            return None
        return heapq.heappop(self.heap)
    
    def peek_min(self):
        if not self.heap:
            return None
        return self.heap[0]
    
    def is_empty(self):
        return len(self.heap) == 0
    
    def size(self):
        return len(self.heap)
    
    def __len__(self):
        return len(self.heap)
    
    def __bool__(self):
        return len(self.heap) > 0
'''

'''py
class HashTable:
        def __init__(self, size=10):
            self.size = size
            self.table = [None] * size

        def __setitem__(self, key, value):
            index = hash(key) % self.size
            if self.table[index] is None:
                self.table[index] = [(key, value)]
            else:
                self.table[index].append((key, value))

        def __getitem__(self, key):
            index = hash(key) % self.size
            if self.table[index] is not None:
                for k, v in self.table[index]:
                    if k == key:
                        return v
            return None
  '''

  '''c++
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
'''

'''c++
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
'''
