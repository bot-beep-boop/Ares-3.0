package net.java.games.input;

public final class EventQueue {
   private int tail;
   private int head;
   private final Event[] queue;

   public EventQueue(int var1) {
      this.queue = new Event[var1 + 1];

      for(int var2 = 0; var2 < this.queue.length; ++var2) {
         this.queue[var2] = new Event();
      }

   }

   final synchronized boolean isFull() {
      return this.increase(this.tail) == this.head;
   }

   public final synchronized boolean getNextEvent(Event var1) {
      if (this.head == this.tail) {
         return false;
      } else {
         var1.set(this.queue[this.head]);
         this.head = this.increase(this.head);
         return true;
      }
   }

   private final int increase(int var1) {
      return (var1 + 1) % this.queue.length;
   }

   final synchronized void add(Event var1) {
      this.queue[this.tail].set(var1);
      this.tail = this.increase(this.tail);
   }
}
