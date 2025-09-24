package engine;

import model.Booking;
import obsever.BookingObserver;

public class EmailNotificationEngine implements BookingObserver {
    @Override
    public void update(Booking booking) {
        String status = booking.getPaymentStatus();
        if ("paid".equalsIgnoreCase(status)) {
            System.out.println("[EMAIL NOTIFICATION]: Gửi email xác nhận Booking ID " + booking.getBookingId());
        } else if ("cancelled".equalsIgnoreCase(status)) {
            System.out.println("[EMAIL NOTIFICATION]: Gửi email thông báo hủy Booking ID " + booking.getBookingId());
        }
    }
}
