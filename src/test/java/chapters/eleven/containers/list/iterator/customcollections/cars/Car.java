package chapters.eleven.containers.list.iterator.customcollections.cars;

import java.util.Objects;

public class Car implements Comparable {
    protected String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    final public String toString() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(brand);
    }

    @Override
    public int compareTo(Object o) {
        return brand.compareTo(o.toString());
    }
}
