package zain.aqdam.githubuserv1;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    private String username;
    private String location;
    private int repository;
    private String company;
    private int followers;
    private int following;
    private int avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRepository() {
        return repository;
    }

    public void setRepository(int repository) {
        this.repository = repository;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.username);
        dest.writeString(this.location);
        dest.writeInt(this.repository);
        dest.writeString(this.company);
        dest.writeInt(this.followers);
        dest.writeInt(this.following);
        dest.writeInt(this.avatar);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.username = in.readString();
        this.location = in.readString();
        this.repository = in.readInt();
        this.company = in.readString();
        this.followers = in.readInt();
        this.following = in.readInt();
        this.avatar = in.readInt();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
