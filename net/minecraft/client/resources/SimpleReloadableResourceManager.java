package net.minecraft.client.resources;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleReloadableResourceManager implements IReloadableResourceManager {
   private static final Joiner joinerResourcePacks = Joiner.on(", ");
   private final IMetadataSerializer rmMetadataSerializer;
   private final Set<String> setResourceDomains = Sets.newLinkedHashSet();
   private final Map<String, FallbackResourceManager> domainResourceManagers = Maps.newHashMap();
   private final List<IResourceManagerReloadListener> reloadListeners = Lists.newArrayList();
   private static final Logger logger = LogManager.getLogger();

   public void reloadResourcePack(IResourcePack var1) {
      FallbackResourceManager var4;
      for(Iterator var3 = var1.getResourceDomains().iterator(); var3.hasNext(); var4.addResourcePack(var1)) {
         String var2 = (String)var3.next();
         this.setResourceDomains.add(var2);
         var4 = (FallbackResourceManager)this.domainResourceManagers.get(var2);
         if (var4 == null) {
            var4 = new FallbackResourceManager(this.rmMetadataSerializer);
            this.domainResourceManagers.put(var2, var4);
         }
      }

   }

   public List<IResource> getAllResources(ResourceLocation var1) throws IOException {
      IResourceManager var2 = (IResourceManager)this.domainResourceManagers.get(var1.getResourceDomain());
      if (var2 != null) {
         return var2.getAllResources(var1);
      } else {
         throw new FileNotFoundException(var1.toString());
      }
   }

   public SimpleReloadableResourceManager(IMetadataSerializer var1) {
      this.rmMetadataSerializer = var1;
   }

   public void registerReloadListener(IResourceManagerReloadListener var1) {
      this.reloadListeners.add(var1);
      var1.onResourceManagerReload(this);
   }

   public void reloadResources(List<IResourcePack> var1) {
      this.clearResources();
      logger.info("Reloading ResourceManager: " + joinerResourcePacks.join(Iterables.transform(var1, new Function<IResourcePack, String>(this) {
         final SimpleReloadableResourceManager this$0;

         public String apply(IResourcePack var1) {
            return var1.getPackName();
         }

         {
            this.this$0 = var1;
         }

         public Object apply(Object var1) {
            return this.apply((IResourcePack)var1);
         }
      })));
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         IResourcePack var2 = (IResourcePack)var3.next();
         this.reloadResourcePack(var2);
      }

      this.notifyReloadListeners();
   }

   private void notifyReloadListeners() {
      Iterator var2 = this.reloadListeners.iterator();

      while(var2.hasNext()) {
         IResourceManagerReloadListener var1 = (IResourceManagerReloadListener)var2.next();
         var1.onResourceManagerReload(this);
      }

   }

   public Set<String> getResourceDomains() {
      return this.setResourceDomains;
   }

   public IResource getResource(ResourceLocation var1) throws IOException {
      IResourceManager var2 = (IResourceManager)this.domainResourceManagers.get(var1.getResourceDomain());
      if (var2 != null) {
         return var2.getResource(var1);
      } else {
         throw new FileNotFoundException(var1.toString());
      }
   }

   private void clearResources() {
      this.domainResourceManagers.clear();
      this.setResourceDomains.clear();
   }
}
