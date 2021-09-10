package net.java.games.input;

class UsagePair {
   private final Usage usage;
   private final UsagePage usage_page;

   public final UsagePage getUsagePage() {
      return this.usage_page;
   }

   public final Usage getUsage() {
      return this.usage;
   }

   public final boolean equals(Object var1) {
      if (!(var1 instanceof UsagePair)) {
         return false;
      } else {
         UsagePair var2 = (UsagePair)var1;
         return var2.usage.equals(this.usage) && var2.usage_page.equals(this.usage_page);
      }
   }

   public final String toString() {
      return "UsagePair: (page = " + this.usage_page + ", usage = " + this.usage + ")";
   }

   public UsagePair(UsagePage var1, Usage var2) {
      this.usage_page = var1;
      this.usage = var2;
   }

   public final int hashCode() {
      return this.usage.hashCode() ^ this.usage_page.hashCode();
   }
}
