package com.example.tastebudsv3;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateProfile extends AppCompatActivity {

    EditText CPFname, CPLname, DOB, CPstate, CPcity, CPzip, CPbio, CPemail;
    ImageButton savebtn, cambtn;
    CheckBox check1;


    FirebaseDatabase database;
    DatabaseReference ref;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        CPFname = (EditText) findViewById(R.id.CPFname);
        CPLname = (EditText) findViewById(R.id.CPLname);
        DOB = (EditText) findViewById(R.id.DOB);
        CPstate = (EditText) findViewById(R.id.CPstate);
        CPcity = (EditText) findViewById(R.id.CPcity);
        CPzip = (EditText) findViewById(R.id.CPzipcode);
        CPbio = (EditText) findViewById(R.id.CPbio);
        CPemail = (EditText) findViewById(R.id.CPemail);
        savebtn = (ImageButton) findViewById(R.id.CPsavebtn);
        cambtn = (ImageButton) findViewById(R.id.CPcamerabtn);
       /* check1 = findViewById(R.id.spicyBox);

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        //pic = (ImageView) findViewById(R.id.CPprofilepic);


        database = FirebaseDatabase.getInstance();
        ref = database.getReference("User");
        //ref = database.getReference("User");
        user = new User();


        //storage = FirebaseStorage.getInstance().getReference();

        cambtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateProfile.this, CameraActivity.class);
                startActivity(i);
            }
        });

    }




    private void setValues()
    {
        user.setFirstName(CPFname.getText().toString());
        user.setLastName(CPLname.getText().toString());
        user.setDOB(DOB.getText().toString());
        user.setCity(CPcity.getText().toString());
        user.setState(CPstate.getText().toString());
        user.setZip(CPzip.getText().toString());
        user.setBio(CPbio.getText().toString());
        user.setEmail(CPemail.getText().toString());
        user.getTags();
    }


    public void selectItem(View view)
    {
        user.selectItem(view);
    }

    public void CPsavebtn(View view)
    {

        ref.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // ref.child("newuser2").setValue(user);
                //  databaseReference.child(usercurrent.getUid()).child("newuser2").setValue(user);
                //ref.child("User").push().setValue(user);
                // newRef.setValue(user);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        setValues();

        DatabaseReference rootRef= FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child("User").push();

        userRef.setValue(user);
        Toast.makeText(CreateProfile.this, "Data is inserted....", Toast.LENGTH_SHORT).show();


        Intent inToHomeFeed = new Intent(CreateProfile.this, HomeFeed.class);
        startActivity(inToHomeFeed);


    }


}
