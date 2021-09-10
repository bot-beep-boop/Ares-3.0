package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Sets;
import java.nio.FloatBuffer;
import java.util.BitSet;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RegionRenderCache;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.optifine.BlockPosM;
import net.optifine.CustomBlockLayers;
import net.optifine.override.ChunkCacheOF;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorForge;
import net.optifine.render.AabbFrame;
import net.optifine.render.RenderEnv;
import net.optifine.shaders.SVertexBuilder;

public class RenderChunk {
   private BlockPos position;
   private RenderChunk[] renderChunkNeighbours;
   private final int index;
   private final RenderGlobal renderGlobal;
   private boolean renderChunkNeighboursUpated;
   private final ReentrantLock lockCompiledChunk;
   public static final EnumWorldBlockLayer[] ENUM_WORLD_BLOCK_LAYERS = EnumWorldBlockLayer.values();
   private boolean playerUpdate;
   private final World world;
   private int frameIndex;
   private BlockPos[] positionOffsets16;
   private RenderChunk[] renderChunkNeighboursValid;
   private final boolean isMipmaps;
   private ChunkCompileTaskGenerator compileTask;
   private final boolean fixBlockLayer;
   private boolean renderChunksOffset16Updated;
   private final RenderChunk[] renderChunksOfset16;
   public int regionX;
   private final Set<TileEntity> setTileEntities;
   private EnumMap<EnumFacing, BlockPos> mapEnumFacing;
   private Chunk chunk;
   private final EnumWorldBlockLayer[] blockLayersSingle;
   private final FloatBuffer modelviewMatrix;
   private boolean needsUpdate;
   private final VertexBuffer[] vertexBuffers;
   public static int renderChunksUpdated;
   private RenderGlobal.ContainerLocalRenderInformation renderInfo;
   public int regionZ;
   public AabbFrame boundingBoxParent;
   public CompiledChunk compiledChunk;
   public AxisAlignedBB boundingBox;
   private final ReentrantLock lockCompileTask;

   public void setCompiledChunk(CompiledChunk var1) {
      this.lockCompiledChunk.lock();

      try {
         this.compiledChunk = var1;
         this.lockCompiledChunk.unlock();
      } finally {
         this.lockCompiledChunk.unlock();
      }
   }

   public void setRenderChunkNeighbour(EnumFacing var1, RenderChunk var2) {
      this.renderChunkNeighbours[var1.ordinal()] = var2;
      this.renderChunkNeighboursValid[var1.ordinal()] = var2;
   }

   private Chunk getChunk(BlockPos var1) {
      Chunk var2 = this.chunk;
      if (var2 != null && var2.isLoaded()) {
         return var2;
      } else {
         var2 = this.world.getChunkFromBlockCoords(var1);
         this.chunk = var2;
         return var2;
      }
   }

   public RenderGlobal.ContainerLocalRenderInformation getRenderInfo() {
      return this.renderInfo;
   }

   private void postRenderOverlay(EnumWorldBlockLayer var1, RegionRenderCacheBuilder var2, CompiledChunk var3, boolean[] var4) {
      WorldRenderer var5 = var2.getWorldRendererByLayer(var1);
      if (var5.isDrawing()) {
         var3.setLayerStarted(var1);
         var4[var1.ordinal()] = true;
      }

   }

   public boolean isPlayerUpdate() {
      return this.playerUpdate;
   }

   public RenderChunk getRenderChunkNeighbour(EnumFacing var1) {
      if (!this.renderChunkNeighboursUpated) {
         this.updateRenderChunkNeighboursValid();
      }

      return this.renderChunkNeighboursValid[var1.ordinal()];
   }

   private boolean isWorldPlayerUpdate() {
      if (this.world instanceof WorldClient) {
         WorldClient var1 = (WorldClient)this.world;
         return var1.isPlayerUpdate();
      } else {
         return false;
      }
   }

