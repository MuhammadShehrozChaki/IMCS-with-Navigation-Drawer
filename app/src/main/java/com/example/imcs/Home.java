package com.example.imcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    ListView listView;
    CardView cardView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_home);

        listView = findViewById(R.id.listview);
        listView.setAdapter(new CustomListAdapter());

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.home:
                Intent i = new Intent(Home.this, Home.class);
                startActivity(i);
                return true;

           case R.id.update:
                    Intent s = new Intent(Home.this, UpdateHome.class);
                    startActivity(s);
                    return true;

            case R.id.timetable:
                    Intent u = new Intent(Home.this, TimeTableHome.class);
                    startActivity(u);
                    return true;
                case R.id.course:
                    Intent c = new Intent(Home.this, CourseHome.class);
                    startActivity(c);
                    return true;
                case R.id.teacher:
                    Intent t = new Intent(Home.this, TeacherHome.class);
                    startActivity(t);
                    return true;
                case R.id.about:
                    Intent ab = new Intent(Home.this, AboutHome.class);
                    startActivity(ab);
                    return true;

                case R.id.logout:
                    Intent lg = new Intent(Home.this, MainActivity.class);
                    startActivity(lg);
                    return true;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
  // end navigation





   // Ad class

    public class CustomListAdapter extends BaseAdapter {
        String[] items = {"Update", "Time Table", "Course", "Teachers","About"};

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_listview_iems, null);
            TextView items_text = view.findViewById(R.id.item_text);
            items_text.setText(items[i]);

            items_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i == 0) {
                        Intent intent = new Intent(Home.this, UpdateHome.class);
                        startActivity(intent);
                        }
                    else if (i == 1) {
                        Intent intent = new Intent(Home.this, TimeTableHome.class);
                        startActivity(intent);
                        }
                    else if (i == 2) {
                        Intent intent = new Intent(Home.this, CourseHome.class);
                        startActivity(intent);
                        }
                    else if (i == 3) {
                        Intent intent = new Intent(Home.this, TeacherHome.class);
                        startActivity(intent);
                        }
                    else if (i == 4) {
                        Intent intent = new Intent(Home.this, AboutHome.class);
                        startActivity(intent);
                    }

                }
            });
         /*   CardView cardView = view.findViewById(R.id.card_action_item);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if(i==0)
                    {
                        Intent intent=new Intent(Home.this,)
                    }
                    Toast.makeText(getApplicationContext(), String.valueOf(i), Toast.LENGTH_LONG).show();
                }
            });*/
            return view;
        }
    }
    }







