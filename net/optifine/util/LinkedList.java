package net.optifine.util;

import java.util.Iterator;

public class LinkedList<T> {
   private int size;
   private LinkedList.Node<T> last;
   private LinkedList.Node<T> first;

   public LinkedList.Node<T> getFirst() {
      return this.first;
   }

   public void moveAfter(LinkedList.Node<T> var1, LinkedList.Node<T> var2) {
      this.remove(var2);
      this.addAfter(var1, var2);
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      return this.size + " [" + var1.toString() + "]";
   }

   public boolean find(LinkedList.Node<T> var1, LinkedList.Node<T> var2, LinkedList.Node<T> var3) {
      this.checkParent(var2);
      if (var3 != null) {
         this.checkParent(var3);
      }

      LinkedList.Node var4;
      for(var4 = var2; var4 != null && var4 != var3; var4 = var4.getNext()) {
         if (var4 == var1) {
            return true;
         }
      }

      if (var4 != var3) {
         throw new IllegalArgumentException("Sublist is not linked, from: " + var2 + ", to: " + var3);
      } else {
         return false;
      }
   }

   public boolean isEmpty() {
      return this.size <= 0;
   }

   public LinkedList.Node<T> getLast() {
      return this.last;
   }

   private void checkParent(LinkedList.Node<T> var1) {
      if (LinkedList.Node.access$3(var1) != this) {
         throw new IllegalArgumentException("Node has different parent, node: " + var1 + ", parent: " + LinkedList.Node.access$3(var1) + ", this: " + this);
      }
   }

   public int getSize() {
      return this.size;
   }

   public void addFirst(LinkedList.Node<T> var1) {
      this.checkNoParent(var1);
      if (this.isEmpty()) {
         this.first = var1;
         this.last = var1;
      } else {
         LinkedList.Node var2 = this.first;
         LinkedList.Node.access$0(var1, var2);
         LinkedList.Node.access$1(var1, var1);
         this.first = var1;
      }

      LinkedList.Node.access$2(var1, this);
      ++this.size;
   }

   public LinkedList.Node<T> remove(LinkedList.Node<T> var1) {
      this.checkParent(var1);
      LinkedList.Node var2 = var1.getPrev();
      LinkedList.Node var3 = var1.getNext();
      if (var2 != null) {
         LinkedList.Node.access$0(var2, var3);
      } else {
         this.first = var3;
      }

      if (var3 != null) {
         LinkedList.Node.access$1(var3, var2);
      } else {
         this.last = var2;
      }

      LinkedList.Node.access$1(var1, (LinkedList.Node)null);
      LinkedList.Node.access$0(var1, (LinkedList.Node)null);
      LinkedList.Node.access$2(var1, (LinkedList)null);
      --this.size;
      return var1;
   }

   public void addAfter(LinkedList.Node<T> var1, LinkedList.Node<T> var2) {
      if (var1 == null) {
         this.addFirst(var2);
      } else if (var1 == this.last) {
         this.addLast(var2);
      } else {
         this.checkParent(var1);
         this.checkNoParent(var2);
         LinkedList.Node var3 = var1.getNext();
         LinkedList.Node.access$0(var1, var2);
         LinkedList.Node.access$1(var2, var1);
         LinkedList.Node.access$1(var3, var2);
         LinkedList.Node.access$0(var2, var3);
         LinkedList.Node.access$2(var2, this);
         ++this.size;
      }
   }

   public boolean contains(LinkedList.Node<T> var1) {
      return LinkedList.Node.access$3(var1) == this;
   }

   public Iterator<LinkedList.Node<T>> iterator() {
      Iterator var1 = new Iterator<LinkedList.Node<T>>(this) {
         final LinkedList this$0;
         LinkedList.Node<T> node;

         public boolean hasNext() {
            return this.node != null;
         }

         {
            this.this$0 = var1;
            this.node = var1.getFirst();
         }

         public LinkedList.Node<T> next() {
            LinkedList.Node var1 = this.node;
            if (this.node != null) {
               this.node = LinkedList.Node.access$4(this.node);
            }

            return var1;
         }

         public Object next() {
            return this.next();
         }
      };
      return var1;
   }

   private void checkNoParent(LinkedList.Node<T> var1) {
      if (LinkedList.Node.access$3(var1) != null) {
         throw new IllegalArgumentException("Node has different parent, node: " + var1 + ", parent: " + LinkedList.Node.access$3(var1) + ", this: " + this);
      }
   }

   public void addLast(LinkedList.Node<T> var1) {
      this.checkNoParent(var1);
      if (this.isEmpty()) {
         this.first = var1;
         this.last = var1;
      } else {
         LinkedList.Node var2 = this.last;
         LinkedList.Node.access$1(var1, var2);
         LinkedList.Node.access$0(var1, var1);
         this.last = var1;
      }

      LinkedList.Node.access$2(var1, this);
      ++this.size;
   }

   public static class Node<T> {
      private LinkedList.Node<T> next;
      private LinkedList.Node<T> prev;
      private final T item;
      private LinkedList<T> parent;

      public Node(T var1) {
         this.item = var1;
      }

      static LinkedList.Node access$4(LinkedList.Node var0) {
         return var0.next;
      }

      private void setParent(LinkedList<T> var1) {
         this.parent = var1;
      }

      static LinkedList access$3(LinkedList.Node var0) {
         return var0.parent;
      }

      private void setPrev(LinkedList.Node<T> var1) {
         this.prev = var1;
      }

      public LinkedList.Node<T> getNext() {
         return this.next;
      }

      public T getItem() {
         return this.item;
      }

      public String toString() {
         return "" + this.item;
      }

      public LinkedList.Node<T> getPrev() {
         return this.prev;
      }

      static void access$1(LinkedList.Node var0, LinkedList.Node var1) {
         var0.setPrev(var1);
      }

      private void setNext(LinkedList.Node<T> var1) {
         this.next = var1;
      }

      static void access$0(LinkedList.Node var0, LinkedList.Node var1) {
         var0.setNext(var1);
      }

      static void access$2(LinkedList.Node var0, LinkedList var1) {
         var0.setParent(var1);
      }
   }
}
