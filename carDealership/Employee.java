//Assignment number 5
//Roei Azriel
//ID: 314821109
package carDealership;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Represents an employee with their details.
 */
public class Employee implements Comparable <Employee> {
    private String name;
    private int ID;
    private int number_of_sales;

    /**
     * Constructs an Employee object with the specified details.
     *
     * @param name            the name of the employee
     * @param ID              the ID of the employee
     * @param number_of_sales the number of sales made by the employee
     * @throws IllegalArgumentException if any of the input values is invalid
     */
    Employee(String name, int ID, int number_of_sales) throws IllegalArgumentException {
        if (!(name.matches("[a-zA-Z]+"))) {
            throw new IllegalArgumentException("invalid name");
        }
        if (ID < 100000000 || ID > 999999999) {
            throw new IllegalArgumentException("invalid ID");
        }
        if (number_of_sales < 0) {
            throw new IllegalArgumentException("invalid number of sales");
        }
        this.name = name;
        this.ID = ID;
        this.number_of_sales = number_of_sales;
    }
    /**
     * Returns the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the employee.
     *
     * @return the ID of the employee
     */
    public int getID() {
        return ID;
    }
    /**
     * Returns the number of sales made by the employee.
     *
     * @return the number of sales made by the employee
     */
    public int getNumber_of_sales() {
        return number_of_sales;
    }

    /**
     * Calculates and returns the salary of the employee.
     *
     * @return the salary of the employee
     */
    public int salary() {
        return 6000 + (100 * number_of_sales);
    }

    /**
     * Returns a string representation of the Employee object.
     *
     * @return the string representation of the Employee object
     */
    @Override
    public String toString() {
        int salary = salary();
        return name + " " + ID + " " + number_of_sales + " || salary:" + salary;
    }

    /**
     * Writes the car details to the specified BufferedWriter.
     *
     * @param car    the car to sell
     * @param writer the BufferedWriter to write the details to
     * @throws IOException if an I/O error occurs while writing to the writer
     */
    public void sellcar(Car car, BufferedWriter writer) throws IOException {
        car.sellcar(writer);
        number_of_sales++;
    }
    /**
     * Compares this Employee object with another Employee object based on their number of sales.
     *
     * @param other the other Employee object to compare to
     * @return 0 if the number of sales is equal, a positive value if this Employee has more sales,
     *         or a negative value if the other Employee has more sales
     */
    public int compareTo(Employee other) {
        if (this.number_of_sales == other.number_of_sales) {
            return 0;
        } else if (this.number_of_sales > other.number_of_sales) {
            return 1;
        } else
            return -1;
    }
}