   public void rebuildChunk(float var1, float var2, float var3, ChunkCompileTaskGenerator var4) {
      CompiledChunk var5 = new CompiledChunk();
      boolean var6 = true;
      BlockPos var7 = new BlockPos(this.position);
      BlockPos var8 = var7.add(15, 15, 15);
      var4.getLock().lock();
      boolean var31 = false;

      VisGraph var9;
      HashSet var10;
      label414: {
         ChunkCacheOF var11;
         boolean[] var12;
         BlockRendererDispatcher var13;
         boolean var14;
         boolean var15;
         Iterator var17;
         label413: {
            try {
               var31 = true;
               if (var4.getStatus() == ChunkCompileTaskGenerator.Status.COMPILING) {
                  var4.setCompiledChunk(var5);
                  var4.getLock().unlock();
                  var9 = new VisGraph();
                  var10 = Sets.newHashSet();
                  if (this.isChunkRegionEmpty(var7)) {
                     var31 = false;
                     break label414;
                  }

                  ++renderChunksUpdated;
                  var11 = this.makeChunkCacheOF(var7);
                  var11.renderStart();
                  var12 = new boolean[ENUM_WORLD_BLOCK_LAYERS.length];
                  var13 = Minecraft.getMinecraft().getBlockRendererDispatcher();
                  var14 = Reflector.ForgeBlock_canRenderInLayer.exists();
                  var15 = Reflector.ForgeHooksClient_setRenderLayer.exists();
                  var17 = BlockPosM.getAllInBoxMutable(var7, var8).iterator();
                  var31 = false;
                  break label413;
               }

               var31 = false;
            } finally {
               if (var31) {
                  var4.getLock().unlock();
               }
            }

            var4.getLock().unlock();
            return;
         }

         while(true) {
            if (!var17.hasNext()) {
               EnumWorldBlockLayer[] var39;
               int var38 = (var39 = ENUM_WORLD_BLOCK_LAYERS).length;

               for(int var37 = 0; var37 < var38; ++var37) {
                  EnumWorldBlockLayer var36 = var39[var37];
                  if (var12[var36.ordinal()]) {
                     var5.setLayerUsed(var36);
                  }

                  if (var5.isLayerStarted(var36)) {
                     if (Config.isShaders()) {
                        SVertexBuilder.calcNormalChunkLayer(var4.getRegionRenderCacheBuilder().getWorldRendererByLayer(var36));
                     }

                     WorldRenderer var40 = var4.getRegionRenderCacheBuilder().getWorldRendererByLayer(var36);
                     this.postRenderBlocks(var36, var1, var2, var3, var40, var5);
                     if (var40.animatedSprites != null) {
                        var5.setAnimatedSprites(var36, (BitSet)var40.animatedSprites.clone());
                     }
                  } else {
                     var5.setAnimatedSprites(var36, (BitSet)null);
                  }
               }

               var11.renderFinish();
               break;
            }

            Object var16 = var17.next();
            BlockPosM var18 = (BlockPosM)var16;
            IBlockState var19 = var11.getBlockState(var18);
            Block var20 = var19.getBlock();
            if (var20.isOpaqueCube()) {
               var9.func_178606_a(var18);
            }

            if (ReflectorForge.blockHasTileEntity(var19)) {
               TileEntity var21 = var11.getTileEntity(new BlockPos(var18));
               TileEntitySpecialRenderer var22 = TileEntityRendererDispatcher.instance.getSpecialRenderer(var21);
               if (var21 != null && var22 != null) {
                  var5.addTileEntity(var21);
                  if (var22.forceTileEntityRender()) {
                     var10.add(var21);
                  }
               }
            }

            EnumWorldBlockLayer[] var41;
            if (var14) {
               var41 = ENUM_WORLD_BLOCK_LAYERS;
            } else {
               var41 = this.blockLayersSingle;
               var41[0] = var20.getBlockLayer();
            }

            for(int var42 = 0; var42 < var41.length; ++var42) {
               EnumWorldBlockLayer var23 = var41[var42];
               if (var14) {
                  boolean var24 = Reflector.callBoolean(var20, Reflector.ForgeBlock_canRenderInLayer, var23);
                  if (!var24) {
                     continue;
                  }
               }

               if (var15) {
                  Reflector.callVoid(Reflector.ForgeHooksClient_setRenderLayer, var23);
               }

               var23 = this.fixBlockLayer(var19, var23);
               int var43 = var23.ordinal();
               if (var20.getRenderType() != -1) {
                  WorldRenderer var25 = var4.getRegionRenderCacheBuilder().getWorldRendererByLayerId(var43);
                  var25.setBlockLayer(var23);
                  RenderEnv var26 = var25.getRenderEnv(var19, var18);
                  var26.setRegionRenderCacheBuilder(var4.getRegionRenderCacheBuilder());
                  if (!var5.isLayerStarted(var23)) {
                     var5.setLayerStarted(var23);
                     this.preRenderBlocks(var25, var7);
                  }

                  var12[var43] |= var13.renderBlock(var19, var18, var11, var25);
                  if (var26.isOverlaysRendered()) {
                     this.postRenderOverlays(var4.getRegionRenderCacheBuilder(), var5, var12);
                     var26.setOverlaysRendered(false);
                  }
               }
            }

            if (var15) {
               Reflector.callVoid(Reflector.ForgeHooksClient_setRenderLayer, null);
            }
         }
      }

      var5.setVisibility(var9.computeVisibility());
      this.lockCompileTask.lock();

      try {
         HashSet var34 = Sets.newHashSet(var10);
         HashSet var35 = Sets.newHashSet(this.setTileEntities);
         var34.removeAll(this.setTileEntities);
         var35.removeAll(var10);
         this.setTileEntities.clear();
         this.setTileEntities.addAll(var10);
         this.renderGlobal.updateTileEntities(var35, var34);
         this.lockCompileTask.unlock();
      } finally {
         this.lockCompileTask.unlock();
      }
   }

