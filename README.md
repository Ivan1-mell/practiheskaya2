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
 
