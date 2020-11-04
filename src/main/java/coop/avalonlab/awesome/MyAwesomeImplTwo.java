package coop.avalonlab.awesome;

public class MyAwesomeImplTwo implements MyAwesomeInterface {
    @Override
    public String getAwesomeName() {
        return this.getClass().getSimpleName();
    }
}
