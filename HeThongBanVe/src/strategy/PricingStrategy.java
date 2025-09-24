package strategy;

import java.math.BigDecimal;

public interface PricingStrategy {

    /**
     * Tính toán giá cuối cùng dựa trên giá gốc.
     * @param basePrice Giá gốc của vé.
     * @return Giá đã được điều chỉnh.
     */
    BigDecimal calculatePrice(BigDecimal basePrice);
}