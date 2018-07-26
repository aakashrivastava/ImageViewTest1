package exodiasolutions.autobox2;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;


public class bedroom extends Fragment {

    ToggleButton md_fan_button, md_light_button, md_halogen_button, md_master_control;
    private String data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bedroom, container, false);

        md_light_button = (v.findViewById(R.id.mdo_light_button1));
        md_fan_button = (v.findViewById(R.id.mdo_fan_button_1));
        md_halogen_button = (v.findViewById(R.id.mdo_halogen_light_1));
        md_master_control = (v.findViewById(R.id.mdo_master_button1));

        boolean stat1 = new Store(getActivity()).getStatus("md light 1");
        if(stat1 == true){
            md_light_button.setChecked(true);
        }
        else{
            md_light_button.setChecked(false);
        }

        boolean stat2 = new Store(getActivity()).getStatus("md fan 1");
        if(stat2 == true){
            md_fan_button.setChecked(true);
        }
        else{
            md_fan_button.setChecked(false);
        }

        boolean stat3 = new Store(getActivity()).getStatus("md halo 1");
        if(stat3 == true){
            md_halogen_button.setChecked(true);
        }
        else{
            md_halogen_button.setChecked(false);
        }

        boolean stat4 = new Store(getActivity()).getStatus("md master 1");
        if(stat4 == true){
            md_master_control.setChecked(true);
        }
        else{
            md_master_control.setChecked(false);
        }
        md_light_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = md_light_button.isChecked();
                if(check){
                    data = "md_lights_on";
                    new Store(getActivity()).setStatus("md light 1",true);
                }
                else{
                    data = "md_lights_off";
                    md_master_control.setChecked(false);
                    new Store(getActivity()).setStatus("md master 1",false);
                    new Store(getActivity()).setStatus("md light 1",false);

                }
                final MyHttpClient myHttpClient = new MyHttpClient(getActivity(),"https://io.adafruit.com/api/v2/omni_connect/feeds/itm/data?X-AIO-Key=cc6dba52786c4e24a80710684da6281f ",new String[]{"value",data});
                myHttpClient.execute();
                myHttpClient.callback = new MyCallback() {
                    @Override
                    public void callbackCall() {
                        // Toast.makeText(MainActivity.this, ""+myHttpClient.result, Toast.LENGTH_SHORT).show();
                    }
                };
            }
        });

        md_fan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = md_fan_button.isChecked();
                if(check){
                    data = "md_fans_on";
                    new Store(getActivity()).setStatus("md fan 1",true);
                }
                else{
                    data = "md_fans_off";
                    md_master_control.setChecked(false);
                    new Store(getActivity()).setStatus("md master 1",false);
                    new Store(getActivity()).setStatus("md fan 1",false);

                }
                final MyHttpClient myHttpClient = new MyHttpClient(getActivity(),"https://io.adafruit.com/api/v2/omni_connect/feeds/itm/data?X-AIO-Key=cc6dba52786c4e24a80710684da6281f ",new String[]{"value",data});
                myHttpClient.execute();
                myHttpClient.callback = new MyCallback() {
                    @Override
                    public void callbackCall() {
                        // Toast.makeText(MainActivity.this, ""+myHttpClient.result, Toast.LENGTH_SHORT).show();
                    }
                };
            }
        });

        md_halogen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = md_halogen_button.isChecked();
                if(check){
                    data = "md_halo_on";
                    new Store(getActivity()).setStatus("md halo 1",true);
                }
                else{
                    data = "md_halo_off";
                    md_master_control.setChecked(false);
                    new Store(getActivity()).setStatus("md master 1",false);
                    new Store(getActivity()).setStatus("md halo 1",false);

                }
                final MyHttpClient myHttpClient = new MyHttpClient(getActivity(),"https://io.adafruit.com/api/v2/omni_connect/feeds/itm/data?X-AIO-Key=cc6dba52786c4e24a80710684da6281f ",new String[]{"value",data});
                myHttpClient.execute();
                myHttpClient.callback = new MyCallback() {
                    @Override
                    public void callbackCall() {
                        // Toast.makeText(MainActivity.this, ""+myHttpClient.result, Toast.LENGTH_SHORT).show();
                    }
                };
            }
        });

        md_master_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = md_master_control.isChecked();
                if(check){
                    data = "md_everything_on";
                    md_light_button.setChecked(true);
                    md_fan_button.setChecked(true);
                    md_halogen_button.setChecked(true);

                    new Store(getActivity()).setStatus("md master 1",true);
                    new Store(getActivity()).setStatus("md light 1",true);
                    new Store(getActivity()).setStatus("md fan 1",true);
                    new Store(getActivity()).setStatus("md halo 1",true);
                }
                else{
                    data = "md_everything_off";
                    md_master_control.setChecked(false);
                    md_light_button.setChecked(false);
                    md_fan_button.setChecked(false);
                    md_halogen_button.setChecked(false);

                    new Store(getActivity()).setStatus("md master 1",false);
                    new Store(getActivity()).setStatus("md light 1",false);
                    new Store(getActivity()).setStatus("md fan 1",false);
                    new Store(getActivity()).setStatus("md halo 1",false);


                }
                final MyHttpClient myHttpClient = new MyHttpClient(getActivity(),"https://io.adafruit.com/api/v2/omni_connect/feeds/itm/data?X-AIO-Key=cc6dba52786c4e24a80710684da6281f ",new String[]{"value",data});
                myHttpClient.execute();
                myHttpClient.callback = new MyCallback() {
                    @Override
                    public void callbackCall() {
                        // Toast.makeText(MainActivity.this, ""+myHttpClient.result, Toast.LENGTH_SHORT).show();
                    }
                };
            }
        });

        return v;
    }

}

   

