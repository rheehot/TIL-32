package domain;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SequenceCondition implements DiscountCondition{
    private int sequence;

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return this.sequence == screening.getSequence();
    }
}
