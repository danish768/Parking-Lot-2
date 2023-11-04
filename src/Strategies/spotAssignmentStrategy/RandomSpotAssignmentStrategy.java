package Strategies.spotAssignmentStrategy;

import Models.*;
import Services.ParkingLotService;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    private ParkingLotService parkingLotService;

    public RandomSpotAssignmentStrategy(ParkingLotService parkingLotService){
        this.parkingLotService=parkingLotService;
    }
    @Override
    public ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate) {

        ParkingLot parkingLot = parkingLotService.getParkingLot(gate.getId());
        List<ParkingSpot> parkingSpots = parkingLotService.getParkingSpots(parkingLot.getId());

        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE) &&
                        parkingSpot.getVehicleTypes().contains(vehicleType)){
                return parkingSpot;
            }
        }
        return null;
    }
}
