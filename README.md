# Facade Design Pattern

### **What is the Facade Design Pattern?**

The Facade Design Pattern is a structural pattern that provides a simplified interface to a complex subsystem of classes, making it easier to use. It involves creating a facade (an interface or class) that hides the complexities of the underlying system and provides a unified interface to interact with it.

### **Why do we use FDP?**

1. **Simplification**: It simplifies the usage of a complex system by providing a high-level interface.
2. **Encapsulation**: It hides the complexities of the subsystem, providing a cleaner interface to clients.
3. **Decoupling**: Facade separates the clients from the implementation details, reducing dependencies.

### **How to Implement FDP?**

To implement the Facade pattern:

1. Identify a complex subsystem with various components.
2. Create a facade class/interface that provides a simple interface to access the subsystem's functionality.
3. The facade delegates the client requests to the appropriate objects within the subsystem.

### **When to use the FDP?**

- When there's a need to provide a simple interface to a complex system.
- When you want to decouple the client from a subsystem to enhance maintainability.

### **Real Life Examples of FDP?**

- **Home Entertainment System**: A remote control acts as a facade for the various electronic devices (TV, sound system, etc.) by providing a simple interface to control them.
- **Computer Boot-Up Process**: BIOS (Basic Input/Output System) acts as a facade that hides complex hardware interactions during booting.

### **UML Diagram of FDP?**

!https://upload.wikimedia.org/wikipedia/commons/5/57/Example_of_Facade_design_pattern_in_UML.png

### **Code Example of FDP?**

```java
// Subsystem classes
class CPU {
    public void freeze() {
        // Implementation
    }

    public void jump(long position) {
        // Implementation
    }

    public void execute() {
        // Implementation
    }
}

class Memory {
    public void load(long position, byte[] data) {
        // Implementation
    }
}

class HardDrive {
    public byte[] read(long lba, int size) {
        // Implementation
        return new byte[size]; // Placeholder for example
    }
}

// Facade
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(10);
        cpu.execute();
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
```

### **Additional Info:**

1. **Subsystems**: In this example, **`CPU`**, **`Memory`**, and **`HardDrive`** represent the subsystems. Each class encapsulates the functionality related to its respective component.
2. **Facade Class**: **`ComputerFacade`** acts as a simplified interface to start the computer system. It initializes the subsystems and orchestrates their interactions through the **`start()`** method.
3. **Client Usage**: The **`Main`** class serves as the client. It creates an instance of **`ComputerFacade`** and calls the **`start()`** method to trigger the complex startup process.
4. **Encapsulation**: The facade (**`ComputerFacade`**) hides the complexities of the subsystems from the client, providing a straightforward interface to start the computer.

Remember, the Facade Design Pattern is utilized when there's a need to simplify interaction with a complex system. It enhances readability, reduces dependencies, and promotes better maintainability by encapsulating the complexities behind a unified interface.

- **Facade**: Provides a simplified interface to the subsystem.
- **Subsystem Classes**: Individual components that perform specific tasks within the system.
- **Client**: Utilizes the facade to interact with the subsystem.
