package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView fullnameOutput, emailOutput, homePageOutput, abotYouOutput;
    ImageView img;
    Button btnHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullnameOutput = findViewById(R.id.label_fullname);
        emailOutput = findViewById(R.id.label_email);
        homePageOutput = findViewById(R.id.label_homepage);
        abotYouOutput = findViewById(R.id.label_about);
        img = findViewById(R.id.image_profile);
        btnHomepage = findViewById(R.id.button_homepage);

        Bundle extras = getIntent().getExtras();

        String AboutValue = extras.getString("about");
        String fullnameValue = extras.getString("fullname");
        String emailValue = extras.getString("email");
        String HomePageValue = extras.getString("homepage");

        if (extras != null) {
            abotYouOutput.setText(AboutValue);
            fullnameOutput.setText(fullnameValue);
            emailOutput.setText(emailValue);
            homePageOutput.setText(HomePageValue);
        }

    }

    public void handleHomePage(View view) {
        btnHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://"+homePageOutput.getText().toString();
                Intent Browser = new Intent(Intent.ACTION_VIEW);
                Browser.setData(Uri.parse(url));
                startActivity(Browser);
            }
        });
    }
}
