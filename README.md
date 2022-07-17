# This repository is for the IptiQ recruitment team

This repository contains my submission to the technical assignment. The src folder contains my java code, whereas the iptiq.pdf contains my description of the ideal architecture and the reasoning behind it. 

I would like to point out that the proposed architecture is very different to my implementation due to the proposed architecture requiring significantly more time to setup and I believe also being outside the scope of the assignment. 

## Explanation of my code
I created 3 classes:
- Item
    - The Item class contains 3 fields: price, quantity, and name. 
    - They also contain getters and setters in order for them to be altered when necessary.
- Inventory
    - The Inventory is essentially a HashMap, but with methods that allow the user to easily retrieve, edit, and delete items from it.
    - The reasoning behind using a HashMap is that retrieval of an item is done in O(1), and with an inventory system being able to grow significantly large, I believe this is a valuable optimization.
- UserInterface
    - The user interface prints a small set of instructions to the user which allows the user to either print, edit, add, remove items from inventory.
    - The interface is controlled by typing an input number between 1-7 and then pressing enter.
