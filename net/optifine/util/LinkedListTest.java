package net.optifine.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.optifine.render.VboRange;

public class LinkedListTest {
   private static void dbgLinkedList(LinkedList<VboRange> var0) {
      StringBuffer var1 = new StringBuffer();

      VboRange var5;
      for(Iterator var3 = ((List)var0).iterator(); var3.hasNext(); var1.append(var5.getPosition())) {
         Object var2 = var3.next();
         LinkedList.Node var4 = (LinkedList.Node)var2;
         var5 = (VboRange)var4.getItem();
         if (var1.length() > 0) {
            var1.append(", ");
         }
      }

      dbg("List: " + var1);
   }

   public static void main(String[] var0) throws Exception {
      LinkedList var1 = new LinkedList();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      Random var4 = new Random();
      byte var5 = 100;

      int var6;
      VboRange var7;
      for(var6 = 0; var6 < var5; ++var6) {
         var7 = new VboRange();
         var7.setPosition(var6);
         var2.add(var7);
      }

      for(var6 = 0; var6 < 100000; ++var6) {
         checkLists(var2, var3, var5);
         checkLinkedList(var1, var3.size());
         if (var6 % 5 == 0) {
            dbgLinkedList(var1);
         }

         LinkedList.Node var8;
         if (var4.nextBoolean()) {
            if (!var2.isEmpty()) {
               var7 = (VboRange)var2.get(var4.nextInt(var2.size()));
               var8 = var7.getNode();
               if (var4.nextBoolean()) {
                  var1.addFirst(var8);
                  dbg("Add first: " + var7.getPosition());
               } else if (var4.nextBoolean()) {
                  var1.addLast(var8);
                  dbg("Add last: " + var7.getPosition());
               } else {
                  if (var3.isEmpty()) {
                     continue;
                  }

                  VboRange var9 = (VboRange)var3.get(var4.nextInt(var3.size()));
                  LinkedList.Node var10 = var9.getNode();
                  var1.addAfter(var10, var8);
                  dbg("Add after: " + var9.getPosition() + ", " + var7.getPosition());
               }

               var2.remove(var7);
               var3.add(var7);
            }
         } else if (!var3.isEmpty()) {
            var7 = (VboRange)var3.get(var4.nextInt(var3.size()));
            var8 = var7.getNode();
            var1.remove(var8);
            dbg("Remove: " + var7.getPosition());
            var3.remove(var7);
            var2.add(var7);
         }
      }

   }

   private static void checkLists(List<VboRange> var0, List<VboRange> var1, int var2) {
      int var3 = var0.size() + var1.size();
      if (var3 != var2) {
         throw new RuntimeException("Total size: " + var3);
      }
   }

   private static void dbg(String var0) {
      System.out.println(var0);
   }

   private static void checkLinkedList(LinkedList<VboRange> var0, int var1) {
      if (var0.getSize() != var1) {
         throw new RuntimeException("Wrong size, linked: " + var0.getSize() + ", used: " + var1);
      } else {
         int var2 = 0;

         for(LinkedList.Node var3 = var0.getFirst(); var3 != null; var3 = var3.getNext()) {
            ++var2;
         }

         if (var0.getSize() != var2) {
            throw new RuntimeException("Wrong count, linked: " + var0.getSize() + ", count: " + var2);
         } else {
            int var5 = 0;

            for(LinkedList.Node var4 = var0.getLast(); var4 != null; var4 = var4.getPrev()) {
               ++var5;
            }

            if (var0.getSize() != var5) {
               throw new RuntimeException("Wrong count back, linked: " + var0.getSize() + ", count: " + var5);
            }
         }
      }
   }
}
