package com.example.roger.restwebservice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roger.restwebservice.model.Clima;
import com.example.roger.restwebservice.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtLatitude = findViewById(R.id.edtLatitude);

        final EditText txtLongitude = findViewById(R.id.edtLongitude);

        final ImageView img = findViewById(R.id.imgClima);

        final Button btnCons = findViewById(R.id.btnConsultar);

        btnCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Clima> call = new RetrofitConfig().getClimaService().consulta(Double.parseDouble(txtLatitude.getText().toString()), Double.parseDouble(txtLatitude.getText().toString()));

                call.enqueue(new Callback<Clima>() {
                    @Override
                    public void onResponse(Call<Clima> call, Response<Clima> response) {
                        Clima c = response.body();
                        switch (c.getCurrently().getIcon()) {

                            case "clear-day":
                                img.setImageResource(R.drawable.clearday);
                                break;
                            case "clear-night":
                                img.setImageResource(R.drawable.clearnight);
                                break;
                            case "rain":
                                img.setImageResource(R.drawable.rain);
                                break;
                            case "snow":
                                img.setImageResource(R.drawable.snow);
                                break;
                            case "sleet":
                                img.setImageResource(R.drawable.sleet);
                                break;
                            case "wind":
                                img.setImageResource(R.drawable.wind);
                                break;
                            case "fog":
                                img.setImageResource(R.drawable.fog);
                                break;
                            case "cloud":
                                img.setImageResource(R.drawable.cloudy);
                                break;
                            case "partly-cloud-day":
                                img.setImageResource(R.drawable.partlycloudday);
                                break;
                            case "partly-cloud-night":
                                img.setImageResource(R.drawable.partlycloudynight);
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<Clima> call, Throwable t) {
                        Log.e("Serviço Clima", "Erro ao buscar o clima:" + t.getMessage());
                    }
                });
            }
        });

    }
}
