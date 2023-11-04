package Services;

import Models.ParkingLot;
import Models.ParkingSpot;
import Repository.ParkingLotRepository;

import java.util.List;

public class ParkingLotService{

    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository=parkingLotRepository;
    }
    public List<ParkingSpot> getParkingSpots(Long parkingLotId){
        return null;
    }

    public ParkingLot getParkingLot(Long gateId){
        return parkingLotRepository.getParkingLot(gateId);
    }
}
