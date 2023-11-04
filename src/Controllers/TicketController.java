package Controllers;

import Dto.GenerateTicketRequestDto;
import Dto.GenerateTicketResponseDto;
import Exceptions.InvalidGateException;
import Models.Gate;
import Models.GenerateTicketResponseStatus;
import Models.Ticket;
import Models.Vehicle;
import Services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto dto) {

        /*
        Steps:-
        Input: Vehicle number and gate id.
        1.Get the vehicle details from the vehicle number.
                -If the vehicle is there in DB then return the object.
                -If not (vehicle is coming for the first time), then create the object
                 and store in the DB.
        2.Get the Gate details from the gate id.

        -> Controllers should be as light as possible.
        The logic for creating a Ticket should go in TicketService class.

         */
        Ticket ticket = null;

        try {
            ticket=ticketService.generateTicket(dto.getVehicleNumber(),dto.getGateId(),dto.getVehicleType());
        } catch (InvalidGateException e) {
            throw new RuntimeException(e);
        }

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        responseDto.setTicket(ticket);
        responseDto.setResponseStatus(GenerateTicketResponseStatus.SUCCESS);


        return responseDto;
    }
}
