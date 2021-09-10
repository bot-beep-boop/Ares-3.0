package net.java.games.input;

import java.io.IOException;

class OSXComponent extends AbstractComponent {
   private final OSXHIDElement element;

   public OSXComponent(Component.Identifier var1, OSXHIDElement var2) {
      super(var1.getName(), var1);
      this.element = var2;
   }

   public final OSXHIDElement getElement() {
      return this.element;
   }

   protected float poll() throws IOException {
      return OSXControllers.poll(this.element);
   }

   public final boolean isRelative() {
      return this.element.isRelative();
   }

   public boolean isAnalog() {
      return this.element.isAnalog();
   }
}
