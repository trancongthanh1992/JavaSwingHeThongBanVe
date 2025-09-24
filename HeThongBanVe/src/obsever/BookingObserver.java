package obsever;

import model.Booking;

public interface BookingObserver {
    // Phương thức được gọi để cập nhật Observer
    void update(Booking booking);
}
