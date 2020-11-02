package com.example.store;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.WindowManager;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.Query;
        import com.google.firebase.database.ValueEventListener;

public class frontscreen extends AppCompatActivity {
    Button callsignup;
    Button btnlogin;
   private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        username=findViewById(R.id.log_username);
        password=findViewById(R.id.log_password);
        btnlogin=findViewById(R.id.button);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamefromuser=username.getText().toString();
                final String passwordfromuser=password.getText().toString();


                if(usernamefromuser.isEmpty() || passwordfromuser.isEmpty())
                {
                    Toast.makeText(frontscreen.this,"Enter something you Dumbfuck",Toast.LENGTH_SHORT).show();
                }
                else {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
                    Query checkUser =reference.orderByChild("username").equalTo(usernamefromuser);
                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String passwordfromDB=dataSnapshot.child(passwordfromuser).child("password").getValue(String.class);
                            if(passwordfromDB.equals(passwordfromuser))
                            {
                                Intent intent=new Intent(frontscreen.this,homescreen.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

            }
        });



    }


}
