# Algorithms and data structures. Laboratory work № 2
Here is the second laboratory work on algorithms. It was prepared and performed by Arseniy Nikitin, a student of Group 22PI2 of the Higher School of Economics. We are faced with the following task: There is some random number of rectangles and a random number of points. It is necessary to determine as efficiently as possible how many rectangles each point given to us belongs to.
We will consider three algorithms:
- The brute force algorithm
- Compressed matrix algorithm
- Algorithm of a persistent tree of segments
# Let's take a closer look at these algorithms
 ### 1) Brute force algorithm
 **Difficulty of implementation** ★☆☆☆☆  
Preparation difficulty: _**O(1)**_  
Search difficulty: _**O(N)**_  
The final complexity is _**O(N * M)**_  

__Solution__:  
The implementation is extremely simple. We iterate through each rectangle for each point and check if its coordinates are inside.


### 2) Compressed matrix algorithm
 **Difficulty of implementation** ★★★☆☆  



Preparation difficulty: _**O(N^3)**_  
Search difficulty: _**O(log(N))**_  
The final complexity is _**O(N^3 + M * log(N))**_  

__Solution__:  
At the preparation stage, we are building a matrix. Next, we use a binary search to search for our interval and return the result from the matrix. 
 
### 3) Compressed matrix algorithm
 **Difficulty of implementation** ★★★★★  



Preparation difficulty: _**O(N * log(N))**_  
Search difficulty: _**O(log(N))**_  
The final complexity is _**O(N * log(N) + M * log(N))**_  

__Solution__:  
At the preparation stage, we are building a matrix. Next, we use a binary search to search for our interval and return the result from the matrix.
___
# Launch
```bash
cd *путь до файла*
git clone https://github.com/Mr-Darkson/Research.-Algorithms-and-data-structures-2.git
```
Далее компилируем и запускаем

```
javac Main.java
java src/main/java/me/absolute/Main.java
```
# Results
