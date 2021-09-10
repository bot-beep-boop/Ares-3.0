public abstract class no<T> {
   private boolean b = false;
   private T a;

   public T c() {
      if (!this.b) {
         this.b = true;
         this.a = this.b();
      }

      return this.a;
   }

   protected abstract T b();
}
