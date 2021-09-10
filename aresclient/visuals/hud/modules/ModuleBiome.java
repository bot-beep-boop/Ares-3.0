package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class ModuleBiome extends MoveableModule {
   public void render() {
      BlockPos var1 = new BlockPos(Minecraft.getMinecraft().getRenderViewEntity().posX, Minecraft.getMinecraft().getRenderViewEntity().getEntityBoundingBox().minY, Minecraft.getMinecraft().getRenderViewEntity().posZ);
      Chunk var2 = Minecraft.getMinecraft().theWorld.getChunkFromBlockCoords(var1);
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "Biome§f] " + var2.getBiome(var1, Minecraft.getMinecraft().theWorld.getWorldChunkManager()).biomeName, (float)this.getX(), (float)this.getY(), Color.white.getRGB());
   }

   public int getWidth() {
      BlockPos var1 = new BlockPos(Minecraft.getMinecraft().getRenderViewEntity().posX, Minecraft.getMinecraft().getRenderViewEntity().getEntityBoundingBox().minY, Minecraft.getMinecraft().getRenderViewEntity().posZ);
      Chunk var2 = Minecraft.getMinecraft().theWorld.getChunkFromBlockCoords(var1);
      return minecraft.fontRendererObj.getStringWidth("[" + ConfigManager.settings.ModColor + "Biome§f] " + var2.getBiome(var1, Minecraft.getMinecraft().theWorld.getWorldChunkManager()).biomeName);
   }

   public int getHeight() {
      return minecraft.fontRendererObj.FONT_HEIGHT;
   }

   public ModuleBiome(int var1, int var2) {
      super(var1, var2, true);
   }

   public String getName() {
      return "Biome";
   }
}
