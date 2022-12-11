package com.gvidia.gvidia.business.enterprise.location;
/**
 *
 * @author kaustubh, mitesh
 */
public class Address {

    private double mLongitude;
    private double mLatitude;

    public Address(double mLongitude, double mLatitude) {
        this.mLongitude = mLongitude;
        this.mLatitude = mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }


    public String toString() {
        return "[" + mLatitude + "," + mLongitude + "]";
    }
}
