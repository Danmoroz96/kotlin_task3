// Base Class
open class Employee(
    protected val name: String,
    protected val baseSalary: Double
) {
    // Open function allows subclasses to override it
    open fun calculateSalary(): Double {
        return baseSalary
    }

    // Function to get employee details for printing
    override fun toString(): String {
        return name
    }
}

// Subclass 1: FullTimeEmployee
class FullTimeEmployee(
    name: String,
    baseSalary: Double,
    private val bonus: Double
) : Employee(name, baseSalary) {

    // Override to include the bonus in the salary calculation
    override fun calculateSalary(): Double {
        return baseSalary + bonus
    }
}

// Subclass 2: PartTimeEmployee
class PartTimeEmployee(
    name: String,
    private val hourlyRate: Double,
    private val hoursWorked: Int
) : Employee(name, 0.0) { // baseSalary can be 0.0 or ignored for this calculation type

    // Override to calculate salary based on hourly rate and hours worked
    override fun calculateSalary(): Double {
        return hourlyRate * hoursWorked
    }
}

fun main() {
    // Create instances of the different employee types
    val alice = FullTimeEmployee("Alice Smith", 50000.0, 5000.0)
    val bob = PartTimeEmployee("Bob Johnson", 25.0, 160)
    val charlie = FullTimeEmployee("Charlie Davis", 65000.0, 7500.0)
    val dana = PartTimeEmployee("Dana Lee", 18.5, 80)

    // Use mapOf to store the employees
    val employeeMap = mapOf<String, Employee>(
        alice.toString() to alice,
        bob.toString() to bob,
        charlie.toString() to charlie,
        dana.toString() to dana
    )

    println("--- Employee Salary Report ---")
    println("Name (Type) \t\t Salary")
    println("------------------------------------")

    // Loop through the map and display each employee’s salary
    for ((name, employee) in employeeMap) {
        // Polymorphism in action: calling calculateSalary() executes the correct subclass's version
        val salary = employee.calculateSalary()
        val type = when (employee) {
            is FullTimeEmployee -> "Full-Time"
            is PartTimeEmployee -> "Part-Time"
            else -> "Unknown"
        }
        println("$name ($type)\t\t \$${"%.2f".format(salary)}")
    }
    println("------------------------------------")
}
