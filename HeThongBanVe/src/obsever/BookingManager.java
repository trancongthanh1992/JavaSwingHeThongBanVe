package obsever;


import dao.BookingDAO;
import factory.DAOFactory;
import factory.DAOManager;
import model.Booking;

import java.util.ArrayList;
import java.util.List;

import static factory.DBType.POSTGRES;

public class BookingManager implements BookingSubject {

    private final List<BookingObserver> observers = new ArrayList<>();
    private final BookingDAO bookingDAO; // Tham chiếu tới BookingDAO

    public BookingManager() {
        // Sử dụng Singleton Factory Pattern để lấy BookingDAO
        DAOFactory factory = DAOManager.getDAOFactory(POSTGRES);
        this.bookingDAO = factory.createBookingDAO();
    }

    // Các phương thức quản lý Observers (attach, detach, notifyObservers) giữ nguyên...
    @Override
    public void attach(BookingObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(BookingObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Booking booking) {
        for (BookingObserver observer : observers) {
            observer.update(booking);
        }
    }

    /**
     * Phương thức xử lý thay đổi trạng thái Booking, cập nhật DB và thông báo Observers.
     * @param booking Đối tượng Booking cần thay đổi.
     * @param newStatus Trạng thái thanh toán mới (paid, cancelled).
     */
    public void changeBookingStatus(Booking booking, String newStatus) {

        // 1. Logic cập nhật DB qua BookingDAO
        try {
            // Cập nhật trạng thái trong cơ sở dữ liệu
            bookingDAO.updatePaymentStatus(booking.getBookingId(), newStatus);

            // Cập nhật trạng thái trong đối tượng POJO (để gửi cho observers)
            booking.setPaymentStatus(newStatus);

            System.out.println("DB SUCCESS: Booking " + booking.getBookingId() + " đã được cập nhật trạng thái thành: " + newStatus);

        } catch (Exception e) {
            System.err.println("DB ERROR: Không thể cập nhật trạng thái Booking ID " + booking.getBookingId() + ". Lỗi: " + e.getMessage());
            // Có thể chọn throw exception hoặc xử lý lỗi khác
            return;
        }

        // 2. Kích hoạt Observer Pattern nếu trạng thái quan trọng thay đổi
        if ("paid".equalsIgnoreCase(newStatus) || "cancelled".equalsIgnoreCase(newStatus)) {
            notifyObservers(booking);
        }
    }
}
//// Giả định Booking Manager là đối tượng Subject
//BookingManager bookingManager = new BookingManager();
//
//// Khởi tạo các Observers
//BookingObserver emailSender = new EmailNotificationObserver();
//BookingObserver inventoryUpdater = new InventoryUpdateObserver();
//
//// Đăng ký Observers với Subject
//bookingManager.attach(emailSender);
//bookingManager.attach(inventoryUpdater);
//
//// Giả định một đối tượng Booking đã được tạo
//Booking initialBooking = new Booking();
//initialBooking.setBookingId(101);
//initialBooking.setTicketId(55);
//initialBooking.setPaymentStatus("pending");
//
//System.out.println("--- KỊCH BẢN 1: THANH TOÁN THÀNH CÔNG ---");
//// Gọi phương thức thay đổi trạng thái
//bookingManager.changeBookingStatus(initialBooking, "paid");
//// Output:
//// Booking 101 đã thay đổi trạng thái thành: paid
//// [EMAIL NOTIFICATION]: Gửi email xác nhận Booking ID 101
//
//System.out.println("\n--- KỊCH BẢN 2: HỦY BOOKING ---");
//// Gọi phương thức thay đổi trạng thái
//bookingManager.changeBookingStatus(initialBooking, "cancelled");
//// Output:
//// Booking 101 đã thay đổi trạng thái thành: cancelled
//// [EMAIL NOTIFICATION]: Gửi email thông báo hủy Booking ID 101
//// [INVENTORY UPDATE]: Hủy vé thành công, Vé ID 55 đã được mở bán lại.