   private ChunkCacheOF makeChunkCacheOF(BlockPos var1) {
      BlockPos var2 = var1.add(-1, -1, -1);
      BlockPos var3 = var1.add(16, 16, 16);
      RegionRenderCache var4 = this.createRegionRenderCache(this.world, var2, var3, 1);
      if (Reflector.MinecraftForgeClient_onRebuildChunk.exists()) {
         Reflector.call(Reflector.MinecraftForgeClient_onRebuildChunk, this.world, var1, var4);
      }

      ChunkCacheOF var5 = new ChunkCacheOF(var4, var2, var3, 1);
      return var5;
   }

   public VertexBuffer getVertexBufferByLayer(int var1) {
      return this.vertexBuffers[var1];
   }

   private void postRenderOverlays(RegionRenderCacheBuilder var1, CompiledChunk var2, boolean[] var3) {
      this.postRenderOverlay(EnumWorldBlockLayer.CUTOUT, var1, var2, var3);
      this.postRenderOverlay(EnumWorldBlockLayer.CUTOUT_MIPPED, var1, var2, var3);
      this.postRenderOverlay(EnumWorldBlockLayer.TRANSLUCENT, var1, var2, var3);
   }

   public Chunk getChunk() {
      return this.getChunk(this.position);
   }

   public void resortTransparency(float var1, float var2, float var3, ChunkCompileTaskGenerator var4) {
      CompiledChunk var5 = var4.getCompiledChunk();
      if (var5.getState() != null && !var5.isLayerEmpty(EnumWorldBlockLayer.TRANSLUCENT)) {
         WorldRenderer var6 = var4.getRegionRenderCacheBuilder().getWorldRendererByLayer(EnumWorldBlockLayer.TRANSLUCENT);
         this.preRenderBlocks(var6, this.position);
         var6.setVertexState(var5.getState());
         this.postRenderBlocks(EnumWorldBlockLayer.TRANSLUCENT, var1, var2, var3, var6, var5);
      }

   }

   private void initModelviewMatrix() {
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      float var1 = 1.000001F;
      GlStateManager.translate(-8.0F, -8.0F, -8.0F);
      GlStateManager.scale(var1, var1, var1);
      GlStateManager.translate(8.0F, 8.0F, 8.0F);
      GlStateManager.getFloat(2982, this.modelviewMatrix);
      GlStateManager.popMatrix();
   }

