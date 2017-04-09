package com.example.nil_akash.apptest.modelclass;

/**
 * Created by NiL-AkAsH on 4/9/2017.
 */

public class MedicineInformation {
    private long precsiptionId;

    public long getPrecsiptionId() {
        return precsiptionId;
    }

    public void setPrecsiptionId(long precsiptionId) {
        this.precsiptionId = precsiptionId;
    }

    private long doctorID;
    private String precsiptionDetails;
    private String precsiptionDate;
    private byte[] precsiptionImage;

    public MedicineInformation() {
    }

    public MedicineInformation(long doctorID, String precsiptionDetails, String precsiptionDate, byte[] precsiptionImage) {
        this.doctorID = doctorID;
        this.precsiptionDetails = precsiptionDetails;
        this.precsiptionDate = precsiptionDate;
        this.precsiptionImage = precsiptionImage;
    }

    public MedicineInformation(String precsiptionDetails, String precsiptionDate, byte[] precsiptionImage) {
        this.precsiptionDetails = precsiptionDetails;
        this.precsiptionDate = precsiptionDate;
        this.precsiptionImage = precsiptionImage;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public String getPrecsiptionDetails() {
        return precsiptionDetails;
    }

    public void setPrecsiptionDetails(String precsiptionDetails) {
        this.precsiptionDetails = precsiptionDetails;
    }

    public String getPrecsiptionDate() {
        return precsiptionDate;
    }

    public void setPrecsiptionDate(String precsiptionDate) {
        this.precsiptionDate = precsiptionDate;
    }

    public byte[] getPrecsiptionImage() {
        return precsiptionImage;
    }

    public void setPrecsiptionImage(byte[] precsiptionImage) {
        this.precsiptionImage = precsiptionImage;
    }
}
