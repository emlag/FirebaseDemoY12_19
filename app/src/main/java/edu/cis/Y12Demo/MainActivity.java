package edu.cis.Y12Demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText birthday;
    Button save;
    Y12User current;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthday = (EditText) findViewById(R.id.birthday);
        save = (Button) findViewById(R.id.save);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ValueEventListener Y12userlistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Y12User newInfo = dataSnapshot.getValue(Y12User.class);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
    }

    public void init(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        current = new Y12User("december 31", "jorja angelo");

        current.setFavoriteArtist("taylor swift");
        final Y12User alan = new Y12User("june 6", "iunno");

        final Y12User sam = new Y12User("july 28", "My favorite artist was Taylor Swift, but that's already taken.");

//        current.setBestFriend(alan);
        alan.setBestFriend(current);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("users").child("EM929").setValue(current);
                mDatabase.child("users").child("AZ999").setValue(alan);
                mDatabase.child("not_sure_cooler_users").child("SAM111").setValue(sam);
            }
        });
    }
}
