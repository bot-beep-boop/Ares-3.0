package net.minecraft.client.gui.spectator.categories;

import com.google.common.base.Objects;
import java.util.List;
import net.minecraft.client.gui.spectator.ISpectatorMenuObject;
import net.minecraft.client.gui.spectator.ISpectatorMenuView;
import net.minecraft.client.gui.spectator.SpectatorMenu;

public class SpectatorDetails {
   private final int field_178683_c;
   private final List<ISpectatorMenuObject> field_178682_b;
   private final ISpectatorMenuView field_178684_a;

   public int func_178681_b() {
      return this.field_178683_c;
   }

   public ISpectatorMenuObject func_178680_a(int var1) {
      return var1 >= 0 && var1 < this.field_178682_b.size() ? (ISpectatorMenuObject)Objects.firstNonNull((ISpectatorMenuObject)this.field_178682_b.get(var1), SpectatorMenu.field_178657_a) : SpectatorMenu.field_178657_a;
   }

   public SpectatorDetails(ISpectatorMenuView var1, List<ISpectatorMenuObject> var2, int var3) {
      this.field_178684_a = var1;
      this.field_178682_b = var2;
      this.field_178683_c = var3;
   }
}
