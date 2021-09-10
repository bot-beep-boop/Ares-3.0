package net.optifine.config;

import net.minecraft.util.ResourceLocation;
import net.optifine.util.EntityUtils;

public class EntityClassLocator implements IObjectLocator {
   public Object getObject(ResourceLocation var1) {
      Class var2 = EntityUtils.getEntityClassByName(var1.getResourcePath());
      return var2;
   }
}
