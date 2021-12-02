package com.alexmartin.firstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {
    private WebView miVisorWeb;
    private SwipeRefreshLayout swipeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Creacion del objeto WebView vinculado con el id
        WebView main_content = (WebView) findViewById(R.id.vistaweb);

//      Registro del menú contextual.
        registerForContextMenu(main_content);


        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_content);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        miVisorWeb.setInitialScale(220);
        miVisorWeb.getSettings().setBuiltInZoomControls(false);
        miVisorWeb.loadUrl("https://thiscatdoesnotexist.com/");

    }
    public void showAlertDialogButtonClicked(Main mainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Hey Listen!!");
        builder.setMessage("Where do you go");
        builder.setIcon(R.drawable.ic_person);
        builder.setCancelable(false);


        // add the buttons
        builder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(Main.this, Signup.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {


            Toast toast0 = Toast.makeText(Main.this, "Refreshed", Toast.LENGTH_SHORT);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chulo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.item10) {
//            showAlertDialogButtonClicked(Main.this);

            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();

        }
        if (id == R.id.item20) {
            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
            toast.show();
        }

        if (id == R.id.item40) {
            showAlertDialogButtonClicked(Main.this);
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
//                Toast toast = Toast.makeText(this, "Item copied",
//                        Toast.LENGTH_LONG);
//                toast.show();

                ConstraintLayout mLayout =  findViewById(R.id.MainConstraint);

                Snackbar snackbar = Snackbar
                        .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();


                return true;

            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "Downloading item...",
                        Toast.LENGTH_LONG);
                toast2.show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }
}