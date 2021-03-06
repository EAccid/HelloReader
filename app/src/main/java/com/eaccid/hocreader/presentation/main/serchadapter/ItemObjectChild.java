package com.eaccid.hocreader.presentation.main.serchadapter;

import java.io.File;

public class ItemObjectChild implements ItemChild {
    private final int icon;
    private final String name;
    private final File file;

    public ItemObjectChild(int icon, String name, File file) {
        this.icon = icon;
        this.name = name;
        this.file = file;
    }

    @Override
    public int getIcon() {
        return icon;
    }

    @Override
    public String getText() {
        return name;
    }

    @Override
    public File getFile() {
        return file;
    }

}
