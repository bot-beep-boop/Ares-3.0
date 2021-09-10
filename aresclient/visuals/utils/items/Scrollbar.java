package com.aresclient.visuals.utils.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.input.Mouse;

public class Scrollbar {
   private int listSize;
   private double backLength;
   private int posBottom;
   boolean hold;
   private int speed = 1;
   private int scrollY;
   int clickY;
   private int right;
   private int posTop;
   private int left;
   private int entryHeight;
   public int top;
   public double barLength;

   public boolean isHidden() {
      return this.listSize == 0 ? true : this.posBottom - this.posTop >= this.listSize * this.entryHeight;
   }

   public void mouseAction(int var1, int var2, boolean var3) {
      this.calc();
      boolean var4 = false;
      if (!var3) {
         this.hold = false;
         if (var1 <= this.right && var1 >= this.left && var2 >= this.top && (double)var2 <= (double)this.top + this.barLength) {
            this.hold = true;
         } else {
            if (var1 > this.right || var1 < this.left || var2 < this.posTop || var2 > this.posBottom) {
               return;
            }

            var3 = true;
            var4 = true;
         }
      } else if (!this.hold) {
         return;
      }

      int var5 = this.scrollY;
      double var6 = this.backLength / (double)(this.listSize * this.entryHeight);
      int var8 = (int)((double)(-var2) / var6);
      if (var3) {
         this.scrollY = var8 - this.clickY;
      } else {
         this.clickY = var8 - this.scrollY;
      }

      if (this.listSize * this.entryHeight + this.scrollY < this.posBottom - this.posTop && !var4) {
         this.scrollY = var5;
      }

      if (this.scrollY > 0 && !var4) {
         this.scrollY = var5;
      }

      if (var4) {
         if (this.listSize * this.entryHeight + this.scrollY < this.posBottom - this.posTop) {
            this.scrollY += this.posBottom - this.posTop - (this.listSize * this.entryHeight + this.scrollY);
         }

         if (this.scrollY > 0) {
            this.scrollY = 0;
         }
      }

   }

   public Scrollbar(int var1) {
      this.entryHeight = var1;
      this.setDefaultPosition();
   }

   public void setPosition(int var1, int var2, int var3, int var4) {
      this.left = var1;
      this.posTop = var2;
      this.right = var3;
      this.posBottom = var4;
      this.calc();
   }

   public void calc() {
      double var1 = (double)this.entryHeight;
      double var3 = (double)(this.listSize * this.entryHeight);
      double var5 = (double)(this.posBottom - this.posTop);
      if (var5 < var3) {
         double var7 = var5 / var3;
         double var9 = var7 * var5;
         double var11 = (double)this.scrollY / var7 * var7 * var7;
         this.top = (int)(-var11) + this.posTop;
         this.barLength = var9;
         this.backLength = var5;
      }

   }

   public void setEntryHeight(int var1) {
      this.entryHeight = var1;
   }

   public void init() {
      this.setDefaultPosition();
   }

   public void setScrollY(int var1) {
      this.scrollY = var1;
   }

   public void mouseInput() {
      int var1 = Mouse.getEventDWheel();
      if (var1 > 0) {
         if (this.scrollY < 0) {
            this.scrollY += this.speed;
         }
      } else if (var1 < 0 && this.listSize * this.entryHeight + this.scrollY > this.posBottom - this.posTop) {
         this.scrollY -= this.speed;
      }

      if (this.listSize * this.entryHeight + this.scrollY < this.posBottom - this.posTop) {
         this.scrollY += this.posBottom - this.posTop - (this.listSize * this.entryHeight + this.scrollY);
      }

      if (this.scrollY > 0) {
         this.scrollY = 0;
      }

   }

   public void setDefaultPosition() {
      this.setPosition(Minecraft.getMinecraft().displayHeight / 2 + 150, 40, Minecraft.getMinecraft().displayWidth / 2 + 156, Minecraft.getMinecraft().displayHeight - 40);
   }

   public void draw() {
      if (!this.isHidden()) {
         this.calc();
         Tessellator var1 = Tessellator.getInstance();
         WorldRenderer var2 = var1.getWorldRenderer();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
         GlStateManager.disableAlpha();
         GlStateManager.shadeModel(7425);
         GlStateManager.disableTexture2D();
         var2.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
         var2.pos((double)this.left, (double)this.posBottom, 0.0D).tex(0.0D, 1.0D).color(0, 0, 0, 255).endVertex();
         var2.pos((double)this.right, (double)this.posBottom, 0.0D).tex(1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
         var2.pos((double)this.right, (double)this.posTop, 0.0D).tex(1.0D, 0.0D).color(0, 0, 0, 255).endVertex();
         var2.pos((double)this.left, (double)this.posTop, 0.0D).tex(0.0D, 0.0D).color(0, 0, 0, 255).endVertex();
         var1.draw();
         var2.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
         var2.pos((double)this.left, (double)this.top + this.barLength, 0.0D).tex(0.0D, 1.0D).color(128, 128, 128, 255).endVertex();
         var2.pos((double)this.right, (double)this.top + this.barLength, 0.0D).tex(1.0D, 1.0D).color(128, 128, 128, 255).endVertex();
         var2.pos((double)this.right, (double)this.top, 0.0D).tex(1.0D, 0.0D).color(128, 128, 128, 255).endVertex();
         var2.pos((double)this.left, (double)this.top, 0.0D).tex(0.0D, 0.0D).color(128, 128, 128, 255).endVertex();
         var1.draw();
         var2.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
         var2.pos((double)this.left, (double)this.top + this.barLength - 1.0D, 0.0D).tex(0.0D, 1.0D).color(192, 192, 192, 255).endVertex();
         var2.pos((double)(this.right - 1), (double)this.top + this.barLength - 1.0D, 0.0D).tex(1.0D, 1.0D).color(192, 192, 192, 255).endVertex();
         var2.pos((double)(this.right - 1), (double)this.top, 0.0D).tex(1.0D, 0.0D).color(192, 192, 192, 255).endVertex();
         var2.pos((double)this.left, (double)this.top, 0.0D).tex(0.0D, 0.0D).color(192, 192, 192, 255).endVertex();
         var1.draw();
         GlStateManager.enableTexture2D();
         GlStateManager.shadeModel(7424);
         GlStateManager.enableAlpha();
         GlStateManager.disableBlend();
      }

   }

   public void reset() {
      this.scrollY = 0;
   }

   public void setSpeed(int var1) {
      this.speed = var1;
   }

   public int getScrollY() {
      return this.scrollY;
   }

   public int getSpeed() {
      return this.speed;
   }

   public void update(int var1) {
      this.listSize = var1 + 1;
   }
}
