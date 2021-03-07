# Breadth-First-Search

Solving a graph problem with breadth first search

# Problem Description 

Suppose that there are n laptops each containing a wireless transmitter. For each laptop i, following information are known:

* Position, (xi, yi),
* Wireless transmission range, ri That is, we can imagine that the wireless range of laptop i is a circle centered at (xi, yi) with radius r. We say that the laptops i and j can communicate if their wireless ranges overlap. Of course, not every laptop can communicate with every other laptop, but laptops can send messages by using intermediate laptops as routers. Hop distance h(i, j) is defined as the minimum number of intermediate laptops used to send a message from laptop i to laptop j. For example, if two laptops can communicate directly, the hop distance between them is 1. Now, you are asked to do the following:
* Given a set of n agents with their positions and wireless ranges, design an algorithm based on Breadth-first Search (BFS) to compute the hop-distance from the first laptop to every other reachable laptop(s). If agent i is not reachable from agent j then the hop distance h(i, j) will be set to 0.

# My Solution 

At the beginning of my code, I asked the user to enter the input filename then I took the appropriate data in the input file I received and saved it in the arraylist. After getting these values, I created a class called Laptop.
The purpose for me to do this was to find the wireless transmission range for each laptop and keep hop distance data.I saved the x, y and radius values ​​from the input file to the Laptop objects, and while doing this, I enumerated the objects.
After these operations I saved my Laptop objects to an arraylist named a wireless and then I created a twodimensional array called adjacency matrix.The purpose of creating the adjacency matrix was to check whether there is a connection between each other using wireless transmission ranges.
Using the x y and radius values ​​of my laptop objects, I found the wireless transmission ranges and checked whether the laptops were adjacent to each other in a nested loop.Thanks to this nested loop, all possible connection chances were checked and my adjacency matrix was completed.
After these operations, I got the data required to calculate hop distance with Breadth first search. I would have to search all nodes for this purpose.I use a queue for this purpose.
Before starting the search,I created a boolean array called visited, which is for the purpose of not visiting the queued objects again.After starting the search process, I added 
the first element of my wireless array list and changed its hop distance to zero. I made a while loop on condition that queue should not be empty and queue frontmost element has become my root then remove my root.
Root was updated every iteration and I added a neighbor node that is connected to the root and has not been visited, and increased the hop distance of this node.The nodes I added became one more than the previous nodes as hop distance value and their visited status returned to true. These operations continued until the queue was completely empty.

# Space Complexity

I use a two dimensional array to record the connection of each laptop with each other. In the array list there are n elements and each element can be consists of another n elements so the complexity is O (n^2) (n square)

# Time Complexity 

The traversing operation decides the time complexity. Since I use an adjacency list, the complexity can be written as O (V + E) ( V is the number of elements and E is the number of edges)