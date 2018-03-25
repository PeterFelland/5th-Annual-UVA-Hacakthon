/*App developed during 5th AnnualHackUVA by the following:
* Peter Felland
* David Xue
* Carl Zhang
*/

package com.example.uva_hackathon;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button changeTextButton;
    TextView message;
    float size = 12;
    int oldPhrase;
    int oldColor;
    int counter = 0;
    int baseline = 40;
    int max = 47;

    String[] positivePhrases = {"I am empowered!", "I can do it!", "Nothing is impossible!", "The world is my" +
            " oyster!", "I will seize the day!", "Nothing will hold me back!", "I'm a unique individual!",
            "The sky is the limit!", "I can reach beyond the stars!"};
    int[] colors = {0xFF67aefa, 0xFFcb0000, 0xFFFFFF00};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = (TextView)findViewById(R.id.tvMessage);
        changeTextButton = (Button)findViewById(R.id.bChangeText);
        changeTextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.muisc);
                mp.start();
                counter++;
                if (counter < 28) {
                    size += 1;
                }
                if (counter < 48 && counter > 28) {
                    if (counter == max) {
                        counter = 7;
                    }
                    size -= 1;
                }

                message.setTextSize(size);
                int random = (int) (Math.random() * positivePhrases.length);
                if (random == oldPhrase) {
                    random = (int) (Math.random() * positivePhrases.length);
                }
                message.setText(positivePhrases[random]);
                oldPhrase = random;

                int randomColor = (int) (Math.random() * colors.length);
                message.setTextColor(colors[randomColor]);
                if (randomColor == oldColor) {
                    randomColor = (int) (Math.random() * positivePhrases.length);
                }
                oldColor = randomColor;
            }
        });
    }
}
