# Algorithms and data structures. Laboratory work № 2
Here is the second laboratory work on algorithms. It was prepared and performed by Arseniy Nikitin, a student of Group 22PI2 of the Higher School of Economics. We are faced with the following task: There is some random number of rectangles and a random number of points. It is necessary to determine as efficiently as possible how many rectangles each point given to us belongs to.
We will consider three algorithms:
- The brute force algorithm
- Compressed matrix algorithm
- Algorithm of a persistent tree of segments

RU:
Это вторая лабораторная работа по алгоритмам. Она была подготовлена и выполнена Арсением Никитиным, студентом группы 22PI2 Высшей школы экономики. Перед нами стоит следующая задача: имеется некоторое случайное количество прямоугольников и случайное количество точек. Необходимо максимально эффективно определить, скольким прямоугольникам принадлежит каждая заданная нам точка.
Мы рассмотрим три алгоритма:
- Алгоритм грубой силы
- Алгоритм сжатой матрицы
- Алгоритм построения постоянного дерева сегментов
# Let's take a closer
 ### 1) Brute force algorithm
 **Difficulty of implementation** ★☆☆☆☆  (Сложность реализации)  
Preparation difficulty: _**O(1)**_  (Сложность подготовки)  
Search difficulty: _**O(N)**_  (Сложность поиска)  
The final complexity is _**O(N * M)**_  (Итоговая сложность)  

__Solution__:  
The implementation is extremely simple. We iterate through each rectangle for each point and check if its coordinates are inside.  
Ru: Реализация чрезвычайно проста. Мы перебираем каждый прямоугольник для каждой точки и проверяем, находятся ли ее координаты внутри.


### 2) Compressed matrix algorithm
 **Difficulty of implementation** ★★★☆☆  


Preparation difficulty: _**O(N^3)**_  
Search difficulty: _**O(log(N))**_  
The final complexity is _**O(N^3 + M * log(N))**_  

__Solution__:  
At the preparation stage, we are building a matrix. Next, we use a binary search to search for our interval and return the result from the matrix.   
Ru: На этапе подготовки мы строим матрицу. Далее мы используем бинарный поиск для поиска нашего интервала и возвращаем результат из матрицы.
### 3) Compressed matrix algorithm
 **Difficulty of implementation** ★★★★★  



Preparation difficulty: _**O(N * log(N))**_  
Search difficulty: _**O(log(N))**_  
The final complexity is _**O(N * log(N) + M * log(N))**_  

__Solution__:  
At the preparation stage, we are building a matrix. Next, we use a binary search to search for our interval and return the result from the matrix.  
Ru: На этапе подготовки мы строим матрицу. Далее мы используем бинарный поиск для поиска нашего интервала и возвращаем результат из матрицы.  
___
# Launch
```bash
cd *путь до файла*
git clone https://github.com/Mr-Darkson/Research.-Algorithms-and-data-structures-2.git
```
Next, compile and run

```
javac Main.java
java src/main/java/me/absolute/Main.java
```
# Results
