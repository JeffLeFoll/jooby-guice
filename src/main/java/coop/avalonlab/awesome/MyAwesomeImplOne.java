package coop.avalonlab.awesome;

public class MyAwesomeImplOne implements MyAwesomeInterface {
    @Override
    public String getAwesomeName() {
        return this.getClass().getSimpleName();
    }
}
