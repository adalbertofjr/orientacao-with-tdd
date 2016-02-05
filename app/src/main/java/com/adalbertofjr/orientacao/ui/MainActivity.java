package com.adalbertofjr.orientacao.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.adalbertofjr.orientacao.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AdalbertoF on 05/02/2016.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.txtNome) EditText mNome;
    @Bind(R.id.btnClick) Button mClick;
    @Bind(R.id.lstView1) ListView mLista;

    private ArrayList<String> nomes;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            nomes = savedInstanceState.getStringArrayList("nomes");
        }else{
            nomes = new ArrayList<String>();
        }

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, nomes);

        mLista.setAdapter(adapter);
        mClick.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("nomes", nomes);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnClick) {
            nomes.add(mNome.getText().toString());
            mNome.setText("");
            adapter.notifyDataSetChanged();
        }
    }
}
