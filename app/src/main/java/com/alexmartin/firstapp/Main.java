package com.alexmartin.firstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Switch;
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

//      Opciones WebView
        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        miVisorWeb.setInitialScale(220);
        miVisorWeb.getSettings().setBuiltInZoomControls(false);
        miVisorWeb.loadUrl("https://thiscatdoesnotexist.com/");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.menu_user) {
           showAlertDialogButtonClickedUser(Main.this);
        }
        if (id == R.id.menu_settings) {
            Toast toast = Toast.makeText(this, "Work-in-progress", Toast.LENGTH_SHORT);
            toast.show();
        }

        if (id == R.id.menu_aboutus) {
            showAlertDialogButtonClicked(Main.this);
        }

        return super.onOptionsItemSelected(item);
    }

//  Alert dialog clicked user
    public void showAlertDialogButtonClickedUser(Main mainActivity) {

//      Setup del Alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//      Diálogo estándar
        builder.setTitle(Login.getLogin_name());
        builder.setMessage("Where do you want to go?");
        builder.setIcon(R.drawable.ic_person);

//      Si clickas fuera de la alerta se cancela ↓
        builder.setCancelable(true);


//      Botones de la alerta ↓
//      Botón derecho ↓
        builder.setPositiveButton("NoHaceNada", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//              Toast nada interesante ↓
                Toast t_nada = Toast.makeText(Main.this, "Nada hecho", Toast.LENGTH_SHORT);
                t_nada.show();
                dialog.dismiss();
            }
        });
//      Botón central ↓
        builder.setNegativeButton("Signout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Main.this, Signup.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
//      Botón izquierdo ↓
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

//      Creacion y muestra del dialogo
        AlertDialog dialog = builder.create();
        dialog.show();
    }
//  Alert dialog clicked singout
    public void showAlertDialogButtonClicked(Main mainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Hey Listen!!");
        builder.setMessage("Where did you go?");
        builder.setIcon(R.drawable.ic_person);
        builder.setCancelable(false);


        // add the buttons
        builder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(Main.this, Login.class);
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
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                    /*Toast toast = Toast.makeText(this, "Item copied",
                            Toast.LENGTH_LONG);
                    toast.show();*/

                final ConstraintLayout mLayout =  findViewById(R.id.MainConstraint);

                Snackbar snackbar = Snackbar
                        .make(mLayout, "Item copied", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Item not copied", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();


                return true;

            case R.id.item2:
                Toast toast2 =
                        Toast.makeText(this, "Item download", Toast.LENGTH_SHORT);
                toast2.show();
                return true;

            default:
        }
        return super.onContextItemSelected(item);
    }
}