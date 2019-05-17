package android.com.example1views;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = "MainActivity LifeCycle";
    Button bt_clickme;
    ImageView iv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_clickme = findViewById(R.id.bt_clickme);
        iv_image = findViewById(R.id.iv_image);
        bt_clickme.setOnClickListener(this);
        Log.v(TAG, TAG + " : onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, TAG + " : onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, TAG + " : onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, TAG + " : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, TAG + ": onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, TAG + " : onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, TAG + " : onRestart");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v(TAG, TAG + " : onBackPressed");
    }

    @Override
    public void onClick(View v) {
        sendSMS();
    }

    private void callBrowser() {
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://www.google.com"));
        startActivity(browser);
    }

    private void call() {
        Intent browser = new Intent(Intent.ACTION_CALL);
        browser.setData(Uri.parse("tel:1234567890"));
        startActivity(browser);
    }

    private void dialNumber() {
        Intent browser = new Intent(Intent.ACTION_DIAL);
        browser.setData(Uri.parse("tel:1234567890"));
        startActivity(browser);
    }

    private void sendSMS() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            sendMySMS();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    12);
        }
    }

    private void multPermissionCheck() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                // Both are not granted
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE},
                        15);
            } else {

            }
        } else {

        }
    }

    private void camera() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Disabled", Toast.LENGTH_LONG).show();
                requestCameraPermission();
            } else {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, 10);
            }
        } else {
            Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(photoCaptureIntent, 10);
        }
    }

    private void requestCameraPermission() {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA},
                11);
    }

    private void second() {
        Intent second = new Intent(this, SecondActivity.class);
        startActivityForResult(second, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 11:
                Log.i("Camera", "G : " + grantResults[0]);
                // If request is cancelled, the result arrays are empty.

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted,
                    Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(photoCaptureIntent, 10);
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

//                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
//                        Toast.makeText(this, "App Requires Permission. Please Allow It", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(this, "Permission Disabled By User Tapped On Never Ask Again", Toast.LENGTH_LONG).show();
//                        showSettingsAlert("App needs to access the Camera.",Manifest.permission.CAMERA);
//                    }

                    showSettingsAlert("App needs to access the Camera.",Manifest.permission.CAMERA);
                }
                break;
            case 15:
                if (grantResults.length > 0) {
                    Log.v("Grant", "Grant : " + grantResults[0]);
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "First Granted", Toast.LENGTH_LONG).show();
                        if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "Second Granted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "Second Not Granted", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(this, "First Not Granted", Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(this, "" + grantResults.length, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Length 0", Toast.LENGTH_LONG).show();
                }
                break;
            // other 'case' lines to check for other
            // permissions this app might request

            case 12:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    sendMySMS();
                } else {
//                    Toast.makeText(this, "Need Permission To Send SMS", Toast.LENGTH_LONG).show();
                    showSettingsAlert("Need Permission To Send SMS",Manifest.permission.SEND_SMS);
                }
                break;

        }
    }

    private void sendMySMS() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+919177414034", null, "Hello From SMS Manager", null, null);
        Toast.makeText(this, "SMS Sent", Toast.LENGTH_LONG).show();
    }

    private void showSettingsAlert(String msg,String permission) {

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
            Toast.makeText(this, "App Requires Permission. Please Allow It", Toast.LENGTH_LONG).show();
            return;
        }

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //finish();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startInstalledAppDetailsActivity(MainActivity.this);
                    }
                });
        alertDialog.show();
    }

    public static void startInstalledAppDetailsActivity(final Activity context) {
        if (context == null) {
            return;
        }
        final Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            String text = data.getStringExtra("edittext");
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }

        if (requestCode == 10 && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            iv_image.setImageBitmap(bitmap);
        }
    }
}
