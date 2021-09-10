package net.optifine.shaders;

import java.util.ArrayList;
import java.util.List;

public class Programs {
   private Program programNone;
   private List<Program> programs = new ArrayList();

   public Programs() {
      this.programNone = this.make("", ProgramStage.NONE, true);
   }

   public Program makeGbuffers(String var1, Program var2) {
      return this.make(var1, ProgramStage.GBUFFERS, var2);
   }

   public Program makeDeferred(String var1) {
      return this.make(var1, ProgramStage.DEFERRED, this.programNone);
   }

   public int getCount() {
      return this.programs.size();
   }

   public Program[] getPrograms() {
      Program[] var1 = (Program[])this.programs.toArray(new Program[this.programs.size()]);
      return var1;
   }

   public Program make(String var1, ProgramStage var2, Program var3) {
      int var4 = this.programs.size();
      Program var5 = new Program(var4, var1, var2, var3);
      this.programs.add(var5);
      return var5;
   }

   public Program[] makeDeferreds(String var1, int var2) {
      Program[] var3 = new Program[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         String var5 = var4 == 0 ? var1 : var1 + var4;
         var3[var4] = this.makeDeferred(var5);
      }

      return var3;
   }

   public Program[] makeComposites(String var1, int var2) {
      Program[] var3 = new Program[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         String var5 = var4 == 0 ? var1 : var1 + var4;
         var3[var4] = this.makeComposite(var5);
      }

      return var3;
   }

   public Program makeShadow(String var1, Program var2) {
      return this.make(var1, ProgramStage.SHADOW, var2);
   }

   public Program[] getPrograms(Program var1, Program var2) {
      int var3 = var1.getIndex();
      int var4 = var2.getIndex();
      if (var3 > var4) {
         int var5 = var3;
         var3 = var4;
         var4 = var5;
      }

      Program[] var7 = new Program[var4 - var3 + 1];

      for(int var6 = 0; var6 < var7.length; ++var6) {
         var7[var6] = (Program)this.programs.get(var3 + var6);
      }

      return var7;
   }

   public String toString() {
      return this.programs.toString();
   }

   public Program makeComposite(String var1) {
      return this.make(var1, ProgramStage.COMPOSITE, this.programNone);
   }

   private Program make(String var1, ProgramStage var2, boolean var3) {
      int var4 = this.programs.size();
      Program var5 = new Program(var4, var1, var2, var3);
      this.programs.add(var5);
      return var5;
   }

   public Program makeVirtual(String var1) {
      return this.make(var1, ProgramStage.NONE, true);
   }

   public Program getProgramNone() {
      return this.programNone;
   }

   public Program getProgram(String var1) {
      if (var1 == null) {
         return null;
      } else {
         for(int var2 = 0; var2 < this.programs.size(); ++var2) {
            Program var3 = (Program)this.programs.get(var2);
            String var4 = var3.getName();
            if (var4.equals(var1)) {
               return var3;
            }
         }

         return null;
      }
   }

   public String[] getProgramNames() {
      String[] var1 = new String[this.programs.size()];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = ((Program)this.programs.get(var2)).getName();
      }

      return var1;
   }
}
