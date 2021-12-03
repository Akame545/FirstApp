package com.alexmartin.firstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
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

//      Creación del objeto WebView vinculado con el id
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

    //  Opciones al seleccionar un elemnto del menú ↓
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_user:
                showAlertDialogButtonClickedUser(Main.this);
                break;
            case R.id.menu_aboutus:
                Toast toast1 = Toast.makeText(this, "Work-in-progress", Toast.LENGTH_SHORT);
                toast1.show();
                break;
            case R.id.menu_singout:
                showAlertDialogButtonClicked(Main.this);
                break;
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
                Intent intent = new Intent(Main.this, Login.class);
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
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("Hey Listen!!");
        builder.setMessage("Are you sure about that?");
        builder.setIcon(R.drawable.ic_monigote_foreground);
        builder.setCancelable(false);

        builder.setPositiveButton("Yeah!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Main.this, Login.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

//  Funciones al refrescar la web.
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
//  Creador del menú de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chulo, menu);
        return true;
    }
//  Creador del ContextMenu con el inflater.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Chose an option");
        inflater.inflate(R.menu.menu_context, menu);
    }
//  Manejo de cada item seleccionado
    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menu_copy:
                final ConstraintLayout mLayout = findViewById(R.id.MainConstraint);
//              Forma de crear un snackbar ↓
                Snackbar snackbar = Snackbar
                        .make(mLayout, "Image copied", Snackbar.LENGTH_LONG)
                        .setAction("Regreat", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Copy canceled :c", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                                }
                            });
                snackbar.show();
                return true;
                case R.id.menu_download:
                    Toast toast2 =
                            Toast.makeText(this, "Image downloaded succesfully!!", Toast.LENGTH_SHORT);
                    toast2.show();
                    return true;
                default:
        }
        return super.onContextItemSelected(item);
    }
}