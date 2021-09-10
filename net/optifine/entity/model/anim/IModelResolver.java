package net.optifine.entity.model.anim;

import net.minecraft.client.model.ModelRenderer;
import net.optifine.expr.IExpressionResolver;

public interface IModelResolver extends IExpressionResolver {
   ModelVariableFloat getModelVariable(String var1);

   ModelRenderer getModelRenderer(String var1);
}
