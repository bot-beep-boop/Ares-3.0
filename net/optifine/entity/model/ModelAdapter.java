package net.optifine.entity.model;

import java.util.ArrayList;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public abstract class ModelAdapter {
   private String[] aliases;
   private Class entityClass;
   private float shadowSize;
   private String name;

   public ModelAdapter(Class var1, String var2, float var3) {
      this.entityClass = var1;
      this.name = var2;
      this.shadowSize = var3;
   }

   public float getShadowSize() {
      return this.shadowSize;
   }

   public abstract ModelRenderer getModelRenderer(ModelBase var1, String var2);

   public Class getEntityClass() {
      return this.entityClass;
   }

   public abstract ModelBase makeModel();

   public ModelRenderer[] getModelRenderers(ModelBase var1) {
      String[] var2 = this.getModelRendererNames();
      ArrayList var3 = new ArrayList();

      for(int var4 = 0; var4 < var2.length; ++var4) {
         String var5 = var2[var4];
         ModelRenderer var6 = this.getModelRenderer(var1, var5);
         if (var6 != null) {
            var3.add(var6);
         }
      }

      ModelRenderer[] var7 = (ModelRenderer[])var3.toArray(new ModelRenderer[var3.size()]);
      return var7;
   }

   public ModelAdapter(Class var1, String var2, float var3, String[] var4) {
      this.entityClass = var1;
      this.name = var2;
      this.shadowSize = var3;
      this.aliases = var4;
   }

   public abstract String[] getModelRendererNames();

   public String getName() {
      return this.name;
   }

   public String[] getAliases() {
      return this.aliases;
   }

   public abstract IEntityRenderer makeEntityRender(ModelBase var1, float var2);
}
