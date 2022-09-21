package com.greencode.sampleapplicationsecond.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class AdditionalData implements Serializable {
    @SerializedName("BulletPoints")
    @Expose
    private ArrayList bulletsList = null;

    @SerializedName("Tags")
    @Expose
    private ArrayList tagList = null;
}
