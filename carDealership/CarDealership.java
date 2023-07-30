//Assignment number 5
//Roei Azriel
//ID: 314821109
package carDealership;

import java.io.*;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class CarDealership {

    public static void printmenu(){
        System.out.println("Welcome to the Car dealership menu:");
        System.out.println("1. Show car dealership employee");
        System.out.println("2. Show available car");
        System.out.println("3. sell car");
        System.out.println("4. add car");
        System.out.println("5. EXIT:");
    }

    public static <E extends Comparable> void sort(ArrayList<E> array){
        Collections.sort(array,Collections.reverseOrder());
    }

    public static void main(String[] args) {
            try {
                BufferedWriter sold_car_writer  = new BufferedWriter(new FileWriter("C:\\Users\\Roei\\IdeaProjects\\task2\\src\\carDealership\\sold_car.txt"));
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Roei\\IdeaProjects\\task2\\src\\carDealership\\carDealership.txt.txt"));
                String line;

                // create cars array list and added the cars from the file
                ArrayList<Car> cars = new ArrayList<Car>();
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(" ");
                    try {
                        Car car = new Car(data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                        cars.add(car);
                    }
                    catch (IllegalCarIndexExecption e){
                        System.out.println(e.getMessage());
                    }
                }
                reader.close();


                // create employee array list and added the employee file
                ArrayList<Employee> Employee_array = new ArrayList<Employee>();
                BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\Roei\\IdeaProjects\\task2\\src\\carDealership\\Employee.txt.txt"));


                while((line = reader1.readLine()) != null){
                        String[] data = line.split(" ");
                        try {
                            Employee employee = new Employee(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            Employee_array.add(employee);

                        }
                        catch (IllegalArgumentException e){
                            System.out.println("invalid " + data[0]);
                        }
                }
                reader1.close();
                boolean flag = true;
                CarDealerShipEnum enum_choice = null;
                Scanner input = new Scanner(System.in);
                while(flag){
                    printmenu();
                    int choice_number = input.nextInt();
                    enum_choice = CarDealerShipEnum.values()[choice_number - 1];
                    switch(enum_choice) {
                        case SHOW_EMPLOYEE:
                            sort(Employee_array);
                            for (Employee x : Employee_array) {
                                System.out.println(x);
                            }
                            break;
                        case SHOW_AVAILABLE_CARS:
                            for (Car x : cars) {
                                System.out.println(x);
                            }
                            break;
                        case SELL_CAR:
                            Employee employee_user_choice = null;
                            Car car_user_choice = null;
                            //Enter employee details
                            System.out.println("Please Choose Employee");
                            System.out.println(" ");
                            for (Employee x : Employee_array) {
                                System.out.println(x.getName() + " " + x.getID());
                            }
                            boolean done = true;
                            while(done){
                                System.out.println("Enter Employee number you choose:");
                                long employee_choice = input.nextLong();

                                try {
                                boolean flag_employee = false;
                                for (Employee x : Employee_array) {
                                    if (x.getID() == employee_choice) {
                                        flag_employee = true;
                                        employee_user_choice = x;
                                    }
                                }
                                if (!(flag_employee)) {
                                    throw new IllegalCarIndexExecption(" ");
                                }
                                done = false;
                                System.out.println("The System accept your id");

                            } catch (IllegalCarIndexExecption e) {
                                System.out.println("the id does not match, please enter id again:");
                                    employee_choice = input.nextInt();
                            }
                        }
                            //Enter vehicle details
                            for(Car x : cars){
                                System.out.println(x);
                            }
                            System.out.println("Choose Car number to sell:");
                            long employee_choice = input.nextLong();
                            done = true;
                            while(done){
                                try {
                                    boolean flag_car = false;
                                    for (Car x : cars) {
                                        if (x.getCar_number().equals(Long.toString(employee_choice))){
                                            flag_car = true;
                                            car_user_choice = x;
                                        }
                                    }
                                    if (!(flag_car)) {
                                        throw new IllegalCarIndexExecption(" ");
                                    }
                                    done = false;
                                    System.out.println("The System accept your car");

                                } catch (IllegalCarIndexExecption e) {
                                    System.out.println("invalid car number, choose again");
                                        employee_choice = input.nextInt();
                                }
                            }
                            // מכירת הרכב עדכון מספר מכירות לעובד ושמירת פרטי הרכב ומחיקה מהמערך
                            employee_user_choice.sellcar(car_user_choice,sold_car_writer);
                            cars.remove(car_user_choice);
                            break;

                        case ADD_CAR:
                            System.out.println("enter car number please:");
                            String car_number = input.next();
                            System.out.println("enter production_year:");
                            int production_year = input.nextInt();
                            System.out.println("enter car_brand");
                            String car_brand = input.next();
                            System.out.println("enter kilometer:");
                            int kilometer = input.nextInt();
                            System.out.println("enter price:");
                            int price = input.nextInt();

                            try{
                                Car new_car = new Car(car_number,production_year,car_brand,kilometer, price);
                                cars.add(new_car);
                            }
                            catch (IllegalCarIndexExecption e){
                                System.out.println("The car has not been added - one of the details incorrect");
                            }
                            break;
                        case EXIT:
                            flag =false;
                            break;
                    }
                }
                BufferedWriter CarDealership_writer  = new BufferedWriter(new FileWriter("C:\\Users\\Roei\\IdeaProjects\\task2\\src\\carDealership\\carDealership.txt.txt"));
                for(Car x : cars){
                    CarDealership_writer.write("\n" + x);
                }
                CarDealership_writer.close();
                sold_car_writer.close();

            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
}
