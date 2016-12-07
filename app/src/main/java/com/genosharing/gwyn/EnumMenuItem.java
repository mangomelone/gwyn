package com.genosharing.gwyn;

/**
 * Created by Blackrental on 07.12.2016.
 */

public enum EnumMenuItem {
    ENTDECKEN("Entdecken", 0),
    KATEGORIEN("Kategorien", 1),
    PROFIL("Mein Profil", 2),
    IMPRESSUM("Impressum", 3),
    HILFE("Hilfe", 4);

    private final String bezeichnung;
    private final int code;
    EnumMenuItem(String bezeichnung, int code) {
        this.bezeichnung = bezeichnung;
        this.code = code;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getCode() {
        return code;
    }

    public static EnumMenuItem getItemByPosition(int position)
    {
        EnumMenuItem result = null;
        for (EnumMenuItem item: EnumMenuItem.values())
        {
            if (item.getCode() == position) {
                result = item;
                break;
            }
        }
        return result;
    }
}
