package com.example.store;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.WindowManager;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

public class frontscreen extends AppCompatActivity {
    Button callsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callsignup=findViewById(R.id.button3);

        callsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(frontscreen.this,Signup.class);
                startActivity(intent);
            }
        });
    }
}