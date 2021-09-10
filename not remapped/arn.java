public class arn {
   public static final arn t = new arn(18, 15066419);
   public static final arn i = new arn(7, 31744);
   public static final arn z = new arn(24, 8339378);
   public static final arn b = new arn(0, 0);
   public static final arn k = new arn(9, 10791096);
   public static final arn I = new arn(33, 55610);
   public static final arn y = new arn(23, 5013401);
   public static final arn s = new arn(17, 6724056);
   public static final arn d = new arn(2, 16247203);
   public final int L;
   public static final arn q = new arn(15, 14188339);
   public static final arn g = new arn(5, 10526975);
   public static final arn r = new arn(16, 11685080);
   public static final arn E = new arn(29, 1644825);
   public static final arn f = new arn(4, 16711680);
   public static final arn J = new arn(34, 8476209);
   public static final arn F = new arn(30, 16445005);
   public static final arn n = new arn(12, 4210943);
   public final int M;
   public static final arn p = new arn(14, 16776437);
   public static final arn A = new arn(25, 3361970);
   public static final arn m = new arn(11, 7368816);
   public static final arn o = new arn(13, 9402184);
   public static final arn v = new arn(20, 15892389);
   public static final arn c = new arn(1, 8368696);
   public static final arn K = new arn(35, 7340544);
   public static final arn B = new arn(26, 6704179);
   public static final arn j = new arn(8, 16777215);
   public static final arn C = new arn(27, 6717235);
   public static final arn h = new arn(6, 10987431);
   public static final arn H = new arn(32, 4882687);
   public static final arn u = new arn(19, 8375321);
   public static final arn G = new arn(31, 6085589);
   public static final arn x = new arn(22, 10066329);
   public static final arn D = new arn(28, 10040115);
   public static final arn[] a = new arn[64];
   public static final arn e = new arn(3, 13092807);
   public static final arn l = new arn(10, 9923917);
   public static final arn w = new arn(21, 5000268);

   private arn(int var1, int var2) {
      if (var1 >= 0 && var1 <= 63) {
         this.M = var1;
         this.L = var2;
         a[var1] = this;
      } else {
         throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
      }
   }

   public int a(int var1) {
      short var2 = 220;
      if (var1 == 3) {
         var2 = 135;
      }

      if (var1 == 2) {
         var2 = 255;
      }

      if (var1 == 1) {
         var2 = 220;
      }

      if (var1 == 0) {
         var2 = 180;
      }

      int var3 = (this.L >> 16 & 255) * var2 / 255;
      int var4 = (this.L >> 8 & 255) * var2 / 255;
      int var5 = (this.L & 255) * var2 / 255;
      return -16777216 | var3 << 16 | var4 << 8 | var5;
   }
}
