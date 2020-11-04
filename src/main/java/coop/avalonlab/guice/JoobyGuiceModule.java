package coop.avalonlab.guice;

import com.google.inject.AbstractModule;
import io.jooby.Jooby;

import javax.annotation.Nonnull;

public abstract class JoobyGuiceModule extends AbstractModule {

  protected Jooby application;

  public JoobyGuiceModule(@Nonnull Jooby application) {
    this.application = application;
  }

  @Override
  protected void configure() {
    configureBinder();
    configureRouter();
  }

  protected abstract void configureRouter();

  protected abstract void configureBinder();

  protected void defaultCqrsBinding(String packageName) {
  }
}
