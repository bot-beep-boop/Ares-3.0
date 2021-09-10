package net.minecraft.network.play.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;

public class S3EPacketTeams implements Packet<INetHandlerPlayClient> {
   private String displayName = "";
   private String suffix = "";
   private String name = "";
   private String nameTagVisibility;
   private int friendlyFlags;
   private int color;
   private Collection<String> players;
   private String prefix = "";
   private int action;

   public String getName() {
      return this.name;
   }

   public S3EPacketTeams(ScorePlayerTeam var1, Collection<String> var2, int var3) {
      this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
      this.color = -1;
      this.players = Lists.newArrayList();
      if (var3 != 3 && var3 != 4) {
         throw new IllegalArgumentException("Method must be join or leave for player constructor");
      } else if (var2 != null && !var2.isEmpty()) {
         this.action = var3;
         this.name = var1.getRegisteredName();
         this.players.addAll(var2);
      } else {
         throw new IllegalArgumentException("Players cannot be null/empty");
      }
   }

   public String getDisplayName() {
      return this.displayName;
   }

   public String getPrefix() {
      return this.prefix;
   }

   public int getColor() {
      return this.color;
   }

   public void processPacket(INetHandler var1) {
      this.processPacket((INetHandlerPlayClient)var1);
   }

   public S3EPacketTeams() {
      this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
      this.color = -1;
      this.players = Lists.newArrayList();
   }

   public S3EPacketTeams(ScorePlayerTeam var1, int var2) {
      this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
      this.color = -1;
      this.players = Lists.newArrayList();
      this.name = var1.getRegisteredName();
      this.action = var2;
      if (var2 == 0 || var2 == 2) {
         this.displayName = var1.getTeamName();
         this.prefix = var1.getColorPrefix();
         this.suffix = var1.getColorSuffix();
         this.friendlyFlags = var1.func_98299_i();
         this.nameTagVisibility = var1.getNameTagVisibility().internalName;
         this.color = var1.getChatFormat().getColorIndex();
      }

      if (var2 == 0) {
         this.players.addAll(var1.getMembershipCollection());
      }

   }

   public String getSuffix() {
      return this.suffix;
   }

   public void readPacketData(PacketBuffer var1) throws IOException {
      this.name = var1.readStringFromBuffer(16);
      this.action = var1.readByte();
      if (this.action == 0 || this.action == 2) {
         this.displayName = var1.readStringFromBuffer(32);
         this.prefix = var1.readStringFromBuffer(16);
         this.suffix = var1.readStringFromBuffer(16);
         this.friendlyFlags = var1.readByte();
         this.nameTagVisibility = var1.readStringFromBuffer(32);
         this.color = var1.readByte();
      }

      if (this.action == 0 || this.action == 3 || this.action == 4) {
         int var2 = var1.readVarIntFromBuffer();

         for(int var3 = 0; var3 < var2; ++var3) {
            this.players.add(var1.readStringFromBuffer(40));
         }
      }

   }

   public Collection<String> getPlayers() {
      return this.players;
   }

   public String getNameTagVisibility() {
      return this.nameTagVisibility;
   }

   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeString(this.name);
      var1.writeByte(this.action);
      if (this.action == 0 || this.action == 2) {
         var1.writeString(this.displayName);
         var1.writeString(this.prefix);
         var1.writeString(this.suffix);
         var1.writeByte(this.friendlyFlags);
         var1.writeString(this.nameTagVisibility);
         var1.writeByte(this.color);
      }

      if (this.action == 0 || this.action == 3 || this.action == 4) {
         var1.writeVarIntToBuffer(this.players.size());
         Iterator var3 = this.players.iterator();

         while(var3.hasNext()) {
            String var2 = (String)var3.next();
            var1.writeString(var2);
         }
      }

   }

   public int getAction() {
      return this.action;
   }

   public int getFriendlyFlags() {
      return this.friendlyFlags;
   }

   public void processPacket(INetHandlerPlayClient var1) {
      var1.handleTeams(this);
   }
}
