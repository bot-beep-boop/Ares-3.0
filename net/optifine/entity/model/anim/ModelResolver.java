package net.optifine.entity.model.anim;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.optifine.entity.model.CustomModelRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.expr.IExpression;

public class ModelResolver implements IModelResolver {
   private ModelBase model;
   private CustomModelRenderer[] customModelRenderers;
   private ModelAdapter modelAdapter;
   private ModelRenderer thisModelRenderer;
   private IRenderResolver renderResolver;
   private ModelRenderer partModelRenderer;

   public void setPartModelRenderer(ModelRenderer var1) {
      this.partModelRenderer = var1;
   }

   public ModelRenderer getModelRenderer(String var1) {
      if (var1 == null) {
         return null;
      } else {
         ModelRenderer var6;
         if (var1.indexOf(":") < 0) {
            if (this.thisModelRenderer != null && var1.equals("this")) {
               return this.thisModelRenderer;
            } else if (this.partModelRenderer != null && var1.equals("part")) {
               return this.partModelRenderer;
            } else {
               ModelRenderer var7 = this.modelAdapter.getModelRenderer(this.model, var1);
               if (var7 != null) {
                  return var7;
               } else {
                  for(int var8 = 0; var8 < this.customModelRenderers.length; ++var8) {
                     CustomModelRenderer var9 = this.customModelRenderers[var8];
                     ModelRenderer var10 = var9.getModelRenderer();
                     if (var1.equals(var10.getId())) {
                        return var10;
                     }

                     var6 = var10.getChildDeep(var1);
                     if (var6 != null) {
                        return var6;
                     }
                  }

                  return null;
               }
            }
         } else {
            String[] var2 = Config.tokenize(var1, ":");
            ModelRenderer var3 = this.getModelRenderer(var2[0]);

            for(int var4 = 1; var4 < var2.length; ++var4) {
               String var5 = var2[var4];
               var6 = var3.getChildDeep(var5);
               if (var6 == null) {
                  return null;
               }

               var3 = var6;
            }

            return var3;
         }
      }
   }

   public void setThisModelRenderer(ModelRenderer var1) {
      this.thisModelRenderer = var1;
   }

   public ModelResolver(ModelAdapter var1, ModelBase var2, CustomModelRenderer[] var3) {
      this.modelAdapter = var1;
      this.model = var2;
      this.customModelRenderers = var3;
      Class var4 = var1.getEntityClass();
      if (TileEntity.class.isAssignableFrom(var4)) {
         this.renderResolver = new RenderResolverTileEntity();
      } else {
         this.renderResolver = new RenderResolverEntity();
      }

   }

   public IExpression getExpression(String var1) {
      ModelVariableFloat var2 = this.getModelVariable(var1);
      if (var2 != null) {
         return var2;
      } else {
         IExpression var3 = this.renderResolver.getParameter(var1);
         return var3 != null ? var3 : null;
      }
   }

   public ModelVariableFloat getModelVariable(String var1) {
      String[] var2 = Config.tokenize(var1, ".");
      if (var2.length != 2) {
         return null;
      } else {
         String var3 = var2[0];
         String var4 = var2[1];
         ModelRenderer var5 = this.getModelRenderer(var3);
         if (var5 == null) {
            return null;
         } else {
            ModelVariableType var6 = ModelVariableType.parse(var4);
            return var6 == null ? null : new ModelVariableFloat(var1, var5, var6);
         }
      }
   }
}
