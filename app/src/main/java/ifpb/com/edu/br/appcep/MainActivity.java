package ifpb.com.edu.br.appcep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends AppCompatActivity {

    private Button bnt;
    private TextView log;
    private TextView com;
    private TextView bar;
    private TextView est;
    private TextView cid;
    private EditText cepnum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = (TextView) findViewById(R.id.log);
        com = (TextView) findViewById(R.id.com);
        bar = (TextView) findViewById(R.id.bar);
        est = (TextView) findViewById(R.id.est);
        cid = (TextView) findViewById(R.id.cid);
        bnt = (Button) findViewById(R.id.button);
        EventBus.getDefault().register(this);
        cepnum = (EditText) findViewById(R.id.cep);
        bnt.setOnClickListener(onDownloadListener());

    }


    private View.OnClickListener onDownloadListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String cepurl = cepnum.getText().toString();
                Intent intent = new Intent(MainActivity.this, CepServiceBus.class);
                intent.putExtra(CepService.PARAM_IN_MSG, cepurl);
                startService(intent);
            }
        };
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CepModel cep){


        log.setText(cep.getLogradouro());
        com.setText(cep.getComplemento());
        bar.setText(cep.getBairro());
        est.setText(cep.getUf());
        cid.setText(cep.getLocalidade());
    }

}


