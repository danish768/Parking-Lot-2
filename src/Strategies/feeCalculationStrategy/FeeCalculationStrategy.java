package Strategies.feeCalculationStrategy;

import Models.Ticket;

public interface FeeCalculationStrategy {
    double calculateFees(Ticket ticket);
}
