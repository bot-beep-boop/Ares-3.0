package com.aresclient.visuals.utils.items;

import java.util.List;

public class DropDownMenu$List {
   private List<String> items;
   private String Header;

   public List<String> getItems() {
      return this.items;
   }

   public String getHeader() {
      return this.Header;
   }

   public void setItems(List<String> var1) {
      this.items = var1;
   }

   public DropDownMenu$List(List<String> var1, String var2) {
      this.Header = var2;
      this.items = var1;
   }

   public void setHeader(String var1) {
      this.Header = var1;
   }
}
