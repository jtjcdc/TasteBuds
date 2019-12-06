package com.example.tastebudsv3;

import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class User {

    private String FirstName;
    private String LastName;
    private String DOB;
    private String city;
    private String state;
    private String bio;
    private String zip;
    private String email;
    //private String tag;
    private ArrayList<String> selection = new ArrayList<String>();

    public User()
    {
        this.FirstName = "";
        this.LastName = "";
        this.DOB = "";
        this.city = "";
        this.state = "";
        this.bio = "";
        this.zip = "";
        this.email = "";
        // this.tag ="";
    }

    public User(String FirstName, String LastName, String DOB, String city, String state,
                String bio, String zip, String email)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DOB = DOB;
        this.city = city;
        this.state = state;
        this.bio = bio;
        this.zip = zip;
        this.email = email;
        //this.tag = tag;
    }

    public void setFirstName(String FirstName)
    {
        this.FirstName = FirstName;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public void setLastName(String LastName)
    {
        this.LastName = LastName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public void setDOB(String DOB)
    {
        this.DOB = DOB;
    }

    public String getDOB()
    {
        return DOB;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }

    public String getBio()
    {
        return bio;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getZip()
    {
        return zip;
    }

    public void setEmail(String email){this.email = email; }

    public String getEmail() { return email; }

    //public void setTags(String tag) {this.tag = tag; }

    public ArrayList<String> getTags() {return selection;}

    public void selectItem(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId())
        {
            case R.id.spicyBox:

                if(checked)
                {
                    selection.add("Spicy");
                }

                else
                {
                    selection.remove("Spicy");
                }

                break;

            case R.id.sweetBox:

                if(checked)
                {
                    selection.add("Sweet");
                }

                else
                {
                    selection.remove("Sweet");
                }

                break;

            case R.id.sourBox:

                if(checked)
                {
                    selection.add("Sour");
                }

                else
                {
                    selection.remove("Sour");
                }

                break;

            case R.id.HealthyBox:

                if(checked)
                {
                    selection.add("Healthy");
                }

                else
                {
                    selection.remove("Healthy");
                }

                break;

            case R.id.seafoodBox:

                if(checked)
                {
                    selection.add("Seafood");
                }

                else
                {
                    selection.remove("Seafood");
                }

                break;

            case R.id.soulBox:

                if(checked)
                {
                    selection.add("Soul");
                }

                else
                {
                    selection.remove("Soul");
                }

                break;

            case R.id.bitterBox:

                if(checked)
                {
                    selection.add("Bitter");
                }

                else
                {
                    selection.remove("Bitter");
                }

                break;

            case R.id.fusionBox:

                if(checked)
                {
                    selection.add("Fusion");
                }

                else
                {
                    selection.remove("Fusion");
                }

                break;

            case R.id.cajunBox:

                if(checked)
                {
                    selection.add("Cajun");
                }

                else
                {
                    selection.remove("Cajun");
                }

                break;

            case R.id.saltyBox:

                if(checked)
                {
                    selection.add("Salty");
                }

                else
                {
                    selection.remove("Salty");
                }

                break;

            case R.id.umamiBox:

                if(checked)
                {
                    selection.add("Umami");
                }

                else
                {
                    selection.remove("Umami");
                }

                break;

        }
    }


}
