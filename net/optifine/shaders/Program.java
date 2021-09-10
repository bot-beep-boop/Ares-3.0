package net.optifine.shaders;

import java.nio.IntBuffer;
import java.util.Arrays;
import net.optifine.render.GlAlphaState;
import net.optifine.render.GlBlendState;
import net.optifine.shaders.config.RenderScale;

public class Program {
   private int countInstances;
   private final ProgramStage programStage;
   private final boolean[] toggleColorTextures = new boolean[8];
   private int id;
   private int ref;
   private RenderScale renderScale;
   private int compositeMipmapSetting;
   private IntBuffer drawBuffersBuffer;
   private IntBuffer drawBuffers;
   private final String name;
   private final Program programBackup;
   private GlBlendState blendState;
   private GlAlphaState alphaState;
   private String drawBufSettings;
   private final int index;
   private final Boolean[] buffersFlip = new Boolean[8];

   public RenderScale getRenderScale() {
      return this.renderScale;
   }

   public int getCompositeMipmapSetting() {
      return this.compositeMipmapSetting;
   }

   public void setAlphaState(GlAlphaState var1) {
      this.alphaState = var1;
   }

   public int getRef() {
      return this.ref;
   }

   public void resetId() {
      this.id = 0;
      this.ref = 0;
   }

   public void setBlendState(GlBlendState var1) {
      this.blendState = var1;
   }

   public GlAlphaState getAlphaState() {
      return this.alphaState;
   }

   public void setCountInstances(int var1) {
      this.countInstances = var1;
   }

   public int getId() {
      return this.id;
   }

   public IntBuffer getDrawBuffers() {
      return this.drawBuffers;
   }

   public void setDrawBufSettings(String var1) {
      this.drawBufSettings = var1;
   }

   public void setDrawBuffers(IntBuffer var1) {
      this.drawBuffers = var1;
   }

   public GlBlendState getBlendState() {
      return this.blendState;
   }

   public int getCountInstances() {
      return this.countInstances;
   }

   public String getName() {
      return this.name;
   }

   public void setId(int var1) {
      this.id = var1;
   }

   public String getDrawBufSettings() {
      return this.drawBufSettings;
   }

   public String getRealProgramName() {
      if (this.id == 0) {
         return "none";
      } else {
         Program var1;
         for(var1 = this; var1.getRef() != this.id; var1 = var1.getProgramBackup()) {
            if (var1.getProgramBackup() == null || var1.getProgramBackup() == var1) {
               return "unknown";
            }
         }

         return var1.getName();
      }
   }

   public void resetConfiguration() {
      this.drawBufSettings = null;
      this.compositeMipmapSetting = 0;
      this.countInstances = 0;
      if (this.drawBuffersBuffer == null) {
         this.drawBuffersBuffer = Shaders.nextIntBuffer(8);
      }

   }

   public int getIndex() {
      return this.index;
   }

   public Program getProgramBackup() {
      return this.programBackup;
   }

   public void copyFrom(Program var1) {
      this.id = var1.getId();
      this.alphaState = var1.getAlphaState();
      this.blendState = var1.getBlendState();
      this.renderScale = var1.getRenderScale();
      System.arraycopy(var1.getBuffersFlip(), 0, this.buffersFlip, 0, this.buffersFlip.length);
      this.drawBufSettings = var1.getDrawBufSettings();
      this.drawBuffers = var1.getDrawBuffers();
      this.compositeMipmapSetting = var1.getCompositeMipmapSetting();
      this.countInstances = var1.getCountInstances();
      System.arraycopy(var1.getToggleColorTextures(), 0, this.toggleColorTextures, 0, this.toggleColorTextures.length);
   }

   public void resetProperties() {
      this.alphaState = null;
      this.blendState = null;
      this.renderScale = null;
      Arrays.fill(this.buffersFlip, (Object)null);
   }

   public Boolean[] getBuffersFlip() {
      return this.buffersFlip;
   }

   public boolean[] getToggleColorTextures() {
      return this.toggleColorTextures;
   }

   public Program(int var1, String var2, ProgramStage var3, boolean var4) {
      this.index = var1;
      this.name = var2;
      this.programStage = var3;
      this.programBackup = var4 ? this : null;
   }

   public void setRenderScale(RenderScale var1) {
      this.renderScale = var1;
   }

   public void setRef(int var1) {
      this.ref = var1;
   }

   public Program(int var1, String var2, ProgramStage var3, Program var4) {
      this.index = var1;
      this.name = var2;
      this.programStage = var3;
      this.programBackup = var4;
   }

   public ProgramStage getProgramStage() {
      return this.programStage;
   }

   public IntBuffer getDrawBuffersBuffer() {
      return this.drawBuffersBuffer;
   }

   public void setCompositeMipmapSetting(int var1) {
      this.compositeMipmapSetting = var1;
   }

   public String toString() {
      return "name: " + this.name + ", id: " + this.id + ", ref: " + this.ref + ", real: " + this.getRealProgramName();
   }
}
