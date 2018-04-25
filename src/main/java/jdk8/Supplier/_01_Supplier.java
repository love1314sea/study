package jdk8.Supplier;

import java.util.function.Supplier;

/**
 * Created by wushang on 2018/1/10.
 */
public class _01_Supplier {

	static void driveVehicle(Supplier<? extends Vehicle> supplier) {
		Vehicle vehicle = supplier.get();
		vehicle.drive();
	}

	public static void main(String[] args) {
//Using Lambda expression
		driveVehicle(() -> new Vehicle());
		driveVehicle(() -> new Car());

//Using method expression
		driveVehicle(Vehicle::new);
		driveVehicle(Car::new);
	}
}


class Vehicle {
	public void drive() {
		System.out.println("Drivingcle …");
	}
}

class Car extends Vehicle {
	@Override
	public void drive() {
		System.out.println("Driving");
	}
}