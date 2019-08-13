package com.example.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_Heroes;

    private ArrayList<Hero> list = new ArrayList<>();

    private String title = "Mode List";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBarTitle(title);


        rv_Heroes = findViewById(R.id.rv_Heroes);
        rv_Heroes.setHasFixedSize(true);

        list.addAll(HeroesData.getListData());
        showRecyclerList();

    }




    @Override
    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);

    }

    public void setMode(int SelectedMode){

        switch (SelectedMode){

            case R.id.action_list:
                title = "Mode List";
                setActionBarTitle(title);
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                setActionBarTitle(title);
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode Card";
                setActionBarTitle(title);
                showRecyclerCardView();
                break;
        }
    }


    private void showRecyclerList(){
        rv_Heroes.setLayoutManager(new LinearLayoutManager(this));

        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);

        rv_Heroes.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });

    }

    private void showRecyclerCardView(){
        rv_Heroes.setLayoutManager(new LinearLayoutManager(this));

        CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(list);

        rv_Heroes.setAdapter(cardViewHeroAdapter);




    }

    private void showRecyclerGrid(){
        rv_Heroes.setLayoutManager(new GridLayoutManager(this, 2));

        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);

        rv_Heroes.setAdapter(gridHeroAdapter);

        gridHeroAdapter.setOnItemClickCallback(new GridHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    private void setActionBarTitle(String title) {

        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle(title);

        }
    }

    private void showSelectedHero(Hero hero){
        Toast.makeText(this, "Kamu Memili " + hero.getName(), Toast.LENGTH_SHORT).show();
    }






}
