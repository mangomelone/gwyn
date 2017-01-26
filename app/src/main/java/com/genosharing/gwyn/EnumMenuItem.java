package com.genosharing.gwyn;

/**
 * Created by Blackrental on 07.12.2016.
 */

public enum EnumMenuItem {
    ENTDECKEN("Entdecken", 0, new EntdeckenFragment()),
    KATEGORIEN("Kategorien", 1, new KategorienFragment()),
    STATIONS("GWYN-Stations", 2, new StationsFragment()),
    PROFIL("Mein Profil", 3, new ProfileFragment()),
    IMPRESSUM("Impressum", 4, new ImpressumFragment()),
    HILFE("Hilfe", 5, new HilfeFragment());

    private final String bezeichnung;
    private final int code;
    private final MenuItemFragment fragment;
    EnumMenuItem(String bezeichnung, int code, MenuItemFragment fragment) {
        this.bezeichnung = bezeichnung;
        this.code = code;
        this.fragment = fragment;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getCode() {
        return code;
    }

    public MenuItemFragment getFragment()
    {
        return fragment;
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
