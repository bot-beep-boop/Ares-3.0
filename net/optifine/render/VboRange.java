package net.optifine.render;

import net.optifine.util.LinkedList;

public class VboRange {
   private int position = -1;
   private int size = 0;
   private LinkedList.Node<VboRange> node = new LinkedList.Node(this);

   public void setPosition(int var1) {
      this.position = var1;
   }

   public int getPositionNext() {
      return this.position + this.size;
   }

   public VboRange getPrev() {
      LinkedList.Node var1 = this.node.getPrev();
      return var1 == null ? null : (VboRange)var1.getItem();
   }

   public String toString() {
      return this.position + "/" + this.size + "/" + (this.position + this.size);
   }

   public LinkedList.Node<VboRange> getNode() {
      return this.node;
   }

   public int getSize() {
      return this.size;
   }

   public int getPosition() {
      return this.position;
   }

   public void setSize(int var1) {
      this.size = var1;
   }

   public VboRange getNext() {
      LinkedList.Node var1 = this.node.getNext();
      return var1 == null ? null : (VboRange)var1.getItem();
   }
}
