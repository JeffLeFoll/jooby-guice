package coop.avalonlab.guice;

import com.google.common.collect.Sets;
import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.lang.reflect.Modifier;
import java.util.Set;

public class GuiceInjectorScanner {

  public static <InterfaceType> InnerScanner<InterfaceType> findImplementationsOf(
      Class<InterfaceType> interfaceName, String packageName) {

    try (ScanResult scanResult =
        new ClassGraph()
            .enableClassInfo()
            .whitelistPackages(packageName)
            .disableNestedJarScanning()
            .scan()) {

      ClassInfoList controlClasses = scanResult
          .getClassesImplementing(interfaceName.getCanonicalName());

      Set<Class<InterfaceType>> subClasses = Sets
          .newHashSet(controlClasses.loadClasses(interfaceName));

      return new InnerScanner<>(interfaceName, subClasses);
    }
  }


  public static class InnerScanner<InterfaceType> {

    private final Class<InterfaceType> interfaceName;
    private final Set<Class<InterfaceType>> subClasses;

    private InnerScanner(Class<InterfaceType> interfaceName,
        Set<Class<InterfaceType>> subClasses) {
      this.interfaceName = interfaceName;
      this.subClasses = subClasses;
    }

    public void bindImplementationsOf(Binder binder) {
      Multibinder<InterfaceType> guiceMultibinder = Multibinder.newSetBinder(binder, interfaceName);

      subClasses.stream()
          .filter(implementation -> !Modifier.isAbstract(implementation.getModifiers()))
          .forEach(implementation -> guiceMultibinder.addBinding().to(implementation));
    }

    public Set<Class<InterfaceType>> getSubClasses() {
      return subClasses;
    }

  }

}
