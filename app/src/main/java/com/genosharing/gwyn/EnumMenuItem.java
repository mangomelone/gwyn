package com.genosharing.gwyn;

/**
 * Created by Blackrental on 07.12.2016.
 */

public enum EnumMenuItem {
    ENTDECKEN("Entdecken", 0, true),
    KATEGORIEN("Kategorien", 1, true),
    STATIONS("GWYN-Stations", 2, true),
    PROFIL("Mein Profil", 3, true),
    IMPRESSUM("Impressum", 4, true),
    HILFE("Hilfe", 5, true),
    ERGEBNISSE("Suchergebnisse", 6, false),
    DETAIL("Detailansicht", 7, false);

    private final String bezeichnung;
    private final int code;
    private final boolean visible;
    EnumMenuItem(String bezeichnung, int code, boolean visible) {
        this.bezeichnung = bezeichnung;
        this.code = code;
        this.visible = visible;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getCode() {
        return code;
    }

    public boolean isVisible()
    {
        return visible;
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
