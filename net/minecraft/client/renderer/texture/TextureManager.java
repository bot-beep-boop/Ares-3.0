package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.src.Config;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.optifine.CustomGuis;
import net.optifine.EmissiveTextures;
import net.optifine.RandomEntities;
import net.optifine.shaders.ShadersTex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextureManager implements IResourceManagerReloadListener, ITickable {
   private final List<ITickable> listTickables = Lists.newArrayList();
   private static final Logger logger = LogManager.getLogger();
   public final Map<ResourceLocation, ITextureObject> mapTextureObjects = Maps.newHashMap();
   private IResourceManager theResourceManager;
   private final Map<String, Integer> mapTextureCounters = Maps.newHashMap();

   public boolean loadTickableTexture(ResourceLocation var1, ITickableTextureObject var2) {
      if (this.loadTexture(var1, var2)) {
         this.listTickables.add(var2);
         return true;
      } else {
         return false;
      }
   }

   public ITextureObject getTexture(ResourceLocation var1) {
      return (ITextureObject)this.mapTextureObjects.get(var1);
   }

   public void deleteTexture(ResourceLocation var1) {
      ITextureObject var2 = this.getTexture(var1);
      if (var2 != null) {
         this.mapTextureObjects.remove(var1);
         TextureUtil.deleteTexture(var2.getGlTextureId());
      }

   }

   public ResourceLocation getDynamicTextureLocation(String var1, DynamicTexture var2) {
      if (var1.equals("logo")) {
         var2 = Config.getMojangLogoTexture(var2);
      }

      Integer var3 = (Integer)this.mapTextureCounters.get(var1);
      if (var3 == null) {
         var3 = 1;
      } else {
         var3 = var3 + 1;
      }

      this.mapTextureCounters.put(var1, var3);
      ResourceLocation var4 = new ResourceLocation(String.format("dynamic/%s_%d", var1, var3));
      this.loadTexture(var4, var2);
      return var4;
   }

   public void reloadBannerTextures() {
      Iterator var2 = (new HashSet(this.mapTextureObjects.entrySet())).iterator();

      while(var2.hasNext()) {
         Entry var1 = (Entry)var2.next();
         ResourceLocation var3 = (ResourceLocation)var1.getKey();
         ITextureObject var4 = (ITextureObject)var1.getValue();
         if (var4 instanceof LayeredColorMaskTexture) {
            this.loadTexture(var3, var4);
         }
      }

   }

   public void bindTexture(ResourceLocation var1) {
      if (Config.isRandomEntities()) {
         var1 = RandomEntities.getTextureLocation(var1);
      }

      if (Config.isCustomGuis()) {
         var1 = CustomGuis.getTextureLocation(var1);
      }

      Object var2 = (ITextureObject)this.mapTextureObjects.get(var1);
      if (EmissiveTextures.isActive()) {
         var2 = EmissiveTextures.getEmissiveTexture((ITextureObject)var2, this.mapTextureObjects);
      }

      if (var2 == null) {
         var2 = new SimpleTexture(var1);
         this.loadTexture(var1, (ITextureObject)var2);
      }

      if (Config.isShaders()) {
         ShadersTex.bindTexture((ITextureObject)var2);
      } else {
         TextureUtil.bindTexture(((ITextureObject)var2).getGlTextureId());
      }

   }

   public void tick() {
      Iterator var2 = this.listTickables.iterator();

      while(var2.hasNext()) {
         ITickable var1 = (ITickable)var2.next();
         var1.tick();
      }

   }

   public void onResourceManagerReload(IResourceManager var1) {
      Config.dbg("*** Reloading textures ***");
      Config.log("Resource packs: " + Config.getResourcePackNames());
      Iterator var2 = this.mapTextureObjects.keySet().iterator();

      while(true) {
         ResourceLocation var3;
         String var4;
         do {
            if (!var2.hasNext()) {
               EmissiveTextures.update();
               Iterator var8 = (new HashSet(this.mapTextureObjects.entrySet())).iterator();

               while(var8.hasNext()) {
                  Entry var7 = (Entry)var8.next();
                  this.loadTexture((ResourceLocation)var7.getKey(), (ITextureObject)var7.getValue());
               }

               return;
            }

            var3 = (ResourceLocation)var2.next();
            var4 = var3.getResourcePath();
         } while(!var4.startsWith("mcpatcher/") && !var4.startsWith("optifine/") && !EmissiveTextures.isEmissive(var3));

         ITextureObject var5 = (ITextureObject)this.mapTextureObjects.get(var3);
         if (var5 instanceof AbstractTexture) {
            AbstractTexture var6 = (AbstractTexture)var5;
            var6.deleteGlTexture();
         }

         var2.remove();
      }
   }

   public boolean loadTexture(ResourceLocation var1, ITextureObject var2) {
      boolean var3 = true;

      try {
         ((ITextureObject)var2).loadTexture(this.theResourceManager);
      } catch (IOException var7) {
         logger.warn("Failed to load texture: " + var1, var7);
         var2 = TextureUtil.missingTexture;
         this.mapTextureObjects.put(var1, var2);
         var3 = false;
      } catch (Throwable var8) {
         CrashReport var5 = CrashReport.makeCrashReport(var8, "Registering texture");
         CrashReportCategory var6 = var5.makeCategory("Resource location being registered");
         var6.addCrashSection("Resource location", var1);
         throw new ReportedException(var5);
      }

      this.mapTextureObjects.put(var1, var2);
      return var3;
   }

   public TextureManager(IResourceManager var1) {
      this.theResourceManager = var1;
   }
}
