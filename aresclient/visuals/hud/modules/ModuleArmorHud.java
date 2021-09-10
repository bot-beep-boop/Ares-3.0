package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ModuleArmorHud extends MoveableModule {
   public ModuleArmorHud(int var1, int var2) {
      super(var1, var2, true);
   }

   public int getWidth() {
      return 17;
   }

   public void render() {
      for(int var1 = 0; var1 < Minecraft.getMinecraft().thePlayer.inventory.armorInventory.length; ++var1) {
         ItemStack var2 = Minecraft.getMinecraft().thePlayer.inventory.armorInventory[var1];
         this.renderItemStack(this.getY(), this.getX(), var1, var2);
      }

   }

   public boolean isRenderDummy() {
      return true;
   }

   public String getName() {
      return "ArmorHud";
   }

   public void renderDummy() {
      int var10001 = this.getY();
      int var10002 = this.getX();
      new Item();
      this.renderItemStack(var10001, var10002, 3, new ItemStack(Item.getItemById(310)));
      var10001 = this.getY();
      var10002 = this.getX();
      new Item();
      this.renderItemStack(var10001, var10002, 2, new ItemStack(Item.getItemById(311)));
      var10001 = this.getY();
      var10002 = this.getX();
      new Item();
      this.renderItemStack(var10001, var10002, 1, new ItemStack(Item.getItemById(312)));
      var10001 = this.getY();
      var10002 = this.getX();
      new Item();
      this.renderItemStack(var10001, var10002, 0, new ItemStack(Item.getItemById(313)));
   }

   public int getHeight() {
      return 67;
   }

   private void renderItemStack(int var1, int var2, int var3, ItemStack var4) {
      if (var4 != null) {
         GL11.glPushMatrix();
         int var5 = -16 * var3 + 48;
         RenderHelper.enableGUIStandardItemLighting();
         Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(var4, var2, var1 + var5);
         GL11.glPopMatrix();
      }
   }
}
