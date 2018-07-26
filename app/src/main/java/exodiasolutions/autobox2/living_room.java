package exodiasolutions.autobox2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;


public class living_room extends Fragment {

    ToggleButton mlight_button1, mlight_button2, mfan_button1,
            mfan_button2, mhalogen_button1, master_control_button;
    private String data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_living_room, container, false);
        mlight_button1=(v.findViewById(R.id.light_button1));
        mlight_button2=(v.findViewById(R.id.light_button2));
        mfan_button1=(v.findViewById(R.id.fan_button_1));
        mfan_button2=(v.findViewById(R.id.fan_button_2));
        mhalogen_button1=(v.findViewById(R.id.halogen_light_1));
        master_control_button = (v.findViewById(R.id.master_button1));



        boolean stat = new Store(getActivity()).getStatus("light 1");
        if(stat == true){
            mlight_button1.setChecked(true);
        }
        else{
            mlight_button1.setChecked(false);
        }

        boolean stat2 = new Store(getActivity()).getStatus("light 2");
        if(stat2 == true){
            mlight_button2.setChecked(true);
        }
        else{
            mlight_button2.setChecked(false);
        }
        boolean stat3 = new Store(getActivity()).getStatus("fan 1");
        if(stat3 == true){
            mfan_button1.setChecked(true);
        }
        else{
            mfan_button1.setChecked(false);
        }
        boolean stat4 = new Store(getActivity()).getStatus("fan 2");
        if(stat4 == true){
            mfan_button2.setChecked(true);
        }
        else{
            mfan_button2.setChecked(false);
        }

        boolean stat5 = new Store(getActivity()).getStatus("halo 1");
        if(stat5 == true){
            mhalogen_button1.setChecked(true);
        }
        else{
            mhalogen_button1.setChecked(false);
        }

        boolean stat6 = new Store(getActivity()).getStatus("master 1");
        if(stat6 == true){
            master_control_button.setChecked(true);
        }
        else{
            master_control_button.setChecked(false);
        }



        mlight_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = mlight_button1.isChecked();
                if(check){
                    data = "living_1_on";
                    new Store(getActivity()).setStatus("light 1",true);
                }
                else{
                    data = "living_1_off";
                    master_control_button.setChecked(false);
                    new Store(getActivity()).setStatus("master 1",false);
                    new Store(getActivity()).setStatus("light 1",false);

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
        mlight_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = mlight_button2.isChecked();
                if(check){
                    data = "light_on";
                    new Store(getActivity()).setStatus("light 2",true);
                }
                else{
                    data = "light_off";
                    master_control_button.setChecked(false);
                    new Store(getActivity()).setStatus("master 1",false);
                    new Store(getActivity()).setStatus("light 2",false);

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
        mfan_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = mfan_button1.isChecked();
                if(check){
                    data = "living_2_on";
                    new Store(getActivity()).setStatus("fan 1",true);
                }
                else{
                    data = "living_2_off";
                    master_control_button.setChecked(false);
                    new Store(getActivity()).setStatus("master 1",false);
                    new Store(getActivity()).setStatus("fan 1",false);

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
        mfan_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = mfan_button2.isChecked();
                if(check){
                    data = "fan_on";
                    new Store(getActivity()).setStatus("fan 2",true);
                }
                else{
                    data = "fan_off";
                    new Store(getActivity()).setStatus("fan 2",false);
                    master_control_button.setChecked(false);
                    new Store(getActivity()).setStatus("master 1",false);

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

        mhalogen_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = mhalogen_button1.isChecked();
                if(check){
                    data = "halo_on";
                    new Store(getActivity()).setStatus("halo 1",true);

                }
                else{
                    data = "halo_off";
                    new Store(getActivity()).setStatus("halo 1",false);
                    master_control_button.setChecked(false);
                    new Store(getActivity()).setStatus("master 1",false);

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

        master_control_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = master_control_button.isChecked();
                if(check){
                    data = "everything_on";

                    mlight_button1.setChecked(true);
                    mlight_button2.setChecked(true);
                    mfan_button1.setChecked(true);
                    mfan_button2.setChecked(true);
                    mhalogen_button1.setChecked(true);

                    new Store(getActivity()).setStatus("master 1",true);
                    new Store(getActivity()).setStatus("fan 1",true);
                    new Store(getActivity()).setStatus("fan 2",true);
                    new Store(getActivity()).setStatus("light 1",true);
                    new Store(getActivity()).setStatus("light 2",true);
                    new Store(getActivity()).setStatus("halo 1",true);

                }
                else{
                    data = "everything_off";

                    mlight_button1.setChecked(false);
                    mlight_button2.setChecked(false);
                    mfan_button1.setChecked(false);
                    mfan_button2.setChecked(false);
                    mhalogen_button1.setChecked(false);

                    new Store(getActivity()).setStatus("master 1",false);
                    new Store(getActivity()).setStatus("fan 1",false);
                    new Store(getActivity()).setStatus("fan 2",false);
                    new Store(getActivity()).setStatus("light 1",false);
                    new Store(getActivity()).setStatus("light 2",false);
                    new Store(getActivity()).setStatus("halo 1",false);

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
