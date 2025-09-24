package factory;

import dao.*;

public interface DAOFactory {
    UserDAO createUserDAO();
    EventDAO createEventDAO();
    VenueDAO createVenueDAO();
    EventVenueDAO createEventVenueDAO();
    TicketDAO createTicketDAO();
    BookingDAO createBookingDAO();
    PaymentDAO createPaymentDAO();
    SeatDAO createSeatDAO();
    TicketSeatDAO createTicketSeatDAO();
    ReviewDAO createReviewDAO();
}
