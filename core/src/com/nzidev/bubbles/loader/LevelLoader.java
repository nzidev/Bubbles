package com.nzidev.bubbles.loader;

public class LevelLoader {
    public static int selectLvl = 1;
    public static String[] stonesLevel = new String[] {"0","1;0#3","2;2#3;4#4"};
    public static String[] levels = new String[] {"0","1;6;3","2;6;5"};

    public static String[] getStonesLevel() {
        return stonesLevel;
    }

    public static String[] getLevels() {
        return levels;
    }

    public static int getSelectLvl() {
        return selectLvl;
    }

    public static void setSelectLvl(int selectLvl) {
        LevelLoader.selectLvl = selectLvl;
    }
}
