package com.example.ajay.jbietnotebook;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registeration_Activity extends AppCompatActivity {
    public EditText RName,RPassword,CPassword,EMAIL;
    public Button RegisterButton;
    public TextView OldUser;
    public FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RegisterationAct();
        firebaseAuth =FirebaseAuth.getInstance();
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if( Validate()) {
                   String Email=EMAIL.getText().toString().trim();
                   String Password=RPassword.getText().toString().trim();
                   firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(Task<AuthResult> task) {
                           if(task.isSuccessful()){
                               Toast.makeText(Registeration_Activity.this,"Registeration Succesful",Toast.LENGTH_SHORT).show();
                           }
                           else {
                               Toast.makeText(Registeration_Activity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                           }


                       }
                   });
                   //upload to database
               }
            }
        });
        OldUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registeration_Activity.this,LoginActivity.class));
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void RegisterationAct(){
        RName= (EditText)findViewById(R.id.RName);
        RPassword=(EditText)findViewById(R.id.RPassword);
        CPassword=(EditText)findViewById(R.id.CPassword);
        EMAIL=(EditText)findViewById(R.id.Email);
        RegisterButton=(Button)findViewById(R.id.RegisterButton);
        OldUser=(TextView) findViewById(R.id.OldUser);
    }

    public Boolean Validate(){
        Boolean result=false;
        String name=RName.getText().toString();
        String Password=RPassword.getText().toString();
        String Email= EMAIL.getText().toString();
        if(name.isEmpty() && Password.isEmpty() && Email.isEmpty()){
            Toast.makeText(this,"Details can't be empty",Toast.LENGTH_SHORT).show();
        }
        else if (RPassword!=CPassword){
            Toast.makeText(this,"Password not matching",Toast.LENGTH_SHORT).show();
        }
        else{
            result=true;
        }
        return result;
    }

}
