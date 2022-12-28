# OOP_Assignment 1 #
Ex1 in OOP Course. The project were writen by:

* Kfir Zilbernagel
* Roy Ofer
* Tomer Gozlan

In This Ex we will practice about Design patterns, we will learn about Observer, one of many kind of Design patterns.
## Observer pattern ##
In software design and engineering, the observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

It is often used for implementing distributed event-handling systems in event-driven software. In such systems, the subject is usually named a "stream of events" or "stream source of events" while the observers are called "sinks of events." The stream nomenclature alludes to a physical setup in which the observers are physically separated and have no control over the emitted events from the subject/stream source. This pattern thus suits any process by which data arrives from some input that is not available to the CPU at startup, but instead arrives seemingly at random (HTTP requests, GPIO data, user input from peripherals, distributed databases and blockchains, etc.).

Most modern programming languages comprise built-in event constructs implementing the observer-pattern components. While not mandatory, most observer implementations use background threads listening for subject events and other support mechanisms provided by the kernel.

![500px-Observer_w_update svg](https://user-images.githubusercontent.com/99495429/209857130-0170c3d6-84c9-4785-8949-c8ebf938bf44.png)

## Classes ##
### Member interface ###
The Member interface defines the methods that must be implemented by any object that is to be registered as an observer of a subject.

### Sender interface ###
The Sender interface defines the methods that a sender object should implement. This includes methods to register and unregister observers, and methods to manipulate the shared object.

### GroupAdmin class ###
The GroupAdmin class implements the Sender interface, which defines methods to register and unregister Member objects, as well as methods to insert and append strings to the UndoableStringBuilder object, delete strings from the UndoableStringBuilder, and undo previous actions on the UndoableStringBuilder.
The GroupAdmin class has a notifyObservers method that is called whenever there is a change to the UndoableStringBuilder. This method iterates through the list of registered Member objects and calls their update method, passing in the current state of the UndoableStringBuilder as an argument.

### ConcreteMember class ###
The ConcreteMember class is a concrete implementation of the Member interface. This class represents a member who is registered to receive updates from a GroupAdmin. When the update method is called, the ConcreteMember class updates its internal copy of the UndoableStringBuilder object with the current state of the shared UndoableStringBuilder.

## How to use it ##
You need first to create a GroupAdmin object and also ConcreteMember object.
Afterwards you need to register the ConcreteMember with GroupAdmin while using the register function.
Then you can use all the other methods such as insert, appened, delete or undo in order to modify the UndoableStringBuilder object.
The ConcreteMember will automatically notify of the changes that were made and will update its interal copy of UndoableStringBuilder

## How to run it ##
In order to run the project just clone the repository:
git clone https://github.com/Kfirul/OOP_1.git

Have fun :)
