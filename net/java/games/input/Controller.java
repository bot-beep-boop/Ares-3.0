package net.java.games.input;

public interface Controller {
   void setEventQueueSize(int var1);

   Component[] getComponents();

   Controller[] getControllers();

   Component getComponent(Component.Identifier var1);

   EventQueue getEventQueue();

   String getName();

   Rumbler[] getRumblers();

   Controller.Type getType();

   boolean poll();

   Controller.PortType getPortType();

   int getPortNumber();

   public static class Type {
      public static final Controller.Type RUDDER = new Controller.Type("Rudder");
      private final String name;
      public static final Controller.Type HEADTRACKER = new Controller.Type("Headtracker");
      public static final Controller.Type FINGERSTICK = new Controller.Type("Fingerstick");
      public static final Controller.Type STICK = new Controller.Type("Stick");
      public static final Controller.Type MOUSE = new Controller.Type("Mouse");
      public static final Controller.Type KEYBOARD = new Controller.Type("Keyboard");
      public static final Controller.Type WHEEL = new Controller.Type("Wheel");
      public static final Controller.Type TRACKBALL = new Controller.Type("Trackball");
      public static final Controller.Type TRACKPAD = new Controller.Type("Trackpad");
      public static final Controller.Type GAMEPAD = new Controller.Type("Gamepad");
      public static final Controller.Type UNKNOWN = new Controller.Type("Unknown");

      public String toString() {
         return this.name;
      }

      protected Type(String var1) {
         this.name = var1;
      }
   }

   public static final class PortType {
      public static final Controller.PortType PARALLEL = new Controller.PortType("Parallel port");
      public static final Controller.PortType GAME = new Controller.PortType("Game port");
      public static final Controller.PortType I8042 = new Controller.PortType("i8042 (PS/2)");
      public static final Controller.PortType UNKNOWN = new Controller.PortType("Unknown");
      private final String name;
      public static final Controller.PortType USB = new Controller.PortType("USB port");
      public static final Controller.PortType SERIAL = new Controller.PortType("Serial port");
      public static final Controller.PortType NETWORK = new Controller.PortType("Network port");

      public String toString() {
         return this.name;
      }

      protected PortType(String var1) {
         this.name = var1;
      }
   }
}
