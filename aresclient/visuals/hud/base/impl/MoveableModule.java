package com.aresclient.visuals.hud.base.impl;

import com.aresclient.visuals.hud.base.FileManager;
import com.aresclient.visuals.hud.base.Position;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public abstract class MoveableModule {
   int randomNum = ThreadLocalRandom.current().nextInt(0, 1001);
   public static Minecraft minecraft = Minecraft.getMinecraft();
   public ScaledResolution sr;
   public Position position;
   public boolean isDrag;

   public MoveableModule(int var1, int var2, boolean var3) {
      this.sr = new ScaledResolution(minecraft);
      this.position = new Position(var1, var2, var3);
      this.position = this.loadPositionFromFile();
   }

   public abstract void render();

   public void renderDummy() {
   }

   public boolean isRenderDummy() {
      return false;
   }

   public int getY() {
      return this.position.getY();
   }

   public int getX() {
      return this.position.getX();
   }

   public abstract int getWidth();

   public abstract int getHeight();

   public Position getPosition() {
      return this.position;
   }

   public abstract String getName();

   public void onClick(int var1, int var2, int var3) {
      if (var1 >= this.getX() && var2 >= this.getY() && var1 < this.getX() + this.getWidth() && var2 < this.getY() + this.getHeight()) {
         if (var3 == 0) {
            this.isDrag = true;
         } else if (var3 == 1) {
            this.position.visible = !this.position.visible;
         }
      }

   }

   public void onRelease() {
      this.isDrag = false;
   }

   public void onMove(int var1, int var2, int var3, int var4) {
      if (this.isDrag) {
         this.adjustBounds(this);
         Position var10000 = this.position;
         var10000.x += var1 - var3;
         var10000 = this.position;
         var10000.y += var2 - var4;
      }

   }

   private void adjustBounds(MoveableModule var1) {
      ScaledResolution var2 = new ScaledResolution(Minecraft.getMinecraft());
      int var3 = var2.getScaledWidth();
      int var4 = var2.getScaledHeight();
      int var5 = Math.max(0, Math.min(var1.getX(), Math.max(var3 - var1.getWidth(), 0)));
      int var6 = Math.max(0, Math.min(var1.getY(), Math.max(var4 - var1.getHeight(), 0)));
      var1.position.setX(var5);
      var1.position.setY(var6);
   }

   public Position load() {
      return this.position;
   }

   public void save(Position var1) {
      this.position = var1;
      this.savePositionToFile();
   }

   private File getFolder() {
      File var1 = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
      var1.mkdirs();
      return var1;
   }

   private void savePositionToFile() {
      FileManager.writeJsonToFile(new File(this.getFolder(), "pos.json"), this.position);
   }

   private Position loadPositionFromFile() {
      Position var1 = (Position)FileManager.readFromJson(new File(this.getFolder(), "pos.json"), Position.class);
      if (var1 == null) {
         var1 = new Position(100, 100, true);
         this.position = var1;
         this.savePositionToFile();
      }

      return var1;
   }
}
