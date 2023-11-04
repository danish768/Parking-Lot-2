package Services;

import Exceptions.InvalidGateException;
import Models.*;
import Repository.TicketRepository;
import Strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import Strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {

    private VehicleService vehicleService;
    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingSpotService parkingSpotService;
    private TicketRepository ticketRepository;

    public TicketService(VehicleService vehicleService,GateService gateService,
                         SpotAssignmentStrategy spotAssignmentStrategys,ParkingSpotService parkingSpotService,
                         TicketRepository ticketRepository){
        this.vehicleService=vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategys;
        this.parkingSpotService=parkingSpotService;
        this.ticketRepository=ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, Long gateId, VehicleType vehicleType) throws InvalidGateException {
        //Logic
        //Check if the vehicle is already present in the DB.
        //vehicleRepository.getVehicleByVehicleNumber(String vehicleNumber).
        //If not, create an object for the vehicle and store in the DB.

        //Way1: Directly call the vehicle repository.
        //Way2: Call the VehicleService and vehicleService will internally call the VehicleRepository.

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if(vehicle==null){
            vehicleService.registerVehicle(vehicleNumber,vehicleType);
        }

        Gate gate= gateService.getGateDetails(gateId);
        if(gate==null){
            throw new InvalidGateException("Please enter the correct gateId");
        }
        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());

        //Assign the Parking Spot.

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignParkingSpot(vehicleType,gate);
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        parkingSpotService.markParkingSpotAsOccupied();

        if(parkingSpot != null){
            ticket.setParkingSpot(parkingSpot);
        }
        //Before returning the ticket store to DB.
        ticket = ticketRepository.saveTicket(ticket);

        return ticket;

    }
}
