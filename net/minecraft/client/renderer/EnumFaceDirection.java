package net.minecraft.client.renderer;

import net.minecraft.util.EnumFacing;

public enum EnumFaceDirection {
   EAST(new EnumFaceDirection.VertexInformation[]{new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null)}),
   DOWN(new EnumFaceDirection.VertexInformation[]{new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null)});

   private static final EnumFaceDirection[] facings = new EnumFaceDirection[6];
   private final EnumFaceDirection.VertexInformation[] vertexInfos;
   private static final EnumFaceDirection[] ENUM$VALUES = new EnumFaceDirection[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};
   SOUTH(new EnumFaceDirection.VertexInformation[]{new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null)}),
   UP(new EnumFaceDirection.VertexInformation[]{new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null)}),
   NORTH(new EnumFaceDirection.VertexInformation[]{new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.EAST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null)}),
   WEST(new EnumFaceDirection.VertexInformation[]{new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.NORTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.DOWN_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null), new EnumFaceDirection.VertexInformation(EnumFaceDirection.Constants.WEST_INDEX, EnumFaceDirection.Constants.UP_INDEX, EnumFaceDirection.Constants.SOUTH_INDEX, (EnumFaceDirection.VertexInformation)null)});

   static {
      facings[EnumFaceDirection.Constants.DOWN_INDEX] = DOWN;
      facings[EnumFaceDirection.Constants.UP_INDEX] = UP;
      facings[EnumFaceDirection.Constants.NORTH_INDEX] = NORTH;
      facings[EnumFaceDirection.Constants.SOUTH_INDEX] = SOUTH;
      facings[EnumFaceDirection.Constants.WEST_INDEX] = WEST;
      facings[EnumFaceDirection.Constants.EAST_INDEX] = EAST;
   }

   public static EnumFaceDirection getFacing(EnumFacing var0) {
      return facings[var0.getIndex()];
   }

   public EnumFaceDirection.VertexInformation getVertexInformation(int var1) {
      return this.vertexInfos[var1];
   }

   private EnumFaceDirection(EnumFaceDirection.VertexInformation... var3) {
      this.vertexInfos = var3;
   }

   public static final class Constants {
      public static final int NORTH_INDEX;
      public static final int DOWN_INDEX;
      public static final int EAST_INDEX;
      public static final int SOUTH_INDEX;
      public static final int UP_INDEX;
      public static final int WEST_INDEX;

      static {
         SOUTH_INDEX = EnumFacing.SOUTH.getIndex();
         UP_INDEX = EnumFacing.UP.getIndex();
         EAST_INDEX = EnumFacing.EAST.getIndex();
         NORTH_INDEX = EnumFacing.NORTH.getIndex();
         DOWN_INDEX = EnumFacing.DOWN.getIndex();
         WEST_INDEX = EnumFacing.WEST.getIndex();
      }
   }

   public static class VertexInformation {
      public final int yIndex;
      public final int xIndex;
      public final int zIndex;

      VertexInformation(int var1, int var2, int var3, EnumFaceDirection.VertexInformation var4) {
         this(var1, var2, var3);
      }

      private VertexInformation(int var1, int var2, int var3) {
         this.xIndex = var1;
         this.yIndex = var2;
         this.zIndex = var3;
      }
   }
}
