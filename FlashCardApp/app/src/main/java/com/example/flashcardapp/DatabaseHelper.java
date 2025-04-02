package com.example.flashcardapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Name and Version of DB
    public static final String DATABASE_NAME = "flash_card.db";
    private static final int DATABASE_VERSION = 27;

    //Table NMame
    public static final String TABLE_NAME = "flash_cards";

    //Column Names
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_ANSWER = "answer";
    public static final String COLUMN_MASTERED = "mastered";

    //Crate Table
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_QUESTION + " TEXT, " +
            COLUMN_ANSWER + " TEXT, " +
            "mastered INTEGER DEFAULT 0);";

    //Drop table
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create Table in OnCreate
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(Question_1);
        db.execSQL(Question_2);
        db.execSQL(Question_3);
        db.execSQL(Question_4);
        db.execSQL(Question_5);
        db.execSQL(Question_6);
        db.execSQL(Question_7);
        db.execSQL(Question_8);
        db.execSQL(Question_9);
        db.execSQL(Question_10);
        db.execSQL(Question_11);
        db.execSQL(Question_12);
        db.execSQL(Question_13);
        db.execSQL(Question_14);
        db.execSQL(Question_15);
        db.execSQL(Question_16);
        db.execSQL(Question_17);
        db.execSQL(Question_18);
        db.execSQL(Question_19);
        db.execSQL(Question_20);
        db.execSQL(Question_21);
        db.execSQL(Question_22);
        db.execSQL(Question_23);
        db.execSQL(Question_24);
        db.execSQL(Question_25);
        db.execSQL(Question_26);
        db.execSQL(Question_27);
        db.execSQL(Question_28);
        db.execSQL(Question_29);
        db.execSQL(Question_30);
        db.execSQL(Question_31);
        db.execSQL(Question_32);
        db.execSQL(Question_33);
        db.execSQL(Question_34);
        db.execSQL(Question_35);
        db.execSQL(Question_36);
        db.execSQL(Question_37);
        db.execSQL(Question_38);
        db.execSQL(Question_39);
        db.execSQL(Question_40);
        db.execSQL(Question_41);
        db.execSQL(Question_42);
        db.execSQL(Question_43);
        db.execSQL(Question_44);
        db.execSQL(Question_45);
        db.execSQL(Question_46);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
    // Method to get writable database
    public SQLiteDatabase getWritableDatabaseInstance() {
        return this.getWritableDatabase();
    }

    // Method to get readable database
    public SQLiteDatabase getReadableDatabaseInstance() {
        return this.getReadableDatabase();
    }

    //Method to get all data
    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Query all columns from the table
        // null for the selection, selectionArgs, groupBy, having, and orderBy
        // to return all the rows and columns in the table
        return db.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);
    }


    public void wipeTable() {
        SQLiteDatabase db = this.getWritableDatabaseInstance();
        db.execSQL(DROP_TABLE);
        db.execSQL(CREATE_TABLE);
    }
    // Test Insert with mastered status (set to 0 for not mastered)
    private static final String Question_1 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('What is an abstract class in OOP?', 'An abstract class in object-oriented programming (OOP) is a class that cannot be instantiated directly. " +
            "It serves as a blueprint for other classes to inherit from. Abstract classes are used to define a base class with common methods or properties " +
            "that can be shared by subclasses, but they also may contain methods that are not fully implemented " +
            "(i.e., abstract methods). Subclasses are required to provide implementations for these abstract methods.', 0)";

    private static final String Question_2 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('What is the difference between ArrayList and LinkedList in Java?', 'ArrayList uses a dynamic array for storage, offering fast random access (O(1)) " +
            "but slower insertions/deletions (O(n)) due to shifting. LinkedList uses a doubly linked list, allowing faster insertions/deletions (O(1)) but slower access " +
            "(O(n)) as nodes must be traversed. ArrayList is memory-efficient, while LinkedList has more overhead. Use ArrayList for random access and LinkedList for frequent " +
            "insertions/deletions.', 0)";

    private static final String Question_3 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('Explain the concept of the final keyword in Java.', 'The final keyword in Java is used to restrict the user:\n" +
            "Final variable: Once initialized, the value of the variable cannot be changed.\n" +
            "Final method: The method cannot be overridden by subclasses.\n" +
            "Final class: The class cannot be subclassed (i.e., no other class can inherit from it).\n" +
            "Usage: final is often used for constants, for methods that should not be overridden, and for classes that should not be extended.\n" +
            "\n', 0)";

    private static final String Question_4 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('What is the concept of inheritance in OOP?', 'Inheritance is a fundamental concept in object-oriented programming (OOP) " +
            "where one class (child class or subclass) can inherit the fields and methods of another class (parent class or superclass). " +
            "This allows code reusability and establishes a relationship between the parent and child classes.\n" +
            "Single inheritance means that a class can inherit from only one superclass.\n" +
            "Method overriding allows a child class to provide a specific implementation of a method that is already defined in the parent class.\n" +
            "super keyword: In Java, the super keyword is used to refer to the parent class and invoke its methods or constructors.', 0)";
    private static final String Question_5 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('What is polymorphism in OOP?', 'Polymorphism is the ability of different classes to respond to the same method call in their own way. " +
            "It allows for objects of different types to be treated as objects of a common superclass. Polymorphism comes in two forms:\n" +
            "Compile-time polymorphism (Method Overloading): This occurs when multiple methods in a class have the same name but different parameter lists. " +
            "The compiler decides which method to call at compile time.\n" +
            "Runtime polymorphism (Method Overriding): This happens when a subclass provides a specific implementation of a method that is already " +
            "defined in its superclass. The decision about which method to call is made at runtime.', 0)";
    private static final String Question_6 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('What is the time complexity of the following operations in a HashMap: insertion, deletion, and lookup?', 'Insertion: O(1) on average, but can be O(n) in " +
            "the worst case if the hash function leads to too many collisions.\n" +
            "Deletion: O(1) on average, but again can be O(n) in the worst case.\n" +
            "Lookup: O(1) on average. Since the elements are hashed, accessing a value via its key is very fast. However, " +
            "if there are many hash collisions, it can degrade to O(n)', 0)";
    private static final String Question_7 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('What is a deadlock in multithreading?', 'A deadlock occurs in a multithreaded environment when two or more threads " +
            "are blocked forever because they are waiting for each other to release resources. It typically happens when:\n" +
            "\n" +
            "Two threads acquire locks on resources in different orders.\n" +
            "Each thread is holding a resource that the other needs, and they both wait for each other to release the lock.\n" +
            "To avoid deadlocks:\n" +
            "\n" +
            "Lock ordering: Always acquire locks in a consistent order.\n" +
            "Timeouts: Implement timeouts when acquiring locks to avoid infinite waiting.\n" +
            "Deadlock detection: Periodically check for deadlocks and recover.', 0)";

    private static final String Question_8 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('What is the difference between Stack and Queue?', 'Stack: A Stack is a Last In, First Out (LIFO) data structure. The last element added to the stack is the " +
            "first one to be removed. Operations are performed at one end (top). Common operations include push (to add) and pop (to remove).\n" +
            "\n" +
            "Queue: A Queue is a First In, First Out (FIFO) data structure. The first element added to the queue is the first one to be removed. " +
            "Operations are performed at both ends—enqueue (to add) happens at the rear, and dequeue (to remove) happens at the front.', 0)";

    private static final String Question_9 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('What is the difference between shallow copy and deep copy?', 'Shallow Copy: A shallow copy of an object is a bit-by-bit copy. If the object contains " +
            "references to other objects, the shallow copy only copies the references, not the objects themselves. Therefore, both the original and the copied object will " +
            "reference the same memory location for objects that are referenced.\n" +
            "Deep Copy: A deep copy creates a completely new copy of the object, as well as all objects referenced by the original object. This ensures that no references to " +
            "shared objects exist between the original and the copy.\n" +
            "\n', 0)";

    private static final String Question_10 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " +
            "VALUES ('What is the difference between process and thread?', 'Advantages:\n" +
            "\n" +
            "Process: A process is an independent program in execution with its own memory space and resources. Processes do not share memory, so inter-process " +
            "communication (IPC) is required if they need to communicate.\n" +
            "Thread: A thread is a smaller unit of execution within a process. Threads share the same memory space and resources of the parent process. Multithreading allows for " +
            "better resource utilization and can improve performance for tasks that can be parallelized.', 0)";

    private static final String Question_11 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is a race condition, and how can you avoid it?', 'A race condition occurs when multiple threads or processes access shared resources concurrently, and at least one of " +
            "them modifies the resource, leading to unpredictable results. The issue arises because the program`s behavior depends on the timing of thread execution.\n" +
            "\n" +
            "How to avoid race conditions:\n" +
            "\n" +
            "Use synchronization to ensure that only one thread can access shared resources at a time.\n" +
            "Use locks to prevent multiple threads from accessing critical sections simultaneously.\n" +
            "Use atomic operations for shared variables, which guarantee that a variable is updated in a single, uninterrupted operation.', 0)";

    private static final String Question_12 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the difference between a stack and a heap in memory management?', 'Stack: The stack is a region of memory used for storing function call information, local " +
            "variables, and return addresses. The memory is automatically managed; when a function call ends, its local variables are removed from the stack. It is fast, and memory " +
            "allocation/deallocation is done in a LIFO (Last In, First Out) manner.\n" +
            "Heap: The heap is used for dynamically allocated memory (e.g., objects in Java or malloc() in C). Unlike the stack, memory in the heap must be explicitly managed by " +
            "the programmer (using free() in C or delete in C++). It is slower than the stack but allows for more flexible memory management.', 0)";

    private static final String Question_13 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the difference between TCP and UDP?', 'TCP (Transmission Control Protocol): It is a connection-oriented protocol, meaning a connection is established between " +
            "the sender and receiver before data is transmitted. " +
            "It guarantees reliable, ordered delivery of data, using mechanisms like acknowledgments, retransmissions, and flow control.\n" +
            "UDP (User Datagram Protocol): It is a connectionless protocol, meaning there is no need for a handshake between sender and receiver before transmitting data. " +
            "It does not guarantee delivery, ordering, or error correction, making it faster but less reliable than TCP.', 0)";

    private static final String Question_14 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is a deadlock in a database system?', 'Answer: A deadlock in a database system occurs when two or more transactions are waiting for " +
            "each other to release locks on resources, and none of the transactions can proceed because each is waiting for a lock that the other transaction holds.\n" +
            "\n" +
            "How to resolve deadlock:\n" +
            "\n" +
            "Detection: The system periodically checks for cycles in the lock graph and terminates one or more transactions to resolve the deadlock.\n" +
            "Prevention: Ensure that all transactions acquire locks in the same order, or impose a timeout for waiting on locks.\n" +
            "Avoidance: Use algorithms like wait-die or wound-wait to avoid circular wait conditions.\n', 0)";

    private static final String Question_15 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is a binary search tree (BST), and how is it different from a binary tree?', 'Binary Tree: A binary tree is a tree data structure where each node has at most two children. The left and right children of a node do not follow any specific ordering rules.\n" +
            "\n" +
            "Binary Search Tree (BST): A BST is a special type of binary tree where the left child node is less than its parent node, and the right child node is greater than its " +
            "parent node. This property ensures that the BST allows for efficient searching, insertion, and deletion operations in O(log n) " +
            "time on average.', 0)";

    private static final String Question_16 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('Explain the concept of Big O notation and why it`s important in analyzing algorithms.', 'Big O notation is a mathematical representation used to describe the time " +
            "complexity or space complexity of an algorithm in terms of the size of the input. It gives an upper bound on the growth rate of the algorithm’s resource usage, " +
            "focusing on how the algorithm’s performance changes as the input size increases.\n" +
            "\n" +
            "Why it`s important: Big O helps you understand the scalability and efficiency of an algorithm. It enables comparisons between algorithms and helps to make informed " +
            "decisions about which algorithm to choose for a given problem.\n" +
            "O(1): Constant time complexity, independent of input size.\n" +
            "O(n): Linear time complexity, grows linearly with the input size.\n" +
            "O(log n): Logarithmic time complexity, grows slower as the input size increases (e.g., binary search).', 0)";

    private static final String Question_17 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "(' What is normalization in databases, and why is it important?', 'Normalization is the process of organizing the attributes and tables of a database to reduce data " +
            "redundancy and improve data integrity. The goal is to ensure that data is stored in a way that avoids anomalies when performing insertions, deletions, or updates.\n" +
            "\n" +
            "Why it`s important: Normalization helps maintain consistent data, reduces the storage requirements, and ensures that data is logically structured. Common " +
            "normalization forms include 1NF, 2NF, and 3NF.', 0)";

    private static final String Question_18 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is a virtual machine (VM), and how does it differ from a container?', 'Virtual Machine (VM): A VM is an emulation of a physical computer. It runs a full operating system " +
            "and behaves like a separate computer. Each VM has its own complete OS, and it is isolated from other VMs. VMs can be resource-intensive because they require full OS installation and " +
            "a hypervisor to manage them.\n" +
            "\n" +
            "Container: A container is a lightweight, portable unit of software that packages an application and its dependencies. " +
            "Containers share the host system’s kernel, making them more resource-efficient and faster to start compared to VMs. However, " +
            "containers provide less isolation than VMs.', 0)";

    private static final String Question_19 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the difference between overloading and overriding in OOP?', 'Method Overloading: It refers to the ability to define multiple methods in the same class with the same name but " +
            "different parameters (either in type, number, or both). Overloading is resolved at compile time (early binding).\n Method Overriding: It occurs when a subclass provides its own " +
            "implementation of a method that is already defined in its superclass. Overriding is resolved at runtime (late binding).', 0)";

    private static final String Question_20 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is encapsulation in OOP?', 'Encapsulation is the concept of bundling the data (variables) and the methods (functions) that operate on the data into a single unit, or class. " +
            "It restricts direct access to some of the object`s components, which can prevent accidental interference and misuse. " +
            "This is typically done by making fields private and providing public getter and setter methods to access them.', 0)";

    private static final String Question_21 = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What does the static keyword do in Java, and how does it affect static variables and methods?', 'The static keyword in Java defines class-level members, meaning they belong to the class itself, not instances. Here`s a brief overview:\n" +
            "\n" +
            "Static Variables: Shared across all instances of a class. Changes affect all objects, and they`re initialized when the class is loaded.\n" +
            "\n" +
            "Static Methods: Belong to the class and can be called without creating an object. They can only access other static members and are commonly used for utility functions.', 0)";

    private static final String Question_22= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What does the HTTP status code 400 indicate, and what could cause it to occur?', 'The 400 Bad Request status code indicates that the server cannot process the request due to a client-side error, " +
            "such as malformed syntax, invalid request parameters, or missing required information. It typically occurs when the client sends an improperly formatted request or invalid data to the server.', 0)";

    private static final String Question_23= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the meaning of the HTTP status code 404, and when would it typically be used?', 'The 404 Not Found status code means that the server could not find the requested resource. " +
            "It is returned when a user tries to access a URL that does not exist on the server or has been removed.', 0)";

    private static final String Question_24= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('Explain the difference between HTTP status codes 401 Unauthorized and 403 Forbidden.', '401 Unauthorized: This status code indicates that the client needs to authenticate before " +
            "accessing the resource. It often happens when no credentials are provided or the provided credentials are invalid.\n" +
            "403 Forbidden: This status code indicates that the server understands the request but refuses to authorize it. The client may be authenticated, but does not have the required permissions " +
            "to access the resource.', 0)";

    private static final String Question_25= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What does the HTTP status code 500 Internal Server Error mean, and what are some common causes for this error?', 'The 500 Internal Server Error status code indicates that the server " +
            "encountered an unexpected condition that prevented it from fulfilling the request. This is a generic error message, meaning the server failed to process the request but does not specify the exact cause.\n" +
            "\n" +
            "Common causes include:\n" +
            "Server misconfigurations (e.g., incorrect server settings).\n" +
            "Application bugs or crashes.\n" +
            "Unhandled exceptions in the server-side code.\n" +
            "Issues with server resources (e.g., database errors or insufficient memory).\n" +
            "To resolve this error, server logs should be checked to identify the root cause and fix the issue.', 0)";

    private static final String Question_26= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What are the 7 layers of the OSI model:', '1: Physical Layer\n2: Data Link Layer\n3: Network Layer\n4: Transport Layer\n5: Session Layer\n6: Presentation Layer\n7: " +
            "Application Layer\n\n\"Please Do Not Throw Sausage Pizza Away\"', 0)";

    private static final String Question_27= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the Singleton design pattern, and when should it be used?', 'The Singleton pattern ensures that a class has only one instance and provides a global point of " +
            "access to it. It`s commonly used for scenarios like managing a single connection to a " +
            "database or logging, where only one instance of the class should exist throughout the application to maintain consistency and reduce resource consumption', 0)";

    private static final String Question_28= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the Factory Method pattern, and why is it useful?', 'The Factory Method pattern defines an interface for creating objects but allows subclasses to alter the " +
            "type of objects that will be created. It’s useful when you want to create objects without specifying the exact " +
            "class of the object being created, enabling flexibility and decoupling of code. It’s often used when the creation process involves complex logic or conditional steps.', 0)";

    private static final String Question_29= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the Observer pattern, and how is it applied?', 'The Observer pattern allows an object (subject) to notify a list of dependent objects (observers) automatically when its state changes. " +
            "It’s used in scenarios where changes in one part of a system " +
            "should automatically trigger updates in other parts, like in UI frameworks where a button click updates multiple components, or in event-driven systems like chat applications.', 0)";

    private static final String Question_30= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is Spring MVC, and how does it work?', 'Spring MVC is a web framework within the Spring ecosystem for building web applications following the Model-View-Controller pattern. " +
            "It separates the application into three layers: the Model (business logic), the View (UI representation), and the Controller (handles user requests and updates the model). " +
            "It allows flexible routing and view resolution, making it easier to develop web applications in a decoupled manner.', 0)";

    private static final String Question_31= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is Inversion of Control (IoC) in Spring, and how does it benefit application development?', 'Inversion of Control (IoC) is a design principle where the " +
            "control over object creation and dependencies is shifted from the application code to a container or framework, like Spring. In Spring, IoC is implemented using " +
            "the ApplicationContext container, which manages object creation and dependency injection. It promotes loose coupling, easier testing, and better maintainability by " +
            "decoupling object creation and dependencies from the business logic.', 0)";

    private static final String Question_32= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is Dependency Injection in Spring?', 'Dependency Injection (DI) in Spring is a design pattern where Spring`s IoC (Inversion of Control) container manages " +
            "the creation and injection of objects (dependencies) into classes. This decouples class dependencies and enhances testability, maintainability, and flexibility. " +
            "DI can be done through constructor injection, setter injection, or field injection.', 0)";

    private static final String Question_33= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the role of the @Controller annotation in Spring MVC?', 'The @Controller annotation in Spring MVC marks a class as a controller that handles HTTP requests. " +
            "It is used to define a controller class, which contains methods that are mapped to specific URLs. These methods return model data and view names, which Spring MVC " +
            "uses to render the appropriate response to the client.', 0)";

    private static final String Question_34= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is Spring Boot, and how does it relate to Spring MVC?', 'Spring Boot is an extension of the Spring Framework that simplifies the setup and configuration of " +
            "Spring applications. It provides production-ready features, like embedded servers (Tomcat, Jetty), auto-configuration, and easy dependency management. Spring Boot often " +
            "integrates with Spring MVC to build web applications, allowing developers to create stand-alone applications without needing complex XML configuration.', 0)";

    private static final String Question_35= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the difference between abstract class and interface?', 'An abstract class can have both abstract methods (without implementation) and " +
            "concrete methods (with implementation). An interface only allows abstract methods (before Java 8) and cannot have any implementation. An abstract class can " +
            "extend only one class, while an interface can be implemented by multiple classes.', 0)";

    private static final String Question_36= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is multithreading?', 'Multithreading is a concurrent execution technique that allows multiple threads to run independently within a process. Each thread " +
            "represents a separate path of execution, making it possible to perform multiple tasks simultaneously, improving efficiency in CPU-bound or I/O-bound operations.', 0)";

    private static final String Question_37= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the **difference between == and equals() in Java?', '== compares object references (memory addresses) to see if two objects are the same. equals() " +
            "compares the actual contents or state of the objects. By default, equals() behaves like == unless overridden in the class.', 0)";

    private static final String Question_38= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is SQL injection?', 'SQL injection is a security vulnerability that allows an attacker to interfere with the queries an application makes to its database. " +
            "It occurs when user input is improperly sanitized, allowing malicious SQL code to be executed, potentially exposing sensitive data or damaging the database.', 0)";

    private static final String Question_39= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is RESTful API?', 'A RESTful API is an architectural style for web services that uses HTTP requests to perform CRUD operations (Create, Read, Update, Delete) " +
            "on resources. It relies on stateless communication and standard HTTP methods (GET, POST, PUT, DELETE). REST APIs are lightweight and easy to scale.', 0)";

    private static final String Question_40= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is garbage collection in Java?', 'Garbage collection in Java is the automatic process of reclaiming memory from objects that are no longer in use or reachable. " +
            "The JVM (Java Virtual Machine) performs garbage collection to ensure efficient memory management, freeing developers from manually managing memory.', 0)";

    private static final String Question_41= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is refactoring?', 'Refactoring is the process of improving the internal structure of code without changing its external behavior. It aims to make the code more efficient, " +
            "readable, and maintainable by removing redundancies, improving naming, and simplifying complex code.', 0)";

    private static final String Question_42= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the Adapter design pattern?', 'The Adapter pattern allows incompatible interfaces to work together by providing a wrapper class that translates the interface of " +
            "one class into another expected by the client. It enables reusability of legacy code without modifying it.', 0)";

    private static final String Question_43= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is synchronization in Java?', 'Synchronization is the process of controlling access to a shared resource by multiple threads. It ensures that only one thread can access the " +
            "resource at a time, preventing issues like data inconsistency. In Java, synchronization is implemented using the synchronized keyword.', 0)";

    private static final String Question_44= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What are Lambda expressions in Java?', 'Lambda expressions in Java allow you to write more concise and functional-style code. They provide a way to represent functions " +
            "as objects. Lambda expressions are often used with Java`s stream API to enable more readable and expressive code for operations on collections.', 0)";
    private static final String Question_45= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the Prototype design pattern?', 'The Prototype pattern allows cloning of objects, where a new instance is created by copying an existing object (the prototype). " +
            "It is useful when object creation is complex or costly, and you need multiple identical objects without directly constructing them.', 0)";
    private static final String Question_46= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('What is the difference between a List and Set in Java?', 'A List allows duplicate elements and maintains the order of insertion (e.g., ArrayList). A Set does not " +
            "allow duplicates and does not guarantee order (e.g., HashSet). Sets are typically used when uniqueness is important.', 0)";
    private static final String Question_47= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('q', 'a', 0)";
    private static final String Question_48= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('q', 'a', 0)";
    private static final String Question_49= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('q', 'a', 0)";
    private static final String Question_50= "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_MASTERED + ") " + "VALUES " +
            "('q', 'a', 0)";


}
