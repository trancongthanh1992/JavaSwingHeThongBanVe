package strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SouldOutPricingStrategy implements PricingStrategy {
    private static final BigDecimal SURCHARGE_RATE = new BigDecimal("1.05"); // Tăng 5%

    @Override
    public BigDecimal calculatePrice(BigDecimal basePrice) {
        System.out.println("Áp dụng phụ phí 5% giờ chót.");
        return basePrice.multiply(SURCHARGE_RATE).setScale(2, RoundingMode.HALF_UP);
    }
}
