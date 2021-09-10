package net.minecraft.realms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;

public class RealmsVertexFormat {
   private VertexFormat v;

   public int getVertexSize() {
      return this.v.getNextOffset();
   }

   public RealmsVertexFormat addElement(RealmsVertexFormatElement var1) {
      return this.from(this.v.addElement(var1.getVertexFormatElement()));
   }

   public int getUvOffset(int var1) {
      return this.v.getUvOffsetById(var1);
   }

   public boolean hasNormal() {
      return this.v.hasNormal();
   }

   public List<RealmsVertexFormatElement> getElements() {
      ArrayList var1 = new ArrayList();
      Iterator var3 = this.v.getElements().iterator();

      while(var3.hasNext()) {
         VertexFormatElement var2 = (VertexFormatElement)var3.next();
         var1.add(new RealmsVertexFormatElement(var2));
      }

      return var1;
   }

   public VertexFormat getVertexFormat() {
      return this.v;
   }

   public int getOffset(int var1) {
      return this.v.getOffset(var1);
   }

   public RealmsVertexFormatElement getElement(int var1) {
      return new RealmsVertexFormatElement(this.v.getElement(var1));
   }

   public RealmsVertexFormat from(VertexFormat var1) {
      this.v = var1;
      return this;
   }

   public int hashCode() {
      return this.v.hashCode();
   }

   public int getIntegerSize() {
      return this.v.getIntegerSize();
   }

   public RealmsVertexFormat(VertexFormat var1) {
      this.v = var1;
   }

   public boolean equals(Object var1) {
      return this.v.equals(var1);
   }

   public int getColorOffset() {
      return this.v.getColorOffset();
   }

   public int getNormalOffset() {
      return this.v.getNormalOffset();
   }

   public boolean hasColor() {
      return this.v.hasColor();
   }

   public String toString() {
      return this.v.toString();
   }

   public int getElementCount() {
      return this.v.getElementCount();
   }

   public boolean hasUv(int var1) {
      return this.v.hasUvOffset(var1);
   }

   public void clear() {
      this.v.clear();
   }
}
