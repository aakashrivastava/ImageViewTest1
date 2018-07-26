package exodiasolutions.autobox2;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    bedroom bedroom;
    private Button mDrawer;
    private Button mLiving;
    private Button mbedroom;
    private DrawerLayout mankit;
    private ImageView rooms_image;
    private Button mlight_button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer = (Button)findViewById(R.id.drawer);
        mankit = (DrawerLayout)findViewById(R.id.ankit);
        mLiving = (Button)findViewById(R.id.living);
        mLiving.setBackgroundResource(R.color.yellow);
        mDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mankit.openDrawer(Gravity.LEFT);

            }
        });
        /***mLiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });***/
    }

    public void ChangeFragment(View view) {
        mbedroom = (Button)findViewById(R.id.bedroom);
        rooms_image = (ImageView)findViewById(R.id.imageView8);
        Fragment fragment;
        if(view.getId() == R.id.living) {

            mbedroom.setBackgroundResource(R.color.black);
            mLiving.setBackgroundResource(R.color.yellow);
            // rooms_image.setBackgroundResource(R.drawable.living_image);
            living_room living_room = new living_room();
            fragment = living_room;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();


            View v = fragment.getView();

        }

        if(view.getId() == R.id.bedroom) {
            mbedroom.setBackgroundResource(R.color.yellow);
            mLiving.setBackgroundResource(R.color.black);
            //rooms_image.setBackgroundResource(R.drawable.bedroom);
            bedroom bedroom = new bedroom();
            fragment = bedroom;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();


            View v = fragment.getView();

        }
    }
}