   private EnumWorldBlockLayer fixBlockLayer(IBlockState var1, EnumWorldBlockLayer var2) {
      if (CustomBlockLayers.isActive()) {
         EnumWorldBlockLayer var3 = CustomBlockLayers.getRenderLayer(var1);
         if (var3 != null) {
            return var3;
         }
      }

      if (!this.fixBlockLayer) {
         return var2;
      } else {
         if (this.isMipmaps) {
            if (var2 == EnumWorldBlockLayer.CUTOUT) {
               Block var4 = var1.getBlock();
               if (var4 instanceof BlockRedstoneWire) {
                  return var2;
               }

               if (var4 instanceof BlockCactus) {
                  return var2;
               }

               return EnumWorldBlockLayer.CUTOUT_MIPPED;
            }
         } else if (var2 == EnumWorldBlockLayer.CUTOUT_MIPPED) {
            return EnumWorldBlockLayer.CUTOUT;
         }

         return var2;
      }
   }

   public boolean isChunkRegionEmpty() {
      return this.isChunkRegionEmpty(this.position);
   }

   public RenderChunk(World var1, RenderGlobal var2, BlockPos var3, int var4) {
      this.compiledChunk = CompiledChunk.DUMMY;
      this.lockCompileTask = new ReentrantLock();
      this.lockCompiledChunk = new ReentrantLock();
      this.compileTask = null;
      this.setTileEntities = Sets.newHashSet();
      this.modelviewMatrix = GLAllocation.createDirectFloatBuffer(16);
      this.vertexBuffers = new VertexBuffer[EnumWorldBlockLayer.values().length];
      this.frameIndex = -1;
      this.needsUpdate = true;
      this.mapEnumFacing = null;
      this.positionOffsets16 = new BlockPos[EnumFacing.VALUES.length];
      this.blockLayersSingle = new EnumWorldBlockLayer[1];
      this.isMipmaps = Config.isMipmaps();
      this.fixBlockLayer = !Reflector.BetterFoliageClient.exists();
      this.playerUpdate = false;
      this.renderChunksOfset16 = new RenderChunk[6];
      this.renderChunksOffset16Updated = false;
      this.renderChunkNeighbours = new RenderChunk[EnumFacing.VALUES.length];
      this.renderChunkNeighboursValid = new RenderChunk[EnumFacing.VALUES.length];
      this.renderChunkNeighboursUpated = false;
      this.renderInfo = new RenderGlobal.ContainerLocalRenderInformation(this, (EnumFacing)null, 0);
      this.world = var1;
      this.renderGlobal = var2;
      this.index = var4;
      if (!var3.equals(this.getPosition())) {
         this.setPosition(var3);
      }

      if (OpenGlHelper.useVbo()) {
         for(int var5 = 0; var5 < EnumWorldBlockLayer.values().length; ++var5) {
            this.vertexBuffers[var5] = new VertexBuffer(DefaultVertexFormats.BLOCK);
         }
      }

   }

   public BlockPos getBlockPosOffset16(EnumFacing var1) {
      return this.getPositionOffset16(var1);
   }

   public void multModelviewMatrix() {
      GlStateManager.multMatrix(this.modelviewMatrix);
   }

   public ChunkCompileTaskGenerator makeCompileTaskChunk() {
      this.lockCompileTask.lock();

      try {
         this.finishCompileTask();
         this.compileTask = new ChunkCompileTaskGenerator(this, ChunkCompileTaskGenerator.Type.REBUILD_CHUNK);
         ChunkCompileTaskGenerator var1 = this.compileTask;
         this.lockCompileTask.unlock();
         return var1;
      } finally {
         this.lockCompileTask.unlock();
      }
   }

   private void postRenderBlocks(EnumWorldBlockLayer var1, float var2, float var3, float var4, WorldRenderer var5, CompiledChunk var6) {
      if (var1 == EnumWorldBlockLayer.TRANSLUCENT && !var6.isLayerEmpty(var1)) {
         var5.sortVertexData(var2, var3, var4);
         var6.setState(var5.getVertexState());
      }

      var5.finishDrawing();
   }

