package net.minecraft.block.state;

import com.google.common.base.Predicate;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockWorldState {
   private final boolean field_181628_c;
   private final BlockPos pos;
   private final World world;
   private IBlockState state;
   private boolean tileEntityInitialized;
   private TileEntity tileEntity;

   public BlockPos getPos() {
      return this.pos;
   }

   public IBlockState getBlockState() {
      if (this.state == null && (this.field_181628_c || this.world.isBlockLoaded(this.pos))) {
         this.state = this.world.getBlockState(this.pos);
      }

      return this.state;
   }

   public TileEntity getTileEntity() {
      if (this.tileEntity == null && !this.tileEntityInitialized) {
         this.tileEntity = this.world.getTileEntity(this.pos);
         this.tileEntityInitialized = true;
      }

      return this.tileEntity;
   }

   public BlockWorldState(World var1, BlockPos var2, boolean var3) {
      this.world = var1;
      this.pos = var2;
      this.field_181628_c = var3;
   }

   public static Predicate<BlockWorldState> hasState(Predicate<IBlockState> var0) {
      return new Predicate<BlockWorldState>(var0) {
         private final Predicate val$predicatesIn;

         public boolean apply(BlockWorldState var1) {
            return var1 != null && this.val$predicatesIn.apply(var1.getBlockState());
         }

         public boolean apply(Object var1) {
            return this.apply((BlockWorldState)var1);
         }

         {
            this.val$predicatesIn = var1;
         }
      };
   }
}
