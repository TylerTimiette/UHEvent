package com.timiette.utils;

import sun.security.krb5.internal.tools.Klist;

import javax.print.attribute.standard.MediaSize;
import javax.xml.stream.Location;
import java.util.HashMap;

public class ChestManager {
    public static HashMap<Location, Boolean> list = new HashMap<>();

    public static HashMap get() {
        return list;
    }
}
