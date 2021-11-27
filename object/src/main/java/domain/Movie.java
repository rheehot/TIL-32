package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;


    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();
}
