package net.minecraft.client.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.util.StringTranslate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanguageManager implements IResourceManagerReloadListener {
   private static final Logger logger = LogManager.getLogger();
   protected static final Locale currentLocale = new Locale();
   private final IMetadataSerializer theMetadataSerializer;
   private Map<String, Language> languageMap = Maps.newHashMap();
   private String currentLanguage;

   public void parseLanguageMetadata(List<IResourcePack> var1) {
      this.languageMap.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         IResourcePack var2 = (IResourcePack)var3.next();

         try {
            LanguageMetadataSection var4 = (LanguageMetadataSection)var2.getPackMetadata(this.theMetadataSerializer, "language");
            if (var4 != null) {
               Iterator var6 = var4.getLanguages().iterator();

               while(var6.hasNext()) {
                  Language var5 = (Language)var6.next();
                  if (!this.languageMap.containsKey(var5.getLanguageCode())) {
                     this.languageMap.put(var5.getLanguageCode(), var5);
                  }
               }
            }
         } catch (RuntimeException var7) {
            logger.warn("Unable to parse metadata section of resourcepack: " + var2.getPackName(), var7);
         } catch (IOException var8) {
            logger.warn("Unable to parse metadata section of resourcepack: " + var2.getPackName(), var8);
         }
      }

   }

   public SortedSet<Language> getLanguages() {
      return Sets.newTreeSet(this.languageMap.values());
   }

   public void onResourceManagerReload(IResourceManager var1) {
      ArrayList var2 = Lists.newArrayList(new String[]{"en_US"});
      if (!"en_US".equals(this.currentLanguage)) {
         var2.add(this.currentLanguage);
      }

      currentLocale.loadLocaleDataFiles(var1, var2);
      StringTranslate.replaceWith(currentLocale.properties);
   }

   public Language getCurrentLanguage() {
      return this.languageMap.containsKey(this.currentLanguage) ? (Language)this.languageMap.get(this.currentLanguage) : (Language)this.languageMap.get("en_US");
   }

   public LanguageManager(IMetadataSerializer var1, String var2) {
      this.theMetadataSerializer = var1;
      this.currentLanguage = var2;
      I18n.setLocale(currentLocale);
   }

   public boolean isCurrentLocaleUnicode() {
      return currentLocale.isUnicode();
   }

   public void setCurrentLanguage(Language var1) {
      this.currentLanguage = var1.getLanguageCode();
   }

   public boolean isCurrentLanguageBidirectional() {
      return this.getCurrentLanguage() != null && this.getCurrentLanguage().isBidirectional();
   }
}
