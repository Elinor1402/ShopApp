package com.example.fragapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragapp.R;
import com.example.fragapp.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public static String username;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        textView = findViewById(R.id.textUser);
        //readData();
    }

    public void addDtata() {

        //inside fragments use Button buton1To3 = view.findViewById(R.id.buttonOneToThree);
        EditText user = findViewById(R.id.textUser);
        EditText pass = findViewById(R.id.textPass);

//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        String unige_id = currentUser.getUid();
//        DatabaseReference myRef = database.getReference("users2").child(unige_id);

// Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //id cant contain @ only unige values
        DatabaseReference myRef = database.getReference("users2").child(user.getText().toString());

        User user1 = new User(user.getText().toString(), pass.getText().toString());

        myRef.setValue(user1);

    }
    public void readData(){
// Read from the database
        EditText user = findViewById(R.id.textUser);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users2").child(user.getText().toString());

        FirebaseUser currentUser = mAuth.getCurrentUser();
        String unige_id = currentUser.getUid();
        //DatabaseReference myRef = database.getReference("users2").child(unige_id);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User value = dataSnapshot.getValue(User.class);
                Toast.makeText(MainActivity.this, value.getEmail(), Toast.LENGTH_SHORT).show();
                //add user date from firebase to text view
               //textView.setText("Welcome to:"+ value.getEmail());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }
    public void setUsername(String username){
        this.username= username;
    }

    public String getUsername(){
        return username;
    }
}