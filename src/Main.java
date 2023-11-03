public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


/*
Notes:-

BaseModel -> id attribute is present in all the model classes, we can have
a common class to store the id attribute i.e BaseModel. Now every model class will
extend the base model class.

Requirement-1: Operator should be able to book the ticket.

Model - View - Controller

TicketController -> Takes the request from the client and passes it as it is to the
                    corresponding services.

Create Controller, Services and repository for each model (wherever required)

 */