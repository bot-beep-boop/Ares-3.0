package com.aresclient.user.cosmetic.imp.capes.particle;

import io.netty.util.internal.ThreadLocalRandom;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public class CapeParticleRenderer {
   private Random random = new Random();
   private List<ParticleStar> starList = new LinkedList();
   private long lastStarSpawned = -1L;

   public void render(EntityLivingBase var1, float var2) {
      if (this.lastStarSpawned < System.currentTimeMillis()) {
         this.lastStarSpawned = System.currentTimeMillis() + (long)ThreadLocalRandom.current().nextInt(300, 801);
         double var3 = (0.5D - this.random.nextDouble()) * 0.6D;
         double var5 = this.random.nextDouble() - 0.025D;
         ParticleStar var7 = new ParticleStar(var3, var5, System.currentTimeMillis());
         this.starList.add(var7);
      }

      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.0F, -0.0629F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Iterator var8 = this.starList.iterator();

      while(var8.hasNext()) {
         ParticleStar var4 = (ParticleStar)var8.next();
         var4.render();
         if (var4.isFadedOut()) {
            var8.remove();
         }
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }
}
