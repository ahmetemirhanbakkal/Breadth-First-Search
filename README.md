# Breadth-First-Search

Solving a graph problem with breadth first search

# Problem Description 

Suppose that there are n laptops each containing a wireless transmitter. For each laptop i, following information are known:

* Position, (xi, yi),
* Wireless transmission range, ri That is, we can imagine that the wireless range of laptop i is a circle centered at (xi, yi) with radius r. We say that the laptops i and j can communicate if their wireless ranges overlap. Of course, not every laptop can communicate with every other laptop, but laptops can send messages by using intermediate laptops as routers. Hop distance h(i, j) is defined as the minimum number of intermediate laptops used to send a message from laptop i to laptop j. For example, if two laptops can communicate directly, the hop distance between them is 1. Now, you are asked to do the following:
* Given a set of n agents with their positions and wireless ranges, design an algorithm based on Breadth-first Search (BFS) to compute the hop-distance from the first laptop to every other reachable laptop(s). If agent i is not reachable from agent j then the hop distance h(i, j) will be set to 0.

# My Solution 

