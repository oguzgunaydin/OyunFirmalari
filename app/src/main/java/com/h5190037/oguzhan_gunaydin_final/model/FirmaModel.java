package com.h5190037.oguzhan_gunaydin_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FirmaModel {

    @SerializedName("CompanyName")
    @Expose
    private String companyName;
    @SerializedName("ReleaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Ceo")
    @Expose
    private String ceo;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("HeaderUrl")
    @Expose
    private String headerUrl;
    @SerializedName("Description")
    @Expose
    private String description;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}