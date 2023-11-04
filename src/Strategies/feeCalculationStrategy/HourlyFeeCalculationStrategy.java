package Strategies.feeCalculationStrategy;

import Models.Ticket;

public class HourlyFeeCalculationStrategy implements FeeCalculationStrategy{

    @Override
    public double calculateFees(Ticket ticket) {

        long currentTime = System.currentTimeMillis();
        long entryTime= ticket.getEntryTime().getTime();

        long duration = (currentTime-entryTime)/(1000*60*60);

        return 50*duration;
    }
}
