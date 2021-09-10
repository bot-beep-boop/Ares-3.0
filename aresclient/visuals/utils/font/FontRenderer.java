package com.aresclient.visuals.utils.font;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public final class FontRenderer extends Font {
   protected final Font.CharData[] boldItalicChars = new Font.CharData[256];
   private byte[] glyphWidth = new byte[65536];
   protected DynamicTexture texBold;
   protected final Font.CharData[] italicChars = new Font.CharData[256];
   private boolean unicodeFlag;
   protected final Font.CharData[] boldChars = new Font.CharData[256];
   protected DynamicTexture texItalic;
   private char COLOR_CODE_START = 167;
   private final int[] colorCode = new int[32];
   private float[] charWidthFloat = new float[256];
   protected DynamicTexture texItalicBold;

   private void drawLine(double var1, double var3, double var5, double var7, float var9) {
      GL11.glDisable(3553);
      GL11.glLineWidth(var9);
      GL11.glBegin(1);
      GL11.glVertex2d(var1, var3);
      GL11.glVertex2d(var5, var7);
      GL11.glEnd();
      GL11.glEnable(3553);
   }

   public float drawStringWithShadow(String var1, double var2, double var4, int var6, int var7) {
      float var8 = this.drawString(var1, var2 + 1.0D, var4 + 1.0D, var7, false);
      return Math.max(var8, this.drawString(var1, var2, var4, var6, false));
   }

   public String trimStringToWidth(String var1, int var2, boolean var3) {
      StringBuilder var4 = new StringBuilder();
      float var5 = 0.0F;
      int var6 = var3 ? var1.length() - 1 : 0;
      int var7 = var3 ? -1 : 1;
      boolean var8 = false;
      boolean var9 = false;

      for(int var10 = var6; var10 >= 0 && var10 < var1.length() && var5 < (float)var2; var10 += var7) {
         char var11 = var1.charAt(var10);
         float var12 = this.getCharWidthFloat(var11);
         if (var8) {
            var8 = false;
            if (var11 != 'l' && var11 != 'L') {
               if (var11 == 'r' || var11 == 'R') {
                  var9 = false;
               }
            } else {
               var9 = true;
            }
         } else if (var12 < 0.0F) {
            var8 = true;
         } else {
            var5 += var12;
            if (var9) {
               ++var5;
            }
         }

         if (var5 > (float)var2) {
            break;
         }

         if (var3) {
            var4.insert(0, var11);
         } else {
            var4.append(var11);
         }
      }

      return var4.toString();
   }

   public void setFractionalMetrics(boolean var1) {
      super.setFractionalMetrics(var1);
      this.setupBoldItalicIDs();
   }

   public int getCharWidth(char var1) {
      return Math.round(this.getCharWidthFloat(var1));
   }

   public float drawString(String var1, float var2, float var3, int var4) {
      return this.drawString(var1, (double)var2, (double)var3, var4, false);
   }

   public FontRenderer(ResourceLocation var1, float var2) {
      super(var1, var2);
      this.setupMinecraftColorCodes();
      this.setupBoldItalicIDs();
   }

   private void setupBoldItalicIDs() {
      this.texBold = this.setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
      this.texItalic = this.setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
      this.texItalicBold = this.setupTexture(this.font.deriveFont(3), this.antiAlias, this.fractionalMetrics, this.boldItalicChars);
   }

   public List<String> formatString(String var1, double var2) {
      ArrayList var4 = new ArrayList();
      String var5 = "";
      char var6 = '\uffff';
      char[] var7 = var1.toCharArray();

      for(int var8 = 0; var8 < var7.length; ++var8) {
         char var9 = var7[var8];
         if (var9 == this.COLOR_CODE_START && var8 < var7.length - 1) {
            var6 = var7[var8 + 1];
         }

         if ((double)this.getStringWidth(var5 + var9) < var2) {
            var5 = var5 + var9;
         } else {
            var4.add(var5);
            var5 = this.COLOR_CODE_START + var6 + String.valueOf(var9);
         }
      }

      if (var5.length() > 0) {
         var4.add(var5);
      }

      return var4;
   }

   public float drawCenteredStringWithShadow(String var1, float var2, float var3, int var4) {
      this.drawString(var1, (double)(var2 - (float)(this.getStringWidth(var1) / 2)) + 0.55D, (double)(var3 - (float)(this.getHeight() / 2)) + 0.55D, var4, true);
      return this.drawString(var1, var2 - (float)(this.getStringWidth(var1) / 2), var3 - (float)(this.getHeight() / 2), var4);
   }

   public float drawString(String var1, double var2, double var4, int var6, boolean var7) {
      --var2;
      var4 -= 0.5D;
      if (var1 == null) {
         return 0.0F;
      } else {
         if (var6 == 553648127) {
            var6 = 16777215;
         }

         if ((var6 & -67108864) == 0) {
            var6 |= -16777216;
         }

         if (var7) {
            var6 = (var6 & 16579836) >> 2 | var6 & -16777216;
         }

         Font.CharData[] var8 = this.charData;
         float var9 = (float)(var6 >> 24 & 255) / 255.0F;
         boolean var10 = false;
         boolean var11 = false;
         boolean var12 = false;
         boolean var13 = false;
         boolean var14 = true;
         var2 *= 2.0D;
         var4 = (var4 - 5.0D) * 2.0D;
         if (var14) {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glScaled(0.5D, 0.5D, 0.5D);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f((float)(var6 >> 16 & 255) / 255.0F, (float)(var6 >> 8 & 255) / 255.0F, (float)(var6 & 255) / 255.0F, var9);
            int var15 = var1.length();
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, this.tex.getGlTextureId());

            for(int var16 = 0; var16 < var15; ++var16) {
               char var17 = var1.charAt(var16);
               if (var17 == this.COLOR_CODE_START && var16 < var15) {
                  int var18 = 21;

                  try {
                     var18 = "0123456789abcdefklmnor".indexOf(var1.charAt(var16 + 1));
                  } catch (Exception var20) {
                     var20.printStackTrace();
                  }

                  if (var18 < 16) {
                     var10 = false;
                     var11 = false;
                     var13 = false;
                     var12 = false;
                     GL11.glBindTexture(3553, this.tex.getGlTextureId());
                     var8 = this.charData;
                     if (var18 < 0 || var18 > 15) {
                        var18 = 15;
                     }

                     if (var7) {
                        var18 += 16;
                     }

                     int var19 = this.colorCode[var18];
                     GL11.glColor4f((float)(var19 >> 16 & 255) / 255.0F, (float)(var19 >> 8 & 255) / 255.0F, (float)(var19 & 255) / 255.0F, var9);
                  } else if (var18 != 16) {
                     if (var18 == 17) {
                        var10 = true;
                        if (var11) {
                           GL11.glBindTexture(3553, this.texItalicBold.getGlTextureId());
                           var8 = this.boldItalicChars;
                        } else {
                           GL11.glBindTexture(3553, this.texBold.getGlTextureId());
                           var8 = this.boldChars;
                        }
                     } else if (var18 == 18) {
                        var12 = true;
                     } else if (var18 == 19) {
                        var13 = true;
                     } else if (var18 == 20) {
                        var11 = true;
                        if (var10) {
                           GL11.glBindTexture(3553, this.texItalicBold.getGlTextureId());
                           var8 = this.boldItalicChars;
                        } else {
                           GL11.glBindTexture(3553, this.texItalic.getGlTextureId());
                           var8 = this.italicChars;
                        }
                     } else if (var18 == 21) {
                        var10 = false;
                        var11 = false;
                        var13 = false;
                        var12 = false;
                        GL11.glColor4f((float)(var6 >> 16 & 255) / 255.0F, (float)(var6 >> 8 & 255) / 255.0F, (float)(var6 & 255) / 255.0F, var9);
                        GL11.glBindTexture(3553, this.tex.getGlTextureId());
                        var8 = this.charData;
                     }
                  }

                  ++var16;
               } else if (var17 < var8.length && var17 >= 0) {
                  GL11.glBegin(4);
                  this.drawChar(var8, var17, (float)var2, (float)var4 + 6.0F);
                  GL11.glEnd();
                  if (var12) {
                     this.drawLine(var2, var4 + (double)(var8[var17].height / 2), var2 + (double)var8[var17].width - 8.0D, var4 + (double)(var8[var17].height / 2), 1.0F);
                  }

                  if (var13) {
                     this.drawLine(var2, var4 + (double)var8[var17].height - 2.0D, var2 + (double)var8[var17].width - 8.0D, var4 + (double)var8[var17].height - 2.0D, 1.0F);
                  }

                  var2 += (double)(var8[var17].width - 8 + this.charOffset);
               }
            }
         }

         GL11.glDisable(3042);
         GL11.glHint(3155, 4352);
         GL11.glPopMatrix();
         return (float)var2 / 2.0F;
      }
   }

   private float getCharWidthFloat(char var1) {
      if (var1 == 167) {
         return -1.0F;
      } else if (var1 != ' ' && var1 != 160) {
         int var2 = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000".indexOf(var1);
         if (var1 > 0 && var2 != -1 && !this.unicodeFlag) {
            return this.charWidthFloat[var2];
         } else if (this.glyphWidth[var1] != 0) {
            int var3 = this.glyphWidth[var1] >>> 4;
            int var4 = this.glyphWidth[var1] & 15;
            if (var4 > 7) {
               var4 = 15;
               var3 = 0;
            }

            ++var4;
            return (float)((var4 - var3) / 2 + 1);
         } else {
            return 0.0F;
         }
      } else {
         return this.charWidthFloat[32];
      }
   }

   public float drawCenteredString(String var1, float var2, float var3, int var4) {
      return this.drawString(var1, var2 - (float)(this.getStringWidth(var1) / 2), var3 - (float)(this.getHeight() / 2), var4);
   }

   public List<String> wrapWords(String var1, double var2) {
      ArrayList var4 = new ArrayList();
      if ((double)this.getStringWidth(var1) > var2) {
         String[] var5 = var1.split(" ");
         String var6 = "";
         char var7 = '\uffff';
         String[] var11 = var5;
         int var10 = var5.length;

         String var8;
         for(int var9 = 0; var9 < var10; ++var9) {
            var8 = var11[var9];

            for(int var12 = 0; var12 < var8.toCharArray().length; ++var12) {
               char var13 = var8.toCharArray()[var12];
               if (var13 == this.COLOR_CODE_START && var12 < var8.toCharArray().length - 1) {
                  var7 = var8.toCharArray()[var12 + 1];
               }
            }

            if ((double)this.getStringWidth(var6 + var8 + " ") < var2) {
               var6 = var6 + var8 + " ";
            } else {
               var4.add(var6);
               var6 = this.COLOR_CODE_START + var7 + var8 + " ";
            }
         }

         if (var6.length() > 0) {
            if ((double)this.getStringWidth(var6) < var2) {
               var4.add(this.COLOR_CODE_START + var7 + var6 + " ");
               var6 = "";
            } else {
               Iterator var14 = this.formatString(var6, var2).iterator();

               while(var14.hasNext()) {
                  var8 = (String)var14.next();
                  var4.add(var8);
               }
            }
         }
      } else {
         var4.add(var1);
      }

      return var4;
   }

   public String trimStringToWidth(String var1, int var2) {
      return this.trimStringToWidth(var1, var2, false);
   }

   public int getStringWidth(String var1) {
      if (var1 == null) {
         return 0;
      } else {
         int var2 = 0;
         Font.CharData[] var3 = this.charData;
         boolean var4 = false;
         boolean var5 = false;
         int var6 = var1.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var1.charAt(var7);
            if (var8 == this.COLOR_CODE_START && var7 < var6) {
               int var9 = "0123456789abcdefklmnor".indexOf(var8);
               if (var9 < 16) {
                  var4 = false;
                  var5 = false;
               } else if (var9 == 17) {
                  var4 = true;
                  if (var5) {
                     var3 = this.boldItalicChars;
                  } else {
                     var3 = this.boldChars;
                  }
               } else if (var9 == 20) {
                  var5 = true;
                  if (var4) {
                     var3 = this.boldItalicChars;
                  } else {
                     var3 = this.italicChars;
                  }
               } else if (var9 == 21) {
                  var4 = false;
                  var5 = false;
                  var3 = this.charData;
               }

               ++var7;
            } else if (var8 < var3.length && var8 >= 0) {
               var2 += var3[var8].width - 8 + this.charOffset;
            }
         }

         return var2 / 2;
      }
   }

   public void setAntiAlias(boolean var1) {
      super.setAntiAlias(var1);
      this.setupBoldItalicIDs();
   }

   private void setupMinecraftColorCodes() {
      for(int var1 = 0; var1 < 32; ++var1) {
         int var2 = (var1 >> 3 & 1) * 85;
         int var3 = (var1 >> 2 & 1) * 170 + var2;
         int var4 = (var1 >> 1 & 1) * 170 + var2;
         int var5 = (var1 & 1) * 170 + var2;
         if (var1 == 6) {
            var3 += 85;
         }

         if (var1 >= 16) {
            var3 /= 4;
            var4 /= 4;
            var5 /= 4;
         }

         this.colorCode[var1] = (var3 & 255) << 16 | (var4 & 255) << 8 | var5 & 255;
      }

   }

   public float drawStringWithShadow(String var1, double var2, double var4, int var6) {
      float var7 = this.drawString(var1, var2 + 1.0D, var4 + 1.0D, var6, true);
      return Math.max(var7, this.drawString(var1, var2, var4, var6, false));
   }
}
