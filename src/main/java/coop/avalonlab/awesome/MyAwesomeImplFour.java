package coop.avalonlab.awesome;

public class MyAwesomeImplFour implements MyAwesomeInterface {
    @Override
    public String getAwesomeName() {
        return this.getClass().getSimpleName();
    }
}
