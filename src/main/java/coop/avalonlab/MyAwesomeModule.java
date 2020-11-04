package coop.avalonlab;

import coop.avalonlab.awesome.MyAwesomeInterface;
import coop.avalonlab.guice.GuiceInjectorScanner;
import coop.avalonlab.guice.JoobyGuiceModule;
import io.jooby.Jooby;

import javax.annotation.Nonnull;

public class MyAwesomeModule extends JoobyGuiceModule {

    public MyAwesomeModule(@Nonnull Jooby application) {
        super(application);
    }

    @Override
    protected void configureRouter() {
        application.mvc(AwesomeController.class);
    }

    @Override
    protected void configureBinder() {
        GuiceInjectorScanner
                .findImplementationsOf(MyAwesomeInterface.class, getClass().getPackageName() + ".awesome")
                .bindImplementationsOf(binder());
    }
}
