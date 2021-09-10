package net.minecraft.server;

import java.util.concurrent.Callable;

class MinecraftServer$4 implements Callable<String> {
   final MinecraftServer a;

   public String a() {
      return MinecraftServer.a(this.a).o() + " / " + MinecraftServer.a(this.a).p() + "; " + MinecraftServer.a(this.a).v();
   }

   MinecraftServer$4(MinecraftServer var1) {
      this.a = var1;
   }

   public Object call() throws Exception {
      return this.a();
   }
}
