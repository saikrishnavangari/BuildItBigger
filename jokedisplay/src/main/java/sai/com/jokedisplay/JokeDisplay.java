package sai.com.jokedisplay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by krrish on 29/12/2016.
 */

public class JokeDisplay extends AppCompatActivity {
private TextView DisplayText;
    public static final String JOKE_KEY="joke";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        DisplayText= (TextView) findViewById(R.id.displayText_tv);
        String joke=getIntent().getStringExtra(JOKE_KEY);
        DisplayText.setText(joke);
    }
}
