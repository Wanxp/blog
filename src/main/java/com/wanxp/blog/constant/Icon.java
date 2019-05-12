package com.wanxp.blog.constant;

import java.util.Arrays;

public enum Icon {
    BOOK("bg-ico-book"),
    GAME("bg-ico-game"),
    NOTE( "bg-ico-note"),
    CHAT( "bg-ico-chat"),
    CODE( "bg-ico-code"),
    IMAGE( "bg-ico-image"),
    WEB( "bg-ico-web"),
    LINK( "bg-ico-link"),
    DESIGN( "bg-ico-design"),
    LOCK("bg-ico-lock");

    private String iconClassName;

    private Icon(String iconClassName) {
        this.iconClassName = iconClassName;
    }

    public String getIconClassName() {
        return iconClassName;
    }

    public static Icon getICON(String iconClassName) {
        return Arrays.stream(Icon.values()).filter(x ->
            x.name().equals(iconClassName)).findFirst().orElse(BOOK);
    }

}
