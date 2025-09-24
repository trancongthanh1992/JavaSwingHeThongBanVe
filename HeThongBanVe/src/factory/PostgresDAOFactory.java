package factory;

import dao.*;

public class PostgresDAOFactory implements DAOFactory {

    @Override
    public UserDAO createUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public EventDAO createEventDAO() {
        return new EventDAOImpl();
    }

    @Override
    public VenueDAO createVenueDAO() {
        return new VenueDAOImpl();
    }

    @Override
    public EventVenueDAO createEventVenueDAO() {
        return new EventVenueDAOImpl();
    }

    @Override
    public TicketDAO createTicketDAO() {
        return new TicketDAOImpl();
    }

    @Override
    public BookingDAO createBookingDAO() {
        return new BookingDAOImpl();
    }

    @Override
    public PaymentDAO createPaymentDAO() {
        return new PaymentDAOImpl();
    }

    @Override
    public SeatDAO createSeatDAO() {
        return new SeatDAOImpl();
    }

    @Override
    public TicketSeatDAO createTicketSeatDAO() {
        return new TicketSeatDAOImpl();
    }

    @Override
    public ReviewDAO createReviewDAO() {
        return new ReviewDAOImpl();
    }
}