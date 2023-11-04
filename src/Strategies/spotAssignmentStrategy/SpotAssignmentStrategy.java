package Strategies.spotAssignmentStrategy;

import Models.Gate;
import Models.ParkingSpot;
import Models.VehicleType;

public interface SpotAssignmentStrategy {

    ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate);
}
