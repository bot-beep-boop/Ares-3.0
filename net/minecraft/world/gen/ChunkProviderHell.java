package net.minecraft.world.gen;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFire;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenGlowStone2;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenNetherBridge;

public class ChunkProviderHell implements IChunkProvider {
   private double[] netherrackExclusivityNoise = new double[256];
   private double[] gravelNoise = new double[256];
   private final WorldGenGlowStone2 field_177468_v = new WorldGenGlowStone2();
   double[] noiseData5;
   private final WorldGenGlowStone1 field_177469_u = new WorldGenGlowStone1();
   public final NoiseGeneratorOctaves netherNoiseGen6;
   private final boolean field_177466_i;
   private final WorldGenHellLava field_177473_x;
   double[] noiseData4;
   private final World worldObj;
   private final WorldGenerator field_177467_w;
   private final MapGenBase netherCaveGenerator;
   private final NoiseGeneratorOctaves netherNoiseGen2;
   private final Random hellRNG;
   double[] noiseData3;
   private final GeneratorBushFeature field_177465_A;
   private double[] noiseField;
   public final NoiseGeneratorOctaves netherNoiseGen7;
   private final NoiseGeneratorOctaves netherNoiseGen1;
   private final MapGenNetherBridge genNetherBridge;
   double[] noiseData1;
   private final GeneratorBushFeature field_177471_z;
   private final WorldGenHellLava field_177472_y;
   double[] noiseData2;
   private final WorldGenFire field_177470_t = new WorldGenFire();
   private final NoiseGeneratorOctaves slowsandGravelNoiseGen;
   private final NoiseGeneratorOctaves netherNoiseGen3;
   private final NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
   private double[] slowsandNoise = new double[256];

   public boolean saveChunks(boolean var1, IProgressUpdate var2) {
      return true;
   }

   public void saveExtraData() {
   }

   public boolean populateChunk(IChunkProvider var1, Chunk var2, int var3, int var4) {
      return false;
   }

   public boolean unloadQueuedChunks() {
      return false;
   }

   public Chunk provideChunk(BlockPos var1) {
      return this.provideChunk(var1.getX() >> 4, var1.getZ() >> 4);
   }

