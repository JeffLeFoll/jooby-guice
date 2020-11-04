package coop.avalonlab;

import io.jooby.Jooby;
import io.jooby.di.GuiceModule;

public class App extends Jooby {

  {
    mvc(new Controller());

    install(new GuiceModule(new MyAwesomeModule(this)));
  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
