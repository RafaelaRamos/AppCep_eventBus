package ifpb.com.edu.br.appcep;

import android.app.IntentService;
import android.content.Intent;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class CepService extends IntentService {

    public static final String NOTIFICATION = "notification";
    public static CepModel cep = null;
    public static final String PARAM_IN_MSG = "imsg";
    public static final String PARAM_OUT_MSG = "omsg";
    public static final String URL = "result";

    public CepService() {
        super("CepService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        StringBuilder resposta = new StringBuilder();

        String cepnumer = intent.getStringExtra(PARAM_IN_MSG);

            try {
                URL url = new URL("https://viacep.com.br/ws/"+cepnumer+"/json");

                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-type", "application/json");
                con.setRequestProperty("Accept", "application/json");
                con.setDoOutput(true);
                con.setConnectTimeout(5000);

                con.connect();

                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    resposta.append(scan.next());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


      Gson gson = new Gson();
          cep = gson.fromJson(resposta.toString(), CepModel.class);


            resultado(cep);
    }

    private void resultado(CepModel cep) {
        Intent intent = new Intent(NOTIFICATION);

        intent.putExtra (PARAM_OUT_MSG, cep);
        sendBroadcast(intent);
    }
}
