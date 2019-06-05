package com.example.resource.dog.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.example.resource.dog.R;
import com.example.resource.dog.presenter.ListAllBreedPresenter;
import com.example.resource.dog.ui.activity.shape.CurvedBottomNavigationView;
import com.example.resource.dog.ui.fragment.ListAllDogsFragment;
import com.example.resource.dog.ui.fragment.RandomFragment;
import com.example.resource.dog.ui.fragment.SemNadaBlankFragment;

public class ListAllBreedActivity extends AppCompatActivity {

    private CurvedBottomNavigationView navigation;
    private ImageView imageFind;
    private ImageView imageOption;
    private ImageView imageMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_breed);

        imageFind = findViewById(R.id.image_find);
        imageOption = findViewById(R.id.image_option);
        imageMessage = findViewById(R.id.image_message);
        imageMessage.setVisibility(View.GONE);
        imageFind.setVisibility(View.GONE);
        navigation = findViewById(R.id.navigation_list_all);
        navigation.setSelectedItemId(R.id.item_option);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return identifyItemMenuClicked(menuItem);
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_random,
                new ListAllDogsFragment()).commit();
    }

    private boolean identifyItemMenuClicked(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.item_find:
                new ListAllBreedPresenter(new IListAllBreedActivity() {
                    @Override
                    public void getPositionCurved(CurvedBottomNavigationView navigation) {
                        ListAllBreedActivity.this.navigation = navigation;
                    }
                }).curvedLeft(navigation);
                visibleImageLeft();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_random, new RandomFragment())
                        .commit();
                break;
            case R.id.item_option:
                new ListAllBreedPresenter(new IListAllBreedActivity() {
                    @Override
                    public void getPositionCurved(CurvedBottomNavigationView navigation) {
                        ListAllBreedActivity.this.navigation = navigation;
                    }
                }).curvedCenter(navigation);
                visibleImageCenter();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_random,
                        new ListAllDogsFragment()).commit();
                break;
            case R.id.item_message:
                new ListAllBreedPresenter(new IListAllBreedActivity() {
                    @Override
                    public void getPositionCurved(CurvedBottomNavigationView navigation) {
                        ListAllBreedActivity.this.navigation = navigation;
                    }
                }).curvedRight(navigation);
                visibleImageRight();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_random,
                        new SemNadaBlankFragment()).commit();
                break;
        }
        return true;
    }

    private void visibleImageRight() {
        imageMessage.setVisibility(View.VISIBLE);
        imageFind.setVisibility(View.GONE);
        imageOption.setVisibility(View.GONE);
    }

    private void visibleImageCenter() {
        imageMessage.setVisibility(View.GONE);
        imageFind.setVisibility(View.GONE);
        imageOption.setVisibility(View.VISIBLE);
    }

    private void visibleImageLeft() {
        imageMessage.setVisibility(View.GONE);
        imageFind.setVisibility(View.VISIBLE);
        imageOption.setVisibility(View.GONE);
    }
}
