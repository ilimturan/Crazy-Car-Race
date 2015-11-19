package com.zargidi.screen;

/**
 * Created by ilimturan on 18/01/15.
 */
public class ScreenManager {

    private static Screen currentScreen;

    public static void setCurrentScreen(Screen screen){
        if(currentScreen != null){
            currentScreen.dispose();
        }
        currentScreen = screen;
        currentScreen.create();
    }

    public static Screen getCurrentScreen(){
        return currentScreen;
    }

    public static void clearScreen(){
        currentScreen = null;
    }

}
