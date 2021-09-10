package net.arikia.dev.drpc;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class DiscordUser extends Structure {
   public String discriminator;
   public String username;
   public String userId;
   public String avatar;

   public List<String> getFieldOrder() {
      return Arrays.asList("userId", "username", "discriminator", "avatar");
   }
}
