package com.example.store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

 EditText regName, regUsername, regEmail, regPhoneNo, regPassword;
 Button regBtn;
 FirebaseDatabase rootNode;
 DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //hooks
        regName=findViewById(R.id.reg_fullname);
        regUsername=findViewById(R.id.reg_username);
        regEmail=findViewById(R.id.reg_email);
        regPhoneNo=findViewById(R.id.reg_phone);
        regPassword=findViewById(R.id.reg_password);
        regBtn=findViewById(R.id.reg_signupbutton);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference =rootNode.getReference("users");
                //all the values from text fields
                String name=regName.getText().toString();
                String username=regUsername.getText().toString();
                String email=regEmail.getText().toString();
                String phoneNo=regPhoneNo.getText().toString();
                String password=regPassword.getText().toString();


                UserHelperClass helperClass=new UserHelperClass(name,username,email,phoneNo,password);

                reference.child(phoneNo).setValue(helperClass);




            }
        });

    }
}