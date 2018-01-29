package uk.ac.tees.s6281752live.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity
{
    private String storedMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Get the Intent that started this activity and extract the string.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set hte string as its text.
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }
    public void shareText(View view)
    {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, storedMessage);
        sendIntent.setType("text/plain");

        Intent chooser = Intent.createChooser(sendIntent,  "Share with friends");
        if(sendIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(chooser);
        }
    }
}
