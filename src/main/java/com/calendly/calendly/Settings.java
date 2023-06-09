package com.calendly.calendly;

public class Settings {

    public final static String[] fonts = {};
    public final static String[] styles = {"css/style.css"};
    public final static String[] themes = {"css/dark.css", "css/light.css"};
    public enum theme {
        DARK,
        LIGHT,
    }
    public final static int DEFAULT_WINDOW_HEIGHT = 900;
    public final static int DEFAULT_WINDOW_WIDTH = 1000;
    public final static int MIN_WINDOW_HEIGHT = 700;
    public final static int MIN_WINDOW_WIDTH_LOGIN = 500;
    public final static int MIN_WINDOW_WIDTH_APP = 800;
    public enum roles {
        PROPRIETARIO,
        SEGRETARIO,
        DIPENDENTE_RICEVE_APPUNTAMENTI,
        DIPENDENTE_NON_RICEVE_APPUNTAMENTI
    }
    public final static String INIT_TITLE = "Calendly";

}
