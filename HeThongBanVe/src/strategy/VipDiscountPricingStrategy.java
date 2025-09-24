package strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VipDiscountPricingStrategy implements PricingStrategy {
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.85"); // Giảm 15%

    @Override
    public BigDecimal calculatePrice(BigDecimal basePrice) {
        System.out.println("Áp dụng giảm giá 15% cho khách VIP.");
        return basePrice.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }
}