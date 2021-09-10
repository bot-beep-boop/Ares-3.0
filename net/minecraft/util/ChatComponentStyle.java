package net.minecraft.util;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public abstract class ChatComponentStyle implements IChatComponent {
   protected List<IChatComponent> siblings = Lists.newArrayList();
   private ChatStyle style;

   public IChatComponent appendSibling(IChatComponent var1) {
      var1.getChatStyle().setParentStyle(this.getChatStyle());
      this.siblings.add(var1);
      return this;
   }

   public ChatStyle getChatStyle() {
      if (this.style == null) {
         this.style = new ChatStyle();
         Iterator var2 = this.siblings.iterator();

         while(var2.hasNext()) {
            IChatComponent var1 = (IChatComponent)var2.next();
            var1.getChatStyle().setParentStyle(this.style);
         }
      }

      return this.style;
   }

   public List<IChatComponent> getSiblings() {
      return this.siblings;
   }

   public IChatComponent setChatStyle(ChatStyle var1) {
      this.style = var1;
      Iterator var3 = this.siblings.iterator();

      while(var3.hasNext()) {
         IChatComponent var2 = (IChatComponent)var3.next();
         var2.getChatStyle().setParentStyle(this.getChatStyle());
      }

      return this;
   }

   public int hashCode() {
      return 31 * this.style.hashCode() + this.siblings.hashCode();
   }

   public final String getUnformattedText() {
      StringBuilder var1 = new StringBuilder();
      Iterator var3 = this.iterator();

      while(var3.hasNext()) {
         IChatComponent var2 = (IChatComponent)var3.next();
         var1.append(var2.getUnformattedTextForChat());
      }

      return var1.toString();
   }

   public IChatComponent appendText(String var1) {
      return this.appendSibling(new ChatComponentText(var1));
   }

   public final String getFormattedText() {
      StringBuilder var1 = new StringBuilder();
      Iterator var3 = this.iterator();

      while(var3.hasNext()) {
         IChatComponent var2 = (IChatComponent)var3.next();
         var1.append(var2.getChatStyle().getFormattingCode());
         var1.append(var2.getUnformattedTextForChat());
         var1.append(EnumChatFormatting.RESET);
      }

      return var1.toString();
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ChatComponentStyle)) {
         return false;
      } else {
         ChatComponentStyle var2 = (ChatComponentStyle)var1;
         return this.siblings.equals(var2.siblings) && this.getChatStyle().equals(var2.getChatStyle());
      }
   }

   public Iterator<IChatComponent> iterator() {
      return Iterators.concat(Iterators.forArray(new ChatComponentStyle[]{this}), createDeepCopyIterator(this.siblings));
   }

   public String toString() {
      return "BaseComponent{style=" + this.style + ", siblings=" + this.siblings + '}';
   }

   public static Iterator<IChatComponent> createDeepCopyIterator(Iterable<IChatComponent> var0) {
      Iterator var1 = Iterators.concat(Iterators.transform(var0.iterator(), new Function<IChatComponent, Iterator<IChatComponent>>() {
         public Iterator<IChatComponent> apply(IChatComponent var1) {
            return var1.iterator();
         }

         public Object apply(Object var1) {
            return this.apply((IChatComponent)var1);
         }
      }));
      var1 = Iterators.transform(var1, new Function<IChatComponent, IChatComponent>() {
         public Object apply(Object var1) {
            return this.apply((IChatComponent)var1);
         }

         public IChatComponent apply(IChatComponent var1) {
            IChatComponent var2 = var1.createCopy();
            var2.setChatStyle(var2.getChatStyle().createDeepCopy());
            return var2;
         }
      });
      return var1;
   }
}
