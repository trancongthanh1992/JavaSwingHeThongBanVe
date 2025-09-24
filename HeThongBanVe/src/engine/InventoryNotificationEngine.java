package engine;

import model.Booking;
import obsever.BookingObserver;

public class InventoryNotificationEngine implements BookingObserver {
    @Override
    public void update(Booking booking) {
        if ("cancelled".equalsIgnoreCase(booking.getPaymentStatus())) {
            // Logic cập nhật trạng thái vé trong DB thành is_sold = FALSE
            System.out.println("[INVENTORY UPDATE]: Hủy vé thành công, Vé ID " + booking.getTicketId() + " đã được mở bán lại.");
        }
    }
}