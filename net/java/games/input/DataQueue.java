package net.java.games.input;

final class DataQueue {
   static final boolean $assertionsDisabled;
   private int limit;
   private int position;
   private final Object[] elements;
   static Class class$net$java$games$input$DataQueue;

   public final void flip() {
      this.limit = this.position;
      this.position = 0;
   }

   public final void position(int var1) {
      this.position = var1;
   }

   public DataQueue(int var1, Class var2) {
      this.elements = new Object[var1];

      for(int var3 = 0; var3 < this.elements.length; ++var3) {
         try {
            this.elements[var3] = var2.newInstance();
         } catch (InstantiationException var5) {
            throw new RuntimeException(var5);
         } catch (IllegalAccessException var6) {
            throw new RuntimeException(var6);
         }
      }

      this.clear();
   }

   public final int limit() {
      return this.limit;
   }

   public final Object get() {
      return !this.hasRemaining() ? null : this.get(this.position++);
   }

   public final Object[] getElements() {
      return this.elements;
   }

   public final boolean hasRemaining() {
      return this.remaining() > 0;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   public final Object get(int var1) {
      if (!$assertionsDisabled && var1 >= this.limit) {
         throw new AssertionError();
      } else {
         return this.elements[var1];
      }
   }

   public final void clear() {
      this.position = 0;
      this.limit = this.elements.length;
   }

   static {
      $assertionsDisabled = !(class$net$java$games$input$DataQueue == null ? (class$net$java$games$input$DataQueue = class$("net.java.games.input.DataQueue")) : class$net$java$games$input$DataQueue).desiredAssertionStatus();
   }

   private final void swap(int var1, int var2) {
      Object var3 = this.elements[var1];
      this.elements[var1] = this.elements[var2];
      this.elements[var2] = var3;
   }

   public final void compact() {
      int var1;
      for(var1 = 0; this.hasRemaining(); ++var1) {
         this.swap(this.position, var1);
         ++this.position;
      }

      this.position = var1;
      this.limit = this.elements.length;
   }

   public final int position() {
      return this.position;
   }

   public final int remaining() {
      return this.limit - this.position;
   }
}
