package net.optifine.shaders;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProgramStack {
   private Deque<Program> stack = new ArrayDeque();

   public Program pop() {
      if (this.stack.isEmpty()) {
         return Shaders.ProgramNone;
      } else {
         Program var1 = (Program)this.stack.pollLast();
         return var1;
      }
   }

   public void push(Program var1) {
      this.stack.addLast(var1);
   }
}
