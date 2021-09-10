package net.minecraft.client.resources;

import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public class SimpleResource implements IResource {
   private boolean mcmetaJsonChecked;
   private final String resourcePackName;
   private JsonObject mcmetaJson;
   private final InputStream resourceInputStream;
   private final InputStream mcmetaInputStream;
   private final ResourceLocation srResourceLocation;
   private final IMetadataSerializer srMetadataSerializer;
   private final Map<String, IMetadataSection> mapMetadataSections = Maps.newHashMap();

   public <T extends IMetadataSection> T getMetadata(String var1) {
      if (!this.hasMetadata()) {
         return null;
      } else {
         if (this.mcmetaJson == null && !this.mcmetaJsonChecked) {
            this.mcmetaJsonChecked = true;
            BufferedReader var2 = null;

            try {
               var2 = new BufferedReader(new InputStreamReader(this.mcmetaInputStream));
               this.mcmetaJson = (new JsonParser()).parse(var2).getAsJsonObject();
            } finally {
               IOUtils.closeQuietly(var2);
            }
         }

         IMetadataSection var6 = (IMetadataSection)this.mapMetadataSections.get(var1);
         if (var6 == null) {
            var6 = this.srMetadataSerializer.parseMetadataSection(var1, this.mcmetaJson);
         }

         return var6;
      }
   }

   public InputStream getInputStream() {
      return this.resourceInputStream;
   }

   public String getResourcePackName() {
      return this.resourcePackName;
   }

   public ResourceLocation getResourceLocation() {
      return this.srResourceLocation;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SimpleResource)) {
         return false;
      } else {
         SimpleResource var2 = (SimpleResource)var1;
         if (this.srResourceLocation != null) {
            if (!this.srResourceLocation.equals(var2.srResourceLocation)) {
               return false;
            }
         } else if (var2.srResourceLocation != null) {
            return false;
         }

         if (this.resourcePackName != null) {
            if (!this.resourcePackName.equals(var2.resourcePackName)) {
               return false;
            }
         } else if (var2.resourcePackName != null) {
            return false;
         }

         return true;
      }
   }

   public SimpleResource(String var1, ResourceLocation var2, InputStream var3, InputStream var4, IMetadataSerializer var5) {
      this.resourcePackName = var1;
      this.srResourceLocation = var2;
      this.resourceInputStream = var3;
      this.mcmetaInputStream = var4;
      this.srMetadataSerializer = var5;
   }

   public int hashCode() {
      int var1 = this.resourcePackName != null ? this.resourcePackName.hashCode() : 0;
      var1 = 31 * var1 + (this.srResourceLocation != null ? this.srResourceLocation.hashCode() : 0);
      return var1;
   }

   public boolean hasMetadata() {
      return this.mcmetaInputStream != null;
   }
}
