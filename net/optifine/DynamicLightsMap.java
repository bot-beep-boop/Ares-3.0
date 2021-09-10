package net.optifine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicLightsMap {
   private Map<Integer, DynamicLight> map = new HashMap();
   private List<DynamicLight> list = new ArrayList();
   private boolean dirty = false;

   public DynamicLight remove(int var1) {
      DynamicLight var2 = (DynamicLight)this.map.remove(var1);
      if (var2 != null) {
         this.setDirty();
      }

      return var2;
   }

   public DynamicLight put(int var1, DynamicLight var2) {
      DynamicLight var3 = (DynamicLight)this.map.put(var1, var2);
      this.setDirty();
      return var3;
   }

   public DynamicLight get(int var1) {
      return (DynamicLight)this.map.get(var1);
   }

   public List<DynamicLight> valueList() {
      if (this.dirty) {
         this.list.clear();
         this.list.addAll(this.map.values());
         this.dirty = false;
      }

      return this.list;
   }

   public void clear() {
      this.map.clear();
      this.list.clear();
      this.setDirty();
   }

   private void setDirty() {
      this.dirty = true;
   }

   public int size() {
      return this.map.size();
   }
}
