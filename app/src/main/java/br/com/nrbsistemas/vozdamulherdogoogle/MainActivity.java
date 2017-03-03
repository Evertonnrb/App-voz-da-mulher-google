package br.com.nrbsistemas.vozdamulherdogoogle;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech talk;
    private EditText fale;
    private Button btnFalar;
    private ImageView imgFalar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "NRB sistemas", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fale = (EditText) findViewById(R.id.edt_talk);
        btnFalar = (Button) findViewById(R.id.btn_falar);
        imgFalar = (ImageView)findViewById(R.id.img_voz);

        btnFalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                talk = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {

                        if ("".equals(fale)) {
                            Toast.makeText(getApplicationContext(),"Escreva alguma coisa ;,)\n mané!!!",Toast.LENGTH_SHORT).show();
                        }else{

                            if (status == TextToSpeech.SUCCESS) {
                                String texto = fale.getText().toString();
                                talk.speak(texto + "", TextToSpeech.QUEUE_FLUSH, null);

                            } else {
                                Toast.makeText(getApplicationContext(), "Não foi possível falar", Toast.LENGTH_SHORT).show();
                            }
                            fale.setText("");
                        }
                    }
                });

            }
        });

        imgFalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                talk = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {

                        if ("".equals(fale)) {
                            Toast.makeText(getApplicationContext(),"Escreva alguma coisa ;,)\n mané!!!",Toast.LENGTH_SHORT).show();
                        }else{

                            if (status == TextToSpeech.SUCCESS) {
                                String texto = fale.getText().toString();
                                talk.speak(texto + "", TextToSpeech.QUEUE_FLUSH, null);

                            } else {
                                Toast.makeText(getApplicationContext(), "Não foi possível falar", Toast.LENGTH_SHORT).show();
                            }
                            fale.setText("");
                        }
                    }
                });


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.compartilhar){

        }
        if (id == R.id.action_settings) {
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
