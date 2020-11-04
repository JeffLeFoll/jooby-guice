package coop.avalonlab.awesome;

public class MyAwesomeImplThree implements MyAwesomeInterface {
    @Override
    public String getAwesomeName() {
        return this.getClass().getSimpleName();
    }
}
