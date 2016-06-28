package orangeit.com.saveactivitystatedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{
    String mUsername ;
    String mPassword;
    Button mSaveCredentialsButton;
    EditText mUsernameEditText, mPasswordEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsernameEditText = ( EditText ) findViewById( R.id.usernameedittext );
        mPasswordEdittext = ( EditText ) findViewById( R.id.passwordedittext  );
        mUsernameEditText.setText(" "+mUsername );
        mPasswordEdittext.setText( " "+mPassword );
        mSaveCredentialsButton  = ( Button )findViewById( R.id.saveButton );
        mSaveCredentialsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mPassword =  mPasswordEdittext.getText().toString();
                mUsername = mUsernameEditText.getText().toString();
            }
        });
        Log.d("MainActivity", "=================in OnCreate=========== the username is="+mUsername+" the password is: "+ mPassword );

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mUsername = savedInstanceState.getString("username");
        mPassword = savedInstanceState.getString("password");
        Log.d("MainActivity", "=================in restoreinstancestate=========== the username is="+mUsername+" the password is: "+ mPassword );

    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {

        mPassword =  mPasswordEdittext.getText().toString();
        mUsername = mUsernameEditText.getText().toString();
        outState.putString("username", mUsername);
        outState.putString("password", mPassword );
        super.onSaveInstanceState(outState);
        Log.d("MainActivity", "=================in SaveInstacestate=========== the username is="+mUsername+" the password is: "+ mPassword );

    }

    @Override
    protected void onPause()
    {
        mUsername = mUsernameEditText.getText().toString();
        mPassword = mPasswordEdittext.getText().toString();
        Log.d("MainA", "=================in OnPause()=========== username is = "+ mUsername +"  the password is:="+mPassword

        );
        super.onPause();
    }
}