   public void func_180516_b(int var1, int var2, ChunkPrimer var3) {
      int var4 = this.worldObj.getSeaLevel() + 1;
      double var5 = 0.03125D;
      this.slowsandNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.slowsandNoise, var1 * 16, var2 * 16, 0, 16, 16, 1, var5, var5, 1.0D);
      this.gravelNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.gravelNoise, var1 * 16, 109, var2 * 16, 16, 1, 16, var5, 1.0D, var5);
      this.netherrackExclusivityNoise = this.netherrackExculsivityNoiseGen.generateNoiseOctaves(this.netherrackExclusivityNoise, var1 * 16, var2 * 16, 0, 16, 16, 1, var5 * 2.0D, var5 * 2.0D, var5 * 2.0D);

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            boolean var9 = this.slowsandNoise[var7 + var8 * 16] + this.hellRNG.nextDouble() * 0.2D > 0.0D;
            boolean var10 = this.gravelNoise[var7 + var8 * 16] + this.hellRNG.nextDouble() * 0.2D > 0.0D;
            int var11 = (int)(this.netherrackExclusivityNoise[var7 + var8 * 16] / 3.0D + 3.0D + this.hellRNG.nextDouble() * 0.25D);
            int var12 = -1;
            IBlockState var13 = Blocks.netherrack.getDefaultState();
            IBlockState var14 = Blocks.netherrack.getDefaultState();

            for(int var15 = 127; var15 >= 0; --var15) {
               if (var15 < 127 - this.hellRNG.nextInt(5) && var15 > this.hellRNG.nextInt(5)) {
                  IBlockState var16 = var3.getBlockState(var8, var15, var7);
                  if (var16.getBlock() != null && var16.getBlock().getMaterial() != Material.air) {
                     if (var16.getBlock() == Blocks.netherrack) {
                        if (var12 == -1) {
                           if (var11 <= 0) {
                              var13 = null;
                              var14 = Blocks.netherrack.getDefaultState();
                           } else if (var15 >= var4 - 4 && var15 <= var4 + 1) {
                              var13 = Blocks.netherrack.getDefaultState();
                              var14 = Blocks.netherrack.getDefaultState();
                              if (var10) {
                                 var13 = Blocks.gravel.getDefaultState();
                                 var14 = Blocks.netherrack.getDefaultState();
                              }

                              if (var9) {
                                 var13 = Blocks.soul_sand.getDefaultState();
                                 var14 = Blocks.soul_sand.getDefaultState();
                              }
                           }

                           if (var15 < var4 && (var13 == null || var13.getBlock().getMaterial() == Material.air)) {
                              var13 = Blocks.lava.getDefaultState();
                           }

                           var12 = var11;
                           if (var15 >= var4 - 1) {
                              var3.setBlockState(var8, var15, var7, var13);
                           } else {
                              var3.setBlockState(var8, var15, var7, var14);
                           }
                        } else if (var12 > 0) {
                           --var12;
                           var3.setBlockState(var8, var15, var7, var14);
                        }
                     }
                  } else {
                     var12 = -1;
                  }
               } else {
                  var3.setBlockState(var8, var15, var7, Blocks.bedrock.getDefaultState());
               }
            }
         }
      }

   }

   public void func_180515_a(int var1, int var2, ChunkPrimer var3) {
      byte var4 = 4;
      int var5 = this.worldObj.getSeaLevel() / 2 + 1;
      int var6 = var4 + 1;
      byte var7 = 17;
      int var8 = var4 + 1;
      this.noiseField = this.initializeNoiseField(this.noiseField, var1 * var4, 0, var2 * var4, var6, var7, var8);

      for(int var9 = 0; var9 < var4; ++var9) {
         for(int var10 = 0; var10 < var4; ++var10) {
            for(int var11 = 0; var11 < 16; ++var11) {
               double var12 = 0.125D;
               double var14 = this.noiseField[(var9 * var8 + var10) * var7 + var11];
               double var16 = this.noiseField[(var9 * var8 + var10 + 1) * var7 + var11];
               double var18 = this.noiseField[((var9 + 1) * var8 + var10) * var7 + var11];
               double var20 = this.noiseField[((var9 + 1) * var8 + var10 + 1) * var7 + var11];
               double var22 = (this.noiseField[(var9 * var8 + var10) * var7 + var11 + 1] - var14) * var12;
               double var24 = (this.noiseField[(var9 * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
               double var26 = (this.noiseField[((var9 + 1) * var8 + var10) * var7 + var11 + 1] - var18) * var12;
               double var28 = (this.noiseField[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

               for(int var30 = 0; var30 < 8; ++var30) {
                  double var31 = 0.25D;
                  double var33 = var14;
                  double var35 = var16;
                  double var37 = (var18 - var14) * var31;
                  double var39 = (var20 - var16) * var31;

                  for(int var41 = 0; var41 < 4; ++var41) {
                     double var42 = 0.25D;
                     double var44 = var33;
                     double var46 = (var35 - var33) * var42;

                     for(int var48 = 0; var48 < 4; ++var48) {
                        IBlockState var49 = null;
                        if (var11 * 8 + var30 < var5) {
                           var49 = Blocks.lava.getDefaultState();
                        }

                        if (var44 > 0.0D) {
                           var49 = Blocks.netherrack.getDefaultState();
                        }

                        int var50 = var41 + var9 * 4;
                        int var51 = var30 + var11 * 8;
                        int var52 = var48 + var10 * 4;
                        var3.setBlockState(var50, var51, var52, var49);
                        var44 += var46;
                     }

                     var33 += var37;
                     var35 += var39;
                  }

                  var14 += var22;
                  var16 += var24;
                  var18 += var26;
                  var20 += var28;
               }
            }
         }
      }

   }

   public String makeString() {
      return "HellRandomLevelSource";
   }

   public Chunk provideChunk(int var1, int var2) {
      this.hellRNG.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      ChunkPrimer var3 = new ChunkPrimer();
      this.func_180515_a(var1, var2, var3);
      this.func_180516_b(var1, var2, var3);
      this.netherCaveGenerator.generate(this, this.worldObj, var1, var2, var3);
      if (this.field_177466_i) {
         this.genNetherBridge.generate(this, this.worldObj, var1, var2, var3);
      }

      Chunk var4 = new Chunk(this.worldObj, var3, var1, var2);
      BiomeGenBase[] var5 = this.worldObj.getWorldChunkManager().loadBlockGeneratorData((BiomeGenBase[])null, var1 * 16, var2 * 16, 16, 16);
      byte[] var6 = var4.getBiomeArray();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)var5[var7].biomeID;
      }

      var4.resetRelightChecks();
      return var4;
   }

   public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType var1, BlockPos var2) {
      if (var1 == EnumCreatureType.MONSTER) {
         if (this.genNetherBridge.func_175795_b(var2)) {
            return this.genNetherBridge.getSpawnList();
         }

         if (this.genNetherBridge.isPositionInStructure(this.worldObj, var2) && this.worldObj.getBlockState(var2.down()).getBlock() == Blocks.nether_brick) {
            return this.genNetherBridge.getSpawnList();
         }
      }

      BiomeGenBase var3 = this.worldObj.getBiomeGenForCoords(var2);
      return var3.getSpawnableList(var1);
   }

   public int getLoadedChunkCount() {
      return 0;
   }

   public void recreateStructures(Chunk var1, int var2, int var3) {
      this.genNetherBridge.generate(this, this.worldObj, var2, var3, (ChunkPrimer)null);
   }

   public boolean chunkExists(int var1, int var2) {
      return true;
   }

   public void populate(IChunkProvider var1, int var2, int var3) {
      BlockFalling.fallInstantly = true;
      BlockPos var4 = new BlockPos(var2 * 16, 0, var3 * 16);
      ChunkCoordIntPair var5 = new ChunkCoordIntPair(var2, var3);
      this.genNetherBridge.generateStructure(this.worldObj, this.hellRNG, var5);

      int var6;
      for(var6 = 0; var6 < 8; ++var6) {
         this.field_177472_y.generate(this.worldObj, this.hellRNG, var4.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
      }

      for(var6 = 0; var6 < this.hellRNG.nextInt(this.hellRNG.nextInt(10) + 1) + 1; ++var6) {
         this.field_177470_t.generate(this.worldObj, this.hellRNG, var4.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
      }

      for(var6 = 0; var6 < this.hellRNG.nextInt(this.hellRNG.nextInt(10) + 1); ++var6) {
         this.field_177469_u.generate(this.worldObj, this.hellRNG, var4.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
      }

      for(var6 = 0; var6 < 10; ++var6) {
         this.field_177468_v.generate(this.worldObj, this.hellRNG, var4.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
      }

      if (this.hellRNG.nextBoolean()) {
         this.field_177471_z.generate(this.worldObj, this.hellRNG, var4.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
      }

      if (this.hellRNG.nextBoolean()) {
         this.field_177465_A.generate(this.worldObj, this.hellRNG, var4.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
      }

      for(var6 = 0; var6 < 16; ++var6) {
         this.field_177467_w.generate(this.worldObj, this.hellRNG, var4.add(this.hellRNG.nextInt(16), this.hellRNG.nextInt(108) + 10, this.hellRNG.nextInt(16)));
      }

      for(var6 = 0; var6 < 16; ++var6) {
         this.field_177473_x.generate(this.worldObj, this.hellRNG, var4.add(this.hellRNG.nextInt(16), this.hellRNG.nextInt(108) + 10, this.hellRNG.nextInt(16)));
      }

      BlockFalling.fallInstantly = false;
   }

   public BlockPos getStrongholdGen(World var1, String var2, BlockPos var3) {
      return null;
   }

   public ChunkProviderHell(World var1, boolean var2, long var3) {
      this.field_177467_w = new WorldGenMinable(Blocks.quartz_ore.getDefaultState(), 14, BlockHelper.forBlock(Blocks.netherrack));
      this.field_177473_x = new WorldGenHellLava(Blocks.flowing_lava, true);
      this.field_177472_y = new WorldGenHellLava(Blocks.flowing_lava, false);
      this.field_177471_z = new GeneratorBushFeature(Blocks.brown_mushroom);
      this.field_177465_A = new GeneratorBushFeature(Blocks.red_mushroom);
      this.genNetherBridge = new MapGenNetherBridge();
      this.netherCaveGenerator = new MapGenCavesHell();
      this.worldObj = var1;
      this.field_177466_i = var2;
      this.hellRNG = new Random(var3);
      this.netherNoiseGen1 = new NoiseGeneratorOctaves(this.hellRNG, 16);
      this.netherNoiseGen2 = new NoiseGeneratorOctaves(this.hellRNG, 16);
      this.netherNoiseGen3 = new NoiseGeneratorOctaves(this.hellRNG, 8);
      this.slowsandGravelNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
      this.netherrackExculsivityNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
      this.netherNoiseGen6 = new NoiseGeneratorOctaves(this.hellRNG, 10);
      this.netherNoiseGen7 = new NoiseGeneratorOctaves(this.hellRNG, 16);
      var1.setSeaLevel(63);
   }

   private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 2053.236D;
      this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(this.noiseData4, var2, var3, var4, var5, 1, var7, 1.0D, 0.0D, 1.0D);
      this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(this.noiseData5, var2, var3, var4, var5, 1, var7, 100.0D, 0.0D, 100.0D);
      this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(this.noiseData1, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 60.0D, var8 / 80.0D);
      this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(this.noiseData2, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(this.noiseData3, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      int var12 = 0;
      double[] var13 = new double[var6];

      int var14;
      for(var14 = 0; var14 < var6; ++var14) {
         var13[var14] = Math.cos((double)var14 * 3.141592653589793D * 6.0D / (double)var6) * 2.0D;
         double var15 = (double)var14;
         if (var14 > var6 / 2) {
            var15 = (double)(var6 - 1 - var14);
         }

         if (var15 < 4.0D) {
            var15 = 4.0D - var15;
            var13[var14] -= var15 * var15 * var15 * 10.0D;
         }
      }

      for(var14 = 0; var14 < var5; ++var14) {
         for(int var31 = 0; var31 < var7; ++var31) {
            double var16 = 0.0D;

            for(int var18 = 0; var18 < var6; ++var18) {
               double var19 = 0.0D;
               double var21 = var13[var18];
               double var23 = this.noiseData2[var12] / 512.0D;
               double var25 = this.noiseData3[var12] / 512.0D;
               double var27 = (this.noiseData1[var12] / 10.0D + 1.0D) / 2.0D;
               if (var27 < 0.0D) {
                  var19 = var23;
               } else if (var27 > 1.0D) {
                  var19 = var25;
               } else {
                  var19 = var23 + (var25 - var23) * var27;
               }

               var19 -= var21;
               double var29;
               if (var18 > var6 - 4) {
                  var29 = (double)((float)(var18 - (var6 - 4)) / 3.0F);
                  var19 = var19 * (1.0D - var29) + -10.0D * var29;
               }

               if ((double)var18 < var16) {
                  var29 = (var16 - (double)var18) / 4.0D;
                  var29 = MathHelper.clamp_double(var29, 0.0D, 1.0D);
                  var19 = var19 * (1.0D - var29) + -10.0D * var29;
               }

               var1[var12] = var19;
               ++var12;
            }
         }
      }

      return var1;
   }

   public boolean canSave() {
      return true;
   }
}
