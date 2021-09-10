package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Lists;
import java.util.BitSet;
import java.util.List;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;

public class CompiledChunk {
   private boolean empty;
   private final boolean[] layersUsed;
   private BitSet[] animatedSprites;
   public static final CompiledChunk DUMMY = new CompiledChunk() {
      public void setAnimatedSprites(EnumWorldBlockLayer var1, BitSet var2) {
         throw new UnsupportedOperationException();
      }

      public boolean isVisible(EnumFacing var1, EnumFacing var2) {
         return false;
      }

      protected void setLayerUsed(EnumWorldBlockLayer var1) {
         throw new UnsupportedOperationException();
      }

      public void setLayerStarted(EnumWorldBlockLayer var1) {
         throw new UnsupportedOperationException();
      }
   };
   private final List<TileEntity> tileEntities;
   private final boolean[] layersStarted;
   private SetVisibility setVisibility;
   private WorldRenderer.State state;

   public boolean isLayerEmpty(EnumWorldBlockLayer var1) {
      return !this.layersUsed[var1.ordinal()];
   }

   public void addTileEntity(TileEntity var1) {
      this.tileEntities.add(var1);
   }

   public void setLayerStarted(EnumWorldBlockLayer var1) {
      this.layersStarted[var1.ordinal()] = true;
   }

   public boolean isLayerStarted(EnumWorldBlockLayer var1) {
      return this.layersStarted[var1.ordinal()];
   }

   public List<TileEntity> getTileEntities() {
      return this.tileEntities;
   }

   public void setAnimatedSprites(EnumWorldBlockLayer var1, BitSet var2) {
      this.animatedSprites[var1.ordinal()] = var2;
   }

   public void setState(WorldRenderer.State var1) {
      this.state = var1;
   }

   public BitSet getAnimatedSprites(EnumWorldBlockLayer var1) {
      return this.animatedSprites[var1.ordinal()];
   }

   public CompiledChunk() {
      this.layersUsed = new boolean[RenderChunk.ENUM_WORLD_BLOCK_LAYERS.length];
      this.layersStarted = new boolean[RenderChunk.ENUM_WORLD_BLOCK_LAYERS.length];
      this.empty = true;
      this.tileEntities = Lists.newArrayList();
      this.setVisibility = new SetVisibility();
      this.animatedSprites = new BitSet[RenderChunk.ENUM_WORLD_BLOCK_LAYERS.length];
   }

   public void setVisibility(SetVisibility var1) {
      this.setVisibility = var1;
   }

   protected void setLayerUsed(EnumWorldBlockLayer var1) {
      this.empty = false;
      this.layersUsed[var1.ordinal()] = true;
   }

   public boolean isVisible(EnumFacing var1, EnumFacing var2) {
      return this.setVisibility.isVisible(var1, var2);
   }

   public WorldRenderer.State getState() {
      return this.state;
   }

   public boolean isEmpty() {
      return this.empty;
   }
}
