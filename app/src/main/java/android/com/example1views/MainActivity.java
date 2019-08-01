package android.com.example1views;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Views only Push
    String TAG = "MainActivity LifeCycle";
    EditText et_username;
    Button bt_login;
    Button bt_clear;
    Button bt_basic_dialog;
    Button bt_date_time;
    CheckBox cb_save;
    RatingBar rb_rating;
    SeekBar sb_seekbar;
    RadioGroup rg_group;
    ImageView iv_image;
    ToggleButton tb_toggle;
    TextView tv_status;// ctrl+d to create new copy in new line

    // 09-05-2019
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v(TAG,TAG+" : onCreate");


        et_username = findViewById(R.id.et_username);
        bt_login = findViewById(R.id.bt_login);
        bt_basic_dialog = findViewById(R.id.bt_basic_dialog);
        bt_date_time = findViewById(R.id.bt_date_time);
        bt_clear = findViewById(R.id.bt_clear);
        tv_status = findViewById(R.id.tv_status);
        cb_save = findViewById(R.id.cb_save);
        rb_rating = findViewById(R.id.rb_rating);
        sb_seekbar = findViewById(R.id.sb_seekbar);
        rg_group = findViewById(R.id.rg_group);
        iv_image = findViewById(R.id.iv_image);
        tb_toggle = findViewById(R.id.tb_toggle);

        bt_basic_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showBasicDialog();
                customDialog();
            }
        });

        bt_date_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                datePicker();
                timePicker();
            }
        });

        tb_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String text = null;
                if(isChecked){
                    text =tb_toggle.getTextOn().toString();
                } else {
                    text = tb_toggle.getTextOff().toString();
                }
                Log.v(TAG,TAG+" : Toggle  : "+isChecked+","+text+",Name : "+buttonView.getText()+", :::::: "+tb_toggle.getText());
            }
        });


        rb_rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.v(TAG,TAG+" : rating : "+rating);
                Toast.makeText(MainActivity.this,"Rating : "+rating,Toast.LENGTH_LONG).show();
            }
        });

        sb_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.v(TAG,TAG+" Seekbar onProgressChanged : progress : "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.v(TAG,TAG+" Seekbar onStartTrackingTouch ");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.v(TAG,TAG+" Seekbar onStopTrackingTouch ");
            }
        });

        rg_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String result = getRadioButtionId(checkedId);
                tv_status.setText(result);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float rating = rb_rating.getRating();
                int seebBarValue = sb_seekbar.getProgress();
                String selectedId = getRadioButtionId(rg_group.getCheckedRadioButtonId());//R.id.rb_1
                RadioButton radioButton = rg_group.findViewById(rg_group.getCheckedRadioButtonId());
                iv_image.setImageResource(R.drawable.map);
                Log.v(TAG,TAG+" Rating Bar "+rating);
                Log.v(TAG,TAG+" Seek Bar "+seebBarValue);
                Log.v(TAG,TAG+" Radio Group "+selectedId);
                Log.v(TAG,TAG+" Radio Button "+radioButton.getText());

                if(cb_save.isChecked()){
                    // save
                } else {
                    // remove
                }

                if(et_username.getText().toString().length()>0){
                    String userName = et_username.getText().toString().trim();
                    displayToast("Valid User "+userName);
                    // Server code will userName
//                    tv_status.setText("Valid User "+userName);
                } else {
//                    tv_status.setText("In Valid User");
                    Toast.makeText(MainActivity.this,"In Valid User",Toast.LENGTH_LONG).show();
                }
            }

        });

        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_username.setText("");
                tv_status.setText("Status");
            }
        });

        cb_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"Your username will be saved",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"Your username not saved",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void datePicker() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.v("Date",year+" : "+month +" "+dayOfMonth);
            }
        },year,month,day);
        datePickerDialog.show();

    }

    private void timePicker(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.v("Time",hourOfDay+" : "+minute);
            }
        },hour,min,true);
        timePickerDialog.show();
    }

    private void showBasicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("My Title");
        builder.setMessage("Hai How Are You");
        builder.setPositiveButton("Good", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v("Dialog","Good");
                dialog.cancel();
            }
        }).setNegativeButton("Bad", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v("Dialog","Bad");
                dialog.cancel();
            }
        }).setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v("Dialog","Ok");
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void customDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        Button button = dialog.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private String getRadioButtionId(int checkedId) {
        String result = null;
        switch (checkedId){
            case R.id.rb_1:
                Log.v(TAG,TAG+" Radio Button 1");
                result = "Radio Button 1";
                break;
            case R.id.rb_2:
                Log.v(TAG,TAG+" Radio Button 2");
                result = "Radio Button 2";
                break;
            case R.id.rb_3:
                Log.v(TAG,TAG+" Radio Button 3");
                result = "Radio Button 3";
                break;
            case R.id.rb_4:
                Log.v(TAG,TAG+" Radio Button 4");
                result = "Radio Button 4";
                break;
        }
        return result;
    }

    private void displayToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,TAG+" : onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,TAG+" : onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,TAG+" : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,TAG+": onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,TAG+" : onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,TAG+" : onRestart");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v(TAG,TAG+" : onBackPressed");
    }
}
