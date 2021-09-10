package net.optifine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.init.Blocks;

public class ListQuadsOverlay {
   private List<BakedQuad> listQuads = new ArrayList();
   private List<BakedQuad> listQuadsSingle = Arrays.asList();
   private List<IBlockState> listBlockStates = new ArrayList();

   public IBlockState getBlockState(int var1) {
      return var1 >= 0 && var1 < this.listBlockStates.size() ? (IBlockState)this.listBlockStates.get(var1) : Blocks.air.getDefaultState();
   }

   public int size() {
      return this.listQuads.size();
   }

   public void clear() {
      this.listQuads.clear();
      this.listBlockStates.clear();
   }

   public void addQuad(BakedQuad var1, IBlockState var2) {
      if (var1 != null) {
         this.listQuads.add(var1);
         this.listBlockStates.add(var2);
      }

   }

   public BakedQuad getQuad(int var1) {
      return (BakedQuad)this.listQuads.get(var1);
   }

   public List<BakedQuad> getListQuadsSingle(BakedQuad var1) {
      this.listQuadsSingle.set(0, var1);
      return this.listQuadsSingle;
   }
}
