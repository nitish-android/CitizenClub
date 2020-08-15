package com.tanzible.sampleproject;

import android.os.Environment;

public class CheckForSDcard  {
    public boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

}
