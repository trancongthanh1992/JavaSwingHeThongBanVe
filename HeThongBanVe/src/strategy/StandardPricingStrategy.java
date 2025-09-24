package strategy;

import java.math.BigDecimal;

public class StandardPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(BigDecimal basePrice) {
        System.out.println("Áp dụng giá tiêu chuẩn.");
        return basePrice;
    }
}
