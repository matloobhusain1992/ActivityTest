package jagran.zmq.com.activitytest.parceble;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by zmq181 on 26/3/19.
 */

public class Contact implements Parcelable{
    private String name;
    private int age;
    private int phone;
    private Address address;

    public Contact(String name, int age, int phone, Address address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    protected Contact(Parcel in) {
        name = in.readString();
        age = in.readInt();
        phone = in.readInt();
        address = in.readParcelable(Address.class.getClassLoader());
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeInt(phone);
        dest.writeParcelable(address,flags);
    }

    public static class Address implements Parcelable{
        private String street;
        private String city;
        private int house;

        public Address(String street, String city, int house) {
            this.street = street;
            this.city = city;
            this.house = house;
        }


        protected Address(Parcel in) {
            street = in.readString();
            city = in.readString();
            house = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(street);
            dest.writeString(city);
            dest.writeInt(house);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Address> CREATOR = new Creator<Address>() {
            @Override
            public Address createFromParcel(Parcel in) {
                return new Address(in);
            }

            @Override
            public Address[] newArray(int size) {
                return new Address[size];
            }
        };
    }

    @Override
    public String toString() {
        return name+" "+age+"  "+address.house+"  "+address.city;
    }
}
