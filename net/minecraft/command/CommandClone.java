package net.minecraft.command;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class CommandClone extends CommandBase {
   public String getCommandName() {
      return "clone";
   }

   public List<String> addTabCompletionOptions(ICommandSender var1, String[] var2, BlockPos var3) {
      if (var2.length > 0 && var2.length <= 3) {
         return func_175771_a(var2, 0, var3);
      } else if (var2.length > 3 && var2.length <= 6) {
         return func_175771_a(var2, 3, var3);
      } else if (var2.length > 6 && var2.length <= 9) {
         return func_175771_a(var2, 6, var3);
      } else if (var2.length == 10) {
         return getListOfStringsMatchingLastWord(var2, new String[]{"replace", "masked", "filtered"});
      } else if (var2.length == 11) {
         return getListOfStringsMatchingLastWord(var2, new String[]{"normal", "force", "move"});
      } else {
         return var2.length == 12 && "filtered".equals(var2[9]) ? getListOfStringsMatchingLastWord(var2, Block.blockRegistry.getKeys()) : null;
      }
   }

   public int getRequiredPermissionLevel() {
      return 2;
   }

   public String getCommandUsage(ICommandSender var1) {
      return "commands.clone.usage";
   }

   public void processCommand(ICommandSender var1, String[] var2) throws CommandException {
      if (var2.length < 9) {
         throw new WrongUsageException("commands.clone.usage", new Object[0]);
      } else {
         var1.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
         BlockPos var3 = parseBlockPos(var1, var2, 0, false);
         BlockPos var4 = parseBlockPos(var1, var2, 3, false);
         BlockPos var5 = parseBlockPos(var1, var2, 6, false);
         StructureBoundingBox var6 = new StructureBoundingBox(var3, var4);
         StructureBoundingBox var7 = new StructureBoundingBox(var5, var5.add(var6.func_175896_b()));
         int var8 = var6.getXSize() * var6.getYSize() * var6.getZSize();
         if (var8 > 32768) {
            throw new CommandException("commands.clone.tooManyBlocks", new Object[]{var8, 32768});
         } else {
            boolean var9 = false;
            Block var10 = null;
            int var11 = -1;
            if ((var2.length < 11 || !var2[10].equals("force") && !var2[10].equals("move")) && var6.intersectsWith(var7)) {
               throw new CommandException("commands.clone.noOverlap", new Object[0]);
            } else {
               if (var2.length >= 11 && var2[10].equals("move")) {
                  var9 = true;
               }

               if (var6.minY >= 0 && var6.maxY < 256 && var7.minY >= 0 && var7.maxY < 256) {
                  World var12 = var1.getEntityWorld();
                  if (var12.isAreaLoaded(var6) && var12.isAreaLoaded(var7)) {
                     boolean var13 = false;
                     if (var2.length >= 10) {
                        if (var2[9].equals("masked")) {
                           var13 = true;
                        } else if (var2[9].equals("filtered")) {
                           if (var2.length < 12) {
                              throw new WrongUsageException("commands.clone.usage", new Object[0]);
                           }

                           var10 = getBlockByText(var1, var2[11]);
                           if (var2.length >= 13) {
                              var11 = parseInt(var2[12], 0, 15);
                           }
                        }
                     }

                     ArrayList var14 = Lists.newArrayList();
                     ArrayList var15 = Lists.newArrayList();
                     ArrayList var16 = Lists.newArrayList();
                     LinkedList var17 = Lists.newLinkedList();
                     BlockPos var18 = new BlockPos(var7.minX - var6.minX, var7.minY - var6.minY, var7.minZ - var6.minZ);

                     for(int var19 = var6.minZ; var19 <= var6.maxZ; ++var19) {
                        for(int var20 = var6.minY; var20 <= var6.maxY; ++var20) {
                           for(int var21 = var6.minX; var21 <= var6.maxX; ++var21) {
                              BlockPos var22 = new BlockPos(var21, var20, var19);
                              BlockPos var23 = var22.add(var18);
                              IBlockState var24 = var12.getBlockState(var22);
                              if ((!var13 || var24.getBlock() != Blocks.air) && (var10 == null || var24.getBlock() == var10 && (var11 < 0 || var24.getBlock().getMetaFromState(var24) == var11))) {
                                 TileEntity var25 = var12.getTileEntity(var22);
                                 if (var25 != null) {
                                    NBTTagCompound var26 = new NBTTagCompound();
                                    var25.writeToNBT(var26);
                                    var15.add(new CommandClone.StaticCloneData(var23, var24, var26));
                                    var17.addLast(var22);
                                 } else if (!var24.getBlock().isFullBlock() && !var24.getBlock().isFullCube()) {
                                    var16.add(new CommandClone.StaticCloneData(var23, var24, (NBTTagCompound)null));
                                    var17.addFirst(var22);
                                 } else {
                                    var14.add(new CommandClone.StaticCloneData(var23, var24, (NBTTagCompound)null));
                                    var17.addLast(var22);
                                 }
                              }
                           }
                        }
                     }

                     if (var9) {
                        BlockPos var27;
                        Iterator var29;
                        for(var29 = var17.iterator(); var29.hasNext(); var12.setBlockState(var27, Blocks.barrier.getDefaultState(), 2)) {
                           var27 = (BlockPos)var29.next();
                           TileEntity var31 = var12.getTileEntity(var27);
                           if (var31 instanceof IInventory) {
                              ((IInventory)var31).clear();
                           }
                        }

                        var29 = var17.iterator();

                        while(var29.hasNext()) {
                           var27 = (BlockPos)var29.next();
                           var12.setBlockState(var27, Blocks.air.getDefaultState(), 3);
                        }
                     }

                     ArrayList var28 = Lists.newArrayList();
                     var28.addAll(var14);
                     var28.addAll(var15);
                     var28.addAll(var16);
                     List var30 = Lists.reverse(var28);

                     CommandClone.StaticCloneData var32;
                     Iterator var33;
                     TileEntity var34;
                     for(var33 = var30.iterator(); var33.hasNext(); var12.setBlockState(var32.pos, Blocks.barrier.getDefaultState(), 2)) {
                        var32 = (CommandClone.StaticCloneData)var33.next();
                        var34 = var12.getTileEntity(var32.pos);
                        if (var34 instanceof IInventory) {
                           ((IInventory)var34).clear();
                        }
                     }

                     var8 = 0;
                     var33 = var28.iterator();

                     while(var33.hasNext()) {
                        var32 = (CommandClone.StaticCloneData)var33.next();
                        if (var12.setBlockState(var32.pos, var32.blockState, 2)) {
                           ++var8;
                        }
                     }

                     for(var33 = var15.iterator(); var33.hasNext(); var12.setBlockState(var32.pos, var32.blockState, 2)) {
                        var32 = (CommandClone.StaticCloneData)var33.next();
                        var34 = var12.getTileEntity(var32.pos);
                        if (var32.compound != null && var34 != null) {
                           var32.compound.setInteger("x", var32.pos.getX());
                           var32.compound.setInteger("y", var32.pos.getY());
                           var32.compound.setInteger("z", var32.pos.getZ());
                           var34.readFromNBT(var32.compound);
                           var34.markDirty();
                        }
                     }

                     var33 = var30.iterator();

                     while(var33.hasNext()) {
                        var32 = (CommandClone.StaticCloneData)var33.next();
                        var12.notifyNeighborsRespectDebug(var32.pos, var32.blockState.getBlock());
                     }

                     List var35 = var12.func_175712_a(var6, false);
                     if (var35 != null) {
                        Iterator var37 = var35.iterator();

                        while(var37.hasNext()) {
                           NextTickListEntry var36 = (NextTickListEntry)var37.next();
                           if (var6.isVecInside(var36.position)) {
                              BlockPos var38 = var36.position.add(var18);
                              var12.scheduleBlockUpdate(var38, var36.getBlock(), (int)(var36.scheduledTime - var12.getWorldInfo().getWorldTotalTime()), var36.priority);
                           }
                        }
                     }

                     if (var8 <= 0) {
                        throw new CommandException("commands.clone.failed", new Object[0]);
                     } else {
                        var1.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, var8);
                        notifyOperators(var1, this, "commands.clone.success", new Object[]{var8});
                     }
                  } else {
                     throw new CommandException("commands.clone.outOfWorld", new Object[0]);
                  }
               } else {
                  throw new CommandException("commands.clone.outOfWorld", new Object[0]);
               }
            }
         }
      }
   }

   static class StaticCloneData {
      public final NBTTagCompound compound;
      public final BlockPos pos;
      public final IBlockState blockState;

      public StaticCloneData(BlockPos var1, IBlockState var2, NBTTagCompound var3) {
         this.pos = var1;
         this.blockState = var2;
         this.compound = var3;
      }
   }
}
