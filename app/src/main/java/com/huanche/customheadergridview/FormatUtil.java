package com.huanche.customheadergridview;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by fanzhengchen on 1/3/16.
 */
public class FormatUtil {

    public static int pixOfDip(final int dip) {
        return pixOfDip((float) dip);
    }

    public static int pixOfDip(final float dip) {
        return Math.round(dip * getDisplayMetrics().density);
    }

    public static int pixOfSp(final float sp) {
        return Math.round(sp * getDisplayMetrics().scaledDensity);
    }

    private static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }


}