   public boolean isNeedsUpdate() {
      return this.needsUpdate;
   }

   public BlockPos getPositionOffset16(EnumFacing var1) {
      int var2 = var1.getIndex();
      BlockPos var3 = this.positionOffsets16[var2];
      if (var3 == null) {
         var3 = this.getPosition().offset(var1, 16);
         this.positionOffsets16[var2] = var3;
      }

      return var3;
   }

   private void updateRenderChunkNeighboursValid() {
      int var1 = this.getPosition().getX();
      int var2 = this.getPosition().getZ();
      int var3 = EnumFacing.NORTH.ordinal();
      int var4 = EnumFacing.SOUTH.ordinal();
      int var5 = EnumFacing.WEST.ordinal();
      int var6 = EnumFacing.EAST.ordinal();
      this.renderChunkNeighboursValid[var3] = this.renderChunkNeighbours[var3].getPosition().getZ() == var2 - 16 ? this.renderChunkNeighbours[var3] : null;
      this.renderChunkNeighboursValid[var4] = this.renderChunkNeighbours[var4].getPosition().getZ() == var2 + 16 ? this.renderChunkNeighbours[var4] : null;
      this.renderChunkNeighboursValid[var5] = this.renderChunkNeighbours[var5].getPosition().getX() == var1 - 16 ? this.renderChunkNeighbours[var5] : null;
      this.renderChunkNeighboursValid[var6] = this.renderChunkNeighbours[var6].getPosition().getX() == var1 + 16 ? this.renderChunkNeighbours[var6] : null;
      this.renderChunkNeighboursUpated = true;
   }

   public void deleteGlResources() {
      this.stopCompileTask();

      for(int var1 = 0; var1 < EnumWorldBlockLayer.values().length; ++var1) {
         if (this.vertexBuffers[var1] != null) {
            this.vertexBuffers[var1].deleteGlBuffers();
         }
      }

   }

   private boolean isChunkRegionEmpty(BlockPos var1) {
      int var2 = var1.getY();
      int var3 = var2 + 15;
      return this.getChunk(var1).getAreLevelsEmpty(var2, var3);
   }

   public ChunkCompileTaskGenerator makeCompileTaskTransparency() {
      this.lockCompileTask.lock();

      Object var4;
      try {
         ChunkCompileTaskGenerator var2;
         if (this.compileTask == null || this.compileTask.getStatus() != ChunkCompileTaskGenerator.Status.PENDING) {
            if (this.compileTask != null && this.compileTask.getStatus() != ChunkCompileTaskGenerator.Status.DONE) {
               this.compileTask.finish();
               this.compileTask = null;
            }

            this.compileTask = new ChunkCompileTaskGenerator(this, ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY);
            this.compileTask.setCompiledChunk(this.compiledChunk);
            var2 = this.compileTask;
            this.lockCompileTask.unlock();
            return var2;
         }

         var2 = null;
         var4 = var2;
      } finally {
         this.lockCompileTask.unlock();
      }

      return (ChunkCompileTaskGenerator)var4;
   }

   public CompiledChunk getCompiledChunk() {
      return this.compiledChunk;
   }

   public void stopCompileTask() {
      this.finishCompileTask();
      this.compiledChunk = CompiledChunk.DUMMY;
   }

   public boolean setFrameIndex(int var1) {
      if (this.frameIndex == var1) {
         return false;
      } else {
         this.frameIndex = var1;
         return true;
      }
   }

   public BlockPos getPosition() {
      return this.position;
   }

   public RenderChunk getRenderChunkOffset16(ViewFrustum var1, EnumFacing var2) {
      if (!this.renderChunksOffset16Updated) {
         for(int var3 = 0; var3 < EnumFacing.VALUES.length; ++var3) {
            EnumFacing var4 = EnumFacing.VALUES[var3];
            BlockPos var5 = this.getBlockPosOffset16(var4);
            this.renderChunksOfset16[var3] = var1.getRenderChunk(var5);
         }

         this.renderChunksOffset16Updated = true;
      }

      return this.renderChunksOfset16[var2.ordinal()];
   }

