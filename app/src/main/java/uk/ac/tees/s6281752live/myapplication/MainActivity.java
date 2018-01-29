package uk.ac.tees.s6281752live.myapplication;

import android.Manifest;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "uk.ac.tees.s6281752live.myapplication.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Called when the user taps the Send button */
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    /* Called when the user taps the 'Google.co.uk' button */
    public void viewWebPage (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.co.uk"));
        startActivity(browserIntent);
    }

    public void sendEmail (View view)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "body");
        startActivity(Intent.createChooser(emailIntent, "Send Email..."));
    }


}