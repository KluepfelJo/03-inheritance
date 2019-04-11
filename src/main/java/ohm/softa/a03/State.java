package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static final Logger logger = LogManager.getLogger();

    protected int t;
    protected int duration;

    public State(int duration){
        this.duration = duration;
    }


    final State tick(Cat cat){
        if(duration < 0) {
            return this;
        }

        t++;

        if(t < duration){
            logger.info("Still in {}",getClass().getSimpleName());
            return this;
        }else{
            return this.successor(cat);
        }
    }

    public abstract State successor(Cat cat);

}