   protected void finishCompileTask() {
      this.lockCompileTask.lock();

      try {
         if (this.compileTask != null && this.compileTask.getStatus() != ChunkCompileTaskGenerator.Status.DONE) {
            this.compileTask.finish();
            this.compileTask = null;
         }
      } finally {
         this.lockCompileTask.unlock();
      }

   }

   public AabbFrame getBoundingBoxParent() {
      if (this.boundingBoxParent == null) {
         BlockPos var1 = this.getPosition();
         int var2 = var1.getX();
         int var3 = var1.getY();
         int var4 = var1.getZ();
         byte var5 = 5;
         int var6 = var2 >> var5 << var5;
         int var7 = var3 >> var5 << var5;
         int var8 = var4 >> var5 << var5;
         if (var6 != var2 || var7 != var3 || var8 != var4) {
            AabbFrame var9 = this.renderGlobal.getRenderChunk(new BlockPos(var6, var7, var8)).getBoundingBoxParent();
            if (var9 != null && var9.minX == (double)var6 && var9.minY == (double)var7 && var9.minZ == (double)var8) {
               this.boundingBoxParent = var9;
            }
         }

         if (this.boundingBoxParent == null) {
            int var10 = 1 << var5;
            this.boundingBoxParent = new AabbFrame((double)var6, (double)var7, (double)var8, (double)(var6 + var10), (double)(var7 + var10), (double)(var8 + var10));
         }
      }

      return this.boundingBoxParent;
   }

   public String toString() {
      return "pos: " + this.getPosition() + ", frameIndex: " + this.frameIndex;
   }

   public boolean isBoundingBoxInFrustum(ICamera var1, int var2) {
      return this.getBoundingBoxParent().isBoundingBoxInFrustumFully(var1, var2) ? true : var1.isBoundingBoxInFrustum(this.boundingBox);
   }

   public ReentrantLock getLockCompileTask() {
      return this.lockCompileTask;
   }

   public void setNeedsUpdate(boolean var1) {
      this.needsUpdate = var1;
      if (var1) {
         if (this.isWorldPlayerUpdate()) {
            this.playerUpdate = true;
         }
      } else {
         this.playerUpdate = false;
      }

   }

   protected RegionRenderCache createRegionRenderCache(World var1, BlockPos var2, BlockPos var3, int var4) {
      return new RegionRenderCache(var1, var2, var3, var4);
   }

   private void preRenderBlocks(WorldRenderer var1, BlockPos var2) {
      var1.begin(7, DefaultVertexFormats.BLOCK);
      if (Config.isRenderRegions()) {
         byte var3 = 8;
         int var4 = var2.getX() >> var3 << var3;
         int var5 = var2.getY() >> var3 << var3;
         int var6 = var2.getZ() >> var3 << var3;
         var4 = this.regionX;
         var6 = this.regionZ;
         var1.setTranslation((double)(-var4), (double)(-var5), (double)(-var6));
      } else {
         var1.setTranslation((double)(-var2.getX()), (double)(-var2.getY()), (double)(-var2.getZ()));
      }

   }

   public void setPosition(BlockPos var1) {
      this.stopCompileTask();
      this.position = var1;
      byte var2 = 8;
      this.regionX = var1.getX() >> var2 << var2;
      this.regionZ = var1.getZ() >> var2 << var2;
      this.boundingBox = new AxisAlignedBB(var1, var1.add(16, 16, 16));
      this.initModelviewMatrix();

      int var3;
      for(var3 = 0; var3 < this.positionOffsets16.length; ++var3) {
         this.positionOffsets16[var3] = null;
      }

      this.renderChunksOffset16Updated = false;
      this.renderChunkNeighboursUpated = false;

      for(var3 = 0; var3 < this.renderChunkNeighbours.length; ++var3) {
         RenderChunk var4 = this.renderChunkNeighbours[var3];
         if (var4 != null) {
            var4.renderChunkNeighboursUpated = false;
         }
      }

      this.chunk = null;
      this.boundingBoxParent = null;
   }
}
