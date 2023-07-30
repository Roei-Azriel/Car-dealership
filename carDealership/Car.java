//Assignment number 5
//Roei Azriel
//ID: 314821109
package carDealership;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.MissingFormatArgumentException;
/**
 * Represents a car with its details.
 */
public class Car {
    protected String car_number;
    protected int production_year;
    protected String car_brand;
    protected int kilometer;
    protected int price;

    /**
     * Constructs a Car object with the specified details.
     *
     * @param car_number      the car number
     * @param production_year the production year
     * @param car_brand       the car brand
     * @param kilometer       the kilometer value
     * @param price           the price of the car
     * @throws IllegalCarIndexExecption if any of the input values is invalid
     */
    public Car(String car_number , int production_year , String car_brand ,int kilometer , int price) throws IllegalCarIndexExecption{

            if(!(car_number.matches("\\d{6}"))) {
             throw new IllegalCarIndexExecption("invalid car number");
            }
            if (production_year < 2017 || production_year > 2023) {
                throw new IllegalCarIndexExecption("invalid production_year");
            }
            if (!(car_brand.matches(("[a-zA-Z]+")))) {
                throw new IllegalCarIndexExecption("invalid car brand");
            }
            if (kilometer < 0) {
                throw new IllegalCarIndexExecption("invalid kilometer");
            }
            if (price < 0) {
                throw new IllegalCarIndexExecption("invalid price (under zero)");
                }
            this.car_number = car_number;
            this.car_brand = car_brand;
            this.kilometer = kilometer;
            this.production_year = production_year;
            this.price = price;
            }

    /**
     * Returns a string representation of the Car object.
     *
     * @return the string representation of the Car object
     */
    @Override
    public String toString() {
        return car_number+" "+production_year + " " + car_brand + " " + kilometer + " " + price;
    }

    /**
     * Reduces the price of the car by the specified percentage.
     *
     * @param percent the percentage value by which to reduce the price
     * @throws IllegalCarIndexExecption if the percent is negative or the reduction exceeds 5000 NIS
     */
    public void reductionvalue(double percent) throws IllegalCarIndexExecption {

            if (percent < 0) {
                throw new IllegalCarIndexExecption("percent under zero");
            }
            if ((percent/100) * price > 5000) {
                throw new IllegalCarIndexExecption("error - more then 5000 NIS");
            }
            int number = (int)(price * (double)(percent/100));
            price = price - number;
    }
    /**
     * Writes the car details to the specified BufferedWriter.
     *
     * @param writer the BufferedWriter to write the details to
     * @throws IOException if an I/O error occurs while writing to the writer
     */
    public void sellcar(BufferedWriter writer) throws IOException {
        writer.write("\n"+car_number+" "+production_year + " " + car_brand + " " + kilometer + " " + price);
    }

    /**
     * Returns the car number.
     *
     * @return the car number
     */
    public String getCar_number() {
        return car_number;
    }

    /**
     * Returns the production year of the car.
     *
     * @return the production year of the car
     */
    public int getProduction_year() {
        return production_year;
    }

    /**
     * Returns the brand of the car.
     *
     * @return the brand of the car
     */
    public String getCar_brand() {
        return car_brand;
    }

    /**
     * Returns the kilometer value of the car.
     *
     * @return the kilometer value of the car
     */
    public int getKilometer() {
        return kilometer;
    }

    /**
     * Returns the price of the car.
     *
     * @return the price of the car
     */
    public double getPrice() {
        return price;
    }
}
