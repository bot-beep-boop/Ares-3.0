package net.java.games.input;

final class DIEffectInfo {
   private final byte[] guid;
   private final IDirectInputDevice device;
   private final int guid_id;
   private final String name;
   private final int static_params;
   private final int effect_type;
   private final int dynamic_params;

   public final String getName() {
      return this.name;
   }

   public final int getGUIDId() {
      return this.guid_id;
   }

   public final byte[] getGUID() {
      return this.guid;
   }

   public final int getDynamicParams() {
      return this.dynamic_params;
   }

   public final int getEffectType() {
      return this.effect_type;
   }

   public DIEffectInfo(IDirectInputDevice var1, byte[] var2, int var3, int var4, int var5, int var6, String var7) {
      this.device = var1;
      this.guid = var2;
      this.guid_id = var3;
      this.effect_type = var4;
      this.static_params = var5;
      this.dynamic_params = var6;
      this.name = var7;
   }
}
