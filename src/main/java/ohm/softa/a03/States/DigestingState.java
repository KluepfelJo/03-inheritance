package ohm.softa.a03.States;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DigestingState extends State {
    protected int remainingAwakeTime;

    public DigestingState(int duration, int remainingAwakeTime) {
        super(duration);
        this.remainingAwakeTime = remainingAwakeTime;
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(remainingAwakeTime-cat.getDigest());
    }
}
