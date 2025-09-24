package engine;

import model.Ticket;
import strategy.PricingStrategy;

import java.math.BigDecimal;

public class TicketPriceEngine {
    private final Ticket ticket;
    private PricingStrategy pricingStrategy;

    public TicketPriceEngine(Ticket ticket, PricingStrategy pricingStrategy) {
        this.ticket = ticket;
        this.pricingStrategy = pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public BigDecimal calculateFinalPrice() {
        if (pricingStrategy == null) {
            return ticket.getPrice();
        }
        return pricingStrategy.calculatePrice(ticket.getPrice());
    }
}


//public class StrategyDemo {
//    public static void main(String[] args) {
//        // 1. Tạo một đối tượng Ticket (giá gốc)
//        Ticket baseTicket = new Ticket();
//        baseTicket.setPrice(new BigDecimal("100.00"));
//
//        // --- Kịch bản 1: Giá tiêu chuẩn ---
//        PricingStrategy standard = new StandardPricingStrategy();
//        EventTicket event1 = new EventTicket(baseTicket, standard);
//        BigDecimal price1 = event1.calculateFinalPrice();
//        System.out.println("Giá gốc: " + baseTicket.getPrice());
//        System.out.println("Giá cuối cùng (Tiêu chuẩn): " + price1);
//        // Output: Giá cuối cùng (Tiêu chuẩn): 100.00
//
//        System.out.println("-------------------------");
//
//        // --- Kịch bản 2: Khách VIP ---
//        PricingStrategy vipDiscount = new VipDiscountStrategy();
//        // Context có thể được tạo mới hoặc thay đổi strategy
//        EventTicket event2 = new EventTicket(baseTicket, vipDiscount);
//        BigDecimal price2 = event2.calculateFinalPrice();
//        System.out.println("Giá cuối cùng (VIP): " + price2);
//        // Output: Giá cuối cùng (VIP): 85.00
//
//        System.out.println("-------------------------");
//
//        // --- Kịch bản 3: Thay đổi sang Giờ Chót ---
//        // Sử dụng lại event1 và thay đổi strategy tại runtime
//        PricingStrategy surcharge = new LastMinuteSurchargeStrategy();
//        event1.setPricingStrategy(surcharge);
//        BigDecimal price3 = event1.calculateFinalPrice();
//        System.out.println("Giá cuối cùng (Giờ Chót): " + price3);
//        // Output: Giá cuối cùng (Giờ Chót): 105.00
//    }
//}