package net.minecraft.network;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.network.login.client.C01PacketEncryptionResponse;
import net.minecraft.network.login.server.S00PacketDisconnect;
import net.minecraft.network.login.server.S01PacketEncryptionRequest;
import net.minecraft.network.login.server.S02PacketLoginSuccess;
import net.minecraft.network.login.server.S03PacketEnableCompression;
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minecraft.network.play.client.C11PacketEnchantItem;
import net.minecraft.network.play.client.C12PacketUpdateSign;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.network.play.client.C18PacketSpectate;
import net.minecraft.network.play.client.C19PacketResourcePackStatus;
import net.minecraft.network.play.server.S00PacketKeepAlive;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S04PacketEntityEquipment;
import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraft.network.play.server.S0APacketUseBed;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import net.minecraft.network.play.server.S0DPacketCollectItem;
import net.minecraft.network.play.server.S0EPacketSpawnObject;
import net.minecraft.network.play.server.S0FPacketSpawnMob;
import net.minecraft.network.play.server.S10PacketSpawnPainting;
import net.minecraft.network.play.server.S11PacketSpawnExperienceOrb;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S13PacketDestroyEntities;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S18PacketEntityTeleport;
import net.minecraft.network.play.server.S19PacketEntityHeadLook;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.network.play.server.S1BPacketEntityAttach;
import net.minecraft.network.play.server.S1CPacketEntityMetadata;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1EPacketRemoveEntityEffect;
import net.minecraft.network.play.server.S1FPacketSetExperience;
import net.minecraft.network.play.server.S20PacketEntityProperties;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S24PacketBlockAction;
import net.minecraft.network.play.server.S25PacketBlockBreakAnim;
import net.minecraft.network.play.server.S26PacketMapChunkBulk;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S28PacketEffect;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.network.play.server.S2APacketParticles;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import net.minecraft.network.play.server.S2EPacketCloseWindow;
import net.minecraft.network.play.server.S2FPacketSetSlot;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.network.play.server.S31PacketWindowProperty;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import net.minecraft.network.play.server.S34PacketMaps;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.network.play.server.S36PacketSignEditorOpen;
import net.minecraft.network.play.server.S37PacketStatistics;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.network.play.server.S3APacketTabComplete;
import net.minecraft.network.play.server.S3BPacketScoreboardObjective;
import net.minecraft.network.play.server.S3CPacketUpdateScore;
import net.minecraft.network.play.server.S3DPacketDisplayScoreboard;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.network.play.server.S40PacketDisconnect;
import net.minecraft.network.play.server.S41PacketServerDifficulty;
import net.minecraft.network.play.server.S42PacketCombatEvent;
import net.minecraft.network.play.server.S43PacketCamera;
import net.minecraft.network.play.server.S44PacketWorldBorder;
import net.minecraft.network.play.server.S45PacketTitle;
import net.minecraft.network.play.server.S46PacketSetCompressionLevel;
import net.minecraft.network.play.server.S47PacketPlayerListHeaderFooter;
import net.minecraft.network.play.server.S48PacketResourcePackSend;
import net.minecraft.network.play.server.S49PacketUpdateEntityNBT;
import net.minecraft.network.status.client.C00PacketServerQuery;
import net.minecraft.network.status.client.C01PacketPing;
import net.minecraft.network.status.server.S00PacketServerInfo;
import net.minecraft.network.status.server.S01PacketPong;
import org.apache.logging.log4j.LogManager;

