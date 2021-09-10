import java.util.Collection;

public interface amo<T extends Comparable<T>> {
   String a();

   Collection<T> c();

   Class<T> b();

   String a(T var1);
}
