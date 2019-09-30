# Computer Science

## Basic Data Structures
Data can be structured in many ways but the commonly used practices are given below:
* **Array**
* **List**
* **Hash table**
* **Stack**
* **Queue**
* **Tree**
* **Set**

*The data structures provided by the Java utility package **java.util**, contains all the classes and interfaces for the Collection framework.*

![Collection Framework](https://static.javatpoint.com/images/java-collection-hierarchy.png)

### Array
An array is a container object that holds a fixed number of values of a single type. The length of an array is established when the array is created. 
After creation, its ***length is fixed.***

![Array](https://docs.oracle.com/javase/tutorial/figures/java/objects-tenElementArray.gif)

In case of primitives data types, the actual values are stored in contiguous memory locations. In case of objects of a class, the actual objects are stored in heap segment.
Each item in an array is called an element, and each element is accessed by its numerical index. 
As shown in the preceding illustration, numbering begins with 0. The 9th element, for example, would therefore be accessed at index 8.

### List
 The Java.util.List is a child interface of Collection. It is an ordered collection of objects in which duplicate values can be stored. 
 Since List preserves the insertion order, it allows positional access and insertion of elements. 
 List Interface is implemented by **ArrayList**, **LinkedList**, **Vector** and **Stack** classes.
 
 #### ArrayList
 The ArrayList class is a resizable array. The difference between a built-in array and an ArrayList in Java, 
 is that the size of an array cannot be modified (if you want to add or remove elements to/from an array, 
 you have to create a new one). While elements can be added and removed from an ArrayList whenever you want. 
 The syntax is also slightly different.