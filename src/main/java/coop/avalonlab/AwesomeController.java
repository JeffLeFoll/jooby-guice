package coop.avalonlab;

import coop.avalonlab.awesome.MyAwesomeInterface;
import io.jooby.annotations.GET;
import io.jooby.annotations.Path;

import javax.inject.Inject;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/guice")
public class AwesomeController {

    private final Set<MyAwesomeInterface> myAwesomeInterfaces;

    @Inject
    public AwesomeController(Set<MyAwesomeInterface> myAwesomeInterfaces) {
        this.myAwesomeInterfaces = myAwesomeInterfaces;
    }

    @GET
    String getAwesomeName() {
        return myAwesomeInterfaces.stream()
                .map(MyAwesomeInterface::getAwesomeName)
                .collect(Collectors.joining("\r\n"));
    }
}
