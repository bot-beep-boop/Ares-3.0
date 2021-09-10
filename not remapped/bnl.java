import java.io.File;
import java.io.FileNotFoundException;

public class bnl extends FileNotFoundException {
   public bnl(File var1, String var2) {
      super(String.format("'%s' in ResourcePack '%s'", var2, var1));
   }
}
