package obsever;

import model.Booking;

public interface BookingSubject {
    // Đăng ký một Observer (thêm vào danh sách)
    void attach(BookingObserver observer);

    // Hủy đăng ký một Observer (xóa khỏi danh sách)
    void detach(BookingObserver observer);

    // Thông báo cho tất cả các Observers về một thay đổi trạng thái
    void notifyObservers(Booking booking);
}
