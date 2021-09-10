package net.optifine.config;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemLocator implements IObjectLocator {
   public Object getObject(ResourceLocation var1) {
      Item var2 = Item.getByNameOrId(var1.toString());
      return var2;
   }
}
