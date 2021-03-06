package owlinone.pae;

/**
 * Created by Julian on 09/12/2016.
 */


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import owlinone.pae.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



public class DetailAppart extends AppCompatActivity implements OnMapReadyCallback{
    String strDetail;
    String strDetailTel;
    String strNomPropDetail;
    String strLongitude;
    String strLatitude;
    String strMail;
    String strAdresse;
    String strVille;
    String strPrix;
    String strDispoContext;
        SupportMapFragment supportMapFragment = new SupportMapFragment();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailappart);

        supportMapFragment = (SupportMapFragment) this
                .getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        // ajoute la fonction toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        TextView textDetail = (TextView) findViewById(R.id.detail);
        TextView textTel = (TextView) findViewById(R.id.detail_tel);
        TextView textNomPropDetail = (TextView) findViewById(R.id.nom_prop_detail);
        TextView textMail = (TextView) findViewById(R.id.detail_mail);

        //Récupère le string srtDetail pour les détails--------------------------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strDetail = null;
            } else {
                strDetail = extras.getString("strDetail");
            }
        } else {
            strDetail = (String) savedInstanceState.getSerializable("strDetail");
        }

        //Récupère le string srtDetailTel pour le telephone-----------------------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strDetailTel = null;
            } else {
                strDetailTel = extras.getString("strDetailTel");
            }
        } else {
            strDetailTel = (String) savedInstanceState.getSerializable("strDetailTel");
        }

        //Récupère le string strNomPropDetail pour le nom du propriétaire---------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strNomPropDetail = null;
            } else {
                strNomPropDetail = extras.getString("strNomPropDetail");
            }
        } else {
            strNomPropDetail = (String) savedInstanceState.getSerializable("strNomPropDetail");
        }

        //Récupère le string strLongitude pour la longitude de l'adresse---------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strLongitude = null;
            } else {
                strLongitude = extras.getString("strLongitude");
            }
        } else {
            strLongitude = (String) savedInstanceState.getSerializable("strLongitude");
        }

        //Récupère le string strLongitude pour la latitude de l'adresse---------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strLatitude = null;
            } else {
                strLatitude = extras.getString("strLatitude");
            }
        } else {
            strLatitude = (String) savedInstanceState.getSerializable("strLatitude");
        }

        //Récupère le string strMail pour le mail du propriétaire-----------------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strMail = null;
            } else {
                strMail = extras.getString("strMail");
            }
        } else {
            strMail = (String) savedInstanceState.getSerializable("strMail");
        }

        //Récupère le string strAdresse pour l'adresse de l'appartement-----------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strAdresse = null;
            } else {
                strAdresse = extras.getString("strAdresse");
            }
        } else {
            strAdresse = (String) savedInstanceState.getSerializable("strAdresse");
        }

        //Récupère le string strVille pour la ville de l'appartement--------------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strVille = null;
            } else {
                strVille = extras.getString("strVille");
            }
        } else {
            strVille = (String) savedInstanceState.getSerializable("strVille");
        }

        //Récupère le string strVille pour le prix de l'appartement---------------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strPrix= null;
            } else {
                strPrix = extras.getString("strPrix");
            }
        } else {
            strPrix= (String) savedInstanceState.getSerializable("strPrix");
        }

        //Récupère le string strDispoContext pour la disponibilité----------------------------------
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                strDispoContext = null;
            } else {
                strDispoContext = extras.getString("strDispoContext");
            }
        } else {
            strDispoContext = (String) savedInstanceState.getSerializable("strDispoContext");
        }
        textDetail.setText("Adresse: " + "\n" + strAdresse + " à " + strVille + "." + "\n" + "\n" + "Ses caractéristiques sont: " + "\n" + strDetail + "\n" + "\n" + "Le prix est de: " + strPrix + "€/mois."  + "\n" + "\n" + "A la dernière mise à jour l'appartement est: " + strDispoContext + "." );
        textTel.setText(strDetailTel);
        textNomPropDetail.setText(" " + strNomPropDetail);
        textMail.setText(strMail);

        //click pour appeler au téléphone
        textTel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + strDetailTel;
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });

        //click pour envoyer un mail
        textMail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:" + strMail);
                intent.setData(data);
                startActivity(intent);
            }
        });
    }

    //méthode pour démarrer google map avec la position de 2 markers avec l'animation de départ
    @Override
    public void onMapReady(GoogleMap map) {
        Marker markerEsaip = map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_esaip))
                .position(new LatLng(47.464051, -0.497334)));
        Marker markerAppart = map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_home))
                .position(new LatLng( Double.valueOf(strLatitude),Double.valueOf(strLongitude)
                )));
        LatLng position = new LatLng(47.46848551035859, -0.5252838134765625);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(position, 12);
        map.animateCamera(yourLocation);
        // You can customize the marker image using images bundled with
        // your app, or dynamically generated bitmaps.
    }

}

