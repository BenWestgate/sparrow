package com.sparrowwallet.sparrow;

public enum Interface {
    DESKTOP, TERMINAL, SERVER;

    private static Interface currentInterface;

    public static Interface get() {
        if(currentInterface == null) {
            if(java.awt.GraphicsEnvironment.isHeadless()) {
                if("Monocle".equalsIgnoreCase(System.getProperty("glass.platform"))) {
                    currentInterface = TERMINAL;
                } else {
                    throw new UnsupportedOperationException("Headless environment detected but Monocle platform not found");
                }
            } else {
                currentInterface = DESKTOP;
            }
        }

        return currentInterface;
    }

    public static void set(Interface interf) {
        if(currentInterface != null && interf != currentInterface) {
            throw new IllegalStateException("Interface already set to " + currentInterface);
        }

        currentInterface = interf;
    }
}