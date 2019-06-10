package com.leandro.marvelapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

import java.io.Serializable;

public class MarvelResponse implements Serializable, Parcelable
{

    @Json(name = "code")
    private long code;
    @Json(name = "status")
    private String status;
    @Json(name = "copyright")
    private String copyright;
    @Json(name = "attributionText")
    private String attributionText;
    @Json(name = "attributionHTML")
    private String attributionHTML;
    @Json(name = "etag")
    private String etag;
    @Json(name = "data")
    private Data data;
    public final static Parcelable.Creator<MarvelResponse> CREATOR = new Creator<MarvelResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MarvelResponse createFromParcel(Parcel in) {
            return new MarvelResponse(in);
        }

        public MarvelResponse[] newArray(int size) {
            return (new MarvelResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -1828003551043255827L;

    protected MarvelResponse(Parcel in) {
        this.code = ((long) in.readValue((long.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.copyright = ((String) in.readValue((String.class.getClassLoader())));
        this.attributionText = ((String) in.readValue((String.class.getClassLoader())));
        this.attributionHTML = ((String) in.readValue((String.class.getClassLoader())));
        this.etag = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public MarvelResponse() {
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(code);
        dest.writeValue(status);
        dest.writeValue(copyright);
        dest.writeValue(attributionText);
        dest.writeValue(attributionHTML);
        dest.writeValue(etag);
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }

}