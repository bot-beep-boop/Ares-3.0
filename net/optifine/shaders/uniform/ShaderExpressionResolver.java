package net.optifine.shaders.uniform;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.expr.ConstantFloat;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionResolver;
import net.optifine.shaders.SMCLog;

public class ShaderExpressionResolver implements IExpressionResolver {
   private Map<String, IExpression> mapExpressions = new HashMap();

   private void registerExpressions() {
      ShaderParameterFloat[] var1 = ShaderParameterFloat.values();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         ShaderParameterFloat var3 = var1[var2];
         this.addParameterFloat(this.mapExpressions, var3);
      }

      ShaderParameterBool[] var8 = ShaderParameterBool.values();

      for(int var9 = 0; var9 < var8.length; ++var9) {
         ShaderParameterBool var4 = var8[var9];
         this.mapExpressions.put(var4.getName(), var4);
      }

      Iterator var11 = BiomeGenBase.BIOME_ID_MAP.values().iterator();

      while(var11.hasNext()) {
         BiomeGenBase var10 = (BiomeGenBase)var11.next();
         String var5 = var10.biomeName.trim();
         var5 = "BIOME_" + var5.toUpperCase().replace(' ', '_');
         int var6 = var10.biomeID;
         ConstantFloat var7 = new ConstantFloat((float)var6);
         this.registerExpression(var5, var7);
      }

   }

   public IExpression getExpression(String var1) {
      return (IExpression)this.mapExpressions.get(var1);
   }

   public ShaderExpressionResolver(Map<String, IExpression> var1) {
      this.registerExpressions();
      Iterator var3 = var1.keySet().iterator();

      while(var3.hasNext()) {
         String var2 = (String)var3.next();
         IExpression var4 = (IExpression)var1.get(var2);
         this.registerExpression(var2, var4);
      }

   }

   public boolean hasExpression(String var1) {
      return this.mapExpressions.containsKey(var1);
   }

   public boolean registerExpression(String var1, IExpression var2) {
      if (this.mapExpressions.containsKey(var1)) {
         SMCLog.warning("Expression already defined: " + var1);
         return false;
      } else {
         this.mapExpressions.put(var1, var2);
         return true;
      }
   }

   private void addParameterFloat(Map<String, IExpression> var1, ShaderParameterFloat var2) {
      String[] var3 = var2.getIndexNames1();
      if (var3 == null) {
         var1.put(var2.getName(), new ShaderParameterIndexed(var2));
      } else {
         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            String[] var6 = var2.getIndexNames2();
            if (var6 == null) {
               var1.put(var2.getName() + "." + var5, new ShaderParameterIndexed(var2, var4));
            } else {
               for(int var7 = 0; var7 < var6.length; ++var7) {
                  String var8 = var6[var7];
                  var1.put(var2.getName() + "." + var5 + "." + var8, new ShaderParameterIndexed(var2, var4, var7));
               }
            }
         }
      }

   }
}
