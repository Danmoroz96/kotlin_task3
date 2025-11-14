# kotlin_task3
Kotlin OOP: Employee Salary Calculation  This program demonstrates core Object-Oriented Programming (OOP) principles in Kotlin through the creation of an Employee salary system.
# Kotlin OOP: Employee Salary Calculation

## Program Description

1.  **Employee (Base Class):** Contains protected properties for `name` and `baseSalary`, and an `open` function `calculateSalary()`.
2.  **FullTimeEmployee (Subclass):** Inherits from `Employee` and overrides `calculateSalary()` to include an additional `bonus`.
3.  **PartTimeEmployee (Subclass):** Inherits from `Employee` and overrides `calculateSalary()` to calculate pay based on `hourlyRate` and `hoursWorked`.
4.  A `mapOf` is used to store various instances of these subclasses.
5.  The program iterates over the map, calling the appropriate `calculateSalary()` function for each employee using **polymorphism** to display their final compensation.
