package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceId=NO_IMAGE;

    public static final int NO_IMAGE=-1;

    private int audioId;

    public Word(String defaultTranslation,String miwokTranslation,int audioID){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        audioId=audioID;
    }

    public Word(String defaultTranslation,String miwokTranslation,int imageResourceId,int audioID){
        mImageResourceId=imageResourceId;
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        audioId=audioID;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId!=NO_IMAGE;
    }

    public int getAudioId(){
        return  audioId;
    }
}
