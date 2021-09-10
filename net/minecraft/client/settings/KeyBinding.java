package net.minecraft.client.settings;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.IntHashMap;

public class KeyBinding implements Comparable<KeyBinding> {
   private static final IntHashMap<KeyBinding> hash = new IntHashMap();
   private final int keyCodeDefault;
   private int pressTime;
   private final String keyDescription;
   private static final Set<String> keybindSet = Sets.newHashSet();
   private final String keyCategory;
   private static final List<KeyBinding> keybindArray = Lists.newArrayList();
   private boolean pressed;
   private int keyCode;

   public static void unPressAllKeys() {
      Iterator var1 = keybindArray.iterator();

      while(var1.hasNext()) {
         KeyBinding var0 = (KeyBinding)var1.next();
         var0.unpressKey();
      }

   }

   public static void resetKeyBindingArrayAndHash() {
      hash.clearMap();
      Iterator var1 = keybindArray.iterator();

      while(var1.hasNext()) {
         KeyBinding var0 = (KeyBinding)var1.next();
         hash.addKey(var0.keyCode, var0);
      }

   }

   public int compareTo(Object var1) {
      return this.compareTo((KeyBinding)var1);
   }

   public String getKeyDescription() {
      return this.keyDescription;
   }

   public static void setKeyBindState(int var0, boolean var1) {
      if (var0 != 0) {
         KeyBinding var2 = (KeyBinding)hash.lookup(var0);
         if (var2 != null) {
            var2.pressed = var1;
         }
      }

   }

   public boolean isPressed() {
      if (this.pressTime == 0) {
         return false;
      } else {
         --this.pressTime;
         return true;
      }
   }

   private void unpressKey() {
      this.pressTime = 0;
      this.pressed = false;
   }

   public void setKeyCode(int var1) {
      this.keyCode = var1;
   }

   public int getKeyCodeDefault() {
      return this.keyCodeDefault;
   }

   public int compareTo(KeyBinding var1) {
      int var2 = I18n.format(this.keyCategory).compareTo(I18n.format(var1.keyCategory));
      if (var2 == 0) {
         var2 = I18n.format(this.keyDescription).compareTo(I18n.format(var1.keyDescription));
      }

      return var2;
   }

   public String getKeyCategory() {
      return this.keyCategory;
   }

   public int getKeyCode() {
      return this.keyCode;
   }

   public static void onTick(int var0) {
      if (var0 != 0) {
         KeyBinding var1 = (KeyBinding)hash.lookup(var0);
         if (var1 != null) {
            ++var1.pressTime;
         }
      }

   }

   public boolean isKeyDown() {
      return this.pressed;
   }

   public static Set<String> getKeybinds() {
      return keybindSet;
   }

   public KeyBinding(String var1, int var2, String var3) {
      this.keyDescription = var1;
      this.keyCode = var2;
      this.keyCodeDefault = var2;
      this.keyCategory = var3;
      keybindArray.add(this);
      hash.addKey(var2, this);
      keybindSet.add(var3);
   }
}
