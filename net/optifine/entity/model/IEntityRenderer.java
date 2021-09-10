package net.optifine.entity.model;

import net.minecraft.util.ResourceLocation;

public interface IEntityRenderer {
   void setLocationTextureCustom(ResourceLocation var1);

   Class getEntityClass();

   ResourceLocation getLocationTextureCustom();

   void setEntityClass(Class var1);
}
