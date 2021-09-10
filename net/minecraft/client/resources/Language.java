package net.minecraft.client.resources;

public class Language implements Comparable<Language> {
   private final String region;
   private final String languageCode;
   private final String name;
   private final boolean bidirectional;

   public int compareTo(Language var1) {
      return this.languageCode.compareTo(var1.languageCode);
   }

   public String toString() {
      return String.format("%s (%s)", this.name, this.region);
   }

   public boolean isBidirectional() {
      return this.bidirectional;
   }

   public int compareTo(Object var1) {
      return this.compareTo((Language)var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         return !(var1 instanceof Language) ? false : this.languageCode.equals(((Language)var1).languageCode);
      }
   }

   public String getLanguageCode() {
      return this.languageCode;
   }

   public Language(String var1, String var2, String var3, boolean var4) {
      this.languageCode = var1;
      this.region = var2;
      this.name = var3;
      this.bidirectional = var4;
   }

   public int hashCode() {
      return this.languageCode.hashCode();
   }
}