public enum EnumConnectionState {
   PLAY(0) {
      {
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S00PacketKeepAlive.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S01PacketJoinGame.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S02PacketChat.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S03PacketTimeUpdate.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S04PacketEntityEquipment.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S05PacketSpawnPosition.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S06PacketUpdateHealth.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S07PacketRespawn.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S08PacketPlayerPosLook.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S09PacketHeldItemChange.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0APacketUseBed.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0BPacketAnimation.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0CPacketSpawnPlayer.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0DPacketCollectItem.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0EPacketSpawnObject.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0FPacketSpawnMob.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S10PacketSpawnPainting.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S11PacketSpawnExperienceOrb.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S12PacketEntityVelocity.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S13PacketDestroyEntities.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S14PacketEntity.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S14PacketEntity.S15PacketEntityRelMove.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S14PacketEntity.S16PacketEntityLook.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S14PacketEntity.S17PacketEntityLookMove.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S18PacketEntityTeleport.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S19PacketEntityHeadLook.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S19PacketEntityStatus.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1BPacketEntityAttach.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1CPacketEntityMetadata.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1DPacketEntityEffect.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1EPacketRemoveEntityEffect.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1FPacketSetExperience.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S20PacketEntityProperties.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S21PacketChunkData.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S22PacketMultiBlockChange.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S23PacketBlockChange.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S24PacketBlockAction.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S25PacketBlockBreakAnim.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S26PacketMapChunkBulk.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S27PacketExplosion.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S28PacketEffect.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S29PacketSoundEffect.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2APacketParticles.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2BPacketChangeGameState.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2CPacketSpawnGlobalEntity.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2DPacketOpenWindow.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2EPacketCloseWindow.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2FPacketSetSlot.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S30PacketWindowItems.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S31PacketWindowProperty.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S32PacketConfirmTransaction.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S33PacketUpdateSign.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S34PacketMaps.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S35PacketUpdateTileEntity.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S36PacketSignEditorOpen.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S37PacketStatistics.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S38PacketPlayerListItem.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S39PacketPlayerAbilities.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3APacketTabComplete.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3BPacketScoreboardObjective.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3CPacketUpdateScore.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3DPacketDisplayScoreboard.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3EPacketTeams.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3FPacketCustomPayload.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S40PacketDisconnect.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S41PacketServerDifficulty.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S42PacketCombatEvent.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S43PacketCamera.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S44PacketWorldBorder.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S45PacketTitle.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S46PacketSetCompressionLevel.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S47PacketPlayerListHeaderFooter.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S48PacketResourcePackSend.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S49PacketUpdateEntityNBT.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C00PacketKeepAlive.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C01PacketChatMessage.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C02PacketUseEntity.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C03PacketPlayer.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C03PacketPlayer.C04PacketPlayerPosition.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C03PacketPlayer.C05PacketPlayerLook.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C03PacketPlayer.C06PacketPlayerPosLook.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C07PacketPlayerDigging.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C08PacketPlayerBlockPlacement.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C09PacketHeldItemChange.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C0APacketAnimation.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C0BPacketEntityAction.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C0CPacketInput.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C0DPacketCloseWindow.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C0EPacketClickWindow.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C0FPacketConfirmTransaction.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C10PacketCreativeInventoryAction.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C11PacketEnchantItem.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C12PacketUpdateSign.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C13PacketPlayerAbilities.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C14PacketTabComplete.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C15PacketClientSettings.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C16PacketClientStatus.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C17PacketCustomPayload.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C18PacketSpectate.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C19PacketResourcePackStatus.class);
      }
   };

   private final int id;
   HANDSHAKING(-1) {
      {
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C00Handshake.class);
      }
   };

   private static int field_181136_e = -1;
   private static int field_181137_f = 2;
   private static final Map<Class<? extends Packet>, EnumConnectionState> STATES_BY_CLASS = Maps.newHashMap();
   STATUS(1) {
      {
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C00PacketServerQuery.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S00PacketServerInfo.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C01PacketPing.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S01PacketPong.class);
      }
   };

   private static final EnumConnectionState[] ENUM$VALUES = new EnumConnectionState[]{HANDSHAKING, PLAY, STATUS, LOGIN};
   private final Map<EnumPacketDirection, BiMap<Integer, Class<? extends Packet>>> directionMaps;
   LOGIN(2) {
      {
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S00PacketDisconnect.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S01PacketEncryptionRequest.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S02PacketLoginSuccess.class);
         this.registerPacket(EnumPacketDirection.CLIENTBOUND, S03PacketEnableCompression.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C00PacketLoginStart.class);
         this.registerPacket(EnumPacketDirection.SERVERBOUND, C01PacketEncryptionResponse.class);
      }
   };

   private static final EnumConnectionState[] STATES_BY_ID = new EnumConnectionState[field_181137_f - field_181136_e + 1];

   public static EnumConnectionState getById(int var0) {
      return var0 >= field_181136_e && var0 <= field_181137_f ? STATES_BY_ID[var0 - field_181136_e] : null;
   }

   public Packet getPacket(EnumPacketDirection var1, int var2) throws IllegalAccessException, InstantiationException {
      Class var3 = (Class)((BiMap)this.directionMaps.get(var1)).get(var2);
      return var3 == null ? null : (Packet)var3.newInstance();
   }

   public static EnumConnectionState getFromPacket(Packet var0) {
      return (EnumConnectionState)STATES_BY_CLASS.get(var0.getClass());
   }

   static {
      EnumConnectionState[] var3;
      int var2 = (var3 = values()).length;

      for(int var1 = 0; var1 < var2; ++var1) {
         EnumConnectionState var0 = var3[var1];
         int var4 = var0.getId();
         if (var4 < field_181136_e || var4 > field_181137_f) {
            throw new Error("Invalid protocol ID " + Integer.toString(var4));
         }

         STATES_BY_ID[var4 - field_181136_e] = var0;
         Iterator var6 = var0.directionMaps.keySet().iterator();

         while(var6.hasNext()) {
            EnumPacketDirection var5 = (EnumPacketDirection)var6.next();

            Class var7;
            for(Iterator var8 = ((BiMap)var0.directionMaps.get(var5)).values().iterator(); var8.hasNext(); STATES_BY_CLASS.put(var7, var0)) {
               var7 = (Class)var8.next();
               if (STATES_BY_CLASS.containsKey(var7) && STATES_BY_CLASS.get(var7) != var0) {
                  throw new Error("Packet " + var7 + " is already assigned to protocol " + STATES_BY_CLASS.get(var7) + " - can't reassign to " + var0);
               }

               try {
                  var7.newInstance();
               } catch (Throwable var10) {
                  throw new Error("Packet " + var7 + " fails instantiation checks! " + var7);
               }
            }
         }
      }

   }

   protected EnumConnectionState registerPacket(EnumPacketDirection var1, Class<? extends Packet> var2) {
      Object var3 = (BiMap)this.directionMaps.get(var1);
      if (var3 == null) {
         var3 = HashBiMap.create();
         this.directionMaps.put(var1, var3);
      }

      if (((BiMap)var3).containsValue(var2)) {
         String var4 = var1 + " packet " + var2 + " is already known to ID " + ((BiMap)var3).inverse().get(var2);
         LogManager.getLogger().fatal(var4);
         throw new IllegalArgumentException(var4);
      } else {
         ((BiMap)var3).put(((BiMap)var3).size(), var2);
         return this;
      }
   }

   EnumConnectionState(int var3, EnumConnectionState var4) {
      this(var3);
   }

   public Integer getPacketId(EnumPacketDirection var1, Packet var2) {
      return (Integer)((BiMap)this.directionMaps.get(var1)).inverse().get(var2.getClass());
   }

   public int getId() {
      return this.id;
   }

   private EnumConnectionState(int var3) {
      this.directionMaps = Maps.newEnumMap(EnumPacketDirection.class);
      this.id = var3;
   }
}
