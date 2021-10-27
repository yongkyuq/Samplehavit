package org.techtown.havit;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BasketActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private ListView mListView;
    Toolbar toolbar1;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버튼 만들기
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24); //왼쪽 상단 버튼 아이콘 지정


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        /* 위젯과 멤버변수 참조 획득 */
        mListView = (ListView)findViewById(R.id.listview);





        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();





    }

    private void dataSetting(){

        MyAdapter mMyAdapter = new MyAdapter();
        mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.rechargerble_1),"HAVIT V1","67,000원");
        mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.rechargerble_2),"HAVIT V2","67,000원");
        mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.disposable_1),"HAVIT T1","19,500원");
        mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.disposable_2),"HAVIT T2","38,500원");








        /* 리스트뷰에 어댑터 등록 */
        mListView.setAdapter(mMyAdapter);
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { // 왼쪽 상단 버튼 눌렀을 때
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }


        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() { //뒤로가기 했을 때
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

          /*  case R.id.item_about: {
                Intent pintent = new Intent(this, AboutActivity.class);
                startActivity(pintent);
                break;
            }

            case R.id.item_product: {
                Intent pintent = new Intent(this, ProductActivity.class);
                startActivity(pintent);
                break;
            }
            case R.id.item_contact: {
                Intent lintent = new Intent(this, ContactActivity.class);
                startActivity(lintent);
                break;
            }*/
        }

        return true;
    }

}









