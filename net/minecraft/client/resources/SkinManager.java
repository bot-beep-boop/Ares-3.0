package net.minecraft.client.resources;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.InsecureTextureException;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class SkinManager {
   private final TextureManager textureManager;
   private final File skinCacheDir;
   private static final ExecutorService THREAD_POOL;
   private final MinecraftSessionService sessionService;
   private final LoadingCache<GameProfile, Map<Type, MinecraftProfileTexture>> skinCacheLoader;

   static {
      THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
   }

   static MinecraftSessionService access$0(SkinManager var0) {
      return var0.sessionService;
   }

   public ResourceLocation loadSkin(MinecraftProfileTexture var1, Type var2, SkinManager.SkinAvailableCallback var3) {
      ResourceLocation var4 = new ResourceLocation("skins/" + var1.getHash());
      ITextureObject var5 = this.textureManager.getTexture(var4);
      if (var5 != null) {
         if (var3 != null) {
            var3.skinAvailable(var2, var4, var1);
         }
      } else {
         File var6 = new File(this.skinCacheDir, var1.getHash().length() > 2 ? var1.getHash().substring(0, 2) : "xx");
         File var7 = new File(var6, var1.getHash());
         ImageBufferDownload var8 = var2 == Type.SKIN ? new ImageBufferDownload() : null;
         ThreadDownloadImageData var9 = new ThreadDownloadImageData(var7, var1.getUrl(), DefaultPlayerSkin.getDefaultSkinLegacy(), new IImageBuffer(this, var8, var3, var2, var4, var1) {
            private final Type val$p_152789_2_;
            private final ResourceLocation val$resourcelocation;
            private final SkinManager.SkinAvailableCallback val$skinAvailableCallback;
            private final MinecraftProfileTexture val$profileTexture;
            final SkinManager this$0;
            private final IImageBuffer val$iimagebuffer;

            public void skinAvailable() {
               if (this.val$iimagebuffer != null) {
                  this.val$iimagebuffer.skinAvailable();
               }

               if (this.val$skinAvailableCallback != null) {
                  this.val$skinAvailableCallback.skinAvailable(this.val$p_152789_2_, this.val$resourcelocation, this.val$profileTexture);
               }

            }

            {
               this.this$0 = var1;
               this.val$iimagebuffer = var2;
               this.val$skinAvailableCallback = var3;
               this.val$p_152789_2_ = var4;
               this.val$resourcelocation = var5;
               this.val$profileTexture = var6;
            }

            public BufferedImage parseUserSkin(BufferedImage var1) {
               if (this.val$iimagebuffer != null) {
                  var1 = this.val$iimagebuffer.parseUserSkin(var1);
               }

               return var1;
            }
         });
         this.textureManager.loadTexture(var4, var9);
      }

      return var4;
   }

   public void loadProfileTextures(GameProfile var1, SkinManager.SkinAvailableCallback var2, boolean var3) {
      THREAD_POOL.submit(new Runnable(this, var1, var3, var2) {
         private final GameProfile val$profile;
         private final boolean val$requireSecure;
         final SkinManager this$0;
         private final SkinManager.SkinAvailableCallback val$skinAvailableCallback;

         public void run() {
            HashMap var1 = Maps.newHashMap();

            try {
               var1.putAll(SkinManager.access$0(this.this$0).getTextures(this.val$profile, this.val$requireSecure));
            } catch (InsecureTextureException var3) {
            }

            if (var1.isEmpty() && this.val$profile.getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) {
               this.val$profile.getProperties().clear();
               this.val$profile.getProperties().putAll(Minecraft.getMinecraft().getProfileProperties());
               var1.putAll(SkinManager.access$0(this.this$0).getTextures(this.val$profile, false));
            }

            Minecraft.getMinecraft().addScheduledTask(new Runnable(this, var1, this.val$skinAvailableCallback) {
               private final SkinManager.SkinAvailableCallback val$skinAvailableCallback;
               final <undefinedtype> this$1;
               private final Map val$map;

               public void run() {
                  if (this.val$map.containsKey(Type.SKIN)) {
                     null.access$0(this.this$1).loadSkin((MinecraftProfileTexture)this.val$map.get(Type.SKIN), Type.SKIN, this.val$skinAvailableCallback);
                  }

                  if (this.val$map.containsKey(Type.CAPE)) {
                     null.access$0(this.this$1).loadSkin((MinecraftProfileTexture)this.val$map.get(Type.CAPE), Type.CAPE, this.val$skinAvailableCallback);
                  }

               }

               {
                  this.this$1 = var1;
                  this.val$map = var2;
                  this.val$skinAvailableCallback = var3;
               }
            });
         }

         static SkinManager access$0(Object var0) {
            return var0.this$0;
         }

         {
            this.this$0 = var1;
            this.val$profile = var2;
            this.val$requireSecure = var3;
            this.val$skinAvailableCallback = var4;
         }
      });
   }

   public SkinManager(TextureManager var1, File var2, MinecraftSessionService var3) {
      this.textureManager = var1;
      this.skinCacheDir = var2;
      this.sessionService = var3;
      this.skinCacheLoader = CacheBuilder.newBuilder().expireAfterAccess(15L, TimeUnit.SECONDS).build(new CacheLoader<GameProfile, Map<Type, MinecraftProfileTexture>>(this) {
         final SkinManager this$0;

         public Object load(Object var1) throws Exception {
            return this.load((GameProfile)var1);
         }

         {
            this.this$0 = var1;
         }

         public Map<Type, MinecraftProfileTexture> load(GameProfile var1) throws Exception {
            return Minecraft.getMinecraft().getSessionService().getTextures(var1, false);
         }
      });
   }

   public ResourceLocation loadSkin(MinecraftProfileTexture var1, Type var2) {
      return this.loadSkin(var1, var2, (SkinManager.SkinAvailableCallback)null);
   }

   public Map<Type, MinecraftProfileTexture> loadSkinFromCache(GameProfile var1) {
      return (Map)this.skinCacheLoader.getUnchecked(var1);
   }

   public interface SkinAvailableCallback {
      void skinAvailable(Type var1, ResourceLocation var2, MinecraftProfileTexture var3);
   }
}
