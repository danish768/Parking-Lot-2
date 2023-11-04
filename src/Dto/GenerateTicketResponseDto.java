package Dto;

import Models.GenerateTicketResponseStatus;
import Models.Ticket;

public class GenerateTicketResponseDto {

    private Ticket ticket;
    private GenerateTicketResponseStatus responseStatus;


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public GenerateTicketResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(GenerateTicketResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
