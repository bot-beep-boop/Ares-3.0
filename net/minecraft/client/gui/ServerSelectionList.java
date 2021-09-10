package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.network.LanServerDetector;

public class ServerSelectionList extends GuiListExtended {
   private int selectedSlotIndex = -1;
   private final GuiListExtended.IGuiListEntry lanScanEntry = new ServerListEntryLanScan();
   private final GuiMultiplayer owner;
   private final List<ServerListEntryNormal> serverListInternet = Lists.newArrayList();
   private final List<ServerListEntryLanDetected> serverListLan = Lists.newArrayList();

   public int func_148193_k() {
      return this.selectedSlotIndex;
   }

   public int getListWidth() {
      return super.getListWidth() + 85;
   }

   public void setSelectedSlotIndex(int var1) {
      this.selectedSlotIndex = var1;
   }

   protected boolean isSelected(int var1) {
      return var1 == this.selectedSlotIndex;
   }

   protected int getSize() {
      return this.serverListInternet.size() + 1 + this.serverListLan.size();
   }

   public void func_148195_a(ServerList var1) {
      this.serverListInternet.clear();

      for(int var2 = 0; var2 < var1.countServers(); ++var2) {
         this.serverListInternet.add(new ServerListEntryNormal(this.owner, var1.getServerData(var2)));
      }

   }

   public void func_148194_a(List<LanServerDetector.LanServer> var1) {
      this.serverListLan.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         LanServerDetector.LanServer var2 = (LanServerDetector.LanServer)var3.next();
         this.serverListLan.add(new ServerListEntryLanDetected(this.owner, var2));
      }

   }

   public GuiListExtended.IGuiListEntry getListEntry(int var1) {
      if (var1 < this.serverListInternet.size()) {
         return (GuiListExtended.IGuiListEntry)this.serverListInternet.get(var1);
      } else {
         var1 -= this.serverListInternet.size();
         if (var1 == 0) {
            return this.lanScanEntry;
         } else {
            --var1;
            return (GuiListExtended.IGuiListEntry)this.serverListLan.get(var1);
         }
      }
   }

   public ServerSelectionList(GuiMultiplayer var1, Minecraft var2, int var3, int var4, int var5, int var6, int var7) {
      super(var2, var3, var4, var5, var6, var7);
      this.owner = var1;
   }

   protected int getScrollBarX() {
      return super.getScrollBarX() + 30;
   }
}
