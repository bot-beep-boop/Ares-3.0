package net.minecraft.client.resources.data;

import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AnimationMetadataSection implements IMetadataSection {
   private final boolean interpolate;
   private final List<AnimationFrame> animationFrames;
   private final int frameTime;
   private final int frameHeight;
   private final int frameWidth;

   public boolean isInterpolate() {
      return this.interpolate;
   }

   public boolean frameHasTime(int var1) {
      return !((AnimationFrame)this.animationFrames.get(var1)).hasNoTime();
   }

   public int getFrameHeight() {
      return this.frameHeight;
   }

   public int getFrameTimeSingle(int var1) {
      AnimationFrame var2 = this.getAnimationFrame(var1);
      return var2.hasNoTime() ? this.frameTime : var2.getFrameTime();
   }

   private AnimationFrame getAnimationFrame(int var1) {
      return (AnimationFrame)this.animationFrames.get(var1);
   }

   public Set<Integer> getFrameIndexSet() {
      HashSet var1 = Sets.newHashSet();
      Iterator var3 = this.animationFrames.iterator();

      while(var3.hasNext()) {
         AnimationFrame var2 = (AnimationFrame)var3.next();
         var1.add(var2.getFrameIndex());
      }

      return var1;
   }

   public int getFrameCount() {
      return this.animationFrames.size();
   }

   public int getFrameTime() {
      return this.frameTime;
   }

   public AnimationMetadataSection(List<AnimationFrame> var1, int var2, int var3, int var4, boolean var5) {
      this.animationFrames = var1;
      this.frameWidth = var2;
      this.frameHeight = var3;
      this.frameTime = var4;
      this.interpolate = var5;
   }

   public int getFrameIndex(int var1) {
      return ((AnimationFrame)this.animationFrames.get(var1)).getFrameIndex();
   }

   public int getFrameWidth() {
      return this.frameWidth;
   }
}
